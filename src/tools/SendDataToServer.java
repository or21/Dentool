package tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.R.transition;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public class SendDataToServer extends AsyncTask<String, Void, Boolean>{


	private static final String POST = "POST";

	private final String method;

	private Activity activity;
	private List<NameValuePair> requestParams;
	private InputStream is;
	private String line;
	private String json;

	private JSONObject jsonObj;

	public SendDataToServer(Activity activity, List<NameValuePair> params, String method) {
		this.activity = activity;
		this.requestParams = params;
		this.method = method;
	}


	@Override
	protected Boolean doInBackground(String... params) {
		Boolean requestStatus = false;
		try {
			String url = params[0];
			HttpResponse httpResponse;
			HttpRequestBase httpMethod;
			// create http request
			if (method == POST) {
				HttpPost httpPost = new HttpPost(url);
				httpPost.setEntity(new UrlEncodedFormEntity(requestParams, "utf-8"));
				httpMethod = httpPost;
			} else {
				String paramString = URLEncodedUtils.format(requestParams, "utf-8");
				httpMethod = new HttpGet(url + "?" + paramString);
			}

			DefaultHttpClient httpClient = new DefaultHttpClient();

			httpResponse = httpClient.execute(httpMethod);

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
			
			jsonObj = new JSONObject();
			
			// TODO: read message and check if success
			
			return requestStatus;
			
		} catch (Exception e) {
			Log.d("DenTool", "Request failed");
			e.printStackTrace();
		}
		return null;
	}

}
