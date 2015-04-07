package com.example.dentool;

import tools.Patient;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class BottomFragment1 extends Fragment implements OnClickListener {
	String title;
	int page;
	Patient patient;
	ImageButton b1;
	ImageButton b2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.bottom_fragment_1, container, false);

		b1 = (ImageButton) view.findViewById(R.id.imageButton1);
		b2 = (ImageButton) view.findViewById(R.id.imageButton2);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
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
	public void onClick(View v) {
		switch (v.getId()) {
		case (R.id.imageButton1):
			if (!NewPatient.patient.getTeeth()[0].getExisting()) {
				v.setVisibility(View.VISIBLE);
				NewPatient.patient.getTeeth()[0].setExisting(true);
			} else {
				v.setVisibility(View.INVISIBLE);
				NewPatient.patient.getTeeth()[0].setExisting(false);
			}
		case (R.id.imageButton2):
			if (!NewPatient.patient.getTeeth()[1].getExisting()) {
				v.setVisibility(View.VISIBLE);
				NewPatient.patient.getTeeth()[1].setExisting(true);
			} else {
				v.setVisibility(View.INVISIBLE);
				NewPatient.patient.getTeeth()[1].setExisting(false);
			}
		}

	}


}
