package com.remesh.interview.dto;

public class QueryParam {

	private String age;
	private String sex;
	private String income;
	private String livingEnvironment;

	public String getAge() {
		return age;
	}

	public void setAge(String age) throws Exception {
		this.age = age;

	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) throws Exception {
		this.income = income;
	}

	public String getLivingEnvironment() {
		return livingEnvironment;
	}

	public void setLivingEnvironment(String livingEnvironment) {
		this.livingEnvironment = livingEnvironment;
	}
}
