package com.example.dentool;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment1 extends Fragment{
	String title;
	int page;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.bottom_fragment_1, container, false);
    	
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
