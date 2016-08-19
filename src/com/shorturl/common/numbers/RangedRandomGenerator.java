package com.shorturl.common.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import com.shorturl.common.exception.UnsupportedDataTypeException;

/**
 * Generates a random number for the given type within the specified range.
 * 
 * @author Pradeep Kumar
 * @param <T> The Type for which the random number is to be generated.
 */
public class RangedRandomGenerator<T extends Number> {
	// The starting number for the range.
	private T startNum;

	// The ending number for the range.
	private T endNum;

	// Pseudorandom number generator instance
	private Random randomGenerator;

	/**
	 * Create a random number generator with the specified range
	 * @param argStartNum Starting number for the range
	 * @param argEndNum Ending number for the range
	 */
	public RangedRandomGenerator(T argStartNum, T argEndNum) {
		this.startNum = argStartNum;
		this.endNum = argEndNum;
		this.randomGenerator = new Random();
	}

	/**
	 * Generate a random number
	 * @return A random number
	 */
	@SuppressWarnings("unchecked")
	public T getRandomNumber() throws UnsupportedDataTypeException {
		T randomNumber = null;
		if (startNum instanceof Integer) {
			int temp = (int) (startNum.intValue() + (endNum.intValue() - startNum.intValue()) * randomGenerator.nextDouble());
			randomNumber = (T) new Integer(temp);
		} else if (startNum instanceof Long) {
			long temp = (long) (startNum.longValue() + (endNum.longValue() - startNum.longValue()) * randomGenerator.nextDouble());
			randomNumber = (T) new Long(temp);
		} else if (startNum instanceof BigInteger) {
			BigDecimal temp = new BigDecimal(((BigInteger) endNum).subtract((BigInteger)startNum));
			temp = temp.multiply(BigDecimal.valueOf(randomGenerator.nextDouble()));
			temp.add(new BigDecimal((BigInteger)startNum));
			randomNumber = (T) temp.toBigInteger();
		} else {
			throw new UnsupportedDataTypeException(startNum.getClass());
		}
		return randomNumber;
	}
}
