package tm.charlie.expandabletextview.demo

import android.os.Build
import android.support.v7.widget.CardView
import android.util.TypedValue
import android.view.View
import android.view.ViewManager
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.custom.ankoView

inline fun ViewManager.cardView(init: CardView.() -> Unit) = ankoView({ CardView(it) }, 0, init)

fun View.getString(resId: Int): String = context.getString(resId)

// Use borderless=true for round views
fun View.makeClickable(borderless: Boolean = false) {
	val outValue = TypedValue()
	val attr =
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && borderless)
				android.R.attr.selectableItemBackgroundBorderless
			else android.R.attr.selectableItemBackground
	
	context.theme.resolveAttribute(attr, outValue, true)
	backgroundResource = outValue.resourceId//android.R.attr.selectableItemBackground
}