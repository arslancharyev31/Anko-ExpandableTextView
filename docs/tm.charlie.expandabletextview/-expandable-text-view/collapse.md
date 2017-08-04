---
title: ExpandableTextView.collapse - expandable-textview
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">expandable-textview</a> / <a href="../index.html">tm.charlie.expandabletextview</a> / <a href="index.html">ExpandableTextView</a> / <a href=".">collapse</a></div>

# collapse

<div class="signature"><code><span class="identifier">@JvmOverloads</span> <span class="keyword">fun </span><span class="identifier">collapse</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$collapse(kotlin.Boolean, kotlin.Boolean)/withAnimation">withAnimation</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;true<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$collapse(kotlin.Boolean, kotlin.Boolean)/forceCollapse">forceCollapse</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;false<br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

Collapses this <a href="index.html">ExpandableTextView</a> if its <a href="state.html">state</a> is <a href="-state/-expanded.html">Expanded</a>.

### Parameters

<code>withAnimation</code> - should it collapse with animation or instantaneously. **true** by default.

<code>forceCollapse</code> - collapses this <a href="index.html">ExpandableTextView</a> even if it is not in
the <a href="-state/-expanded.html">expanded</a> <a href="state.html">state</a>. **false** by default.

**Return**
**true** if started collapsing, **false** otherwise.

