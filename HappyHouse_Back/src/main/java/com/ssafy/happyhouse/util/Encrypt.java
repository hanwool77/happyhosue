package com.ssafy.happyhouse.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.SecureRandom;

@Component
public class Encrypt {
	static private int SALT_SIZE = 16;

	// SALT 값 생성
	public String getSALT() throws Exception {
		SecureRandom rnd = new SecureRandom();
		byte[] temp = new byte[SALT_SIZE];
		rnd.nextBytes(temp);

		return Byte_to_String(temp);

	}

	// 바이트 값을 16진수로 변경해준다
	public String Byte_to_String(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for (byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}

	// 비밀번호 해싱
	public String Hashing(byte[] password, String Salt) throws Exception {

		MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256 해시함수를 사용

		String temp = Byte_to_String(password) + Salt;
		md.update(temp.getBytes());
		password = md.digest();

		return Byte_to_String(password);
	}
}
