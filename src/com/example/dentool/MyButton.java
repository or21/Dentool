package com.example.dentool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ToggleButton;

public class MyButton extends ToggleButton{
private boolean mChecked = false;
	public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyButton(Context context) {

		
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void init(){
		setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (inBounds(event)){
					mChecked = !mChecked;
					setChecked(mChecked);
				}				
				return true;
			}
		});
	}
	
	private boolean inBounds(MotionEvent event){
		getWidth();
		getHeight();
	}
}
