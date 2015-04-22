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
import tools.Tooth.State;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import fonts.OpenSansTextView;

// TODO: For entire class: Make UI thread wait for SaveDataToServer to finish, or send an answer
//			complete createTooth(). After that, should be a walk in the park to populate the Patient instance.
// TODO: Send the data - turn the Patient instance into a JSON array. CHECK HOW TO CREATE PROPER PARAMS FOR HTTP REQUEST OF UPLOAD_FILE!
public class NewPatient extends Activity implements OnClickListener {

	private static final CharSequence FIRSTNAME = "First name";
	private static final CharSequence LASTNAME = "Last name";
	private static final CharSequence ID = "Patient ID";
	private static final String MISSING_INPUT = "Please fill all the fields";
	private Context context;
	public static Patient patient;
	private boolean firstTimeClick = true;
	EditText firstName;
	EditText lastName;
	EditText id;

	private boolean alreadyVisited;

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
		String patientId = id.getText().toString();
		String patientFirstName = firstName.getText().toString();
		String patientLastName = lastName.getText().toString();

		// Send request to server
		if (firstTimeClick) {
			// ensure all fields have been filled
			if ((patientId.equals("")) || (patientFirstName.equals("")) || (patientLastName.equals(""))) {
				Toast.makeText(getApplicationContext(), MISSING_INPUT , Toast.LENGTH_SHORT).show();
			} else {
				ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("first_name", patientFirstName));
				params.add(new BasicNameValuePair("last_name", patientLastName));
//				new SendDataToServer(SendDataToServer.CHECK_IF_EXISTS, patientId, params, this).execute();
//				firstTimeClick = false;
			}
			initNewPatient();
			postExecute(null);
		}
		// TODO: Should wait for AsyncTask to finish before proceeding
	}

	private Patient initNewPatient() {
		patient = new Patient(firstName.getText().toString(), lastName.getText().toString(), id.getText().toString());	
		// TODO: For loop to populate the teeth using createTooth - Maybe this goes in loadPatientData?
		return patient;
	}

	private void loadPatientData(JSONArray json) {
		for (int i = 0; i < 32; i++) {
			try {
				createTooth(json.getJSONObject(i), i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Create a single tooth from a JSON string
	private Tooth createTooth(JSONObject toothAsJson, int patientNum) {
		Boolean[] decayFromJson = new Boolean[5];
		State[] fillingsFromJson = new State[5];
		try {
			patient.getTeeth()[patientNum].setExisting(Boolean.valueOf(toothAsJson.getString("existing")));
			for (int i = 0; i < 5; i++) {
				decayFromJson[i] = Boolean.valueOf(toothAsJson.getJSONArray("decay").getString(i));
				fillingsFromJson[i] = State.valueOf(toothAsJson.getJSONArray("fillings").getString(i));
			}
			patient.getTeeth()[patientNum].setDecay(decayFromJson);
			patient.getTeeth()[patientNum].setFillings(fillingsFromJson);
			patient.getTeeth()[patientNum].setCrowns(State.valueOf(toothAsJson.get("crowns").toString()));
			patient.getTeeth()[patientNum].setRoot(State.valueOf(toothAsJson.get("root").toString()));
			patient.getTeeth()[patientNum].setImplants(State.valueOf(toothAsJson.get("implants").toString()));

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

	public void postExecute(JSONArray json) {
		if (alreadyVisited) {
			loadPatientData(json);
		}
		Intent intent = new Intent(context, Main.class);
		startActivity(intent);
		finish();
	}
}
