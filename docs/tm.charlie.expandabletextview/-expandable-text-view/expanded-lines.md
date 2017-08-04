---
title: ExpandableTextView.expandedLines - expandable-textview
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">expandable-textview</a> / <a href="../index.html">tm.charlie.expandabletextview</a> / <a href="index.html">ExpandableTextView</a> / <a href=".">expandedLines</a></div>

# expandedLines

<div class="signature"><code><span class="keyword">var </span><span class="identifier">expandedLines</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

Number of lines in the <a href="-state/-expanded.html">expanded</a> <a href="state.html">state</a>. <a href="https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE">Integer.MAX_VALUE</a> by default.

### Exceptions

<code>IllegalArgumentException</code> - if number of expanded lines is being set to number less than <a href="collapsed-lines.html">collapsedLines</a>.