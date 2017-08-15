package com.hotent.core.util;

import com.hotent.core.encrypt.EncryptUtil;

public class EncrptUtilTest {
	
	
	public static void main(String[] args) throws Exception {
		String str=EncryptUtil.encrypt("aaa");
		
		String out=EncryptUtil.decrypt(str);
		System.out.println(str);
	}
}
