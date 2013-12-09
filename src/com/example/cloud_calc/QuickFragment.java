package com.example.cloud_calc;

import android.support.v4.app.*;
import android.annotation.SuppressLint;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("ValidFragment")
public class QuickFragment extends Fragment implements OnClickListener {
	Context mContext;
	private Button bt;
	private EditText et;
	private String info;
	
	public QuickFragment() {}
	
	public QuickFragment(Context context) {
		mContext = context;
		this.setArguments(getArguments());
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.quick_fragment, container, false);
		et = (EditText) view.findViewById(R.id.query_field);
		bt = (Button) view.findViewById(R.id.query_btn);
		
		et.setHint("Enter what you want to calculate or know about:");
		bt.setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onClick(View v) {
		info = et.getText().toString();
		
		Intent intent = new Intent(getActivity(), QueryResultActivity.class);
		Bundle data = new Bundle();
		data.putString("queryString", info);
		intent.putExtras(data);
		this.startActivity(intent);
	}
}

// import android.annotation.SuppressLint;
// import android.app.Fragment;
// import android.content.Context;
// import android.os.Bundle;
// import android.view.LayoutInflater;
// import android.view.View;
// import android.view.ViewGroup;
// import android.annotation.SuppressLint;
// import android.support.v4.app.*;
// import android.content.*;
// import android.os.*;
// import android.view.*;
//
// @SuppressLint("ValidFragment")
// public class QuickFragment extends Fragment {
// // private Button bt;
// // private EditText et;
// // private String info;
// Context mContext;
//
// public QuickFragment(Context context) {
// mContext = context;
// }
//
// // @Override
// // public void onClick(View v) {
// // info = et.getText().toString();
// //
// // Intent intent = new Intent(getActivity(), QueryResultActivity.class);
// // Bundle data = new Bundle();
// // data.putString("queryString", info);
// // intent.putExtras(data);
// // this.startActivity(intent);
// // }
//
// public View onCreateView(LayoutInflater inflater, ViewGroup container,
// Bundle savedInstanceState) {
// View view = inflater.inflate(R.layout.quick_fragment, container, false);
//
// // et = (EditText) view.findViewById(R.id.query_field);
// // bt = (Button) view.findViewById(R.id.query_btn);
// //
// // et.setHint("Enter what you want to calculate or know about:");
// // bt.setOnClickListener(this);
// //
// return view;
// }
//
// // @Override
// // protected void onCreate(Bundle savedInstanceState) {
// // super.onCreate(savedInstanceState);
// // // Button search_btn = (Button) findViewById(R.id.btn_internet);
// // // search_btn.setOnClickListener(new Button.OnClickListener() {
// // // public void onClick(View v) {
// // // Intent intent = new Intent(MainActivity.this,
// // // QueryResultActivity.class);
// // // startActivity(intent);
// // // }
// // // });
// // setContentView(R.layout.quick_fragment);
// //
// // bt = (Button) findViewById(R.id.btn_internet);
// // bt.setOnClickListener(this);
// // }
// //
// // @Override
// // public boolean onCreateOptionsMenu(Menu menu) {
// // // Inflate the menu; this adds items to the action bar if it is present.
// // getMenuInflater().inflate(R.menu.main, menu);
// // return true;
// // }
// //
// // @Override
// // public void onClick(View v) {
// // Intent intent = new Intent(QuickFragment.this,
// // QueryResultActivity.class);
// // Bundle data = new Bundle();
// // this.startActivity(intent);
// // }
// // }
// }
