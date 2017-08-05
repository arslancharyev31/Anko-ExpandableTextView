package tm.charlie.expandabletextview.demo

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.SystemClock
import android.support.annotation.IdRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage
import org.hamcrest.CoreMatchers
import org.jetbrains.anko.find
import org.junit.Assert.assertTrue
import tm.charlie.expandabletextview.ExpandableTextView
import tm.charlie.expandabletextview.ExpandableTextView.State.*
import kotlin.properties.Delegates

/**
 * Implementation of test functions.
 * All test are meant to be run on 1920x1980 420 dpi device/emulator.
 * You may need to run test involving rotation multiple times if they fail,
 * because of the short delay after rotation.
 * */
interface ITest {
	val actionDelay: Long get() = 0
	val expandableTextView get() = currentActivity.find<ExpandableTextView>(R.id.expandable_textview)
	
	fun checkIfCollapsed() = expandableTextView.apply {
		assertTrue(state == Collapsed)
		assertTrue(lineCount == collapsedLines)
	}
	
	fun checkIfExpanded() = expandableTextView.apply {
		assertTrue(state == Expanded)
		assertTrue(lineCount > collapsedLines)
		assertTrue(lineCount <= expandedLines)
	}
	
	fun checkIfStatic() = expandableTextView.apply {
		assertTrue(state == Static)
		assertTrue(collapsedLines == expandedLines || lineCount <= collapsedLines)
	}
	
	fun clickOnView(@IdRes viewId: Int) {
		SystemClock.sleep(actionDelay)
		Espresso.onView(ViewMatchers.withId(viewId)).perform(ViewActions.click())!!
	}
	
	fun clickOnView(viewText: String) {
		SystemClock.sleep(actionDelay)
		Espresso.onView(ViewMatchers.withText(viewText)).perform(ViewActions.click())!!
	}
	
	fun clickOnExpandableTextView() = clickOnView(R.id.expandable_textview)
	
	fun rotateLandscape(delay: Long = 300) {
		currentActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
		SystemClock.sleep(delay)
	}
	
	fun rotatePortrait(delay: Long = 300) {
		currentActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
		SystemClock.sleep(delay)
	}
	
	fun selectSpinnerItem(id: Int, position: Int) {
		onView(ViewMatchers.withId(id)).perform(click())
		onData(CoreMatchers.anything()).atPosition(position).perform(click())
		SystemClock.sleep(actionDelay)
	}
	
	val currentActivity: Activity get() {
		var currentActivity: Activity by Delegates.notNull()
		InstrumentationRegistry.getInstrumentation().runOnMainSync {
			val resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)
			for (act in resumedActivity) {
				currentActivity = act
				break
			}
		}
		return currentActivity
	}
}