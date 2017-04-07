package org.filecab.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;



public final class EncryptionUtils {

	public static final String CHARSET_UTF8 = "UTF8";
	private EncryptionUtils() {
	}
	
	public static String encrypt(String unencryptedString) {
		String reversed = StringUtils.reverse(unencryptedString);
		return Base64.encodeBase64String(reversed.getBytes());
	}
	
	public static String decrypt(String encryptedString) {
		String returnVal = new String();
		byte[] decodedBytes = Base64.decodeBase64(encryptedString);
		
		try {
			String decodedValue = new String(decodedBytes, CHARSET_UTF8);
			returnVal = StringUtils.reverse(decodedValue);
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		
		return returnVal;
	}
}
