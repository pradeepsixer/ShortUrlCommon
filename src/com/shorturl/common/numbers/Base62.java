package com.shorturl.common.numbers;

import java.math.BigInteger;

import com.shorturl.common.CommonConstants.CharacterConstants;
import com.shorturl.common.CommonConstants.NumericConstants;

/**
 * This class deals with the encoding and the decoding of the Base62 values.
 * 
 * @author Pradeep Kumar
 */
public class Base62 {

	/**
	 * The digits involved in the Base62 encoding scheme
	 */
	private static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final int BASE_INT = 62;
	private static final BigInteger BASE = BigInteger.valueOf(62);

	/**
	 * Prevent Instantiation with private constructor
	 */
	private Base62() {
	}

	/**
	 * Encode the given {@link BigInteger} in the Base62 encoding scheme. No
	 * padding will be done.
	 * 
	 * @param number
	 *            Number (a BigInteger)
	 * @return Base62 encoded value for the given number.
	 */
	public static String encode(BigInteger number) {
		return encode(number, NumericConstants.ZERO, CharacterConstants.ZERO);
	}

	/**
	 * Encode the given {@link BigInteger} in the Base62 encoding scheme. The
	 * padding character {code 0} will be padded at the start of the resulting
	 * string, if the number of the characters in the encoded string produced is
	 * less than the number of expected characters
	 * 
	 * @param number
	 *            Number (a BigInteger)
	 * @param paddingNum
	 *            The number of characters to be expected in the resulting
	 *            string, less than which the padding will be done
	 * @return Base62 encoded value for the given number.
	 */
	public static String encode(BigInteger number, int paddingNum) {
		return encode(number, paddingNum, CharacterConstants.ZERO);
	}

	/**
	 * Encode the given {@link BigInteger} in the Base62 encoding scheme. The
	 * padding character will be padded at the start of the resulting string, if
	 * the number of the characters in the encoded string produced is less than
	 * the number of expected characters
	 * 
	 * @param number
	 *            Number (a BigInteger)
	 * @param numCharsExpected
	 *            The number of characters to be expected in the resulting
	 *            string, less than which the padding will be done
	 * @param paddingChar
	 *            The character to be padded at the start of the encoded string
	 * @return Base62 encoded value for the given number.
	 */
	public static String encode(BigInteger number, int numCharsExpected, char paddingChar) {

		/*
		 * Algorithm: Until the number 'n' is greater than 0: Remainder = n % 62
		 * EncStr = EncStr + DIGITS[Remainder] n = n / 62 (The quotient now
		 * becomes n)
		 */

		StringBuilder encodedStringSb = new StringBuilder();
		int remainder = -1;
		while (number.compareTo(BigInteger.ZERO) > 0) {
			remainder = number.mod(BASE).intValue();
			encodedStringSb.append(DIGITS.charAt(remainder));
			number = number.divide(BASE);
		}

		prependPaddingChars(encodedStringSb, numCharsExpected, paddingChar);
		return encodedStringSb.toString();
	}

	/**
	 * Decode the given Base62 encoded string to a {@link BigInteger}
	 * 
	 * @param base62EncStr
	 *            Base62 encoded string
	 * @return BigInteger value for the given Base62 encoded string
	 */
	public static BigInteger decodeBigInt(String base62EncStr) {
		/*
		 * Algorithm: The digits in the String are multiplied by 62 raised to
		 * its appropriate power and summed up.
		 * 
		 * For each Digit in Encoded String (Reversed): Temp = Digit's decimal
		 * value Temp = Temp * 62 ^ i Result = Result + Temp
		 */

		int len = base62EncStr.length();
		BigInteger result = BigInteger.ZERO, temp;
		for (int i = 0; i < len; i++) {
			temp = BigInteger.valueOf(DIGITS.indexOf(base62EncStr.charAt(len - i - 1)));
			temp = temp.multiply(BASE.pow(i));
			result = result.add(temp);
		}
		return result;
	}

	/**
	 * Encode the given long number in the Base62 encoding scheme. No
	 * padding will be done.
	 * 
	 * @param number a long number
	 * @return Base62 encoded value for the given number.
	 */
	public static String encode(long number) {
		return encode(number, NumericConstants.ZERO, CharacterConstants.ZERO);
	}

	/**
	 * Encode the given long number in the Base62 encoding scheme. The
	 * padding character {code 0} will be padded at the start of the resulting
	 * string, if the number of the characters in the encoded string produced is
	 * less than the number of expected characters
	 * 
	 * @param number
	 *            Number (a BigInteger)
	 * @param numCharsExpected
	 *            The number of characters to be expected in the resulting
	 *            string, less than which the padding will be done
	 * @return Base62 encoded value for the given number.
	 */
	public static String encode(long number, int numCharsExpected) {
		return encode(number, numCharsExpected, CharacterConstants.ZERO);
	}

	/**
	 * Encode the given {@link Long} in the Base62 encoding scheme. The padding
	 * character will be padded at the start of the resulting string, if the
	 * number of the characters in the encoded string produced is less than the
	 * number of expected characters.
	 * 
	 * @param number
	 *            Number (a Long)
	 * @param numCharsExpected
	 *            The number of characters to be expected in the resulting
	 *            string, less than which the padding will be done
	 * @param paddingChar
	 *            The character to be padded at the start of the encoded string
	 * @return Base62 encoded value for the given number.
	 */
	public static String encode(long number, int numCharsExpected, char paddingChar) {

		/*
		 * Algorithm: Until the number 'n' is greater than 0: Remainder = n % 62
		 * EncStr = EncStr + DIGITS[Remainder] n = n / 62 (The quotient now
		 * becomes n)
		 */

		StringBuilder encodedStringSb = new StringBuilder();
		int remainder = -1;
		while (number > 0) {
			remainder = (int) (number % BASE_INT);
			encodedStringSb.append(DIGITS.charAt(remainder));
			number = number / BASE_INT;
		}

		prependPaddingChars(encodedStringSb, numCharsExpected, paddingChar);
		return encodedStringSb.toString();
	}

	/**
	 * Decode the given Base62 encoded string to a long number
	 * 
	 * @param base62EncStr
	 *            Base62 encoded string
	 * @return Long value for the given Base62 encoded string
	 */
	public static long decodeLong(String base62EncStr) {
		/*
		 * Algorithm: The digits in the String are multiplied by 62 raised to
		 * its appropriate power and summed up.
		 * 
		 * For each Digit in Encoded String (Reversed): Temp = Digit's decimal
		 * value Temp = Temp * 62 ^ i Result = Result + Temp
		 */

		int len = base62EncStr.length();
		long result = 0, temp;
		for (int i = 0; i < len; i++) {
			temp = DIGITS.indexOf(base62EncStr.charAt(len - i - 1));
			temp *= Math.pow(BASE_INT, i);
			result += temp;
		}
		return result;
	}

	/**
	 * Prepend the padding characters, when the length of the encoded string is
	 * less than the number of expected characters
	 * 
	 * @param encStrSb
	 *            The encoded string whose length is to be compared
	 * @param numCharsExpected
	 *            Number of characters to be expected in the encoded string
	 * @param paddingChar
	 *            The character to be padded
	 */
	private static void prependPaddingChars(final StringBuilder encStrSb, final int numCharsExpected,
			final char paddingChar) {
		while (encStrSb.length() < numCharsExpected) {
			encStrSb.insert(0, paddingChar);
		}
	}
}
