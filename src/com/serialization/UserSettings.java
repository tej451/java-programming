package com.serialization;

public class UserSettings {

	

	private Integer fieldOne;
	private String fieldTwo;
	private boolean fieldThree;
	
	private static String fieldFour;

	public Integer getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(Integer fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public boolean isFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(boolean fieldThree) {
		this.fieldThree = fieldThree;
	}

	public static String getFieldFour() {
		return fieldFour;
	}

	public static void setFieldFour(String fieldFour) {
		UserSettings.fieldFour = fieldFour;
	}

	@Override
	public String toString() {
		return "UserSettings [fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo
				+ ", fieldThree=" + fieldThree + ", fieldFour=" + fieldFour+"]";
	}
}
