package com.sunq.hello.time;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *@author sunq
 *@date2019/6/28 17:59
 *@Description
 */
public class TestList {


	public static <E> List<E> getDuplicateElements(List<E> list) {
		return list.stream()   // list 对应的 Stream
				.collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
				// 获得元素出现频率的 Map，键为元素，值为元素出现的次数
				.entrySet().stream()
				// 所有 entry 对应的 Stream
				.filter(entry -> entry.getValue() > 1)
				// 过滤出元素出现次数大于 1 的 entry
				.map(entry -> entry.getKey())
				// 获得 entry 的键（重复元素）对应的 Stream
				.collect(Collectors.toList());
		// 转化为 List
	}


	public static void main(String[] args) {

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
		//List<Student> repeatList = getDuplicateElements(testList);

		System.out.println("开始时间----->"+System.currentTimeMillis());
		List<Student> repeatList = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Set<String> exist = new HashSet<>();


		for (Student stu : testList) {
			if (set.contains(stu.getName())) {
				exist.add(stu.getName());
			} else {
				set.add(stu.getName());
			}
		}

		for (Student stu : testList) {
			if (exist.contains(stu.getName())){
				repeatList.add(stu);
			}
		}
		System.out.println("开始时间----->"+System.currentTimeMillis());

		for (Student stu : repeatList) {
			System.out.println(stu.getName());
		}
	}
}
