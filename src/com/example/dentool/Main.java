package com.example.dentool;

import com.tabs.PagerSlidingTabStrip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class Main extends FragmentActivity {

	TabsPagerAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		// Initialize the ViewPager and set an adapter
		ViewPager pager = (ViewPager) findViewById(R.id.Vpager);
		TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setOffscreenPageLimit(6);
		

		// Bind the tabs to the ViewPager
		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		tabs.setViewPager(pager);


	}
}
