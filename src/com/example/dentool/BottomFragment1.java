package com.example.dentool;

import tools.Patient;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class BottomFragment1 extends Fragment implements OnCheckedChangeListener {
	String title;
	int page;
	Patient patient;
	ToggleButton b1;
	ToggleButton b2;
	TextView t1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.bottom_fragment_1, container, false);

		b1 = (ToggleButton) view.findViewById(R.id.tb1);
		b2 = (ToggleButton) view.findViewById(R.id.tb2);
		b1.setOnCheckedChangeListener(this);
		b2.setOnCheckedChangeListener(this);
		
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
			if (!NewPatient.patient.getTeeth()[0].getExisting()) {
				buttonView.setBackgroundResource(R.drawable.tooth);
				NewPatient.patient.getTeeth()[0].setExisting(true);
			} else {
				buttonView.setBackgroundResource(Color.TRANSPARENT);
				NewPatient.patient.getTeeth()[0].setExisting(false);
			}
		case (R.id.tb2):
			if (!NewPatient.patient.getTeeth()[1].getExisting()) {
				buttonView.setBackgroundResource(R.drawable.tooth);
				NewPatient.patient.getTeeth()[1].setExisting(true);
			} else {
				buttonView.setBackgroundResource(Color.TRANSPARENT);
				NewPatient.patient.getTeeth()[1].setExisting(false);
			}
		}
	}


}
