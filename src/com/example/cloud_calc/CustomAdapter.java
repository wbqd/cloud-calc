/**
 * 
 */
package com.example.cloud_calc;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Joshua
 * 
 */
public class CustomAdapter extends ArrayAdapter<Object> {
	public CustomAdapter(Context context, int textViewResourceId,
			ArrayList items) {
		super(context, textViewResourceId, items);
		// TODO Auto-generated constructor stub
		this.podDataArray = items;
	}
	
	private ArrayList<PodData> podDataArray;
	private View view;
	// private URL imageUrl;
	// private ImageView imageView;
	private ProgressDialog dialog;
	
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
			imageView.setImageBitmap(podData.getSubData().get(0).getBitmap());
			
			// new Thread() {
			// public void run() {
			// dialog = ProgressDialog.show(getContext(), "Loading...",
			// "Loading...", true, false);
			// URL imageUrl;
			// try {
			// imageUrl = new URL(podData.getSubData().get(0).getImgSrc());
			// Toast.makeText(getContext(), "imageUrl",
			// Toast.LENGTH_SHORT).show();
			// HttpURLConnection con = (HttpURLConnection) imageUrl
			// .openConnection();
			// BufferedInputStream bis = new BufferedInputStream(
			// con.getInputStream(), 10240);
			//
			// Bitmap bm = BitmapFactory.decodeStream(bis);
			// bis.close();
			// imageView.setImageBitmap(bm);
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
		}
		// }.start();
		// }
		
		return view;
	}
}
