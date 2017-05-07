package net.projecteuler.problem.solutions;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;

/**
 * Solution to Project Euler Problem 345 (Matrix Sum)
 * 
 * @author Sarath Kumar Sivan
 * @see <a href="https://projecteuler.net/problem=345">Matrix Sum</a>
 * 
 */
public class Problem345Solution {

	/** Get actual class name to be printed on the logs. */
	private static final Logger logger = Logger.getLogger(Problem345Solution.class);

	/**
	 * Initializing the Matrix with the input values. The input data set is
	 * loaded into a two dimensional array for computation.
	 */
	private static int[][] MATRIX = {

			{ 7, 53, 183, 439, 863, 497, 383, 563, 79, 973, 287, 63, 343, 169, 583 },
			{ 627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583, 639, 913 },
			{ 447, 283, 463, 29, 23, 487, 463, 993, 119, 883, 327, 493, 423, 159, 743 },
			{ 217, 623, 3, 399, 853, 407, 103, 983, 89, 463, 290, 516, 212, 462, 350 },
			{ 960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172, 812, 350 },
			{ 870, 456, 192, 162, 593, 473, 915, 45, 989, 873, 823, 965, 425, 329, 803 },
			{ 973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165, 992, 326 },
			{ 322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601, 95, 973 },
			{ 445, 721, 11, 525, 473, 65, 511, 164, 138, 672, 18, 428, 154, 448, 848 },
			{ 414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430, 392, 198 },
			{ 184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284, 760, 390 },
			{ 821, 461, 843, 513, 17, 901, 711, 993, 293, 157, 274, 94, 192, 156, 574 },
			{ 34, 124, 4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823, 329, 699 },
			{ 815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251, 631, 107 },
			{ 813, 883, 451, 509, 615, 77, 281, 613, 459, 205, 380, 274, 302, 35, 805 } };
	/**
	 * Number of rows in the matrix.
	 */
	private static final int ROWS = MATRIX.length;

	/**
	 * Number of columns in the matrix.
	 */
	private static final int COLUMNS = MATRIX[0].length;

	/**
	 * Two dimensional array used to store the results of getMaximumSum calls
	 * and returning the cached result when the same inputs occur again.
	 */
	private int[][] maximumSum;

	/**
	 * Returns the Matrix Sum of a matrix as the maximum sum of matrix elements
	 * with each element being the only one in his row and column. Since the
	 * matrix elements of {@code maximumSum} are positive, initializing to 0.
	 * 
	 * @return maximum sum of matrix elements
	 */
	public int getMaximumSum() {
		maximumSum = new int[ROWS][1 << COLUMNS];
		return getMaximumSum(0, (1 << COLUMNS) - 1);
	}

	/**
	 * Returns the maximum sum when considering the sub matrix from row
	 * {@code row} until the bottom, with the bit set {@code columns} indicating
	 * which column indexes are still free to be used.
	 * 
	 * @param row
	 *            the start row
	 * @param columns
	 *            bit set indicates which column indexes are still free to be
	 *            used.
	 * @return the maximum sum when considering the sub matrix from row
	 *         {@code row} until the bottom.
	 */
	private int getMaximumSum(int row, int columns) {
		if (row == ROWS) {
			if (Integer.bitCount(columns) != COLUMNS - ROWS)
				throw new AssertionError();
			return 0;
		}

		if (maximumSum[row][columns] == 0) {
			int maximum = 0;
			for (int column = 0; (1 << column) <= columns; column++) {
				if ((columns & (1 << column)) != 0) {
					maximum = Math.max(MATRIX[row][column] + getMaximumSum(row + 1, columns ^ (1 << column)), maximum);
				}
			}
			maximumSum[row][columns] = maximum;
		}
		return maximumSum[row][columns];

	}

	/**
	 * The main method which makes use of getMaximumSum method. This is the main
	 * entry point of the problem solution.
	 * 
	 * @param args
	 *            Unused. No command line arguments are used in this program.
	 * @return Nothing
	 */
	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		Problem345Solution solution = new Problem345Solution();
		int maximumSum = solution.getMaximumSum();

		logger.info("Matrix Sum of the matrix is: " + maximumSum);
		logger.info("Execution completed in: " + stopwatch);
	}
}
