package com.sunq.hello.copy_params;

/**
 *@author sunq
 *@date2019/7/29 10:04
 *@Description
 */
public class Leg {


	private Integer length;

	private Integer num;

	private String legName;

	private Double weight;

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getLegName() {
		return legName;
	}

	public void setLegName(String legName) {
		this.legName = legName;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Leg{" + "length=" + length + ", num=" + num + ", legName='" + legName + '\'' + ", weight=" + weight
				+ '}';
	}
}
