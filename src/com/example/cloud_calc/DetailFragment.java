package com.example.cloud_calc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class DetailFragment extends Fragment {
	Context mContext;
	
	public DetailFragment(Context context) {
		mContext = context;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.deatail_fragment,
				container, false);
		// final RelativeLayout rel =
		// (RelativeLayout)inflater.inflate(R.layout.summessage,m);
		Button submit_btn = (Button) view.findViewById(R.id.detail_btn);
		submit_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText inputText = (EditText) view.findViewById(R.id.detail_field);
				String queryString = inputText.getText().toString();
				
				Intent intent = new Intent(getActivity(), QueryResultActivity.class);
				Bundle data = new Bundle();
				data.putString("queryString", queryString);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
		Button sum_btn = (Button) view.findViewById(R.id.sumbtn);
		sum_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LinearLayout linear = (LinearLayout) view
						.findViewById(R.id.sum_liner);
				if (linear.getChildCount() >= 3) {
					linear.removeViewAt(2);
				} else {
					ScrollView rel = (ScrollView) View.inflate(getActivity(),
							R.layout.detailmessage, null);
					// for margin
					rel.setBackgroundColor(Color.rgb(174, 234, 255));
					LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					margin.setMargins(40, 0, 40, 0);
					linear.addView(rel, margin);
					Toast.makeText(mContext, "Sum Button", Toast.LENGTH_SHORT)
							.show();
					Button test_btn = (Button) view.findViewById(R.id.test_btn);
					Button from_inf = (Button) view
							.findViewById(R.id.from_infinity_btn);
					Button to_inf = (Button) view
							.findViewById(R.id.to_infinity_btn);
					test_btn.setOnClickListener(new View.OnClickListener() {
						
						@Override
						// SUM �������� ���� �κ�
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Editable str_querry;
							EditText a = (EditText) view
									.findViewById(R.id.detail_field);
							EditText temp;
							str_querry = a.getText();
							temp = (EditText) view.findViewById(R.id.sum_from);
							str_querry.append("SUM FROM " + temp.getText());
							temp = (EditText) view.findViewById(R.id.sum_to);
							str_querry.append(" TO " + temp.getText());
							temp = (EditText) view
									.findViewById(R.id.sum_formula);
							str_querry.append(", " + temp.getText());
							a.setText(str_querry);
							
						}
					});
					
					// from field infinity
					from_inf.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Editable str;
							EditText from = (EditText) view
									.findViewById(R.id.sum_from);
							str = from.getText();
							str.append("infinity");
							from.setText(str);
						}
					});
					
					// to field infinity
					to_inf.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Editable str;
							EditText to = (EditText) view
									.findViewById(R.id.sum_to);
							str = to.getText();
							str.append("infinity");
							to.setText(str);
						}
					});
					
				}
				
			}
		});
		
		// delete_btn
		Button int_btn = (Button) view.findViewById(R.id.intbtn);
		int_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LinearLayout linear = (LinearLayout) view
						.findViewById(R.id.sum_liner);
				if (linear.getChildCount() >= 3) {
					linear.removeViewAt(2);
				} else {
					ScrollView rel = (ScrollView) View.inflate(getActivity(),
							R.layout.detailmessage, null);
					rel.setBackgroundColor(Color.rgb(198, 240, 255));
					// for margin
					LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
							LinearLayout.LayoutParams.WRAP_CONTENT,
							LinearLayout.LayoutParams.WRAP_CONTENT);
					margin.setMargins(40, 0, 40, 0);
					linear.addView(rel, margin);
					Toast.makeText(mContext, "Integral", Toast.LENGTH_SHORT)
							.show();
					Button test_btn = (Button) view.findViewById(R.id.test_btn);
					Button from_inf = (Button) view
							.findViewById(R.id.from_infinity_btn);
					Button to_inf = (Button) view
							.findViewById(R.id.to_infinity_btn);
					// submint Buutton
					test_btn.setOnClickListener(new View.OnClickListener() {
						
						@Override
						// SUM �������� ���� �κ�
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Editable str_querry;
							EditText a = (EditText) view
									.findViewById(R.id.detail_field);
							EditText temp;
							str_querry = a.getText();
							temp = (EditText) view.findViewById(R.id.sum_from);
							str_querry.append("Integral FROM " + temp.getText());
							temp = (EditText) view.findViewById(R.id.sum_to);
							str_querry.append(" TO " + temp.getText());
							temp = (EditText) view
									.findViewById(R.id.sum_formula);
							str_querry.append(", " + temp.getText());
							a.setText(str_querry);
							
						}
					});
					
					// from field infinity
					from_inf.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Editable str;
							EditText from = (EditText) view
									.findViewById(R.id.sum_from);
							str = from.getText();
							str.append("infinity");
							from.setText(str);
						}
					});
					
					// to field infinity
					to_inf.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Editable str;
							EditText to = (EditText) view
									.findViewById(R.id.sum_to);
							str = to.getText();
							str.append("infinity");
							to.setText(str);
						}
					});
				}
				
			}
		});
		// delete_btn
		Button delete_btn = (Button) view.findViewById(R.id.delete);
		delete_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Delete all queery",
						Toast.LENGTH_SHORT).show();
				EditText a = (EditText) view.findViewById(R.id.detail_field);
				a.setText("");
			}
		});
		
		return view;
	}
}
