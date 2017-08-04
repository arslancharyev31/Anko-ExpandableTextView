---
title: ExpandableTextView.collapsedLines - expandable-textview
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">expandable-textview</a> / <a href="../index.html">tm.charlie.expandabletextview</a> / <a href="index.html">ExpandableTextView</a> / <a href=".">collapsedLines</a></div>

# collapsedLines

<div class="signature"><code><span class="keyword">var </span><span class="identifier">collapsedLines</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

Number of lines in <a href="-state/-collapsed.html">collapsed</a> <a href="state.html">state</a>. <a href="https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE">Integer.MAX_VALUE</a> by default.

### Exceptions

<code>IllegalArgumentException</code> - if number of collapsed lines is being set to number greater than <a href="expanded-lines.html">expandedLines</a>.