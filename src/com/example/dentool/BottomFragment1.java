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


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.bottom_fragment_1, container, false);

		b1 = (ImageButton) view.findViewById(R.id.imageButton1);

		b1.setOnClickListener(this);
		
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
		if (!NewPatient.patient.getTeeth()[0].getExisting()){
			v.setBackgroundResource(R.drawable.button_selected);
			NewPatient.patient.getTeeth()[0].setExisting(false);
	}
		else{
			v.setBackgroundResource(R.drawable.button_normal);
			NewPatient.patient.getTeeth()[0].setExisting(true);
		}
		}

	


}
