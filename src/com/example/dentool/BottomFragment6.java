package com.example.dentool;

import java.util.ArrayList;

import tools.HorizontalLayout;
import tools.ImplantsAdapter;
import tools.Tooth;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment6 extends Fragment{
	
	String title;
	int page;
	private HorizontalLayout topList;
	private HorizontalLayout bottomList;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.bottom_fragment_6, container, false);
    	topList = (HorizontalLayout) view.findViewById(R.id.top_mouth_implants);
		bottomList = (HorizontalLayout) view.findViewById(R.id.bottom_mouth_implants);
		
		ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		for (int i = 0; i < 16; i++) {
			top.add(NewPatient.patient.getTeeth()[i]);
			bottom.add(NewPatient.patient.getTeeth()[i + 16]);
		}
		
		ImplantsAdapter topAdapter = new ImplantsAdapter(getActivity(), R.layout.implants_layout, top, 0);
		topList.generateLayout(topAdapter);
		
		ImplantsAdapter bottomAdapter = new ImplantsAdapter(getActivity(), R.layout.implants_layout, bottom, 1);
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
	public static BottomFragment6 newInstance(int page, String title){
		BottomFragment6 fragment = new BottomFragment6();
		Bundle args = new Bundle();
		
		args.putString("title", title);
    	args.putInt("int", page);
    	
		
		fragment.setArguments(args);
		
		return fragment;
	}
	
}
