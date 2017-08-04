package tm.charlie.expandabletextview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tm.charlie.expandabletextview.ExpandableTextView;
import tm.charlie.expandabletextview.ExpandableTextView.State;

import static org.jetbrains.anko.ToastsKt.toast;
import static tm.charlie.expandabletextview.demo.ExtensionsKt.makeClickable;

public class JavaActivity extends AppCompatActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setTitle(getClass().getSimpleName());
		setContentView(R.layout.java_activity_main);
		setupExpandableTextView();
	}
	
	void setupExpandableTextView(){
		final ExpandableTextView expandableTextView = findViewById(R.id.expandable_textview);
		
		// Make ExpandableTextView expand/collapse on click
		makeClickable(expandableTextView, new Function1<View, Unit>(){
			// OnClickListener
			@Override
			public Unit invoke(View view){
				expandableTextView.toggle();
				return null;
			}
		});
		expandableTextView.onStateChange(new Function3<ExpandableTextView, State, State, Unit>(){
			@Override
			public Unit invoke(ExpandableTextView expandableTextView, State oldState, State newState){
				toast(getApplicationContext(), oldState.toString() + " -> " + newState.toString());
				return null;
			}
		});
	}
}
