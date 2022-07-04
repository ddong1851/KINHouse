package com.ssafy.model.dto;

public class AptSearchIsLoginVo {
	private String jibun;	//지번
	private String dong;	//법정동
	private String apartmentName;	//아파트
	private Integer buildYear;	//건축년도
	private Integer dealAmount; // 거래금액
	private String lat;	// 위도
	private String lng; // 경도
	private long no; // 거래번
	private long userCheckNo; // 유저가 체크한 거래번호
	private long aptCode; // 아파트코드
	private String userId; // 유저 id
	
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public Integer getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(Integer buildYear) {
		this.buildYear = buildYear;
	}
	public Integer getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(Integer dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	
	public long getUserCheckNo() {
		return userCheckNo;
	}
	public void setUserCheckNo(long userCheckNo) {
		this.userCheckNo = userCheckNo;
	}
	public long getAptCode() {
		return aptCode;
	}
	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AptSearchIsLoginVo [jibun=" + jibun + ", dong=" + dong + ", apartmentName=" + apartmentName
				+ ", buildYear=" + buildYear + ", dealAmount=" + dealAmount + ", lat=" + lat + ", lng=" + lng + ", no="
				+ no + ", userCheckNo=" + userCheckNo + ", aptCode=" + aptCode + ", userId=" + userId + "]";
	}
	
}
