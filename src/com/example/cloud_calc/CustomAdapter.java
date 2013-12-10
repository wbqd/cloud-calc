/**
 * 
 */
package com.example.cloud_calc;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Joshua
 * 
 */
public class CustomAdapter extends ArrayAdapter<Object> {
	public CustomAdapter(Context context, int textViewResourceId,
			ArrayList items) {
		super(context, textViewResourceId, items);
		this.podDataArray = items;
	}
	
	private ArrayList<PodData> podDataArray;
	private View view;
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		view = convertView;
		
		if (view == null) {
			LayoutInflater layoutInflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater
					.inflate(R.layout.query_result_list_view, null);
		}
		
		final PodData podData = podDataArray.get(position);
		if (podData != null) {
			ImageView imageView = (ImageView) view
					.findViewById(R.id.subpod_image);
			TextView textViewPodTitle = (TextView) view
					.findViewById(R.id.pod_title);
			TextView textViewSubPodTitle = (TextView) view
					.findViewById(R.id.subpod_title);
			TextView textViewSubPodPlainText = (TextView) view
					.findViewById(R.id.subpod_plain_text);
			
			textViewPodTitle.setText(podData.getTitle());
			
			textViewSubPodTitle.setText(podData.getSubData().get(0).getTitle());
			textViewSubPodTitle.setVisibility(TextView.VISIBLE);
			if (podData.getSubData().get(0).getImgSrc().isEmpty()) {
				textViewSubPodPlainText.setText(podData.getSubData().get(0)
						.getPlainText());
				textViewSubPodPlainText.setVisibility(TextView.VISIBLE);
			}
			imageView
					.setMinimumWidth(podData.getSubData().get(0).getImgWidth() * 2);
			imageView.setMinimumHeight(podData.getSubData().get(0)
					.getImgHeight() * 2);
			imageView
					.setMaxWidth(podData.getSubData().get(0).getImgWidth() * 3);
			imageView
					.setMaxHeight(podData.getSubData().get(0).getImgHeight() * 3);
			imageView.setImageBitmap(podData.getSubData().get(0).getBitmap());
		}
		return view;
	}
}
