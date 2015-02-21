package uebung06;

import org.junit.Test;
import static org.junit.Assert.*;

public class BigIntegerSimpleTest {

	@Test
	public void testAdd() {
		BigInteger num1 = new BigInteger("9000000000001");
		BigInteger num2 = new BigInteger("1000000000009");

		num1.add(num2);

		assertEquals("10000000000010", num1.toString());
	}

	@Test
	public void testToString() {
		BigInteger num1 = new BigInteger("123456789");

		assertEquals("123456789", num1.toString());
	}

}
