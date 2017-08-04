---
title: ExpandableTextView - expandable-textview
---

[expandable-textview](../../index.html) / [tm.charlie.expandabletextview](../index.html) / [ExpandableTextView](.)

# ExpandableTextView

`open class ExpandableTextView : `[`AppCompatTextView`](https://developer.android.com/reference/android/support/v7/widget/AppCompatTextView.html)

### Types

| [SavedState](-saved-state/index.html) | `class SavedState : `[`BaseSavedState`](https://developer.android.com/reference/android/view/View/BaseSavedState.html)<br>Protected class that is being used to save and restore ExpandableTextView's state on configuration change. |
| [State](-state/index.html) | `enum class State`<br>Enum representing current state of the ExpandableTextView. |

### Constructors

| [&lt;init&gt;](-init-.html) | `ExpandableTextView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>`ExpandableTextView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`?)`<br>`ExpandableTextView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`?, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| [animationDuration](animation-duration.html) | `var animationDuration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Duration of expand/collapse animation in milliseconds. 300 by default. |
| [collapseInterpolator](collapse-interpolator.html) | `var collapseInterpolator: `[`TimeInterpolator`](https://developer.android.com/reference/android/animation/TimeInterpolator.html)<br>Interpolator applied to collapse animation. [AccelerateDecelerateInterpolator](https://developer.android.com/reference/android/view/animation/AccelerateDecelerateInterpolator.html) by default |
| [collapsedHeight](collapsed-height.html) | `var collapsedHeight: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [collapsedLines](collapsed-lines.html) | `var collapsedLines: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Maximum number of lines in [collapsed](-state/-collapsed.html) [state](state.html). [Integer.MAX_VALUE](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) by default. |
| [expandInterpolator](expand-interpolator.html) | `var expandInterpolator: `[`TimeInterpolator`](https://developer.android.com/reference/android/animation/TimeInterpolator.html)<br>Interpolator applied to expand animation. [AccelerateDecelerateInterpolator](https://developer.android.com/reference/android/view/animation/AccelerateDecelerateInterpolator.html) by default. |
| [expandedHeight](expanded-height.html) | `var expandedHeight: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [expandedLines](expanded-lines.html) | `var expandedLines: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Maximum number of lines in the [expanded](-state/-expanded.html) [state](state.html). [Integer.MAX_VALUE](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) by default. |
| [layoutHeight](layout-height.html) | `var layoutHeight: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onStateChangeListener](on-state-change-listener.html) | `var onStateChangeListener: ExpandableTextView.(oldState: `[`State`](-state/index.html)`, newState: `[`State`](-state/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Protected listener that is being called when this ExpandableTextView changes its [state](state.html). Use public [onStateChange](on-state-change.html) to set the listener. |
| [state](state.html) | `var state: `[`State`](-state/index.html)<br>Current [State](-state/index.html) of this ExpandableTextView. Read-only property. [Static](-state/-static.html) by default. |

### Functions

| [collapse](collapse.html) | `fun collapse(withAnimation: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, forceCollapse: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Collapses this ExpandableTextView if its [state](state.html) is [Expanded](-state/-expanded.html). |
| [expand](expand.html) | `fun expand(withAnimation: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, forceExpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Expands this ExpandableTextView if its [state](state.html) is [Collapsed](-state/-collapsed.html). |
| [initAttrs](init-attrs.html) | `fun initAttrs(attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`? = null, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, defStyleRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onRestoreInstanceState](on-restore-instance-state.html) | `open fun onRestoreInstanceState(state: `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSaveInstanceState](on-save-instance-state.html) | `open fun onSaveInstanceState(): `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html) |
| [onSizeChanged](on-size-changed.html) | `open fun onSizeChanged(w: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, h: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, oldw: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, oldh: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStateChange](on-state-change.html) | `fun onStateChange(func: ExpandableTextView.(oldState: `[`State`](-state/index.html)`, newState: `[`State`](-state/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Listener which is being called when ExpandableTextView changes its [state](state.html). |
| [onTextChanged](on-text-changed.html) | `open fun onTextChanged(text: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`?, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, lengthBefore: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, lengthAfter: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setEllipsize](set-ellipsize.html) | `open fun ~~setEllipsize~~(where: `[`TruncateAt`](https://developer.android.com/reference/android/text/TextUtils/TruncateAt.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setMaxLines](set-max-lines.html) | `open fun ~~setMaxLines~~(maxLines: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toggle](toggle.html) | `fun toggle(withAnimation: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>[Expands](expand.html) this ExpandableTextView if the [state](state.html) is [Collapsed](-state/-collapsed.html), [collapses](collapse.html) if the [state](state.html) is [Expanded](-state/-expanded.html) and does nothing otherwise. |
| [updateState](update-state.html) | `fun updateState(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

