package tm.charlie.expandabletextview.demo

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewResizeTest: ITest {
	@Rule @JvmField
	val mActivityRule = ActivityTestRule<KotlinActivity>(KotlinActivity::class.java)
	
	@Test fun changeCollapsedLinesTest() {
		selectSpinnerItem(R.id.spinner_collapsed_lines, 0)// "1"
		checkIfCollapsed()
		
		clickOnExpandableTextView()
		checkIfExpanded()
		
		selectSpinnerItem(R.id.spinner_collapsed_lines, 1)// "3"
		checkIfExpanded()
		
		clickOnExpandableTextView()
		checkIfCollapsed()
		
		selectSpinnerItem(R.id.spinner_collapsed_lines, 2)// "Integer.MAX_VALUE"
		checkIfStatic()
		
		clickOnExpandableTextView()
		checkIfStatic()
	}
	
	@Test fun changeExpandedLinesTest() {
		clickOnExpandableTextView()
		checkIfExpanded()
		
		selectSpinnerItem(R.id.spinner_collapsed_lines, 0)// "1"
		checkIfExpanded()
		
		selectSpinnerItem(R.id.spinner_expanded_lines, 1)// "3"
		checkIfExpanded()
		
		clickOnExpandableTextView()
		checkIfCollapsed()
		
		selectSpinnerItem(R.id.spinner_expanded_lines, 0)// "1"
		checkIfStatic()
		
		clickOnExpandableTextView()
		checkIfStatic()
	}
	
	@Test fun changeTextTest(){
		selectSpinnerItem(R.id.spinner_demo_text, 2)// "3 lines text"
		checkIfStatic()
		
		selectSpinnerItem(R.id.spinner_demo_text, 0)// "1 line text"
		checkIfStatic()
		
		selectSpinnerItem(R.id.spinner_demo_text, 3)// "10 lines text"
		checkIfCollapsed()
		
		clickOnExpandableTextView()
		checkIfExpanded()
		
		selectSpinnerItem(R.id.spinner_demo_text, 0)// "1 line text"
		checkIfStatic()
		
		selectSpinnerItem(R.id.spinner_demo_text, 3)// "10 lines text"
		checkIfExpanded()
	}
}