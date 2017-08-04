---
title: ExpandableTextView.expandedLines - expandable-textview
---

[expandable-textview](../../index.html) / [tm.charlie.expandabletextview](../index.html) / [ExpandableTextView](index.html) / [expandedLines](.)

# expandedLines

`var expandedLines: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Maximum number of lines in the [expanded](-state/-expanded.html) [state](state.html). [Integer.MAX_VALUE](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) by default.

### Exceptions

`IllegalArgumentException` - if number of expanded lines is being set to number less than [collapsedLines](collapsed-lines.html).