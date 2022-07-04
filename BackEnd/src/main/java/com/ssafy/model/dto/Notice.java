package com.ssafy.model.dto;

public class Notice {
	int no, hits;
	String title, content, id, regtime;
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Notice [no=" + no + ", hits=" + hits + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", regtime=" + regtime + "]";
	}
	

}
