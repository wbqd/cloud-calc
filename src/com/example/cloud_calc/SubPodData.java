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
	private int imgWidth;
	private int imgHeight;
	
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
	 * @param bitmap
	 *            the bitmap to set
	 */
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	/**
	 * @param dimensions
	 *            the dimensions to set
	 */
	public void setDimensions(int[] dimensions) {
		this.setImgWidth(dimensions[0]);
		this.setImgHeight(dimensions[1]);
	}
	
	/**
	 * @return the imgWidth
	 */
	public int getImgWidth() {
		return imgWidth;
	}
	
	/**
	 * @return the imgHeight
	 */
	public int getImgHeight() {
		return imgHeight;
	}
	
	/**
	 * @param imgWidth
	 *            the imgWidth to set
	 */
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}
	
	/**
	 * @param imgHeight
	 *            the imgHeight to set
	 */
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}
}
