---
title: ExpandableTextView.toggle - expandable-textview
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">expandable-textview</a> / <a href="../index.html">tm.charlie.expandabletextview</a> / <a href="index.html">ExpandableTextView</a> / <a href=".">toggle</a></div>

# toggle

<div class="signature"><code><span class="identifier">@JvmOverloads</span> <span class="keyword">fun </span><span class="identifier">toggle</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$toggle(kotlin.Boolean)/withAnimation">withAnimation</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;true<br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

<a href="expand.html">Expands</a> this <a href="index.html">ExpandableTextView</a> if the <a href="state.html">state</a> is <a href="-state/-collapsed.html">Collapsed</a>,
<a href="collapse.html">collapses</a> if the <a href="state.html">state</a> is <a href="-state/-expanded.html">Expanded</a> and does nothing otherwise.

### Parameters

<code>withAnimation</code> - should it toggle with animation or instantaneously. **true** by default.

**Return**
**true** if started expanding/collapsing, **false** otherwise.

