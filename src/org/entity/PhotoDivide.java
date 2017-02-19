package org.entity;

import java.util.List;

public class PhotoDivide {
	
	private int photoCode=1;
	//分页的页数
	private long totalRecored;
	//总的照片数
	private int totalPhoto;
	private List<Photo> photoList;
	
	public int getPhotoCode() {
		return photoCode;
	}

	public void setPhotoCode(int photoCode) {
		this.photoCode = photoCode;
	}

	public long getTotalRecored() {
		int temp = totalPhoto/18;
		return totalPhoto%18>0?temp+1:temp;
	}

	public int getTotalPhoto() {
		return totalPhoto;
	}

	public void setTotalPhoto(long totalPhoto) {
		this.totalPhoto = (int)totalPhoto;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	@Override
	public String toString() {
		return "PhotoDivide [photoCode=" + photoCode + ", totalRecored="
				+ getTotalRecored() + ", totalPhoto=" + totalPhoto + ", photoList="
				+ photoList + "]";
	}

}
