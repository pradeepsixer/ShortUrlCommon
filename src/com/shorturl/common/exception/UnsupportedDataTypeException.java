/**
 * 
 */
package com.shorturl.common.exception;

/**
 * When an unsupported data type is used (particularly within a generic)
 * @author Pradeep Kumar
 */
@SuppressWarnings("serial")
public class UnsupportedDataTypeException extends Exception {
	/**
	 * Create an {@link UnsupportedDataTypeException}
	 */
	public UnsupportedDataTypeException() {
		super("Invalid data type encountered");
	}

	/**
	 * Create an {@link UnsupportedDataTypeException} for the given class name
	 * @param clazz The unsupported data type's class
	 */
	public UnsupportedDataTypeException(Class<?> clazz) {
		super("Invalid data type encountered : " + clazz.getCanonicalName());
	}

	/**
	 * Create an {@link UnsupportedDataTypeException} for the given class name with the given message
	 * @param clazz The unsupported data type's class 
	 * @param message The message to be used while building the exception
	 */
	public UnsupportedDataTypeException(Class<?> clazz, String message) {
		super(message + " " + clazz.getCanonicalName());
	}
}
