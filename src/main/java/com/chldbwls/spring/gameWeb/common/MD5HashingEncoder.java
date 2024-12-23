package com.chldbwls.spring.gameWeb.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingEncoder {
// 암호화 환경(비밀번호)
	
	public static String encode(String message) {
		String result = "";
		try {
			MessageDigest messageDigest =  MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes();
			
			messageDigest.update(bytes);
			
			byte[] digest = messageDigest.digest();
			
			for(int i = 0; i < digest.length; i++) {
//				여기에 누적해서 더한다			byte 값을 16진수로 변환하기 위한 값(하나하나를 얻어내는것)
				result += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// 인자로 받은 알고리즘이 없다면
			e.printStackTrace();
			return null;
		}
		
		return result;
		}
}
