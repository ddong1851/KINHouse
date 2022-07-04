package com.ssafy.model.dto;

public class Liked_apt {
	String apartmentName, roadName, dong, no, apt_code;
	int id, buildYear;
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getApt_code() {
		return apt_code;
	}
	public void setApt_code(String apt_code) {
		this.apt_code = apt_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	@Override
	public String toString() {
		return "Liked_apt [apartmentName=" + apartmentName + ", roadName=" + roadName + ", dong=" + dong + ", no=" + no
				+ ", apt_code=" + apt_code + ", id=" + id + ", buildYear=" + buildYear + "]";
	}
	
}
