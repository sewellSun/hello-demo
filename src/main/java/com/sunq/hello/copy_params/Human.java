package com.sunq.hello.copy_params;

import java.util.List;

/**
 *@author sunq
 *@date2019/7/29 10:02
 *@Description
 */
public class Human {

	private String name;

	private Integer age;

	private List<Leg> legs;

	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Leg> getLegs() {
		return legs;
	}

	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Human{" + "name='" + name + '\'' + ", age=" + age + ", legs=" + legs + ", address='" + address + '\''
				+ '}';
	}
}
