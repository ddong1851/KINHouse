package com.ssafy.model.dto;

public class LikedAptRequest {
	private String userId;
	private long aptCode;
	private long no;
//	private String regtime;
	private String apartmentName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getAptCode() {
		return aptCode;
	}
	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
//	public String getRegtime() {
//		return regtime;
//	}
//	public void setRegtime(String regtime) {
//		this.regtime = regtime;
//	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	@Override
	public String toString() {
		return "LikedAptRequest [userId=" + userId + ", aptCode=" + aptCode + ", no=" + no + ", apartmentName="
				+ apartmentName + "]";
	}
	
}
