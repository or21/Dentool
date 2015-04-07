package com.example.dentool;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	private int NUMBER_OF_FRAGMENTS = 6;
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return BottomFragment1.newInstance(0, "Page 1");
        case 1:
        	return BottomFragment1.newInstance(1, "Page 2");
        case 2:
        	return BottomFragment1.newInstance(2, "Page 3");
        case 3:
        	return BottomFragment1.newInstance(3, "Page 4");
        case 4:
        	return BottomFragment1.newInstance(4, "Page 5");
        case 5:
        	return BottomFragment1.newInstance(5, "Page 6");
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
    	return "Page " + position;
    }
 
}
