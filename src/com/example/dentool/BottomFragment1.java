package com.example.dentool;

import tools.Patient;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class BottomFragment1 extends Fragment implements OnCheckedChangeListener {
	String title;
	int page;
	Patient patient;
	ToggleButton b1;
	ToggleButton b2;
	TextView t1;
	private ToggleButton b3;
	private ToggleButton b4;
	private ToggleButton b5;
	private ToggleButton b6;
	private ToggleButton b7;
	private ToggleButton b8;
	private ToggleButton b9;
	private ToggleButton b10;
	private ToggleButton b11;
	private ToggleButton b12;
	private ToggleButton b13;
	private ToggleButton b14;
	private ToggleButton b15;
	private ToggleButton b16;
	private ToggleButton b17;
	private ToggleButton b18;
	private ToggleButton b19;
	private ToggleButton b20 ;
	private ToggleButton b21;
	private ToggleButton b22;
	private ToggleButton b23;
	private ToggleButton b24;
	private ToggleButton b25;
	private ToggleButton b27;
	private ToggleButton b26;
	private ToggleButton b29;
	private ToggleButton b28;
	private ToggleButton b30;
	private ToggleButton b31;
	private ToggleButton b32;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.bottom_fragment_1, container, false);

		b1 = (ToggleButton) view.findViewById(R.id.tb1);
		b2 = (ToggleButton) view.findViewById(R.id.tb2);
		b3 = (ToggleButton) view.findViewById(R.id.tb3);
		b4 = (ToggleButton) view.findViewById(R.id.tb4);
		b5 = (ToggleButton) view.findViewById(R.id.tb5);
		b6 = (ToggleButton) view.findViewById(R.id.tb6);
		b7 = (ToggleButton) view.findViewById(R.id.tb7);
		b8 = (ToggleButton) view.findViewById(R.id.tb8);
		b9 = (ToggleButton) view.findViewById(R.id.tb9);
		b10 = (ToggleButton) view.findViewById(R.id.tb10);
		b11 = (ToggleButton) view.findViewById(R.id.tb11);
		b12 = (ToggleButton) view.findViewById(R.id.tb12);
		b13 = (ToggleButton) view.findViewById(R.id.tb13);
		b14 = (ToggleButton) view.findViewById(R.id.tb14);
		b15 = (ToggleButton) view.findViewById(R.id.tb15);
		b16 = (ToggleButton) view.findViewById(R.id.tb16);
		b17 = (ToggleButton) view.findViewById(R.id.tb17);
		b18 = (ToggleButton) view.findViewById(R.id.tb18);
		b19 = (ToggleButton) view.findViewById(R.id.tb19);
		b20 = (ToggleButton) view.findViewById(R.id.tb20);
		b21 = (ToggleButton) view.findViewById(R.id.tb21);
		b22 = (ToggleButton) view.findViewById(R.id.tb22);
		b23 = (ToggleButton) view.findViewById(R.id.tb23);
		b24 = (ToggleButton) view.findViewById(R.id.tb24);
		b25 = (ToggleButton) view.findViewById(R.id.tb25);
		b26 = (ToggleButton) view.findViewById(R.id.tb26);
		b27 = (ToggleButton) view.findViewById(R.id.tb27);
		b28 = (ToggleButton) view.findViewById(R.id.tb28);
		b29 = (ToggleButton) view.findViewById(R.id.tb29);
		b30 = (ToggleButton) view.findViewById(R.id.tb30);
		b31 = (ToggleButton) view.findViewById(R.id.tb31);
		b32 = (ToggleButton) view.findViewById(R.id.tb32);
		b1.setOnCheckedChangeListener(this);
		b2.setOnCheckedChangeListener(this);
		b3.setOnCheckedChangeListener(this);
		b4.setOnCheckedChangeListener(this);
		b5.setOnCheckedChangeListener(this);
		b6.setOnCheckedChangeListener(this);
		b7.setOnCheckedChangeListener(this);
		b8.setOnCheckedChangeListener(this);
		b9.setOnCheckedChangeListener(this);
		b10.setOnCheckedChangeListener(this);
		b11.setOnCheckedChangeListener(this);
		b12.setOnCheckedChangeListener(this);
		b13.setOnCheckedChangeListener(this);
		b14.setOnCheckedChangeListener(this);
		b15.setOnCheckedChangeListener(this);
		b16.setOnCheckedChangeListener(this);
		b17.setOnCheckedChangeListener(this);
		b18.setOnCheckedChangeListener(this);
		b19.setOnCheckedChangeListener(this);
		b20.setOnCheckedChangeListener(this);
		b21.setOnCheckedChangeListener(this);
		b22.setOnCheckedChangeListener(this);
		b23.setOnCheckedChangeListener(this);
		b24.setOnCheckedChangeListener(this);
		b25.setOnCheckedChangeListener(this);
		b26.setOnCheckedChangeListener(this);
		b27.setOnCheckedChangeListener(this);
		b28.setOnCheckedChangeListener(this);
		b29.setOnCheckedChangeListener(this);
		b30.setOnCheckedChangeListener(this);
		b31.setOnCheckedChangeListener(this);
		b32.setOnCheckedChangeListener(this);

		return view;
	}

	// Store instance variables based on arguments passed
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		page = getArguments().getInt("int", 0);
		title = getArguments().getString("title");
	}

	//set a title for this fragment
	public static BottomFragment1 newInstance(int page, String title){
		BottomFragment1 fragment = new BottomFragment1();
		Bundle args = new Bundle();

		args.putString("title", title);
		args.putInt("int", page);

		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		switch (buttonView.getId()) {
		case (R.id.tb1):
			changeStatus(buttonView, 0, R.drawable.tooth);
		case (R.id.tb2):
			changeStatus(buttonView, 1, R.drawable.tooth);
		case (R.id.tb3):
			changeStatus(buttonView, 2, R.drawable.tooth);
		case (R.id.tb4):
			changeStatus(buttonView, 3, R.drawable.tooth);
		case (R.id.tb5):
			changeStatus(buttonView, 4, R.drawable.tooth);
		case (R.id.tb6):
			changeStatus(buttonView, 5, R.drawable.tooth);
		case (R.id.tb7):
			changeStatus(buttonView, 6, R.drawable.tooth);
		case (R.id.tb8):
			changeStatus(buttonView, 7, R.drawable.tooth);
		case (R.id.tb9):
			changeStatus(buttonView, 8, R.drawable.tooth);
		case (R.id.tb10):
			changeStatus(buttonView, 9, R.drawable.tooth);
		case (R.id.tb11):
			changeStatus(buttonView, 10, R.drawable.tooth);
		case (R.id.tb12):
			changeStatus(buttonView, 11, R.drawable.tooth);
		case (R.id.tb13):
			changeStatus(buttonView, 12, R.drawable.tooth);
		case (R.id.tb14):
			changeStatus(buttonView, 13, R.drawable.tooth);
		case (R.id.tb15):
			changeStatus(buttonView, 14, R.drawable.tooth);
		case (R.id.tb16):
			changeStatus(buttonView, 15, R.drawable.tooth);
		case (R.id.tb17):
			changeStatus(buttonView, 16, R.drawable.tooth);
		case (R.id.tb18):
			changeStatus(buttonView, 17, R.drawable.tooth);
		case (R.id.tb19):
			changeStatus(buttonView, 18, R.drawable.tooth);
		case (R.id.tb20):
			changeStatus(buttonView, 19, R.drawable.tooth);
		case (R.id.tb21):
			changeStatus(buttonView, 20, R.drawable.tooth);
		case (R.id.tb22):
			changeStatus(buttonView, 21, R.drawable.tooth);
		case (R.id.tb23):
			changeStatus(buttonView, 22, R.drawable.tooth);
		case (R.id.tb24):
			changeStatus(buttonView, 23, R.drawable.tooth);
		case (R.id.tb25):
			changeStatus(buttonView, 24, R.drawable.tooth);
		case (R.id.tb26):
			changeStatus(buttonView, 25, R.drawable.tooth);
		case (R.id.tb27):
			changeStatus(buttonView, 26, R.drawable.tooth);
		case (R.id.tb28):
			changeStatus(buttonView, 27, R.drawable.tooth);
		case (R.id.tb29):
			changeStatus(buttonView, 28, R.drawable.tooth);
		case (R.id.tb30):
			changeStatus(buttonView, 29, R.drawable.tooth);
		case (R.id.tb31):
			changeStatus(buttonView, 30, R.drawable.tooth);
		case (R.id.tb32):
			changeStatus(buttonView, 31, R.drawable.tooth);
		}
	}

private void changeStatus(CompoundButton buttonView, int index, int r) {
	if (!NewPatient.patient.getTeeth()[index].getExisting()) {
		buttonView.setBackgroundResource(r);
		NewPatient.patient.getTeeth()[index].setExisting(true);
	} else {
		buttonView.setBackgroundResource(Color.TRANSPARENT);
		NewPatient.patient.getTeeth()[index].setExisting(false);
	}
}
}
