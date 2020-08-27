package com.indiv.front.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cryptoUtil {

	/**
	 * SHA-256 암호화
	 * @param pass
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String sha256(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(pass.getBytes());
		return cryptoUtil.byteToHexString(md.digest());
	}
	
	/**
	 * HEX 문자열로 변환
	 * @param data
	 * @return
	 */
	public static String byteToHexString(byte[] data) {
		StringBuffer sb = new StringBuffer();
		for(byte b : data) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
