package com.sunq.hello.testenum;

public class TestOr {


	public static void main(String[] args) {

		//System.out.println(false|false|false|false|false);
		//MyEnum.HAHA.
		//TestString testString = new TestString();
		//System.out.println(testString.testStr());


		/*String s = "1、哈哈哈\n2、呵呵呵";
		String ss = "Ios";
		System.out.println("ios".equalsIgnoreCase(ss));
		System.out.println("ios".equals(ss));*/
		for (int i=0;i<20;i++){
			int times = i;
			calculateUserBadgeByTimes(times);
			System.out.println(times);
		}

	}


	public static int calculateUserBadgeByTimes(int times) {
		/**
		 * 分享人数     得分
		 * 1                 15
		 * 2                 18
		 * 3                 10
		 * 4                 12
		 * 5                 13
		 * 6                 18
		 * 7                 10
		 * 8                 11
		 * 9                 12
		 * 10               13
		 * 11               20
		 */
		int[] badges = new int[15];

		badges[1] = 15;
		badges[2] = 18;
		badges[3] = 10;
		badges[4] = 12;
		badges[5] = 13;
		badges[6] = 18;
		badges[7] = 10;
		badges[8] = 11;
		badges[9] = 12;
		badges[10] = 13;
		badges[11] = 20;

		if (times < 1) {
			return badges[1];
		} else if (times > 10) {
			return badges[11];
		} else {
			return badges[times + 1];
		}
	}

}
