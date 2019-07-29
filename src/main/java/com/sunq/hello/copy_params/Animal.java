package com.sunq.hello.copy_params;

import java.util.List;

/**
 *@author sunq
 *@date2019/7/29 10:02
 *@Description
 */
public class Animal {

	private String name;

	private Integer age;

	private List<Leg> legs;


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

	@Override
	public String toString() {
		return "Animal{" + "name='" + name + '\'' + ", age=" + age + ", legs=" + legs + '}';
	}
}
