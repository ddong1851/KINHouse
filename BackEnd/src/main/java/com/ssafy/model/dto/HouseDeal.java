package com.ssafy.model.dto;

public class HouseDeal {

	/** 거래 식별 번호*/
	private int no;
	/** 아파트 코드*/
	private int aptCode;
	/**거래 금액 */
	private String dealAmount;
	/**거래 연도*/
	private int dealYear;
	/**거래 월 */
	private int dealMonth;
	/**거래 일 */
	private int dealDay;
	/**전용면적 */
	private String area;
	/**층*/
	private String floor;
	
	public HouseDeal() {}
	
	public HouseDeal(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	};
	
	
	
}// end of class
