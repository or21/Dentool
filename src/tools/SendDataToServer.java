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
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public class SendDataToServer extends AsyncTask<Void, Void, Boolean>{

	private static final String HOST = "http://10.10.1.25:5000";
	private final String urlUploadFile = HOST + "/upload_file/";
	private final String urlNewSession = HOST + "/";
	private String url;
	
	private List<NameValuePair> requestParams;
	private InputStream is;
	private String line;
	private String json;
	private String firstName;
	private String lastName;
	private Activity activity;
	private int requestType;
	
	private JSONArray jsonArray;
	
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
	public SendDataToServer(int requestType, String patientId, String firstName,
			String lastName, List<NameValuePair> params, Activity activity) {
		// Set empty firstName and lastName if non are given
		if (firstName == null) {
			this.firstName = "";
		} else {
			this.firstName = firstName;
		}
		
		if (lastName == null) {
			this.lastName = "";
		} else {
			this.lastName = lastName;
		}		
		
		if (requestType == 0) {
			url = urlUploadFile + patientId;
		} else if (requestType == 1) {
			// TODO: Add some test to ensure no empty first and last name are given?
			url = urlNewSession + patientId + "?first_name=" + this.firstName + "&last_name=" + this.lastName;
		}
		
		this.activity = activity;
		this.requestParams = params;
		this.requestType = requestType;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// TODO: Run on UI Thread Spinner
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		Boolean requestStatus = false;
		try {
			HttpResponse httpResponse;
			
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(requestParams, "utf-8"));
	
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
			
			// If requestType == 0 (invoked upload_file), create the jsonArray
			if (requestType == 0) {
				json = sb.toString();
			
				jsonArray = new JSONArray(json);
			}
			
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
	protected void onPostExecute(Boolean requestStatus) {
		if (requestStatus && requestType == 0) {
			// activity.populateTeeth
		}
	}

}
