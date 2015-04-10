package com.example.dentool;

import tools.SendDataToServer;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.tabs.PagerSlidingTabStrip;

public class Main extends FragmentActivity {

	TabsPagerAdapter adapter;
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		context = getApplicationContext();

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0096EA")));
		bar.setTitle("");
		bar.setIcon(R.drawable.logo);

		// Initialize the ViewPager and set an adapter
		ViewPager pager = (ViewPager) findViewById(R.id.Vpager);
		TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setOffscreenPageLimit(6);


		// Bind the tabs to the ViewPager
		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		tabs.setViewPager(pager);


	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		menu.clear();
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu_buttons, menu);

		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		if (item.getItemId() == R.id.sendInfo) {
			sendFiles();
			return true;
		}
		else {
			return super.onOptionsItemSelected(item);
		}
	}

	private void sendFiles() {
		Toast.makeText(context, "Sending data...", Toast.LENGTH_LONG).show();
//		new SendDataToServer(requestType, patientId, firstName, lastName, params, activity).execute(null);
	}
}
