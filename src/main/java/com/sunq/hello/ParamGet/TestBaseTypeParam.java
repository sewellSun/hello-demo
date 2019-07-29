package com.sunq.hello.ParamGet;

/**
 *@author sunq
 *@date2019/7/26 18:10
 *@Description
 */
public class TestBaseTypeParam {


	/**
	 * 结论
	 *
	 * 1、基本类型作为参数传递时，是传递值的拷贝，无论你怎么改变这个拷贝，原值是不会改变的
	 *
	 * 2、对象作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数。
	 * Java中的参数传递机制一直以来大家都争论不休，究竟是“传值”还是“传址（传引用）”，
	 * 争论的双方各执一词，互不相让。不但“菜鸟”们一头雾水，一些“老鸟”也只知道结果却说不出所以然来。
	 *
	 *
	 *  基本类型作为参数传递时，是传递值的拷贝，
	 *  无论你怎么改变这个拷贝，原值是不会改变的，输出的结果证明了这一点
	 */


	public static void main(String[] args) {

		int n = 3;
		System.out.println("Before change, n = " + n);

		changeData(n);

		System.out.println("After changeData(n), n = " + n);


		Integer n2 = new Integer(133);
		System.out.println("Before change, n = " + n2);

		changeData2(n2);

		System.out.println("After changeData2(n), n = " + n2);

	}

	public static void changeData(int data){
		data = 10;
	}

	public static void changeData2(Integer data){
		data = 10;
	}

}
