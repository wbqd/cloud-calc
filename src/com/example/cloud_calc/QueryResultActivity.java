package com.example.cloud_calc;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.widget.ListView;

public class QueryResultActivity extends Activity {
	private QueryResultParser queryResultParser;
	private ProgressDialog dialog;
	private CustomAdapter adapter;
	private ListView listView;
	private ArrayList<PodData> podDataArray;
	private String queryString;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_query_result);
		
		Intent intent = getIntent();
		Bundle myBundle = intent.getExtras();
		queryString = myBundle.getString("queryString");
		
		listView = (ListView) findViewById(R.id.find_listview);
		getQueryResultFromWA(queryString);
	}
	
	public void getQueryResultFromWA(final String queryString) {
		dialog = ProgressDialog.show(this, "Loading...", "Loading...", true,
				false);
		new Thread() {
			public void run() {
				queryResultParser = new QueryResultParser(queryString);
				podDataArray = queryResultParser.getQueryResultData();
				handler.sendEmptyMessage(0);
			}
		}.start();
	}
	
	private final Handler handler = new Handler() {
		public void handleMessage(final Message msg) {
			dialog.dismiss();
			adapter = new CustomAdapter(QueryResultActivity.this,
					R.layout.query_result_list_view, podDataArray);
			listView.setAdapter(adapter);
			listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
