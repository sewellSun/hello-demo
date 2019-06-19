package com.sunq.hello.testenum;

public enum MyEnum {

	HEHE(1,"呵呵"),
	HAHA(2,"哈哈"),
	HEIHEI(3,"嘿嘿"),
	HENHEN(4,"哼哼");
	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	MyEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}


}
