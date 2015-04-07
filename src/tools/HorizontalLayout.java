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

}
