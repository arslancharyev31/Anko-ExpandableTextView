package tm.charlie.expandabletextview

import android.animation.*
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View.MeasureSpec.makeMeasureSpec
import android.view.animation.AccelerateDecelerateInterpolator
import org.jetbrains.anko.wrapContent
import tm.charlie.expandabletextview.ExpandableTextView.State.*

open class ExpandableTextView: AppCompatTextView {
	// Protected functions and properties
	
	/**
	 * Protected listener that is being called when this [ExpandableTextView] changes its [state].
	 * Use public [onStateChange] to set the listener.
	 * @see [onStateChange]
	 * */
	protected var onStateChangeListener: (ExpandableTextView.(oldState: State, newState: State) -> Unit)? = null
	
	protected var layoutHeight: Int
		get() {
			measure(makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY), makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
			return measuredHeight
		}
		set(value) {
			fun setHeight() = { layoutParams = layoutParams.apply { height = value } }()
			layoutParams?.let { setHeight() } ?: post { setHeight() }
		}
	
	protected var collapsedHeight = 0
		get () = { super.setMaxLines(collapsedLines); layoutHeight }()
	
	protected var expandedHeight = 0
		get () = { super.setMaxLines(expandedLines); layoutHeight }()
	
	protected fun initAttrs(attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) {
		super.setEllipsize(TextUtils.TruncateAt.END)
		context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView, defStyleAttr, defStyleRes).apply {
			animationDuration = getInteger(R.styleable.ExpandableTextView_etv_animationDuration, animationDuration)
			collapsedLines = getInteger(R.styleable.ExpandableTextView_etv_collapsedLines, collapsedLines)
			expandedLines = getInteger(R.styleable.ExpandableTextView_etv_expandedLines, expandedLines)
		}.recycle()
	}
	
	@Suppress("NON_EXHAUSTIVE_WHEN")
	protected fun updateState(restoredState: State? = null) {
		when (state) {
			Collapsing, Expanding -> return
		}
		log("updateState")
		when (restoredState) {
			Collapsed -> collapse(withAnimation = false, forceCollapse = true)
			Expanded -> expand(withAnimation = false, forceExpand = true)
			else -> state =
					if (isEllipsized) {
						if (collapsedLines != expandedLines) {
							if (lineCount == expandedLines)
								Expanded
							else Collapsed
						} else Static
					} else {
						if (collapsedLines == expandedLines || lineCount <= collapsedLines)
							Static
						else Expanded
					}
		}
		
	}
	
	// Public properties with protected setters
	
	/** Current [State] of this [ExpandableTextView]. Read-only property. [Static] by default. */
	var state = State.Static
		protected set(value) {
			if (field != value) {
				log("$field -> $value")
				onStateChangeListener?.let { it(field, value) }
				field = value
			}
		}
	
	// Public properties
	
	/** Duration of expand/collapse animation in milliseconds. 300 by default. */
	var animationDuration = 300
	
	/** Interpolator applied to expand animation. [AccelerateDecelerateInterpolator] by default. */
	var expandInterpolator: TimeInterpolator = AccelerateDecelerateInterpolator()
	
	/** Interpolator applied to collapse animation. [AccelerateDecelerateInterpolator] by default */
	var collapseInterpolator: TimeInterpolator = AccelerateDecelerateInterpolator()
	
	/**
	 * Maximum number of lines in [collapsed][Collapsed] [state]. [Integer.MAX_VALUE] by default.
	 * @throws [IllegalArgumentException] if number of collapsed lines is being set to number greater than [expandedLines].
	 * */
	var collapsedLines = Integer.MAX_VALUE
		set (value) {
			field = when {
				(value > expandedLines) -> throw IllegalArgumentException("Collapsed lines($value) cannot be greater than expanded lines($expandedLines)")
				(value < 0) -> 0
				(field == value) -> return
				else -> value
			}
			// here new collapsedLines <= expandedLines and new collapsedLines != old collapsedLines
			// TODO: Test Collapsing and Expanding conditions
			when (state) {
				Collapsed, Collapsing, Static -> collapse(withAnimation = false, forceCollapse = true)
				Expanding -> doNothing()
				Expanded -> if (field == expandedLines) state = Static else doNothing()
			}
		}
	
	/**
	 * Maximum number of lines in the [expanded][Expanded] [state]. [Integer.MAX_VALUE] by default.
	 * @throws [IllegalArgumentException] if number of expanded lines is being set to number less than [collapsedLines].
	 * */
	var expandedLines = Integer.MAX_VALUE
		set(value) {
			field = when {
				(value < collapsedLines) -> throw IllegalArgumentException("Expanded lines ($value) cannot be less than collapsed lines($collapsedLines)")
				(value < 0) -> 0
				(field == value) -> return
				else -> value
			}
			// here new expandedLines >= collapsedLines and new expandedLines != old expandedLines
			// TODO: Test Collapsing and Expanding conditions
			when (state) {
				Collapsed -> if (field == collapsedLines) state = Static else doNothing()
				Collapsing -> doNothing()
				Static, Expanding -> expand(withAnimation = false, forceExpand = true)
				Expanded -> expand(withAnimation = false, forceExpand = true)
			}
		}

