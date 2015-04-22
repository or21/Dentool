package tools;

import java.util.HashMap;

import tools.Tooth.State;

import com.example.dentool.NewPatient;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyDrawerFiveButtonFillings extends View {

	private Context context;

	private Paint top, right, left, bottom, border, inner;
	int mRadius = 100;
	final String blue = "#056faa";
	final String lightBlue = "#b1ecfc";
	final String brown = "#bf6102";
	final int WHITE = Color.WHITE;
	final int BLUE = Color.parseColor(blue);
	final int LIGHTBLUE = Color.parseColor(lightBlue);
	final int BROWN = Color.parseColor(brown);
	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	State[] status;
	State[] enumList = {State.NULL,State.EXISTING,State.DEFECTIVE,State.NOTURGENT};
	String[] items = {"NULL", "EXISTING", "DEFECTIVE", "NOT URGENT"};
	private int index;
	int afterChoose;
	private int[] initalColors = new int[5];

	// i is the index of the tooth in the teeth array
	public MyDrawerFiveButtonFillings(Context context, int i) {
		super(context);
		this.context = context;
		this.index = i;
		if (NewPatient.patient.getTeeth()[index].getExisting()) {
			initPaint();
		}
		else {
			initPaintWithoutTooth();
		}
	}

	private void initPaintWithoutTooth() {
		top = new Paint();
		right = new Paint();
		border = new Paint();
		left = new Paint();
		bottom = new Paint();
		inner = new Paint();
		
		int color = R.color.holo_blue_light;
		
		top.setColor(color);
		top.setStrokeWidth(mRadius/1.35f);
        top.setAntiAlias(true);
        top.setStyle(Paint.Style.STROKE);
        
        right.setColor(color);
        right.setStrokeWidth(mRadius/1.35f);
        right.setAntiAlias(true);
        right.setStyle(Paint.Style.STROKE);
        
        left.setColor(color);
        left.setStrokeWidth(mRadius/1.35f);
        left.setAntiAlias(true);
        left.setStyle(Paint.Style.STROKE);
        
        bottom.setColor(color);
        bottom.setStrokeWidth(mRadius/1.35f);
        bottom.setAntiAlias(true);
        bottom.setStyle(Paint.Style.STROKE);
        
        border.setColor(color);
        border.setStrokeWidth(mRadius/1.35f + 10);
        border.setAntiAlias(true);
        border.setStyle(Paint.Style.STROKE);
        
        inner.setColor(color);
        inner.setStyle(Paint.Style.FILL);
	}

	private void initPaint() {
		map.put(0, WHITE);
		map.put(1, BLUE);
		map.put(2, BROWN);
		map.put(3, LIGHTBLUE);
		top = new Paint();
		right = new Paint();
		border = new Paint();
		
		left = new Paint();
		bottom = new Paint();
		inner = new Paint();
		
		// initialize the state from the tooth object
		for (int i = 0; i < 5; i++) {
			State currState = NewPatient.patient.getTeeth()[index].getFillings()[i];
			if (currState.equals(enumList[0])) {
				initalColors[i] = WHITE;
			} else 	if (currState.equals(enumList[1])) {
				initalColors[i] = BLUE;
			} else 	if (currState.equals(enumList[2])) {
				initalColors[i] = BROWN;
			} else 	if (currState.equals(enumList[3])) {
				initalColors[i] = LIGHTBLUE;
			}
				
		}
        
		top.setColor(initalColors[1]);
		top.setStrokeWidth(mRadius/1.35f);
        top.setAntiAlias(true);
        top.setStyle(Paint.Style.STROKE);
        
        right.setColor(initalColors[2]);
        right.setStrokeWidth(mRadius/1.35f);
        right.setAntiAlias(true);
        right.setStyle(Paint.Style.STROKE);
        
        left.setColor(initalColors[4]);
        left.setStrokeWidth(mRadius/1.35f);
        left.setAntiAlias(true);
        left.setStyle(Paint.Style.STROKE);
        
        bottom.setColor(initalColors[3]);
        bottom.setStrokeWidth(mRadius/1.35f);
        bottom.setAntiAlias(true);
        bottom.setStyle(Paint.Style.STROKE);
        
        border.setColor(Color.BLACK);
        border.setStrokeWidth(mRadius/1.35f + 10);
        border.setAntiAlias(true);
        border.setStyle(Paint.Style.STROKE);
        
        inner.setColor(initalColors[0]);
        inner.setStyle(Paint.Style.FILL);
        
        this.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(final View v, final MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					
					final float x = event.getX();
					final float y = event.getY();
					
					final float centerX = (v.getWidth() / 2);
					final float centerY = (v.getHeight() / 2);
					
					AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
			        builder.setSingleChoiceItems(items, 0, null)
			        .setItems(items, new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int whichButton) {
			                
			                afterChoose = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
							
							status = NewPatient.patient.getTeeth()[index].getFillings();
							
							if (pitagoras(x, y, centerX, centerY) < (float) (mRadius / 1.5)) {
									inner.setColor(map.get(afterChoose));
									v.invalidate();
									NewPatient.patient.getTeeth()[index].setFillings(
											new State[] {enumList[afterChoose], status[1], status[2], status[3],status[4]});
							} else {
								if ((y < (centerY - mRadius)) && (y > (centerY - mRadius - mRadius/1.35f)) && (x > (centerX - mRadius) && (x < (centerX + mRadius)))) {
										top.setColor(map.get(afterChoose));
										v.invalidate();
										NewPatient.patient.getTeeth()[index].setFillings(
												new State[] {status[0], enumList[afterChoose], status[2], status[3],status[4]});
								} else if ((x > (centerX + mRadius)) && (x < (centerX + mRadius + mRadius/1.35f)) && (y > (centerY - mRadius) && (y < (centerY + mRadius)))) {
										right.setColor(map.get(afterChoose));
										v.invalidate();
										NewPatient.patient.getTeeth()[index].setFillings(
												new State[] {status[0], status[1], enumList[afterChoose], status[3],status[4]});
								} else if ((y > (centerY + mRadius/1.35)) && (y < (centerY + mRadius + mRadius/1.35f)) && (x > (centerX - mRadius) && (x < (centerX + mRadius)))) {							
										bottom.setColor(map.get(afterChoose));
										v.invalidate();
										NewPatient.patient.getTeeth()[index].setFillings(
												new State[] {status[0], status[1], status[2], enumList[afterChoose], status[4]});
								} else if ((x < (centerX - mRadius/1.35)) && (x > (centerX - mRadius - mRadius/1.35f)) && (y > (centerY - mRadius) && (y < (centerY + mRadius)))) {
										left.setColor(map.get(afterChoose));
										v.invalidate();
										NewPatient.patient.getTeeth()[index].setFillings(
												new State[] {status[0], status[1], status[2], status[3], enumList[afterChoose]});
								}
							}
			                dialog.dismiss();
			            }
			        })
			        .create().show();
					
				}
				case MotionEvent.ACTION_UP: {
					// nada
					v.invalidate();
					break;
				}
				}
				return true;
			}
		});
        
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		final RectF rect = new RectF();
		//Example values
        rect.set(getWidth()/2- mRadius, getHeight()/2 - mRadius, getWidth()/2 + mRadius, getHeight()/2 + mRadius); 
        canvas.drawCircle(getWidth()/2, getHeight()/2, (float) (mRadius / 1.5), inner);
        
        canvas.drawArc(rect, 45, 90, false, border);
        canvas.drawArc(rect, 135, 90, false, border);
        canvas.drawArc(rect, 225, 90, false, border);
        canvas.drawArc(rect, 315, 90, false, border);
        
        canvas.drawArc(rect, 45, 90, false, bottom);
        canvas.drawArc(rect, 135, 90, false, left);
        canvas.drawArc(rect, 225, 90, false, top);
        canvas.drawArc(rect, 315, 90, false, right);

	}
	
	private double pitagoras(float x, float y, float centerX, float centerY){
		float distanceX = x - centerX;
		float distanceY = y - centerY;
		return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
	}
	
}
