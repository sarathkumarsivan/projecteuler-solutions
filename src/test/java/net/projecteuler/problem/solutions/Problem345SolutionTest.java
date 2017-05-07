package net.projecteuler.problem.solutions;

import junit.framework.TestCase;

import net.projecteuler.problem.solutions.Problem345Solution;

/**
 * Test Case for the solution implemented for Euler Problem 345 (Matrix Sum)
 * 
 * @author Sarath Kumar Sivan
 * @see Problem345Solution
 *
 */
public class Problem345SolutionTest extends TestCase {

	public void testProblem345Solution() {
		assertEquals(13938, new Problem345Solution().getMaximumSum());
	}
}