//  Public functions
	
	constructor(context: Context): super(context) {
		initAttrs()
	}
	
	constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
		initAttrs(attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
		initAttrs(attrs, defStyleAttr)
	}
	
	/**
	 * [Expands][expand] this [ExpandableTextView] if the [state] is [Collapsed],
	 * [collapses][collapse] if the [state] is [Expanded] and does nothing otherwise.
	 * @param [withAnimation] should it toggle with animation or instantaneously. **true** by default.
	 * @return **true** if [ExpandableTextView] started expanding/collapsing, **false** otherwise.
	 */
	@JvmOverloads
	fun toggle(withAnimation: Boolean = true) = when (state) {
		Expanded -> collapse(withAnimation)
		Collapsed -> expand(withAnimation)
		else -> false
	}
	
	/**
	 * Expands this [ExpandableTextView] if its [state] is [Collapsed].
	 * @param [withAnimation] should it collapse with animation or instantaneously. **true** by default.
	 * @param [forceExpand] expands this [ExpandableTextView] even if it is not in
	 * the [collapsed][Collapsed] [state]. **false** by default.
	 * @return **true** if [ExpandableTextView] started expanding, **false** otherwise.
	 */
	@JvmOverloads
	fun expand(withAnimation: Boolean = true, forceExpand: Boolean = false): Boolean {
		if (state == Collapsed || forceExpand) {
			if (withAnimation) {
				state = Expanding
				
				// animate from collapsed height to expanded height
				ValueAnimator.ofInt(collapsedHeight, expandedHeight).apply {
					super.setMaxLines(expandedLines)
					interpolator = expandInterpolator
					duration = if (withAnimation) animationDuration.toLong() else 0
					
					// animate height change
					addUpdateListener { animation ->
						layoutHeight = animation.animatedValue as Int
					}
					addListener(object: AnimatorListenerAdapter() {
						override fun onAnimationEnd(animation: Animator) {
							super@ExpandableTextView.setMaxLines(expandedLines)
							// keep track of current status
							state = Expanded
							
							// if fully expanded, set height to WRAP_CONTENT, because when rotating the device
							// the height calculated with this ValueAnimator isn't correct anymore
							layoutHeight = wrapContent
							log("end expanding")
						}
					})
					log("start expanding")
				}.start()
			} else {
				super.setMaxLines(expandedLines)
				layoutHeight = wrapContent
				state = Expanded
			}
			return true
		} else return false
	}
	
	/**
	 * Collapses this [ExpandableTextView] if its [state] is [Expanded].
	 * @param [withAnimation] should it collapse with animation or instantaneously. **true** by default.
	 * @param [forceCollapse] collapses this [ExpandableTextView] even if it is not in
	 * the [expanded][Expanded] [state]. **false** by default.
	 * @return **true** if [ExpandableTextView] started collapsing, **false** otherwise.
	 */
	@JvmOverloads
	fun collapse(withAnimation: Boolean = true, forceCollapse: Boolean = false): Boolean {
		if (state == Expanded || forceCollapse) {
			if (withAnimation) {
				state = Collapsing
				// animate from expanded height to collapsed height
				ValueAnimator.ofInt(expandedHeight, collapsedHeight).apply {
					super.setMaxLines(expandedLines)
					interpolator = collapseInterpolator
					duration = animationDuration.toLong()
					
					// animate height change
					addUpdateListener { animation ->
						layoutHeight = animation.animatedValue as Int
					}
					addListener(object: AnimatorListenerAdapter() {
						override fun onAnimationEnd(animation: Animator) {
							// add ellipsis to the end
							super@ExpandableTextView.setMaxLines(collapsedLines)
							// keep track of current status
							state = Collapsed
							// if fully collapsed, set height to WRAP_CONTENT, because when rotating the device
							// the height calculated with this ValueAnimator isn't correct anymore
							layoutHeight = wrapContent
							log("end collapsing")
						}
					})
					log("start collapsing")
				}.start()
			} else {
				super.setMaxLines(collapsedLines)
				layoutHeight = wrapContent
				state = Collapsed
			}
			return true
		} else return false
	}
	
	/** Listener which is being called when [ExpandableTextView] changes its [state]. */
	fun onStateChange(func: (ExpandableTextView.(oldState: State, newState: State) -> Unit)?) = { onStateChangeListener = func }()

