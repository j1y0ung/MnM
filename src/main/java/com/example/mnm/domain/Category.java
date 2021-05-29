package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {

  /* Private Fields */

	private int catId;
	private String catName;
	private String parentCatName;
	private String childCatName;
	private int catIdRef;
	private int level;
	
	
	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public String getParentCatName() {
		return parentCatName;
	}


	public void setParentCatName(String parentCatName) {
		this.parentCatName = parentCatName;
	}


	public String getChildCatName() {
		return childCatName;
	}


	public void setChildCatName(String childCatName) {
		this.childCatName = childCatName;
	}


	public int getCatIdRef() {
		return catIdRef;
	}


	public void setCatIdRef(int catIdRef) {
		this.catIdRef = catIdRef;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + ", parentCatName=" + parentCatName
				+ ", childCatName=" + childCatName + ", catIdRef=" + catIdRef + ", level=" + level + "]";
	}
	
}
