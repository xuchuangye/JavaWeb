package com.atguigu.base;


import java.util.Base64;

public class

Base64Test {
	public static void main(String[] args) throws Exception {
		String str = "我是中国人！";
		Base64.Encoder encoder = Base64.getEncoder();
		String s = encoder.encodeToString(str.getBytes("UTF-8"));
		System.out.println(s);//5oiR5piv5Lit5Zu95Lq677yB
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode(s.getBytes("UTF-8"));
		String string = new String(decode, "UTF-8");
		System.out.println(string);
	}
}
