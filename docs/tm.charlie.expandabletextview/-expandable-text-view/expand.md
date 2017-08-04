---
title: ExpandableTextView.expand - expandable-textview
---

[expandable-textview](../../index.html) / [tm.charlie.expandabletextview](../index.html) / [ExpandableTextView](index.html) / [expand](.)

# expand

`@JvmOverloads fun expand(withAnimation: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, forceExpand: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Expands this [ExpandableTextView](index.html) if its [state](state.html) is [Collapsed](-state/-collapsed.html).

### Parameters

`withAnimation` - should it collapse with animation or instantaneously. **true** by default.

`forceExpand` - expands this [ExpandableTextView](index.html) even if it is not in
the [collapsed](-state/-collapsed.html) [state](state.html). **false** by default.

**Return**
**true** if [ExpandableTextView](index.html) started expanding, **false** otherwise.

