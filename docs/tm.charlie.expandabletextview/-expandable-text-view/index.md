---
title: ExpandableTextView - expandable-textview
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">expandable-textview</a> / <a href="../index.html">tm.charlie.expandabletextview</a> / <a href=".">ExpandableTextView</a></div>

# ExpandableTextView

<div class="signature"><code><span class="keyword">open</span> <span class="keyword">class </span><span class="identifier">ExpandableTextView</span>&nbsp;<span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/support/v7/widget/AppCompatTextView.html"><span class="identifier">AppCompatTextView</span></a></code></div>

### Types

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-saved-state/index.html">SavedState</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">class </span><span class="identifier">SavedState</span>&nbsp;<span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/view/View/BaseSavedState.html"><span class="identifier">BaseSavedState</span></a></code></div>

Protected class that is being used to save and restore <code>ExpandedTextView</code>'s state on configuration change


</td>
</tr>
<tr>
<td markdown="1">

<a href="-state/index.html">State</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">enum</span> <span class="keyword">class </span><span class="identifier">State</span></code></div>

Enum with self-descriptive states.


</td>
</tr>
</tbody>
</table>

### Constructors

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-init-.html">&lt;init&gt;</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="identifier">ExpandableTextView</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$<init>(android.content.Context)/context">context</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/content/Context.html"><span class="identifier">Context</span></a><span class="symbol">)</span></code></div>

<div class="signature"><code><span class="identifier">ExpandableTextView</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$<init>(android.content.Context, android.util.AttributeSet)/context">context</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/content/Context.html"><span class="identifier">Context</span></a><span class="symbol">, </span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$<init>(android.content.Context, android.util.AttributeSet)/attrs">attrs</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/util/AttributeSet.html"><span class="identifier">AttributeSet</span></a><span class="symbol">?</span><span class="symbol">)</span></code></div>

<div class="signature"><code><span class="identifier">ExpandableTextView</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$<init>(android.content.Context, android.util.AttributeSet, kotlin.Int)/context">context</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/content/Context.html"><span class="identifier">Context</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$<init>(android.content.Context, android.util.AttributeSet, kotlin.Int)/attrs">attrs</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/util/AttributeSet.html"><span class="identifier">AttributeSet</span></a><span class="symbol">?</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$<init>(android.content.Context, android.util.AttributeSet, kotlin.Int)/defStyleAttr">defStyleAttr</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">)</span></code></div>

</td>
</tr>
</tbody>
</table>

### Properties

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="animation-duration.html">animationDuration</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">animationDuration</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

Duration of expand/collapse animation in milliseconds. 300 by default.


</td>
</tr>
<tr>
<td markdown="1">

<a href="collapse-interpolator.html">collapseInterpolator</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">collapseInterpolator</span><span class="symbol">: </span><a href="https://developer.android.com/reference/android/animation/TimeInterpolator.html"><span class="identifier">TimeInterpolator</span></a></code></div>

Interpolator applied to collapse animation. <a href="https://developer.android.com/reference/android/view/animation/AccelerateDecelerateInterpolator.html">AccelerateDecelerateInterpolator</a> by default


</td>
</tr>
<tr>
<td markdown="1">

<a href="collapsed-height.html">collapsedHeight</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">collapsedHeight</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="collapsed-lines.html">collapsedLines</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">collapsedLines</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

Number of lines in <a href="-state/-collapsed.html">collapsed</a> <a href="state.html">state</a>. <a href="https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE">Integer.MAX_VALUE</a> by default.


</td>
</tr>
<tr>
<td markdown="1">

<a href="expand-interpolator.html">expandInterpolator</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">expandInterpolator</span><span class="symbol">: </span><a href="https://developer.android.com/reference/android/animation/TimeInterpolator.html"><span class="identifier">TimeInterpolator</span></a></code></div>

Interpolator applied to expand animation. <a href="https://developer.android.com/reference/android/view/animation/AccelerateDecelerateInterpolator.html">AccelerateDecelerateInterpolator</a> by default.


</td>
</tr>
<tr>
<td markdown="1">

<a href="expanded-height.html">expandedHeight</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">expandedHeight</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="expanded-lines.html">expandedLines</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">expandedLines</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

Number of lines in the <a href="-state/-expanded.html">expanded</a> <a href="state.html">state</a>. <a href="https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE">Integer.MAX_VALUE</a> by default.


</td>
</tr>
<tr>
<td markdown="1">

<a href="layout-height.html">layoutHeight</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">layoutHeight</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-state-change-listener.html">onStateChangeListener</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">onStateChangeListener</span><span class="symbol">: </span><span class="identifier">ExpandableTextView</span><span class="symbol">.</span><span class="symbol">(</span><span class="parameterName">oldState</span><span class="symbol">:</span>&nbsp;<a href="-state/index.html"><span class="identifier">State</span></a><span class="symbol">,</span>&nbsp;<span class="parameterName">newState</span><span class="symbol">:</span>&nbsp;<a href="-state/index.html"><span class="identifier">State</span></a><span class="symbol">)</span>&nbsp;<span class="symbol">-&gt;</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

Protected listener that is being called when this ExpandableTextView changes its <a href="state.html">state</a>.
Use public <a href="on-state-change.html">onStateChange</a> to set the listener.


</td>
</tr>
<tr>
<td markdown="1">

<a href="state.html">state</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">state</span><span class="symbol">: </span><a href="-state/index.html"><span class="identifier">State</span></a></code></div>

