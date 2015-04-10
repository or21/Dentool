package com.example.dentool;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tools.Patient;
import tools.SendDataToServer;
import tools.Tooth;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import fonts.OpenSansTextView;

// TODO: For entire class: Make UI thread wait for SaveDataToServer to finish, or send an answer
//			complete createTooth(). After that, should be a walk in the park to populate the Patient instance.
// TODO: Send the data - turn the Patient instance into a JSON array. CHECK HOW TO CREATE PROPER PARAMS FOR HTTP REQUEST OF UPLOAD_FILE!
public class NewPatient extends Activity implements OnClickListener {
	
	private static final CharSequence FIRSTNAME = "First name";
	private static final CharSequence LASTNAME = "Last name";
	private static final CharSequence ID = "Patient ID";
	private Context context;
	public static Patient patient;
	private boolean firstTimeClick = true;
	EditText firstName;
	EditText lastName;
	EditText id;

	private boolean alreadyVisited;
	private Tooth[] teeth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    OpenSansTextView.setDefaultFont(this, "OpenSans", "fonts/OpenSans-Regular.ttf");
	    
		setContentView(R.layout.newpatient_layout);

		context = getApplicationContext();

		firstName = (EditText) findViewById(R.id.fname);
		firstName.setHint(FIRSTNAME);
		firstName.setHintTextColor(Color.WHITE);

		lastName = (EditText) findViewById(R.id.lname);
		lastName.setHint(LASTNAME);
		lastName.setHintTextColor(Color.WHITE);

		id = (EditText) findViewById(R.id.pid);
		id.setHint(ID);
		id.setHintTextColor(Color.WHITE);

		Button send = (Button) findViewById(R.id.connect);
		send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Log.d("I'm in onClick", "HI");
		//		String patientId = id.getText().toString();
		String patientId = "20033"; // DEBUG
		String patientFirstName = firstName.getText().toString();
		String patientLastName = lastName.getText().toString();
		
		if(firstTimeClick) {
			new SendDataToServer(1, patientId, patientFirstName, patientLastName,
					new ArrayList<NameValuePair>(), this).execute();
			firstTimeClick = false;
		}
		// Send request to server
		// TODO: Add some kind of test to ensure all fields have been filled
		// Should wait for AsyncTask to finish before proceeding
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

	public void postExecute() {
		if (alreadyVisited) {
			patient = loadPatientData("");
		}
		else {
			patient = initNewPatient();
		}
		Intent intent = new Intent(context, Main.class);
		startActivity(intent);
		finish();
	}
}
