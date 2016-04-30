/**
 * 
 */
package com.shorturl.security;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * Message Digest Utility class. Digests the message and presents it in the following formats:
 * <ul>
 * <li>1. Base 64 Encoded String</li>
 * <li>2. Hex (Base 16) Encoded String</li>
 * </ul>
 * @author Pradeep Kumar
 */
public class DigestUtil {
	// Prevent Instantiation since this is a utility class
	private DigestUtil() {
	}

	/**
	 * Returns a base 64 encoded digest of the given input byte array
	 * @param digest The {@link MessageDigest Message Digest} to be used
	 * @param hashInput The input which should be digested
	 * @return Base 64 encoded digest
	 */
	public static String base64EncodedHash(MessageDigest digest, byte[] hashInput) {
		byte[] hashOutput = digest.digest(hashInput);
		return new String(Base64.getEncoder().encode(hashOutput));
	}

	/**
	 * Returns a base 64 encoded digest of the given input string
	 * @param digest The {@link MessageDigest Message Digest} to be used
	 * @param input The input string whose message digest would be produced
	 * @return Base 64 encoded digest
	 */
	public static String base64EncodedHash(MessageDigest digest, String input) {
		return base64EncodedHash(digest, input.getBytes());
	}

	/**
	 * Returns a hex encoded digest of the given input byte array
	 * @param digest The {@link MessageDigest Message Digest} to be used
	 * @param hashInput The input which should be digested
	 * @return hex encoded digest
	 */
	public static String hexEncodedHash(MessageDigest digest, byte[] hashInput) {
		byte[] hashOutput = digest.digest(hashInput);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hashOutput.length; i++) {
			sb.append(Integer.toString((hashOutput[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	/**
	 * Returns a hex encoded digest of the given input string
	 * @param digest The {@link MessageDigest Message Digest} to be used
	 * @param input The input string whose message digest would be produced
	 * @return hex encoded digest
	 */
	public static String hexEncodedHash(MessageDigest digest, String input) {
		return hexEncodedHash(digest, input.getBytes());
	}
}
