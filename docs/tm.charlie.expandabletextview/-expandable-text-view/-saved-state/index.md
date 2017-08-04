---
title: ExpandableTextView.SavedState - expandable-textview
---

[expandable-textview](../../../index.html) / [tm.charlie.expandabletextview](../../index.html) / [ExpandableTextView](../index.html) / [SavedState](.)

# SavedState

`protected class SavedState : `[`BaseSavedState`](https://developer.android.com/reference/android/view/View/BaseSavedState.html)

Protected class that is being used to save and restore [ExpandableTextView](../index.html)'s state on configuration change.

### Constructors

| [&lt;init&gt;](-init-.html) | `SavedState(superState: `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html)`)`<br>`SavedState(source: `[`Parcel`](https://developer.android.com/reference/android/os/Parcel.html)`)` |

### Properties

| [state](state.html) | `var state: `[`State`](../-state/index.html) |

### Functions

| [writeToParcel](write-to-parcel.html) | `fun writeToParcel(dest: `[`Parcel`](https://developer.android.com/reference/android/os/Parcel.html)`, flags: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| [CREATOR](-c-r-e-a-t-o-r.html) | `val CREATOR: `[`Creator`](https://developer.android.com/reference/android/os/Parcelable/Creator.html)`<SavedState>` |

