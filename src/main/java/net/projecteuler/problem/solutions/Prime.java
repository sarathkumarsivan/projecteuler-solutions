package net.projecteuler.problem.solutions;

/**
 * The {@code Prime} is a user define data structure to store the power of
 * primes currently used, and the logarithm of the next power of each prime
 * you'd need to multiply by to double the number of divisors.
 * 
 * @author Sarath Kumar Sivan
 */
public class Prime {

	private double log;

	private long value;

	public Prime() {
		super();
	}

	public Prime(double log, long value) {
		super();
		this.log = log;
		this.value = value;
	}

	public double getLog() {
		return log;
	}

	public void setLog(double log) {
		this.log = log;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Prime [log=" + log + ", value=" + value + "]";
	}

}
