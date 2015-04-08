package com.example.dentool;

import tools.Patient;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewPatient extends Activity implements OnClickListener {

	private static final CharSequence USERNAME = "Please enter patient full name";
	private static final CharSequence ID = "Please enter patient ID";
	private Context context;
	public static Patient patient;
	EditText userName;
	EditText id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newpatient_layout);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0096EA")));
		bar.setTitle("");
		bar.setIcon(R.drawable.logo);
		
		context = getApplicationContext();
		
		userName = (EditText) findViewById(R.id.userName);
		userName.setHint(USERNAME);
		id = (EditText) findViewById(R.id.id);
		id.setHint(ID);
		Button skip = (Button) findViewById(R.id.skip);
		skip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, Main.class);
				startActivity(intent);
			}
		});
		Button send = (Button) findViewById(R.id.sendInfo);
		send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO: run method that send data to server
		// if user already treated - load data, else, update and start with empty object
		Boolean alreadyVisited = false;
		if (alreadyVisited) {
			patient = loadPatientData("");
		}
		else {
			patient = initNewPatient();
		}
		Intent intent = new Intent(context, Main.class);
		startActivity(intent);
	}

	private Patient initNewPatient() {
		return new Patient(userName.getText().toString(), id.getText().toString());		
	}

	private Patient loadPatientData(String data) {
		String newUserName = data;
		String uid = data;
		Patient newPatient = new Patient(newUserName, uid);
		return newPatient;
	}
}