//  Overriding super methods
	
	override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
		super.onTextChanged(text, start, lengthBefore, lengthAfter)
		// Layout is null at this moment, so delay any checks
		post { updateState() }
	}
	
	override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
		super.onSizeChanged(w, h, oldw, oldh)
		updateState()
	}
	
	@Suppress("DeprecatedCallableAddReplaceWith")
	@Deprecated("Setting ellipsize will have no effect, since ellipsize is forced to TruncateAt.END to ensure correct behaviour")
	override fun setEllipsize(where: TextUtils.TruncateAt?) {
		doNothing()
	}
	
	@Deprecated("Library uses `maxLines` internally to ensure correct behavior. Use collapsedLines or expandedLines property instead",
			ReplaceWith("setCollapsedLines(lines) or setExpandedLines(lines) "))
	override fun setMaxLines(maxLines: Int) {
		super.setMaxLines(maxLines)
	}

// Making sure textview retains it's expanded/collapse state
// Source: http://trickyandroid.com/saving-android-view-state-correctly/
	
	override fun onSaveInstanceState(): Parcelable = SavedState(super.onSaveInstanceState()).apply {
		state = this@ExpandableTextView.state
	}
	
	override fun onRestoreInstanceState(state: Parcelable) {
		val ss = state as SavedState
		super.onRestoreInstanceState(state.superState)
		
		// Expanding ETV when it is not yet shown may yield NPE
		// Therefore we should delay its call
		post {
			when (ss.state) {
				Collapsed, Expanded -> updateState(restoredState = ss.state)
				Collapsing -> updateState(restoredState = Collapsed)
				Expanding -> updateState(restoredState = Expanded)
				else -> return@post
			}
		}
	}
	
	/** Protected class that is being used to save and restore [ExpandableTextView]'s state on configuration change. */
	protected class SavedState: BaseSavedState {
		var state: State = Collapsed
		
		constructor(superState: Parcelable): super(superState)
		constructor(source: Parcel): super(source) {
			state = State.valueOf(source.readString())
		}
		
		override fun writeToParcel(dest: Parcel, flags: Int) {
			super.writeToParcel(dest, flags)
			dest.writeString(state.name)
		}
		
		companion object {
			@Suppress("unused")
			val CREATOR: Parcelable.Creator<SavedState> = object: Parcelable.Creator<SavedState> {
				override fun createFromParcel(source: Parcel) = SavedState(source)
				override fun newArray(size: Int): Array<SavedState?> = arrayOfNulls(size)
			}
		}
	}
	
	/** Enum representing current state of the [ExpandableTextView]. */
	enum class State {
		/** [State], in which text is ellipsized and it is possible to expand it, if [expandedLines] is greater than [collapsedLines]. */
		Collapsed,
		/** [State], in which [ExpandableTextView] is in the progress of [collapsing][collapse]. */
		Collapsing,
		/** [State], in which [ExpandableTextView] is in the progress of [expanding][expand]. */
		Expanding,
		/** [State], in which text is expanded, with maximum number of displayed [text lines][getLineCount] equal to [expandedLines]. */
		Expanded,
		/** [State], in which either text can fit in specified number of [collapsedLines] without ellipsizing
		 * or [collapsedLines] equals [expandedLines]. [ExpandableTextView] will not [expand] or [collapse] in this state. */
		Static
	}
}
