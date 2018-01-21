package com.serialization;

import java.io.Serializable;

public class UserDetails implements Serializable{
	//public UserDetails(){}
	
	public static final long serialVersionUID = 1L;

	private Integer fieldOne;
	private String fieldTwo;
	private boolean fieldThree;
	private static String str ;

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

	public static String getStr() {
		return str;
	}

	public static void setStr(String str) {
		UserDetails.str = str;
	}

	@Override
	public String toString() {
		return "UserSettings [fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo
				+ ", fieldThree=" + fieldThree + " str= "+str +"]";
	}
}
