package tm.charlie.expandabletextview.demo

import android.support.v7.widget.CardView
import android.util.TypedValue
import android.view.View
import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

inline fun ViewManager.cardView(init:  (@AnkoViewDslMarker CardView).() -> Unit) = ankoView({ CardView(it) }, 0, init)

fun View.getString(resId: Int): String = context.getString(resId)

/** Adds ripple effect on view. */
inline fun View.makeClickable(crossinline onClick: View.() -> Unit) {
	val outValue = TypedValue()
	context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
	backgroundResource = outValue.resourceId//android.R.attr.selectableItemBackground
	onClick{ onClick() }
}