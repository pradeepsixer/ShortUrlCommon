/**
 * 
 */
package com.shorturl.common;

/**
 * @author Pradeep Kumar
 *
 */
public class ArrayUtil {
	/**
	 * Check whether the integer number is a member of the integer array
	 * @param array Integer Array
	 * @param num The number whose membership is to be tested in the array
	 * @return <code>true</code> if contained, <code>false</code> if not
	 */
	public static boolean contains(int[] array, int num) {
		for (int temp : array) {
			if (temp == num) {
				return true;
			}
		}
		return false;
	}
}
