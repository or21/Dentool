package com.example.dentool;

import java.util.ArrayList;

import tools.HorizontalLayout;
import tools.Tooth;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment2_part_1 extends Fragment{
	
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
		
		topList.generateDrawingLayout(0);
		
		bottomList.generateDrawingLayout(1);
		
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
	public static BottomFragment2_part_1 newInstance(int page, String title){
		BottomFragment2_part_1 fragment = new BottomFragment2_part_1();
		Bundle args = new Bundle();
		
		args.putString("title", title);
    	args.putInt("int", page);
    	
		
		fragment.setArguments(args);
		
		return fragment;
	}
	
}