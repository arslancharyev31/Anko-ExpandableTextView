package tm.charlie.expandabletextview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View.MeasureSpec.makeMeasureSpec
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.TextView
import org.jetbrains.anko.wrapContent
import kotlin.properties.Delegates

class ExpandableTextView: TextView {
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
	
	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
			: super(context, attrs, defStyleAttr, defStyleRes) {
		initAttrs(attrs, defStyleAttr, defStyleRes)
	}
	
	// private properties
	private var collapsedHeight: Int = 0
	private var expandedHeight: Int = 0
	private var originalMaxLines = maxLines // keep the original value of maxLines
	override fun setMaxLines(maxLines: Int) {
		super.setMaxLines(maxLines)
		originalMaxLines = maxLines
	}
	
	// public properties with private setters
	var isAnimating = false; private set
	var isExpanded = false; private set
	
	// public properties
	var animationDuration: Long by Delegates.notNull()
	/** Called when [ExpandableTextView] starts expanding*/
	var onExpand: (ExpandableTextView.() -> Unit) = {}
	/** Called when [ExpandableTextView] starts collapsing*/
	var onCollapse: (ExpandableTextView.() -> Unit) = {}
	var expandInterpolator = AccelerateDecelerateInterpolator()
	var collapseInterpolator = AccelerateDecelerateInterpolator()
	
	fun initAttrs(attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) {
		context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView, defStyleAttr, defStyleRes).apply {
			animationDuration = getInteger(R.styleable.ExpandableTextView_animationDuration, 400).toLong()
		}.recycle()
		
	}
	
	/**
	 * Toggle the expanded state of this [ExpandableTextView].
	 * @return true if toggled, false otherwise.
	 */
	fun toggle() = if (isExpanded) collapse() else expand()
	
	/**
	 * Expand this [ExpandableTextView].
	 * @return true if expanded, false otherwise.
	 */
	fun expand(): Boolean {
		if (!isExpanded && !isAnimating && originalMaxLines >= 0) {
			
			// notify listener
			onExpand()
			
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
				duration = animationDuration
				
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
					}
				})
			}.start() // start the animation
			isAnimating = true
			return true
		}
		return false
	}
	
	/**
	 * Collapse this [ExpandableTextView].
	 * @return true if collapsed, false otherwise.
	 */
	fun collapse(): Boolean {
		if (isExpanded && !isAnimating && originalMaxLines >= 0) {
			// notify listener
			onCollapse()
			
			// get expanded height
			expandedHeight = measuredHeight
			
			// animate from expanded height to collapsed height
			ValueAnimator.ofInt(expandedHeight, collapsedHeight).apply {
				interpolator = collapseInterpolator
				duration = animationDuration
				
				addUpdateListener { animation ->
					layoutParams = layoutParams.apply { height = animation.animatedValue as Int }
				}
				addListener(object: AnimatorListenerAdapter() {
					override fun onAnimationEnd(animation: Animator) {
						// set maxLines to original value
						super@ExpandableTextView.setMaxLines(originalMaxLines)
						
						// if fully collapsed, set height to WRAP_CONTENT, because when rotating the device
						// the height calculated with this ValueAnimator isn't correct anymore
						layoutParams.apply { height = wrapContent }
						
						// keep track of current status
						isExpanded = false
						isAnimating = false
					}
				})
			}.start() // start the animation
			isAnimating = true
			return true
		}
		return false
	}
	
	// Making sure view retains it's expanded/collapse state
	
	override fun onSaveInstanceState() = SavedState(super.onSaveInstanceState()).apply {
		isExpanded = this@ExpandableTextView.isExpanded
	}
	
	override fun onRestoreInstanceState(state: Parcelable) {
		val ss = state as SavedState
		super.onRestoreInstanceState(state.superState)
		
		// Restore collapsed/expanded state
		
		val tempAnimDur = animationDuration
		animationDuration = 0
		if (ss.isExpanded) expand() else collapse()
		animationDuration = tempAnimDur
	}
	
	class SavedState: BaseSavedState {
		var isExpanded: Boolean = false
		
		constructor(superState: Parcelable): super(superState)
		
		private constructor(source: Parcel): super(source) {
			isExpanded = source.readBool()
		}
		
		override fun writeToParcel(dest: Parcel, flags: Int) {
			super.writeToParcel(dest, flags)
			dest.writeBool(isExpanded)
		}
		
		companion object {
			val CREATOR: Parcelable.Creator<SavedState> = object: Parcelable.Creator<SavedState> {
				override fun createFromParcel(source: Parcel) = SavedState(source)
				override fun newArray(size: Int): Array<SavedState?> = arrayOfNulls(size)
			}
		}
		
		fun Parcel.writeBool(boolean: Boolean) = writeInt(if (boolean) 1 else 0)
		fun Parcel.readBool() = readInt() != 0
	}
}

