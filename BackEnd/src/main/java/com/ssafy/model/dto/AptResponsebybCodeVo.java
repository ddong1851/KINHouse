package com.ssafy.model.dto;

import java.util.List;

import com.ssafy.util.PageNavigation;

public class AptResponsebybCodeVo {
	List<AptSearchBybCodeVo> list;
	PageNavigation navigation;
	private String key;
	private String word;
	private int currentPage;
	
	public List<AptSearchBybCodeVo> getList() {
		return list;
	}
	public void setList(List<AptSearchBybCodeVo> list) {
		this.list = list;
	}
	public PageNavigation getNavigation() {
		return navigation;
	}
	public void setNavigation(PageNavigation navigation) {
		this.navigation = navigation;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public AptResponsebybCodeVo(List<AptSearchBybCodeVo> list, PageNavigation navigation, String key, String word, int currentPage) {
		super();
		this.list = list;
		this.navigation = navigation;
		this.key = key;
		this.word = word;
		this.currentPage = currentPage;
		
	}
	
	
}
