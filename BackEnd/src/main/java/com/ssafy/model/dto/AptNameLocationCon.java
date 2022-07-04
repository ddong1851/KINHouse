package com.ssafy.model.dto;


public class AptNameLocationCon {
	String apt_name, apt_dong_ga, apt_jibun, apt_con_year;
	double lat, lng;
	public String getApt_name() {
		return apt_name;
	}
	public void setApt_name(String apt_name) {
		this.apt_name = apt_name;
	}
	public String getApt_dong_ga() {
		return apt_dong_ga;
	}
	public void setApt_dong_ga(String apt_dong_ga) {
		this.apt_dong_ga = apt_dong_ga;
	}
	public String getApt_jibun() {
		return apt_jibun;
	}
	public void setApt_jibun(String apt_jibun) {
		this.apt_jibun = apt_jibun;
	}
	public String getApt_con_year() {
		return apt_con_year;
	}
	public void setApt_con_year(String apt_con_year) {
		this.apt_con_year = apt_con_year;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
}
