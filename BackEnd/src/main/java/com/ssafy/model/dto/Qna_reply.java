package com.ssafy.model.dto;

public class Qna_reply {
	int no, qna_no;
	String author, content, regtime;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "Qna_reply [no=" + no + ", qna_no=" + qna_no + ", author=" + author + ", content=" + content
				+ ", regtime=" + regtime + "]";
	}
}
