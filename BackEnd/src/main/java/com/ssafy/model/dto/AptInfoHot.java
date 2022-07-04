package com.ssafy.model.dto;

public class AptInfoHot {
	String apartmentName, apt_code, dong, roadname;
	int cnt, img_num;
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getApt_code() {
		return apt_code;
	}
	public void setApt_code(String apt_code) {
		this.apt_code = apt_code;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	@Override
	public String toString() {
		return "AptInfoHot [apartmentName=" + apartmentName + ", apt_code=" + apt_code + ", dong=" + dong
				+ ", roadname=" + roadname + ", cnt=" + cnt + ", img_num=" + img_num + "]";
	}
}
