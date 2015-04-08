package com.example.dentool;

import java.util.ArrayList;

import tools.HorizontalLayout;
import tools.Tooth;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment3 extends Fragment{
	
	String title;
	int page;
	private HorizontalLayout topList;
	private HorizontalLayout bottomList;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.bottom_fragment_3, container, false);
    	
		topList = (HorizontalLayout) view.findViewById(R.id.top_mouth_fillings);
		bottomList = (HorizontalLayout) view.findViewById(R.id.bottom_mouth_fillings);
		
		ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		for (int i = 0; i < 8; i++) {
			top.add(NewPatient.patient.getTeeth()[i]);
			bottom.add(NewPatient.patient.getTeeth()[i + 8]);
		}
		
		topList.generateDrawingLayoutFillings(0);
		
		bottomList.generateDrawingLayoutFillings(1);
    	
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
	public static BottomFragment3 newInstance(int page, String title){
		BottomFragment3 fragment = new BottomFragment3();
		Bundle args = new Bundle();
		
		args.putString("title", title);
    	args.putInt("int", page);
		
		fragment.setArguments(args);
		
		return fragment;
	}
	
}
