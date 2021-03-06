package tools;

import com.example.dentool.NewPatient;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class MyDrawerFiveButtonDecay extends View {

	private Paint top, right, left, bottom, border, inner;
	int mRadius = 100;
	final String orange = "#f99d11";
	final int WHITE = Color.WHITE;
	final int ORANGE = Color.parseColor(orange);
	int[] initalColors = new int[5];
	Boolean[] status;
	private int index;

	// i is the index of the tooth in the teeth array
	public MyDrawerFiveButtonDecay(Context context, int i) {
		super(context);
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
		top = new Paint();
		right = new Paint();
		border = new Paint();
		left = new Paint();
		bottom = new Paint();
		inner = new Paint();
		
		// init the state from the tooth object
		for (int i = 0; i < 5; i++) {
			if (NewPatient.patient.getTeeth()[index].getDecay()[i]) {
				initalColors[i] = ORANGE;
			}
			else {
				initalColors[i] = WHITE;
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
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN: {
					float x = event.getX();
					float y = event.getY();
					
					float centerX = (v.getWidth() / 2);
					float centerY = (v.getHeight() / 2);
					
					status = NewPatient.patient.getTeeth()[index].getDecay();
					
					if (pitagoras(x, y, centerX, centerY) < (float) (mRadius / 1.5)) {
						if (!status[0]) {
							inner.setColor(ORANGE);
							NewPatient.patient.getTeeth()[index].setDecay(
									new Boolean[] {!status[0], status[1], status[2], status[3],status[4]});
							
						} else {
							inner.setColor(WHITE);
							NewPatient.patient.getTeeth()[index].setDecay(
									new Boolean[] {!status[0], status[1], status[2], status[3],status[4]});
						}
					} else {
						if ((y < (centerY - mRadius)) && (y > (centerY - mRadius - mRadius/1.35f)) && (x > (centerX - mRadius) && (x < (centerX + mRadius)))) {
							if (!status[1]) {
								top.setColor(ORANGE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], !status[1], status[2], status[3],status[4]});
							} else {
								top.setColor(WHITE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], !status[1], status[2], status[3],status[4]});
							}
						} else if ((x > (centerX + mRadius)) && (x < (centerX + mRadius + mRadius/1.35f)) && (y > (centerY - mRadius) && (y < (centerY + mRadius)))) {
							if (!status[2]) {
								right.setColor(ORANGE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], status[1], !status[2], status[3],status[4]});
							} else {
								right.setColor(WHITE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], status[1], !status[2], status[3],status[4]});
							}
						} else if ((y > (centerY + mRadius/1.35)) && (y < (centerY + mRadius + mRadius/1.35f)) && (x > (centerX - mRadius) && (x < (centerX + mRadius)))) {							if (!status[3]) {
								bottom.setColor(ORANGE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], status[1], status[2], !status[3],status[4]});
							} else {
								bottom.setColor(WHITE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], status[1], status[2], !status[3],status[4]});
							}
						} else if ((x < (centerX - mRadius/1.35)) && (x > (centerX - mRadius - mRadius/1.35f)) && (y > (centerY - mRadius) && (y < (centerY + mRadius)))) {
							if (!status[4]) {
								left.setColor(ORANGE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], status[1], status[2], status[3], !status[4]});
							} else {
								left.setColor(WHITE);
								NewPatient.patient.getTeeth()[index].setDecay(
										new Boolean[] {status[0], status[1], status[2], status[3], !status[4]});
							}
						}
					}
					v.invalidate();
					return true;					
				}
				case MotionEvent.ACTION_UP: {
					// nada
					break;
				}
				}
				return false;
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
