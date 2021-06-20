package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {

  /* Private Fields */

	private int catId; // 카테고리 아이디
	private String catName; // 카테고리 이름
	private String parentCatName; // 부모 카테고리 이름
	private String childCatName; // 자식 카테고리 이름
	private int catIdRef; // 참조하는 카테고리 아이디
	private int level; // 카테고리 계층
	
	
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
