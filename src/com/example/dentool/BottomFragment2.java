package com.example.dentool;

import java.util.ArrayList;

import tools.DecayAdapter;
import tools.HorizontalLayout;
import tools.MissingTeethAdapter;
import tools.Tooth;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment2 extends Fragment{
	
	HorizontalLayout topList;
	HorizontalLayout bottomList;
	
	String title;
	int page;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.bottom_fragment_2, container, false);
    	
		topList = (HorizontalLayout) view.findViewById(R.id.top_mouth_decay);
		bottomList = (HorizontalLayout) view.findViewById(R.id.bottom_mouth_decay);
		
		ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		for (int i = 0; i < 8; i++) {
			top.add(NewPatient.patient.getTeeth()[i]);
			bottom.add(NewPatient.patient.getTeeth()[i + 8]);
		}
		
		DecayAdapter topAdapter = new DecayAdapter(getActivity(), R.layout.decay_layout, top, R.drawable.decay_001);
		topList.generateLayout(topAdapter);
		
		DecayAdapter bottomAdapter = new DecayAdapter(getActivity(), R.layout.decay_layout, bottom, R.drawable.decay_001);
	
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
	public static BottomFragment2 newInstance(int page, String title){
		BottomFragment2 fragment = new BottomFragment2();
		Bundle args = new Bundle();
		
		args.putString("title", title);
    	args.putInt("int", page);
    	
		
		fragment.setArguments(args);
		
		return fragment;
	}
	
}
