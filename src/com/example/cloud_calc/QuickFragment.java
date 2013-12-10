package com.example.cloud_calc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
