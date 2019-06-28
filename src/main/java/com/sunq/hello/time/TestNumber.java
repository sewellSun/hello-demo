package com.sunq.hello.time;

import java.util.*;

/**
 *@author sunq
 *@date2019/6/28 10:21
 *@Description
 */
public class TestNumber {
	public static void main(String[] args) {

		/*List<Integer> orderType = new ArrayList<>();

		orderType.add(5);
		orderType.add(3);

		if (orderType.contains(5)){
			System.out.println(5);
		}else if (orderType.contains(6)){
			System.out.println(6);
		}else {
			System.out.println(3);
		}*/


		List<Student> testList = new ArrayList<Student>();
		testList.add(new Student("张一"));
		testList.add(new Student("张二"));
		testList.add(new Student("张三"));
		testList.add(new Student("老王"));
		testList.add(new Student("张四"));
		testList.add(new Student("张五"));
		testList.add(new Student("张六"));
		testList.add(new Student("张七"));
		testList.add(new Student("老王"));
		testList.add(new Student("张八"));
		testList.add(new Student("张九"));
		testList.add(new Student("老王"));
		for (int i = 0;i<10000;i++){
			testList.add(new Student("张"+i));
		}



		System.out.println("开始时间----->"+System.currentTimeMillis());
		List<Student> repeatList = new ArrayList<Student>();//用于存放重复的元素的list
		List<Student> tempList = testList;//用于存放重复的元素的list

		int flag = 0;
		Student student;
		Student student2;

		/**
		 * 先拷贝一份集合，遍历完临时集合，找到重复元素，如果有就保存下重复元素，并且再使用一个迭代器遍历临时集合，删除与当前元素相等的元素（包含当前元素）
		 * 注意：： 迭代器只能使用一次，使用时必须要再生成一次，具体原理百度，没时间弄
		 */

		//外层循环  拿到每一个元素看是否有重复的
		for (int i = 0; i < testList.size(); i++) {
			student = testList.get(i);
			//获取复制的临时集合的迭代器
			Iterator<Student> ite = tempList.iterator();
			//迭代看有没有重复的，因为自己与自己算重复的，那么flag最小是1，如果大于一表示至少有两个元素的name属性一样
			while (ite.hasNext()) {
				student2 = ite.next();
				//复制的集合 的每个元素和当前 testList.get(i) 元素的name属性进行比较，相等flag 加1
				if (student.getName().equals(student2.getName())) {
					flag++;
				}
			}
			//判断flag属性，如果大于1，那么就当前 的 testList.get(i)的name属性有重复，保存当前testList.get(i)的元素
			if (flag > 1) {
				repeatList.add(student);
			}
			//一个循环结束，flag 清零
			flag = 0;
		}

		System.out.println("开始时间----->"+System.currentTimeMillis());

		for (Student stu : repeatList) {
			System.out.println(stu.getName());
		}

	}
}
