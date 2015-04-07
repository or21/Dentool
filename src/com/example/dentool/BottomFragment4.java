package com.example.dentool;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomFragment4 extends Fragment{
	
	String title;
	int page;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View view = inflater.inflate(R.layout.bottom_fragment_4, container, false);
    	
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
	public static BottomFragment4 newInstance(int page, String title){
		BottomFragment4 fragment = new BottomFragment4();
		Bundle args = new Bundle();
		
		args.putString("title", title);
    	args.putInt("int", page);
    	
		
		fragment.setArguments(args);
		
		return fragment;
	}
	
}