Current <a href="-state/index.html">State</a> of this ExpandableTextView. Read-only property. <a href="-state/-static.html">Static</a> by default.


</td>
</tr>
</tbody>
</table>

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="collapse.html">collapse</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">collapse</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$collapse(kotlin.Boolean, kotlin.Boolean)/withAnimation">withAnimation</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;true<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$collapse(kotlin.Boolean, kotlin.Boolean)/forceCollapse">forceCollapse</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;false<br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

Collapses this ExpandableTextView if its <a href="state.html">state</a> is <a href="-state/-expanded.html">Expanded</a>.


</td>
</tr>
<tr>
<td markdown="1">

<a href="expand.html">expand</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">expand</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$expand(kotlin.Boolean, kotlin.Boolean)/withAnimation">withAnimation</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;true<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$expand(kotlin.Boolean, kotlin.Boolean)/forceExpand">forceExpand</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;false<br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

Expands this ExpandableTextView if its <a href="state.html">state</a> is <a href="-state/-collapsed.html">Collapsed</a>.


</td>
</tr>
<tr>
<td markdown="1">

<a href="init-attrs.html">initAttrs</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">initAttrs</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$initAttrs(android.util.AttributeSet, kotlin.Int, kotlin.Int)/attrs">attrs</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/util/AttributeSet.html"><span class="identifier">AttributeSet</span></a><span class="symbol">?</span>&nbsp;<span class="symbol">=</span>&nbsp;null<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$initAttrs(android.util.AttributeSet, kotlin.Int, kotlin.Int)/defStyleAttr">defStyleAttr</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a>&nbsp;<span class="symbol">=</span>&nbsp;0<span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$initAttrs(android.util.AttributeSet, kotlin.Int, kotlin.Int)/defStyleRes">defStyleRes</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a>&nbsp;<span class="symbol">=</span>&nbsp;0<br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-restore-instance-state.html">onRestoreInstanceState</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">onRestoreInstanceState</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onRestoreInstanceState(android.os.Parcelable)/state">state</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/os/Parcelable.html"><span class="identifier">Parcelable</span></a><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-save-instance-state.html">onSaveInstanceState</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">onSaveInstanceState</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://developer.android.com/reference/android/os/Parcelable.html"><span class="identifier">Parcelable</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-size-changed.html">onSizeChanged</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">onSizeChanged</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onSizeChanged(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/w">w</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onSizeChanged(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/h">h</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onSizeChanged(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/oldw">oldw</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onSizeChanged(kotlin.Int, kotlin.Int, kotlin.Int, kotlin.Int)/oldh">oldh</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="on-state-change.html">onStateChange</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">onStateChange</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onStateChange(kotlin.Function3((tm.charlie.expandabletextview.ExpandableTextView, tm.charlie.expandabletextview.ExpandableTextView.State, , kotlin.Unit)))/func">func</span><span class="symbol">:</span>&nbsp;<span class="identifier">ExpandableTextView</span><span class="symbol">.</span><span class="symbol">(</span><span class="parameterName">oldState</span><span class="symbol">:</span>&nbsp;<a href="-state/index.html"><span class="identifier">State</span></a><span class="symbol">,</span>&nbsp;<span class="parameterName">newState</span><span class="symbol">:</span>&nbsp;<a href="-state/index.html"><span class="identifier">State</span></a><span class="symbol">)</span>&nbsp;<span class="symbol">-&gt;</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

Listener which is being called when ExpandableTextView changes its <a href="state.html">state</a>.


</td>
</tr>
<tr>
<td markdown="1">

<a href="on-text-changed.html">onTextChanged</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><span class="identifier">onTextChanged</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onTextChanged(kotlin.CharSequence, kotlin.Int, kotlin.Int, kotlin.Int)/text">text</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html"><span class="identifier">CharSequence</span></a><span class="symbol">?</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onTextChanged(kotlin.CharSequence, kotlin.Int, kotlin.Int, kotlin.Int)/start">start</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onTextChanged(kotlin.CharSequence, kotlin.Int, kotlin.Int, kotlin.Int)/lengthBefore">lengthBefore</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$onTextChanged(kotlin.CharSequence, kotlin.Int, kotlin.Int, kotlin.Int)/lengthAfter">lengthAfter</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><br/><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="set-ellipsize.html">setEllipsize</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><s><span class="identifier">setEllipsize</span></s><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$setEllipsize(android.text.TextUtils.TruncateAt)/where">where</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/text/TextUtils/TruncateAt.html"><span class="identifier">TruncateAt</span></a><span class="symbol">?</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="set-max-lines.html">setMaxLines</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">open</span> <span class="keyword">fun </span><s><span class="identifier">setMaxLines</span></s><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$setMaxLines(kotlin.Int)/maxLines">maxLines</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
<tr>
<td markdown="1">

<a href="toggle.html">toggle</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">toggle</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView$toggle(kotlin.Boolean)/withAnimation">withAnimation</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a>&nbsp;<span class="symbol">=</span>&nbsp;true<span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html"><span class="identifier">Boolean</span></a></code></div>

<a href="expand.html">Expands</a> this ExpandableTextView if the <a href="state.html">state</a> is <a href="-state/-collapsed.html">Collapsed</a>,
<a href="collapse.html">collapses</a> if the <a href="state.html">state</a> is <a href="-state/-expanded.html">Expanded</a> and does nothing otherwise.


</td>
</tr>
<tr>
<td markdown="1">

<a href="update-state.html">updateState</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">updateState</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
</tbody>
</table>
