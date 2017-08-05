package tm.charlie.expandabletextview.demo

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.*
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
					lparams { margin = dip(16) }
					var expandableTextView: ExpandableTextView by Delegates.notNull()
					var stateTextView: TextView by Delegates.notNull()
					val lipsum = ctx.getString(R.string.lipsum_long)
					
					cardView {
						useCompatPadding = true
						expandableTextView = expandableTextView(text = lipsum) {
							lparams { margin = dip(8) }
							id = R.id.expandable_textview// provide consistent id for saving expanded state
							textSize = 17f
							textColor = Color.BLACK
							typeface = ResourcesCompat.getFont(context, R.font.lato_black)
							collapsedLines = 3
							animationDuration = 200
							
							onStateChange { oldState, newState ->
								toast("$oldState -> $newState")
								stateTextView.text = newState.toString()
							}
							
							// Make ExpandableTextView expand/collapse on click
							makeClickable { toggle() }
						}
					}
					button(text = getString(R.string.open_java_activity)) { onClick { startActivity<JavaActivity>() } }
					
					linearLayout {
						val lines = arrayOf("1", "3", Integer.MAX_VALUE.toString())
						textView("Collapsed lines:")
						spinner {
							id = R.id.spinner_collapsed_lines
							adapter = ArrayAdapter<String>(ctx, R.layout.support_simple_spinner_dropdown_item, lines)
							setSelection(1)
							onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
								override fun onNothingSelected(parent: AdapterView<*>?) {}
								override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
									expandableTextView.collapsedLines = lines[pos].toInt()
								}
							}
						}.lparams { weight = 1f }
						textView("Expanded lines:")
						spinner {
							id = R.id.spinner_expanded_lines
							adapter = ArrayAdapter<String>(ctx, R.layout.support_simple_spinner_dropdown_item, lines)
							setSelection(2)
							onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
								override fun onNothingSelected(parent: AdapterView<*>?) {}
								override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
									expandableTextView.expandedLines = lines[pos].toInt()
								}
							}
						}.lparams { weight = 1f }
					}
					linearLayout {
						textView("Demo text:")
						spinner {
							id = R.id.spinner_demo_text
							val texts = arrayOf(lipsum.substring(0..30), lipsum.substring(0..70), lipsum.substring(0..100), lipsum)
							adapter = ArrayAdapter<String>(ctx, R.layout.support_simple_spinner_dropdown_item, texts)
							setSelection(texts.size - 1)
							onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
								override fun onNothingSelected(parent: AdapterView<*>?) {}
								override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
									expandableTextView.text = texts[pos]
								}
							}
						}
					}
					stateTextView = textView(text = expandableTextView.state.toString()) {
						textSize = 20f
						gravity = Gravity.CENTER_HORIZONTAL
					}
				}
			}
		}
	}
}