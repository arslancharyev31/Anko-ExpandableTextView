---
title: ExpandableTextView.State - expandable-textview
---

[expandable-textview](../../../index.html) / [tm.charlie.expandabletextview](../../index.html) / [ExpandableTextView](../index.html) / [State](.)

# State

`enum class State`

Enum representing current state of the [ExpandableTextView](../index.html).

### Enum Values

| [Collapsed](-collapsed.html) | State, in which text is ellipsized and it is possible to expand it, if [expandedLines](../expanded-lines.html) is greater than [collapsedLines](../collapsed-lines.html). |
| [Collapsing](-collapsing.html) | State, in which [ExpandableTextView](../index.html) is in the progress of [collapsing](../collapse.html). |
| [Expanding](-expanding.html) | State, in which [ExpandableTextView](../index.html) is in the progress of [expanding](../expand.html). |
| [Expanded](-expanded.html) | State, in which text is expanded, with maximum number of displayed [text lines](#) equal to [expandedLines](../expanded-lines.html). |
| [Static](-static.html) | State, in which either text can fit in specified number of [collapsedLines](../collapsed-lines.html) without ellipsizing or [collapsedLines](../collapsed-lines.html) equals [expandedLines](../expanded-lines.html). [ExpandableTextView](../index.html) will not [expand](../expand.html) or [collapse](../collapse.html) in this state. |

