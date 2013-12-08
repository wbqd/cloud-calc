/**
 * 
 */
package com.example.cloud_calc;

import java.util.ArrayList;

import android.util.Log;

import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;

/**
 * @author Joshua Jung
 * 
 */
public class QueryResultParser {
	public ArrayList<PodData> data;
	
	// PUT APPID HERE:
	private final static String APPID = "XK6UL2-VWVWL9UJ98";
	private String queryString;
	
	// This is for debugging process.
	private static final String TAG = "DEBUGGING";
	
	public QueryResultParser(String queryString) {
		this.setQueryString(queryString);
	}
	
	public ArrayList<PodData> getResultData() {
		data = new ArrayList<PodData>();
		PodData pod = new PodData();
		
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
		
		// Create the query.
		WAQuery query = engine.createQuery();
		
		// Set properties of the query.
		query.setInput(queryString);
		
		try {
			// For debugging purposes, print out the URL we are about to send:
			Log.i(TAG, "Query URL:" + engine.toURL(query));
			
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return data;
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
}
