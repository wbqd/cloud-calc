package com.example.cloud_calc;

import java.util.ArrayList;

/**
 * @author Joshua Jung
 * @Description pod elements are subelements of queryresult. Each contains the
 *              results for a single pod. pod has the following attributes:
 */
public class PodData {
	// The pod title, used to identify the pod.
	private String title;
	
	// true or false depending on whether a serious processing error occurred
	// with this specific pod. If true, there will be an <error> subelement.
	private String error;
	
	// A number indicating the intended position of the pod in a visual display.
	// These numbers are typically multiples of 100, but it is only relevant
	// that they form an increasing sequence from top to bottom.
	private String postion;
	
	// The name of the scanner that produced this pod. A guide to the type of
	// data it holds.
	private String scanner;
	
	// This attribute is undocumented at this time.
	private String id;
	
	// The number of subpod elements present.
	private String numsubpods;
	
	private ArrayList<SubPodData> subPodDataArray;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * @return the postion
	 */
	public String getPostion() {
		return postion;
	}
	
	/**
	 * @return the scanner
	 */
	public String getScanner() {
		return scanner;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return the numsubpods
	 */
	public String getNumsubpods() {
		return numsubpods;
	}
	
	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * @param postion
	 *            the postion to set
	 */
	public void setPostion(String postion) {
		this.postion = postion;
	}
	
	/**
	 * @param scanner
	 *            the scanner to set
	 */
	public void setScanner(String scanner) {
		this.scanner = scanner;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @param numsubpods
	 *            the numsubpods to set
	 */
	public void setNumsubpods(String numsubpods) {
		this.numsubpods = numsubpods;
	}
	
	/**
	 * @return the subData
	 */
	public ArrayList<SubPodData> getSubData() {
		return subPodDataArray;
	}
	
	/**
	 * @param subDataArray
	 *            the subData to set
	 */
	public void setSubData(ArrayList<SubPodData> subDataArray) {
		this.subPodDataArray = subDataArray;
	}
}
