package net.projecteuler.problem.solutions;

import junit.framework.TestCase;

/**
 * Test Case for the solution implemented for Euler Problem 16 (Power digit sum)
 * 
 * @author Sarath Kumar Sivan
 * @see Problem16Solution
 *
 */
public class Problem16SolutionTest extends TestCase {

	public void testProblem16Solution() {
		assertEquals(1366, new Problem16Solution().getPowerDigitSum());
	}

}
