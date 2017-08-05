package tm.charlie.expandabletextview.demo

import android.support.test.espresso.Espresso.pressBack
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * */
@RunWith(AndroidJUnit4::class)
class ConfigChangeTest: ITest {
	@Rule @JvmField
	val mActivityRule = ActivityTestRule<KotlinActivity>(KotlinActivity::class.java)
	
	@Test fun orientationChangeTest() {
		// In Kotlin Activity
		clickOnExpandableTextView()
		checkIfExpanded()
		
		rotateLandscape()
		checkIfExpanded()
		
		clickOnView(currentActivity.getString(R.string.open_java_activity))
		
		// In Java Activity
		clickOnExpandableTextView()
		checkIfExpanded()
		
		rotateLandscape()
		checkIfExpanded()
		
		clickOnExpandableTextView()
		checkIfCollapsed()
		
		pressBack()
		checkIfExpanded()
		
		// In Kotlin Activity
		rotatePortrait()
		checkIfExpanded()
		
		clickOnExpandableTextView()
		checkIfCollapsed()
	}
	
	@Test fun orientationStateChangeTest(){
		clickOnExpandableTextView()
		checkIfExpanded()
		
		selectSpinnerItem(R.id.spinner_collapsed_lines, 0)// 1
		checkIfExpanded()
		
		selectSpinnerItem(R.id.spinner_demo_text, 1)// "2 lines text in portrait, 1 line in landscape"
		checkIfExpanded()
		
		rotateLandscape(1000)
		checkIfStatic()
		
		rotatePortrait()
		checkIfCollapsed() // Should it be Expanded?
	}
}