package com.example.dentool;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	private int NUMBER_OF_FRAGMENTS = 6;
	
	//problems definitions 
    private String PROBLEM_1 = "Missing Teeth";
    private String PROBLEM_2 = "Primary Decay";
    private String PROBLEM_3 = "Existing Fillings";
	private String PROBLEM_4 = "Existing Crowns/Bridges";
	private String PROBLEM_5 = "Existing Root Canal Fillings";
	private String PROBLEM_6 = "Dental Implants";

	private FragmentManager mFragmentManager;
	private Map<Integer,String> mFragmentTags;
	
	private Context mContext;
 
    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mFragmentManager = fm;
        this.mFragmentTags = new HashMap<Integer, String>();
        this.mContext = context;
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return BottomFragment1.newInstance(0, PROBLEM_1);
        case 1:
        	return BottomFragment2.newInstance(1, PROBLEM_2);
        case 2:
        	return BottomFragment3.newInstance(2, PROBLEM_3);
        case 3:
        	return BottomFragment4.newInstance(3, PROBLEM_4);
        case 4:
        	return BottomFragment5.newInstance(4, PROBLEM_5);
        case 5:
        	return BottomFragment6.newInstance(5, PROBLEM_6);
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
    
    public Fragment getFragmet(int position) {
    	String tag = mFragmentTags.get(position);
    	
    	if (tag == null) {
    		return null;
    	}
    	else {
    		return mFragmentManager.findFragmentByTag(tag);
    	}
    }
    
    @Override
    public Object instantiateItem(View container, int position) {
    	Object obj =  super.instantiateItem(container, position);
    	if (obj instanceof Fragment) {
    		Fragment f = (Fragment) obj;
    		String tag = f.getTag();
    		mFragmentTags.put(position, tag);
    	}
		return obj;
    }
}
