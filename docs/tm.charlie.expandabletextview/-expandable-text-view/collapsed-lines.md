---
title: ExpandableTextView.collapsedLines - expandable-textview
---

[expandable-textview](../../index.html) / [tm.charlie.expandabletextview](../index.html) / [ExpandableTextView](index.html) / [collapsedLines](.)

# collapsedLines

`var collapsedLines: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Maximum number of lines in [collapsed](-state/-collapsed.html) [state](state.html). [Integer.MAX_VALUE](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) by default.

### Exceptions

`IllegalArgumentException` - if number of collapsed lines is being set to number greater than [expandedLines](expanded-lines.html).