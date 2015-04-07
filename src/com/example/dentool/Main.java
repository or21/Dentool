package com.example.dentool;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
//
public class Main extends FragmentActivity {
	
	FragmentPagerAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		ViewPager viewPage = (ViewPager)findViewById(R.id.pager);
		adapter = new TabsPagerAdapter(getSupportFragmentManager());
		viewPage.setAdapter(adapter);
		
	}
}
