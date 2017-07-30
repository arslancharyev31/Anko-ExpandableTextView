package tm.charlie.expandabletextview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View.MeasureSpec.makeMeasureSpec
import android.view.animation.AccelerateDecelerateInterpolator
import org.jetbrains.anko.wrapContent

open class ExpandableTextView: AppCompatTextView {
	constructor(context: Context): super(context) {
		initAttrs()
	}
	
	constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
		initAttrs(attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
			: super(context, attrs, defStyleAttr) {
		initAttrs(attrs, defStyleAttr)
	}
	
	// Protected properties
	protected var collapsedHeight: Int = 0
	protected var expandedHeight: Int = 0
	protected var defaultMaxLines = maxLines // keep the original value of maxLines
	
	// Public properties with protected setters
	var isAnimating = false; protected set
	var isExpanded = false; protected set
	
	// Public properties
	var animationDuration = 350
	var onStartExpand: (ExpandableTextView.() -> Unit) = {}
	var onEndExpand: (ExpandableTextView.() -> Unit) = {}
	var onStartCollapse: (ExpandableTextView.() -> Unit) = {}
	var onEndCollapse: (ExpandableTextView.() -> Unit) = {}
	
	var expandInterpolator = AccelerateDecelerateInterpolator()
	var collapseInterpolator = AccelerateDecelerateInterpolator()
	/** @return **true** if this [ExpandableTextView] is either expanded, ellipsized or
	 *  number of lines is 0 even though text is not empty*/
	val isExpandable get() = isExpanded || isEllipsized || (defaultMaxLines == 0 && text.isNotEmpty())
	
	protected fun initAttrs(attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) {
		context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView, defStyleAttr, defStyleRes).apply {
			animationDuration = getInteger(R.styleable.ExpandableTextView_etv_animationDuration, animationDuration)
		}.recycle()
		super.setEllipsize(TextUtils.TruncateAt.END)
	}
	
	/**
	 * Expand this [ExpandableTextView] if it is collapsed,
	 * Collapse if it is expanded and do nothing if this [ExpandableTextView]
	 * is animating
	 * @return true if toggled, false otherwise.
	 */
	@JvmOverloads fun toggle(withAnimation: Boolean = true): Boolean {
		return if (isExpanded) collapse(withAnimation) else expand(withAnimation)
	}
	
	/**
	 * Expand this [ExpandableTextView] if it is collapsed and not animating
	 * @return true if expanded, false otherwise.
	 */
	@JvmOverloads fun expand(withAnimation: Boolean = true): Boolean {
		if (!isExpanded && !isAnimating && defaultMaxLines >= 0) {
			
			// notify listener
			onStartExpand()
			
			// get collapsed height
			measure(makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY),
					makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
			
			collapsedHeight = measuredHeight
			
			// set maxLines to MAX Integer, so we can calculate the expanded height
			super.setMaxLines(Integer.MAX_VALUE)
			
			// get expanded height
			measure(makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY),
					makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
			
			expandedHeight = measuredHeight
			
			// animate from collapsed height to expanded height
			ValueAnimator.ofInt(collapsedHeight, expandedHeight).apply {
				interpolator = expandInterpolator
				duration = if (withAnimation) animationDuration.toLong() else 0
				
				// animate height change
				addUpdateListener { animation ->
					layoutParams = layoutParams.apply { height = animation.animatedValue as Int }
				}
				addListener(object: AnimatorListenerAdapter() {
					override fun onAnimationEnd(animation: Animator) {
						// if fully expanded, set height to WRAP_CONTENT, because when rotating the device
						// the height calculated with this ValueAnimator isn't correct anymore
						layoutParams.apply { height = wrapContent }
						
						// keep track of current status
						isExpanded = true
						isAnimating = false
						onEndExpand()
					}
				})
			}.start() // start the animation
			isAnimating = true
			return true
		}
		return false
	}
	
	/**
	 * Collapse this [ExpandableTextView] if it is expanded and not animating
	 * @return true if collapsed, false otherwise.
	 */
	@JvmOverloads fun collapse(withAnimation: Boolean = true): Boolean {
		if (isExpanded && !isAnimating && defaultMaxLines >= 0) {
			// notify listener
			onStartCollapse()
			
			// get expanded height
			expandedHeight = measuredHeight
			
			// animate from expanded height to collapsed height
			ValueAnimator.ofInt(expandedHeight, collapsedHeight).apply {
				interpolator = collapseInterpolator
				duration = if (withAnimation) animationDuration.toLong() else 0
				
				addUpdateListener { animation ->
					layoutParams = layoutParams.apply { height = animation.animatedValue as Int }
				}
				addListener(object: AnimatorListenerAdapter() {
					override fun onAnimationEnd(animation: Animator) {
						// set maxLines to original value
						super@ExpandableTextView.setMaxLines(defaultMaxLines)
						
						// if fully collapsed, set height to WRAP_CONTENT, because when rotating the device
						// the height calculated with this ValueAnimator isn't correct anymore
						layoutParams.apply { height = wrapContent }
						
						// keep track of current status
						isExpanded = false
						isAnimating = false
						onEndCollapse()
					}
				})
			}.start() // start the animation
			isAnimating = true
			return true
		}
		return false
	}
	
	// Overriding super methods
	override fun setMaxLines(maxLines: Int) {
		super.setMaxLines(maxLines)
		defaultMaxLines = maxLines
	}
	
	@Deprecated(message = "Ellipsize will be enforced to TruncateAt.END to ensure correct behaviour", level = DeprecationLevel.WARNING)
	override fun setEllipsize(where: TextUtils.TruncateAt?) {
		super.setEllipsize(TextUtils.TruncateAt.END)
	}
	
	// Making sure textview retains it's expanded/collapse state
	// More at: http://trickyandroid.com/saving-android-view-state-correctly/
	
	override fun onSaveInstanceState(): Parcelable = SavedState(super.onSaveInstanceState()).apply {
		isExpanded = this@ExpandableTextView.isExpanded
	}
	
	override fun onRestoreInstanceState(state: Parcelable) {
		val ss = state as SavedState
		super.onRestoreInstanceState(state.superState)
		
		// Calling isExpandable when view is not yet shown will yield NPE
		// Therefore we should delay its call
		post {
			if (ss.isExpanded && this@ExpandableTextView.isExpandable)
				expand(withAnimation = false)
		}
	}
	
	protected class SavedState: BaseSavedState {
		var isExpanded: Boolean = false
		
		constructor(superState: Parcelable): super(superState)
		constructor(source: Parcel): super(source) {
			isExpanded = source.readBool()
		}
		
		override fun writeToParcel(dest: Parcel, flags: Int) {
			super.writeToParcel(dest, flags)
			dest.writeBool(isExpanded)
		}
		
		companion object {
			@Suppress("unused")
			val CREATOR: Parcelable.Creator<SavedState> = object: Parcelable.Creator<SavedState> {
				override fun createFromParcel(source: Parcel) = SavedState(source)
				override fun newArray(size: Int): Array<SavedState?> = arrayOfNulls(size)
			}
		}
		
		fun Parcel.writeBool(boolean: Boolean) = writeInt(if (boolean) 1 else 0)
		fun Parcel.readBool() = readInt() != 0
	}
}

