package com.wind.utils.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hsc
 */
public class BigDecimalUtil {

	/**
	 * 除法  保留两位小数
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @return 值
	 */
	public static double div(double dividend, double divisor) {
		if (compareZero(divisor)) {
			return 0.0;
		}
		return BigDecimal.valueOf(dividend).divide(BigDecimal.valueOf(divisor), 2, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * 保留两位小数
	 * @param value 值
	 * @return 值
	 */
	public static double haleUp(double value) {
		return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public static boolean compareZero(double value) {
		return BigDecimal.valueOf(value).compareTo(BigDecimal.ZERO) == 0;
	}
}
