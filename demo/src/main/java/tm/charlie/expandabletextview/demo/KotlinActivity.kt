package tm.charlie.expandabletextview.demo

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.widget.ToggleButton
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import tm.charlie.expandabletextview.ExpandableTextView
import tm.charlie.expandabletextview.expandableTextView
import kotlin.properties.Delegates

class KotlinActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		title = this::class.java.simpleName
		KotlinActivityUi().setContentView(this)
	}
	
	// Separate layout from activity logic
	private class KotlinActivityUi: AnkoComponent<KotlinActivity> {
		override fun createView(ui: AnkoContext<KotlinActivity>) = with(ui) {
			scrollView {
				verticalLayout {
					var expandableText: ExpandableTextView by Delegates.notNull()
					var toggleExpand: ToggleButton by Delegates.notNull()
					
					cardView {
						lparams { margin = dip(16) }
						expandableText = expandableTextView(text = ctx.getString(R.string.lipsum_long)) {
							lparams { margin = dip(8) }
							id = R.id.expandable_textview// provide consistent id for saving expanded state
							maxLines = 3
							textSize = 17f
							textColor = Color.BLACK
							typeface = ResourcesCompat.getFont(context, R.font.lato_black)
							animationDuration = 300
							
							makeClickable{
								if (toggle())// try toggling
									toggleExpand.toggle()
							}
						}
					}
					toggleExpand = toggleButton {
						id = R.id.toggle_expand// provide consistent id for saving expanded state
						textOn = getString(R.string.toggle_on)
						textOff = getString(R.string.toggle_off)
						isChecked = false // apply off text
						onClick {
							// sync toggle button and expandableTextView states
							if (!expandableText.isAnimating) expandableText.toggle()
							else toggle()//revert toggle
						}
					}
					button(text = getString(R.string.open_java_activity)) {
						onClick { startActivity<JavaActivity>() }
					}
				}
			}
		}
	}
}