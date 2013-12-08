package com.example.cloud_calc;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.activity_main);
		QueryResultParser qrp = new QueryResultParser("sin x^3");
		qrp.getResultData();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
