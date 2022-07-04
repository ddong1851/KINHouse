package com.ssafy.model.dto;

public class HouseInfo {
	/** 아파트 식별 키*/
	private int aptCode;
	/**아파트 이름 */
	private String aptName;
	/**법정 동코드 */
	private String code;
	/**법정 동명 */
	private String dong;
	/**건축 연도*/
	private int buildYear;
	/**지번*/
	private String jibun;
//	/** 위도*/
//	private String lat;
//	/** 경도*/
//	private String lng;
//	/** 이미지경로?*/
//	private String img;
	
	public HouseInfo() {}
	
	public HouseInfo(int aptCode) {
	super();
	this.aptCode = aptCode;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void addCode(String code) {
		this.code +=code;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	@Override
	public String toString() {
		return "HouseInfo [aptCode=" + aptCode + ", aptName=" + aptName + ", code=" + code + ", dong=" + dong
				+ ", buildYear=" + buildYear + ", jibun=" + jibun + "]";
	}

//	public String getLat() {
//		return lat;
//	}
//
//	public void setLat(String lat) {
//		this.lat = lat;
//	}
//
//	public String getLng() {
//		return lng;
//	}
//
//	public void setLng(String lng) {
//		this.lng = lng;
//	}
//
//	public String getImg() {
//		return img;
//	}
//
//	public void setImg(String img) {
//		this.img = img;
//	};
	
	
}// end of class
