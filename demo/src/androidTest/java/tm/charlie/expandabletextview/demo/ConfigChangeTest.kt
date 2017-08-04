package tm.charlie.expandabletextview.demo

import android.support.test.espresso.Espresso.pressBack
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * You may need to run this test multiple times if it fails,
 * because of the short delay after rotation.
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
}