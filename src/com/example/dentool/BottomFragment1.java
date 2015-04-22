package com.example.dentool;

import java.util.ArrayList;

import tools.HorizontalLayout;
import tools.MissingTeethAdapter;
import tools.Patient;
import tools.Tooth;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment1 extends Fragment {
	String title;
	int page;
	Patient patient;
	HorizontalLayout topList;
	HorizontalLayout bottomList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.bottom_fragment_1, container, false);

		topList = (HorizontalLayout) view.findViewById(R.id.top_mouth);
		bottomList = (HorizontalLayout) view.findViewById(R.id.bottom_mouth);
		
		ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		for (int i = 0; i < 16; i++) {
			top.add(NewPatient.patient.getTeeth()[i]);
			bottom.add(NewPatient.patient.getTeeth()[i + 16]);
		}
		
		MissingTeethAdapter topAdapter = new MissingTeethAdapter(getActivity(), R.layout.missing_teeth_layout, top, 0);
		topList.generateLayout(topAdapter);
		
		MissingTeethAdapter bottomAdapter = new MissingTeethAdapter(getActivity(), R.layout.missing_teeth_layout, bottom, 1);
		bottomList.generateLayout(bottomAdapter);
		
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

}
