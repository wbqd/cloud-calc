/**
 * 
 */
package com.example.cloud_calc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.wolfram.alpha.WAAssumption;
import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAImage;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

/**
 * @author Joshua Jung
 * 
 */
public class QueryResultParser {
	public QueryResultData queryResultData;
	
	// PUT APPID HERE:
	private final static String APPID = "XK6UL2-VWVWL9UJ98";
	private String queryString;
	
	// This is for debugging process.
	private static final String TAG = "DEBUGGING";
	
	public QueryResultParser(String queryString) {
		this.setQueryString(queryString);
	}
	
	public ArrayList<PodData> getQueryResultData() {
		queryResultData = new QueryResultData();
		// Create podDataArray
		ArrayList<PodData> podDataArray = new ArrayList<PodData>();
		
		// The WAEngine is a factory for creating WAQuery objects, and it
		// also used to perform those queries. You can set properties of the
		// WAEngine (such as the desired API output format types) that will
		// be inherited by all WAQuery objects created from it. Most
		// applications will only need to create one WAEngine object, which
		// is used throughout the life of the application.
		WAEngine engine = new WAEngine();
		
		// These properties will be set in all the WAQuery objects created from
		// this WAEngine.
		engine.setAppID(APPID);
		engine.addFormat("plaintext");
		engine.addFormat("image");
		
		// Create the query.
		WAQuery query = engine.createQuery();
		
		// Set properties of the query.
		query.setInput(queryString);
		
		try {
			// For debugging purposes, print out the URL we are about to send:
			Log.i(TAG, "Query URL: " + engine.toURL(query));
			
			// This sends the URL to the Wolfram|Alpha server, gets the XML
			// result and parses it into an object hierarchy held by the
			// WAQueryResult object.
			WAQueryResult queryResult = engine.performQuery(query);
			
			if (queryResult.isError()) {
				Log.i(TAG,
						"Query error. error code: "
								+ queryResult.getErrorCode()
								+ " / error message: "
								+ queryResult.getErrorMessage());
			} else if (!queryResult.isSuccess()) {
				Log.i(TAG, "Query was not understood; no results available.");
			} else {
				// Got a result
				Log.i(TAG, "Successful query. Pods follow:");
				Log.w(TAG, "queryResult.getPods() loop start");
				
				for (WAPod pod : queryResult.getPods()) {
					if (!pod.isError()) {
						// Create podData
						PodData podData = new PodData();
						
						// Create subPodDataArray
						ArrayList<SubPodData> subPodDataArray = new ArrayList<SubPodData>();
						
						podData.setTitle(pod.getTitle());
						Log.i(TAG, "Title: " + podData.getTitle());
						
						Log.w(TAG, "pod.getSubpods() loop start");
						for (WASubpod subpod : pod.getSubpods()) {
							Log.w(TAG, "subpod.getContents() loop start");
							SubPodData subPodData = new SubPodData();
							if (!subpod.getTitle().isEmpty()) {
								subPodData.setTitle(subpod.getTitle());
								Log.e(TAG,
										"SubPodTitle: " + subPodData.getTitle());
							}
							for (Object element : subpod.getContents()) {
								if (element instanceof WAPlainText) {
									subPodData
											.setPlainText(((WAPlainText) element)
													.getText());
									
									Log.i(TAG,
											"PlainText: "
													+ subPodData.getPlainText());
								}
								if (element instanceof WAImage) {
									subPodData.setImgSrc(((WAImage) element)
											.getURL());
									subPodData.setBitmap(getBitmap(subPodData
											.getImgSrc()));
									Log.i(TAG,
											"Images: " + subPodData.getImgSrc());
								}
							}
							Log.w(TAG, "subpod.getContents() loop end");
							subPodDataArray.add(subPodData);
						}
						
						// Assumptions handling
						for (WAAssumption assumption : queryResult.getAssumptions()) {
							
						}
						
						Log.w(TAG, "pod.getSubpods() loop end");
						podData.setSubData(subPodDataArray);
						podDataArray.add(podData);
					}
				}
				Log.w(TAG, "queryResult.getPods() loop end");
				
				queryResultData.setPodDatas(podDataArray);
				
				// We ignored many other types of Wolfram|Alpha output, such as
				// warnings, assumptions, etc. These can be obtained by methods
				// of WAQueryResult or objects deeper in the hierarchy.
			}
		} catch (WAException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return podDataArray;
	}
	
	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}
	
	/**
	 * @param queryString
	 *            the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
	public Bitmap getBitmap(String imgSrc) throws IOException {
		URL imgUrl = new URL(imgSrc);
		HttpURLConnection con = (HttpURLConnection) imgUrl.openConnection();
		BufferedInputStream bis = new BufferedInputStream(con.getInputStream(),
				65536);
		Bitmap bitmap = BitmapFactory.decodeStream(bis);
		bis.close();
		return bitmap;
	}
}
