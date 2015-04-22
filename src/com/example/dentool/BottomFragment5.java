package com.example.dentool;

import java.util.ArrayList;

import tools.HorizontalLayout;
import tools.RootTeethAdapter;
import tools.Tooth;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment5 extends Fragment{
	
	String title;
	int page;
	private HorizontalLayout topList;
	private HorizontalLayout bottomList;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.bottom_fragment_5, container, false);
    	topList = (HorizontalLayout) view.findViewById(R.id.top_mouth_roots);
		bottomList = (HorizontalLayout) view.findViewById(R.id.bottom_mouth_roots);
		
		initView();
    	return view;
    }
    
    public void initView(){
    	ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		for (int i = 0; i < 16; i++) {
			top.add(NewPatient.patient.getTeeth()[i]);
			bottom.add(NewPatient.patient.getTeeth()[i + 16]);
		}
		
		topList.removeAllViews();
		RootTeethAdapter topAdapter = new RootTeethAdapter(getActivity(), R.layout.roots_layout, top, 0);
		topList.generateLayout(topAdapter);
		
		bottomList.removeAllViews();
		RootTeethAdapter bottomAdapter = new RootTeethAdapter(getActivity(), R.layout.roots_layout, bottom, 1);
		bottomList.generateLayout(bottomAdapter);
    }
    
    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("int", 0);
        title = getArguments().getString("title");
    }
    
    
	
	//set a title for this fragment
	public static BottomFragment5 newInstance(int page, String title){
		BottomFragment5 fragment = new BottomFragment5();
		Bundle args = new Bundle();
		
		args.putString("title", title);
    	args.putInt("int", page);
    	
		
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public void onResume() {
		initView();
		super.onResume();
	}
}
