/**
 * 
 */
package com.shorturl.common.string;

import com.shorturl.common.CommonConstants.StringConstants;

/**
 * Util class for common string related operations
 * @author Pradeep Kumar
 */
public class StringUtil {
	private StringUtil() {
	}

	/**
	 * Checks whether a string is empty (null safe)
	 * @param inputStr The string to be checked
	 * @return {@code true} if empty, {@code false} if not.
	 */
	public static boolean isEmpty(String inputStr) {
		if (inputStr == null || inputStr.equals(StringConstants.EMPTY_STRING))
			return true;
		return false;
	}
}
