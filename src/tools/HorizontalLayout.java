package tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class HorizontalLayout extends LinearLayout {

	public HorizontalLayout(Context context) {
		super(context);
	}

	public HorizontalLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HorizontalLayout(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public void generateLayout(ArrayAdapter<Tooth> adapter) {
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		params.setMargins(6, 25, 6, 6);

		for (int i = 0; i < adapter.getCount(); i++) {
			View child = adapter.getView(i, null, this);
			child.setLayoutParams(params);
			this.addView(child);
		}
	}

	public void generateDrawingLayout(int line) {

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		params.setMargins(6, 25, 6, 6);
		for (int i = 0; i < 8; i++) {
			MyDrawerFiveButtonDecay child = new MyDrawerFiveButtonDecay(getContext(), i + (line * 8));
			child.setLayoutParams(params);
			child.setIndex(i + (line * 8));
			this.addView(child);
		}
	}
	public void generateDrawingLayoutFillings(int line) {

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		params.setMargins(6, 25, 6, 6);
		for (int i = 0; i < 8; i++) {
			MyDrawerFiveButtonFillings child = new MyDrawerFiveButtonFillings(getContext(), i + (line * 8));
			child.setLayoutParams(params);
			child.setIndex(i + (line * 8));
			this.addView(child);
		}
	}
}	
