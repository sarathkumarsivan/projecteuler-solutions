package net.projecteuler.problem.solutions;

import java.util.PriorityQueue;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;

/**
 * Solution to Project Euler Problem 500 (Problem 500!!!)
 * 
 * @author Sarath Kumar Sivan
 * @see <a href="https://projecteuler.net/problem=500">Problem 500!!!</a> Find
 *      the smallest number with 2<sup>500500</sup> divisors.
 * 
 */
public class Problem500Solution {

	/** Get actual class name to be printed on the logs. */
	private static final Logger logger = Logger.getLogger(Problem500Solution.class);

	/**
	 * The limit to be used to find the 2<sup>500500</sup>divisors
	 */
	private static final int MAX = 10000000;

	private static final long MODULUS = 500500507L;

	/**
	 * Exponent value to be used to find the smallest number with
	 * 2<sup>500500</sup>divisors. The priority queue to keep track of the
	 * smallest prime power is initialized with this capacity.
	 */
	private static final int EXPONENT = 500500;

	/**
	 * Priority queue to keep track of the smallest prime power.
	 */
	private PriorityQueue<Prime> primes;

	/**
	 * Computes the smallest number with 2<sup>500500</sup>divisors, apply the
	 * modulo operation with 500500507 and returns the result.
	 * 
	 * It uses a {@code PriorityQueue} with initial capacity of 500500 that
	 * orders the {@code Prime} elements according to the
	 * {@code PrimeComparator} comparator.
	 *
	 * @return result the smallest number with 2<sup>500500</sup>divisors %
	 *         500500507
	 */
	public long compute() {
		primes = new PriorityQueue<Prime>(EXPONENT, new PrimeComparator());
		boolean[] sieve = new boolean[MAX];

		for (int i = 2; i < MAX; ++i) {
			if (!sieve[i]) {
				Prime prime = new Prime(Math.log(i), i);
				primes.add(prime);
				int j = i + i;
				while (j < MAX) {
					sieve[j] = true;
					j += i;
				}
			}
		}
		long result = 1L;
		for (int i = 0; i < EXPONENT; ++i) {
			Prime prime = primes.remove(); // First item from the priority queue
			result = result * prime.getValue() % MODULUS;
			prime.setLog(prime.getLog() * 2);
			prime.setValue(prime.getValue() * prime.getValue() % MODULUS);
			primes.add(prime);
		}
		return result;
	}

	/**
	 * The main method which makes use of compute method. This is the main entry
	 * point of the problem solution.
	 * 
	 * @param args
	 *            Unused. No command line arguments are used in this program.
	 * @return Nothing
	 */
	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		Problem500Solution solution = new Problem500Solution();

		long result = solution.compute(); // computing the result

		logger.info("Smallest number with 2^500500 divisors (modulo 500500507): " + result);
		logger.info("Execution completed in: " + stopwatch);
	}

}
