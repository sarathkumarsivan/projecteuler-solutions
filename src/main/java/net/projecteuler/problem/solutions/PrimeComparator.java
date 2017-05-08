package net.projecteuler.problem.solutions;

import java.util.Comparator;

/**
 * The {@code PrimeComparator} is an implementation of {@code Comparator}
 * interface to order the objects of Prime. Using {@code PrimeComparator}, we
 * can sort the elements based on log data member value (the natural logarithm).
 * 
 * @author Sarath Kumar Sivan
 * @see Comparable
 * 
 */
public class PrimeComparator implements Comparator<Prime> {

	/**
	 * Compares its two arguments for order. Returns a negative integer, zero,
	 * or a positive integer as the first argument is less than, equal to, or
	 * greater than the second. Comparison is based on {@code log} data member
	 * value (the natural logarithm) of two Prime objects.
	 * 
	 * @param curr
	 *            the first object of Prime to be compared.
	 * @param next
	 *            the second object of Prime to be compared.
	 * @return a negative integer, zero, or a positive integer as the first
	 *         argument is less than, equal to, or greater than the second.
	 */
	public int compare(Prime curr, Prime next) {
		if (curr.getLog() < next.getLog())
			return -1;
		if (curr.getLog() == next.getLog())
			return 0;
		return 1;
	}

}
