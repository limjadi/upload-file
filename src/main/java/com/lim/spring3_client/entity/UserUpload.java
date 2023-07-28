package com.lim.spring3_client.entity;

import com.opencsv.bean.CsvBindByName;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
public class UserUpload {

	@CsvBindByName
	private String name;
	@CsvBindByName
	private String email;
	@CsvBindByName(column = "country")
	private String countryCode;
	@CsvBindByName
	private int age;

	public UserUpload() {
	}

	public UserUpload(String name, String email, String countryCode, int age) {
		this.name = name;
		this.email = email;
		this.countryCode = countryCode;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", countryCode='" + countryCode + '\''
				+ ", age=" + age + '}';
	}
}