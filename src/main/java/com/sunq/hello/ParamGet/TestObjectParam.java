package com.sunq.hello.ParamGet;

/**
 *@author sunq
 *@date2019/7/26 18:13
 *@Description
 */
public class TestObjectParam {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Hello ");

		System.out.println("Before change, sb = " + sb);

		changeData(sb);

		System.out.println("After changeData(n), sb = " + sb);

		/**
		 *  从结果来看，sb的值被改变了，那么是不是可以说：对象作为参数传递时，是把对象的引用传递过去，
		 *  如果引用在方法内被改变了，那么原对象也跟着改变。从上面例子的输出结果来看，这样解释是合理。
		 */

		/**
		 * 对象作为参数传递时，同样是在方法内改变了对象的值，为什么有的是改变了原对象的值，
		 * 而有的并没有改变原对象的值呢？这时候究竟是“传值”还是“传引用”呢？
		 */

		StringBuffer sb2 = new StringBuffer("Hello ");

		System.out.println("Before change, sb2 = " + sb2);

		changeData2(sb2);

		System.out.println("After changeData2(n), sb2 = " + sb2);

		/** 重要
		 * 在Java中对象作为参数传递时，是把对象在内存中的地址拷贝了一份传给了参数。
		 */


	}

	public static void changeData(StringBuffer strBuf) {

		strBuf.append("World!");

	}

	public static void changeData2(StringBuffer strBuf) {

		strBuf = new StringBuffer("Hi ");

		strBuf.append("World!");

	}




}
