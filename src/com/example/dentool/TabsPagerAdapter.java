package com.example.dentool;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	private int NUMBER_OF_FRAGMENTS = 6;
	
	//problems definitions 
    private String PROBLEM_1 = "Missing Teeth";
    private String PROBLEM_2 = "Primary Decay";
    private String PROBLEM_3 = "Existing Fillings";
	private String PROBLEM_4 = "Existing Root Canal Fillings";
	private String PROBLEM_5 = "Existing Crowns/Bridges";
	private String PROBLEM_6 = "Dental Implants";
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return BottomFragment1.newInstance(0, "Missing Teeth");
        case 1:
        	return BottomFragment2.newInstance(1, "Primary Decay");
        case 2:
        	return BottomFragment3.newInstance(2, "Existing Fillings");
        case 3:
        	return BottomFragment4.newInstance(3, "Existing Root Canal Fillings");
        case 4:
        	return BottomFragment5.newInstance(4, "Existing Crowns/Bridges");
        case 5:
        	return BottomFragment6.newInstance(5, "Dental Implants");
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count
        return NUMBER_OF_FRAGMENTS;
    }
    
    //return page index and title
    @Override
    public CharSequence getPageTitle(int position){
    	 
        switch (position) {
        case 0:
            return PROBLEM_1;
        case 1:
        	return PROBLEM_2;
        case 2:
        	return PROBLEM_3;
        case 3:
        	return PROBLEM_4;
        case 4:
        	return PROBLEM_5;
        case 5:
        	return PROBLEM_6;
        }
 
        return null;
    }
 
}
