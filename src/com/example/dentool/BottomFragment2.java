package com.example.dentool;

import java.util.ArrayList;

import tools.HorizontalLayout;
import tools.Tooth;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class BottomFragment2 extends Fragment implements OnClickListener{

	HorizontalLayout topList;
	HorizontalLayout bottomList;

	static String tag;
	int page;

	private int side;
	private Button sideChooser;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.bottom_fragment_2, container, false);
		sideChooser = (Button) view.findViewById(R.id.sides_decay);

		topList = (HorizontalLayout) view.findViewById(R.id.top_mouth_decay);
		bottomList = (HorizontalLayout) view.findViewById(R.id.bottom_mouth_decay);

		sideChooser.setOnClickListener(this);
		return view;
				
	}
	
	// Store instance variables based on arguments passed
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		page = getArguments().getInt("int", 0);
		tag = getArguments().getString("title");
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

	@Override
	public void onClick(View v) {
		ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		if (side == 1) {

			for (int i = 0; i < 8; i++) {
				top.add(NewPatient.patient.getTeeth()[i]);
				bottom.add(NewPatient.patient.getTeeth()[i + 16]);
			}
			topList.removeAllViews();
			topList.generateDrawingLayout(0);
			bottomList.removeAllViews();
			bottomList.generateDrawingLayout(2);
			sideChooser.setText(R.string.right_side);
			side = 0;
		} 
		else {
			for (int i = 0; i < 8; i++) {
				top.add(NewPatient.patient.getTeeth()[i + 8]);
				bottom.add(NewPatient.patient.getTeeth()[i + 24]);
			}

			topList.removeAllViews();
			topList.generateDrawingLayout(1);
			bottomList.removeAllViews();
			bottomList.generateDrawingLayout(3);
			sideChooser.setText(R.string.left_side);
			side = 1;
		}
	}
	
	@Override
	public void onResume() {
		Toast.makeText(getActivity(), "BAAAAAAAAAA", Toast.LENGTH_SHORT).show();
		initView();
		super.onResume();
	}

	private void initView() {
		ArrayList<Tooth> top = new ArrayList<Tooth>();
		ArrayList<Tooth> bottom = new ArrayList<Tooth>();
		for (int i = 0; i < 8; i++) {
			top.add(NewPatient.patient.getTeeth()[i]);
			bottom.add(NewPatient.patient.getTeeth()[i + 16]);
		}
		
		topList.removeAllViews();
		topList.generateDrawingLayout(0);
		bottomList.removeAllViews();
		bottomList.generateDrawingLayout(2);
		
		// 0 - left, 1 - right
		side = 0;
	}
}
