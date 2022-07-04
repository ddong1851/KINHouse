package com.ssafy.model.dto;

public class Interest {
	String dongCode, id;

	
	public Interest() {}
	
	public Interest(String dongCode, String id) {
		super();
		this.dongCode = dongCode;
		this.id = id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return dongCode;
	}
	/**
	 * @param content the content to set
	 */
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Interest [dongCode=" + dongCode + ", id=" + id + "]";
	}
	
}
