package tm.charlie.expandabletextview.demo

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.os.SystemClock
import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.jetbrains.anko.find
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tm.charlie.expandabletextview.ExpandableTextView
import android.app.Activity
import android.support.test.runner.lifecycle.Stage
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.InstrumentationRegistry.getInstrumentation
import kotlin.properties.Delegates


@SmallTest
@RunWith(AndroidJUnit4::class)
class ConfigChangeInstrumentedTest {
	@Rule @JvmField
	val mActivityRule = ActivityTestRule<KotlinActivity>(KotlinActivity::class.java)
	
	@Test fun quickOrientationTest() {
		clickOnView(R.id.expandable_textview)
		rotateLandscape(400)
		checkIfExpanded()
	}
	
	@Test fun fullOrientationTest() {
		// In Kotlin Activity
		clickOnView(R.id.expandable_textview)
		checkIfExpanded()
		
		rotateLandscape()
		checkIfExpanded()
		
		clickOnView("Open Java Activity")
		
		// In Java Activity
		clickOnView(R.id.toggle_expand)
		checkIfExpanded()
		
		rotateLandscape()
		checkIfExpanded()
		
		clickOnView(R.id.expandable_textview)
		checkIfCollapsed()
		
		pressBack()
		checkIfExpanded()
		
		// In Kotlin Activity
		rotatePortrait()
		checkIfExpanded()
		
		clickOnView(R.id.toggle_expand)
		checkIfCollapsed()
	}
	
	// Helper functions
	val actionDelay = 500L
	
	fun checkIfExpanded() = assertTrue(textIsExpanded)
	fun checkIfCollapsed() = assertFalse(textIsExpanded)
	val textIsExpanded get() = currentActivity.find<ExpandableTextView>(R.id.expandable_textview).isExpanded
	
	fun clickOnView(@IdRes viewId: Int) {
		SystemClock.sleep(actionDelay)
		onView(withId(viewId)).perform(click())!!
	}
	
	fun clickOnView(viewText: String) {
		SystemClock.sleep(actionDelay)
		onView(withText(viewText)).perform(click())!!
	}
	
	fun rotateLandscape(delay: Long = 200) {
		currentActivity.requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE
		SystemClock.sleep(delay)
	}
	
	fun rotatePortrait(delay: Long = 200) {
		currentActivity.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
		SystemClock.sleep(delay)
	}
	
	val currentActivity: Activity get() {
		var currentActivity: Activity by Delegates.notNull()
		getInstrumentation().runOnMainSync {
			val resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)
			for (act in resumedActivity) {
				currentActivity = act
				break
			}
		}
		return currentActivity
	}
}