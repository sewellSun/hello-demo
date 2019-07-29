package com.sunq.hello.copy_params;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *@author sunq
 *@date2019/7/29 10:00
 *@Description 测试属性拷贝
 */
public class CopyPropertiesTest {

	public static void main(String[] args) {

		List<Leg> legs = new ArrayList<>();

		Leg leg1 = new Leg();
		leg1.setLegName("左腿");
		leg1.setNum(1);
		leg1.setLength(1);
		leg1.setWeight(new Double(2));
		legs.add(leg1);

		Leg leg2 = new Leg();
		leg2.setLegName("右腿");
		leg2.setNum(1);
		leg2.setLength(1);
		leg2.setWeight(new Double(2));
		legs.add(leg2);



		Human human = new Human();

		human.setName("smith");
		human.setAge(1);
		human.setAddress("上海市长宁区天山路1718号");
		human.setLegs(legs);

		System.out.println("拷贝前的human属性");
		System.out.println(human.toString());

		Animal animal = new Animal();

		System.out.println("拷贝前的animal属性");
		System.out.println(animal.toString());

		// 拷贝属性
		BeanUtils.copyProperties(human,animal);

		System.out.println("拷贝后的human属性");
		System.out.println(human);

		System.out.println("拷贝后的animal属性");
		System.out.println(animal);

		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");

		List<Leg> legs2 = new ArrayList<>();

		System.out.println("拷贝前的legs属性");
		System.out.println(legs);

		System.out.println("拷贝前的legs2属性");
		System.out.println(legs2);
		// 拷贝属性
		//BeanUtils.copyProperties(legs,legs2);

		legs2 = JSON.parseArray(JSON.toJSONString(legs), Leg.class);


		System.out.println("拷贝后的legs属性");
		System.out.println(legs);

		System.out.println("拷贝后的legs2属性");
		System.out.println(legs2);







	}
}
