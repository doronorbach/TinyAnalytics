package com.bytefly.analytics.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkAsyncTask extends AsyncTask<String, Integer, Long> {
	public Activity act = null;
	public String paramValue = "";
	AnalyticsHttpConnector wconnect = null;
	boolean res = false;
	Dialog dialog = null;

	public NetworkAsyncTask(Activity leet) {
		act = leet;
	}

	@Override
	protected Long doInBackground(String... params) {
		wconnect = new AnalyticsHttpConnector();
		res = wconnect.executeHttpDoAction(act, params[0]);
		if(Debug.debugging){
			Log.d("Analytics", Boolean.toString(res));
		}
		return null;
	}

	protected void onPostExecute(Long result) {
	}
}
