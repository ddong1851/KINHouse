package com.ssafy.model.dto;

public class Qna {
	private int no;
	private String userid;
	private String title;
	private String content;
	private int hits;
	private String regtime;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "Qna [no=" + no + ", userid=" + userid + ", title=" + title + ", content=" + content + ", hits=" + hits
				+ ", regtime=" + regtime + "]";
	}
	
}
