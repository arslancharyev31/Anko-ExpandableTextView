---
title: ExpandableTextView.SavedState - expandable-textview
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../../index.html">expandable-textview</a> / <a href="../../index.html">tm.charlie.expandabletextview</a> / <a href="../index.html">ExpandableTextView</a> / <a href=".">SavedState</a></div>

# SavedState

<div class="signature"><code><span class="keyword">protected</span> <span class="keyword">class </span><span class="identifier">SavedState</span>&nbsp;<span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/view/View/BaseSavedState.html"><span class="identifier">BaseSavedState</span></a></code></div>

Protected class that is being used to save and restore <code>ExpandedTextView</code>'s state on configuration change

### Constructors

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-init-.html">&lt;init&gt;</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="identifier">SavedState</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView.SavedState$<init>(android.os.Parcelable)/superState">superState</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/os/Parcelable.html"><span class="identifier">Parcelable</span></a><span class="symbol">)</span></code></div>

<div class="signature"><code><span class="identifier">SavedState</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView.SavedState$<init>(android.os.Parcel)/source">source</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/os/Parcel.html"><span class="identifier">Parcel</span></a><span class="symbol">)</span></code></div>

</td>
</tr>
</tbody>
</table>

### Properties

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="state.html">state</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">var </span><span class="identifier">state</span><span class="symbol">: </span><a href="../-state/index.html"><span class="identifier">State</span></a></code></div>

</td>
</tr>
</tbody>
</table>

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="write-to-parcel.html">writeToParcel</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">writeToParcel</span><span class="symbol">(</span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView.SavedState$writeToParcel(android.os.Parcel, kotlin.Int)/dest">dest</span><span class="symbol">:</span>&nbsp;<a href="https://developer.android.com/reference/android/os/Parcel.html"><span class="identifier">Parcel</span></a><span class="symbol">, </span><span class="parameterName" id="tm.charlie.expandabletextview.ExpandableTextView.SavedState$writeToParcel(android.os.Parcel, kotlin.Int)/flags">flags</span><span class="symbol">:</span>&nbsp;<a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html"><span class="identifier">Int</span></a><span class="symbol">)</span><span class="symbol">: </span><a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html"><span class="identifier">Unit</span></a></code></div>

</td>
</tr>
</tbody>
</table>

### Companion Object Properties

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">

<a href="-c-r-e-a-t-o-r.html">CREATOR</a>


</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">val </span><span class="identifier">CREATOR</span><span class="symbol">: </span><a href="https://developer.android.com/reference/android/os/Parcelable/Creator.html"><span class="identifier">Creator</span></a><span class="symbol">&lt;</span><span class="identifier">SavedState</span><span class="symbol">&gt;</span></code></div>

</td>
</tr>
</tbody>
</table>
