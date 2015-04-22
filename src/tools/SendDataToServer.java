package tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.dentool.NewPatient;

public class SendDataToServer extends AsyncTask<Void, Void, Boolean>{

	private static final String HOST = "http://10.100.102.6:5000";
	private final String urlUploadFile = HOST + "/upload_file/";
	private final String urlNewSession = HOST + "/";
	public static final int CHECK_IF_EXISTS = 1;
	public static final int SEND_DATA = 0;

	private String url;

	private List<NameValuePair> requestParams;
	private InputStream is;
	private String line;
	private String json;
	private Activity fromActivity;
	private int requestType;

	private ProgressDialog progress;

	private JSONArray jsonArray = null;

	/**
	 * Constructor - SendDataToServer creates the HTTP POST requests to the server
	 * params:
	 * 	requestType - determines whether save_and_send or upload_file methods would
	 * 					be accessed.
	 * 	patientId - this patient's id number
	 * 	firstName - this patient's first name
	 * 	lastName - this patient's last name
	 * 	params - the JSON array of teeth, in case upload_file in invoked. Will be
	 * 					ignored if requestType == 1
	 * 	activity - caller activity instance
	 */
	public SendDataToServer(int requestType, String patientId, List<NameValuePair> params, Activity activity) {
		// Set empty firstName and lastName if non are given

		if (requestType == 0) {
			url = urlUploadFile + patientId;
		} else if (requestType == 1) {
			// TODO: Add some test to ensure no empty first and last name are given?
			url = urlNewSession + patientId;
		}

		this.fromActivity = activity;
		this.requestParams = params;
		this.requestType = requestType;
		this.progress = new ProgressDialog(fromActivity.getApplicationContext());
	}

	@Override
	protected void onPreExecute() {
		try {
			// TODO: Finish circle
			progress = ProgressDialog.show(fromActivity.getApplicationContext(), "", "Server request in progress", true);
		} catch (Exception e)
		{}
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		Boolean requestStatus = false;
		try {
			HttpResponse httpResponse;
			HttpPost httpPost = new HttpPost(url);
			if (url.startsWith(urlUploadFile)) {
				Log.i("SendDataToServer","EnteredURLUploadFile");
				httpPost.setHeader("Accept","application/json");
				httpPost.setHeader("Content-Type","application/json");
				Log.i("SendDataToServer", Patient.getTeethData().toString());
				httpPost.setEntity(new StringEntity(Patient.getTeethData().toString()));
				
			} else { 
				httpPost.setEntity(new UrlEncodedFormEntity(requestParams, "utf-8"));
			}
			DefaultHttpClient httpClient = new DefaultHttpClient();

			// Execute the request
			httpResponse = httpClient.execute(httpPost);

			// Get the server response
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
			StringBuilder sb = new StringBuilder();
			line = reader.readLine();
			while (line != null) {
				sb.append(line + "\n");
				line = reader.readLine();
			}
			is.close();

			json = sb.toString();
			if (json.length() > 0)
				jsonArray = new JSONArray(json);


			int status = httpResponse.getStatusLine().getStatusCode();
			if (status == 200) {
				requestStatus = true;
			}		
		} catch (Exception e) {
			Log.d("DenTool", "Request failed");
			e.printStackTrace();
		}
		return requestStatus;
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	@Override
	protected void onPostExecute(Boolean requestStatus) {
		if (requestStatus && requestType == 1) {
			if (jsonArray != null) {
				((NewPatient) fromActivity).setAlreadyVisited(true);
				//				newPatientActivity.populateTeethArray(jsonArray);
			} else {
				((NewPatient) fromActivity).setAlreadyVisited(false);
			}
		}
		if (requestStatus && requestType == 1) {
			fromActivity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					if (progress.isShowing()) {
						progress.dismiss();
					}
					Log.d("Entering the if", "HI HI");
					((NewPatient) fromActivity).postExecute(jsonArray);
				}
			});
		} else {
			Toast.makeText(fromActivity, "WORKING", Toast.LENGTH_SHORT).show();
		}
	}
}