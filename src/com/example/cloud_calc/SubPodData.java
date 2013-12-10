/**
 * 
 */
package com.example.cloud_calc;

import android.graphics.Bitmap;

/**
 * @author Joshua
 * 
 */
public class SubPodData {
	private String title;
	private String plainText;
	private String imgSrc;
	private Bitmap bitmap;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return the plainText
	 */
	public String getPlainText() {
		return plainText;
	}
	
	/**
	 * @return the imgSrc
	 */
	public String getImgSrc() {
		return imgSrc;
	}
	
	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @param plainText
	 *            the plainText to set
	 */
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	
	/**
	 * @param imgSrc
	 *            the imgSrc to set
	 */
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	/**
	 * @return the bitmap
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}

	/**
	 * @param bitmap the bitmap to set
	 */
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
}
