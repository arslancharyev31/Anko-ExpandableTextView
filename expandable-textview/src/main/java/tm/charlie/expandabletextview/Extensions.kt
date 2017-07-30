package tm.charlie.expandabletextview

import android.view.ViewManager
import android.widget.TextView
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

// Public extensions

inline fun ViewManager.expandableTextView(init: (@AnkoViewDslMarker ExpandableTextView).() -> Unit) = expandableTextView("", init)
inline fun ViewManager.expandableTextView(text: String = "", init: (@AnkoViewDslMarker ExpandableTextView).() -> Unit)
		= ankoView(::ExpandableTextView, 0) { setText(text); init() }

// Internal extensions
internal inline val TextView.isEllipsized get() = layout.getEllipsisCount(lineCount - 1) > 0