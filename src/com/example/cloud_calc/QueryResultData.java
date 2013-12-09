/**
 * 
 */
package com.example.cloud_calc;

import java.util.ArrayList;

/**
 * @author Joshua
 * 
 */
public class QueryResultData {
	private String error;
	private String numpods;
	private String datatypes;
	private String timedout;
	private String timedoutpods;
	private String timing;
	private String parsetiming;
	private String parsetimedout;
	private String recalculate;
	private String id;
	private String host;
	private String server;
	private String related;
	private String version;
	
	private ArrayList<PodData> podDataArray;
	
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * @return the numpods
	 */
	public String getNumpods() {
		return numpods;
	}
	
	/**
	 * @return the datatypes
	 */
	public String getDatatypes() {
		return datatypes;
	}
	
	/**
	 * @return the timedout
	 */
	public String getTimedout() {
		return timedout;
	}
	
	/**
	 * @return the timedoutpods
	 */
	public String getTimedoutpods() {
		return timedoutpods;
	}
	
	/**
	 * @return the timing
	 */
	public String getTiming() {
		return timing;
	}
	
	/**
	 * @return the parsetiming
	 */
	public String getParsetiming() {
		return parsetiming;
	}
	
	/**
	 * @return the parsetimedout
	 */
	public String getParsetimedout() {
		return parsetimedout;
	}
	
	/**
	 * @return the recalculate
	 */
	public String getRecalculate() {
		return recalculate;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * @return the server
	 */
	public String getServer() {
		return server;
	}
	
	/**
	 * @return the related
	 */
	public String getRelated() {
		return related;
	}
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * @return the podDatas
	 */
	public ArrayList<PodData> getPodDatas() {
		return podDataArray;
	}
	
	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * @param numpods
	 *            the numpods to set
	 */
	public void setNumpods(String numpods) {
		this.numpods = numpods;
	}
	
	/**
	 * @param datatypes
	 *            the datatypes to set
	 */
	public void setDatatypes(String datatypes) {
		this.datatypes = datatypes;
	}
	
	/**
	 * @param timedout
	 *            the timedout to set
	 */
	public void setTimedout(String timedout) {
		this.timedout = timedout;
	}
	
	/**
	 * @param timedoutpods
	 *            the timedoutpods to set
	 */
	public void setTimedoutpods(String timedoutpods) {
		this.timedoutpods = timedoutpods;
	}
	
	/**
	 * @param timing
	 *            the timing to set
	 */
	public void setTiming(String timing) {
		this.timing = timing;
	}
	
	/**
	 * @param parsetiming
	 *            the parsetiming to set
	 */
	public void setParsetiming(String parsetiming) {
		this.parsetiming = parsetiming;
	}
	
	/**
	 * @param parsetimedout
	 *            the parsetimedout to set
	 */
	public void setParsetimedout(String parsetimedout) {
		this.parsetimedout = parsetimedout;
	}
	
	/**
	 * @param recalculate
	 *            the recalculate to set
	 */
	public void setRecalculate(String recalculate) {
		this.recalculate = recalculate;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * @param server
	 *            the server to set
	 */
	public void setServer(String server) {
		this.server = server;
	}
	
	/**
	 * @param related
	 *            the related to set
	 */
	public void setRelated(String related) {
		this.related = related;
	}
	
	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * @param podDatasArray
	 *            the podDatas to set
	 */
	public void setPodDatas(ArrayList<PodData> podDatasArray) {
		this.podDataArray = podDatasArray;
	}
}
