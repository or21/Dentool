package com.example.dentool;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tools.Patient;
import tools.SendDataToServer;
import tools.Tooth;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

// TODO: For entire class: Make UI thread wait for SaveDataToServer to finish, or send an answer
//			complete createTooth(). After that, should be a walk in the park to populate the Patient instance.
public class NewPatient extends Activity implements OnClickListener {

	private static final CharSequence FIRSTNAME = "Please enter patient first name";
	private static final CharSequence LASTNAME = "Please enter patient last name";
	private static final CharSequence ID = "Please enter patient ID";
	private Context context;
	public static Patient patient;
	EditText firstName;
	EditText lastName;
	EditText id;
	
	private boolean alreadyVisited;
	private Tooth[] teeth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newpatient_layout);
		
		context = getApplicationContext();
		
		firstName = (EditText) findViewById(R.id.firstName);
		firstName.setHint(FIRSTNAME);
		
		lastName = (EditText) findViewById(R.id.lastName);
		lastName.setHint(LASTNAME);
		
		id = (EditText) findViewById(R.id.id);
		id.setHint(ID);
		
		Button skip = (Button) findViewById(R.id.skip);
		Button tester = (Button) findViewById(R.id.test_button);
		tester.setOnClickListener(this);
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
		Log.d("I'm in onClick", "HI");
//		String patientId = id.getText().toString();
		String patientId = "20033";
		String patientFirstName = firstName.getText().toString();
		String patientLastName = lastName.getText().toString();
		
		// Send request to server
		// TODO: Add some kind of test to ensure all fields have been filled
		new SendDataToServer(1, patientId, patientFirstName, patientLastName,
				new ArrayList<NameValuePair>(), this).execute();
		// Should wait for AsyncTask to finish before proceeding
		Log.d("Entering the if", "HI HI");
		if (this.alreadyVisited) {
			patient = loadPatientData("");
		}
		else {
			patient = initNewPatient();
		}
		Intent intent = new Intent(context, Main.class);
		startActivity(intent);
	}

	private Patient initNewPatient() {
		Patient patient = new Patient(firstName.getText().toString(), lastName.getText().toString(), id.getText().toString());	
		// TODO: For loop to populate the teeth using createTooth - Maybe this goes in loadPatientData?
		return patient;
	}

	private Patient loadPatientData(String data) {
		// TODO:
		return null;
	}
	
	// Create a single tooth from a JSON string
	private Tooth createTooth(JSONObject toothAsJson) {
		try {
			Boolean existing = Boolean.valueOf(toothAsJson.getString("existing"));
			JSONArray decayValues = toothAsJson.getJSONArray("decay");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setAlreadyVisited(boolean alreadyVisited) {
		this.alreadyVisited = alreadyVisited;
		Log.d("I'm in alreadyVisited", "HI");
	}
	
	public void serverTestMethod(View v) {
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
//		params.add(new BasicNameValuePair("patient_id", "20033"));
		new SendDataToServer(1, "20035", "Nadav", "LastName", params, this).execute();
		Log.d("Hi it's working!", "Hurray");
	}
}
