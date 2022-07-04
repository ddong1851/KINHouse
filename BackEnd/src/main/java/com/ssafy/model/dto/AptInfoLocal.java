package com.ssafy.model.dto;

public class AptInfoLocal {
	String apartmentName, dong, roadName, dist;
	int buildYear, img_num;
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	@Override
	public String toString() {
		return "AptInfoLocal [apartmentName=" + apartmentName + ", dong=" + dong + ", roadName=" + roadName + ", dist="
				+ dist + ", buildYear=" + buildYear + ", img_num=" + img_num + "]";
	}
}
