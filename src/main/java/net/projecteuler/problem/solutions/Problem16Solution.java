package net.projecteuler.problem.solutions;

import java.math.BigInteger;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;

/**
 * Solution to Project Euler Problem 16 (Power digit sum)
 * 
 * @author Sarath Kumar Sivan
 * @see <a href="https://projecteuler.net/problem=16">Power digit sum</a>
 * 
 */
public class Problem16Solution {

	/** Get actual class name to be printed on the logs. */
	private static final Logger logger = Logger.getLogger(Problem16Solution.class);

	/**
	 * Returns the sum of the digits of the given base to the power. The
	 * {@link BigInteger} class is being used for handling very large integers
	 * (bigger than 64 bit values). {@link BigInteger} class can handle very
	 * large integers and the size of the integer is only limited by the
	 * available memory of the JVM.
	 * 
	 * <p>
	 * Since the value of base and exponent is known in this problem, we can
	 * directly use {@code BigInteger.ONE.shiftLeft(1000)} to calculate the
	 * power value, but {@code BigInteger.valueOf(base).pow(exponent)} is being
	 * used here in this method so that we can reuse the
	 * {@code getPowerDigitSumOf} method by passing base and exponent for
	 * finding the power digit sum of other numbers too.
	 * <p>
	 * 
	 * @param base
	 *            the base number for repeated multiplication of the same
	 *            factor.
	 * @param exponent
	 *            the number of times the base is used as a factor.
	 * @return {@code sum} the sum of the digits of the number
	 *         base<sup>exponent</sup>.
	 */
	public static int getPowerDigitSumOf(int base, int exponent) {
		BigInteger num = BigInteger.valueOf(base).pow(exponent);
		String digits = num.toString();
		int sum = 0;
		for (int i = 0; i < digits.length(); i++) {
			int digit = (int) (digits.charAt(i) - '0');
			sum = sum + digit;
		}
		return sum;
	}

	/**
	 * Returns the sum of the digits of the number 2<sup>1000</sup>. This method
	 * calls the {@code getPowerDigitSumOf} method to calculate the sum.
	 * 
	 * @return {@code sum} the sum of the digits of the number 2<sup>1000</sup>
	 */
	public int getPowerDigitSum() {
		return getPowerDigitSumOf(2, 1000);
	}

	/**
	 * The main method which makes use of getPowerDigitSum method. This is the
	 * main entry point of the problem solution.
	 * 
	 * @param args
	 *            Unused. No command line arguments are used in this program.
	 * @return Nothing
	 */
	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		Problem16Solution solution = new Problem16Solution();
		int powerDigitSum = solution.getPowerDigitSum();

		logger.info("The sum of the digits of the number 2^1000 is: " + powerDigitSum);
		logger.info("Execution completed in: " + stopwatch);
	}

}
