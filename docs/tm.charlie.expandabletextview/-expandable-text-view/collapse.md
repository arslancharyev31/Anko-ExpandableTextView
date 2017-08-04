---
title: ExpandableTextView.collapse - expandable-textview
---

[expandable-textview](../../index.html) / [tm.charlie.expandabletextview](../index.html) / [ExpandableTextView](index.html) / [collapse](.)

# collapse

`@JvmOverloads fun collapse(withAnimation: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, forceCollapse: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Collapses this [ExpandableTextView](index.html) if its [state](state.html) is [Expanded](-state/-expanded.html).

### Parameters

`withAnimation` - should it collapse with animation or instantaneously. **true** by default.

`forceCollapse` - collapses this [ExpandableTextView](index.html) even if it is not in
the [expanded](-state/-expanded.html) [state](state.html). **false** by default.

**Return**
**true** if [ExpandableTextView](index.html) started collapsing, **false** otherwise.

