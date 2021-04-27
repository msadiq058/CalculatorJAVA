package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void returnZeroOnEmptyString() {
		assertEquals(0,Calculator.Add(""));
	}
	@Test
	public void sumOfSingleNumber() {
		assertEquals(1,Calculator.Add("1"));
	}
	@Test
	public void sumOfTwoNumbers() {
		assertEquals(3,Calculator.Add("1,2"));
	}
	@Test
	public void sumOfMultipleNumbers() {
		assertEquals(10,Calculator.Add("1,2,3,4"));
	}
	@Test
	public void sumOfNumbersWithNewLine() {
		assertEquals(6,Calculator.Add("1\n2,3"));
		assertEquals(7,Calculator.Add("1\n2\n3\n1"));
	}
	@Test
	public void sumOfNumberStartWithDoubleSlash() {
		assertEquals(3,Calculator.Add("//;\\n1;2"));
	}
	@Test
	public void raiseErrorForNegative() {
		try {
			Calculator.Add("//-1,-2");
			fail("Excetion expected.");
		}
		catch(RuntimeException e) {
			assertEquals("negatives not allowed: -1 -2",e.getMessage());
		}
	}
	@Test
	public void raiseErrorForNegative2() {
		try {
			Calculator.Add("//;\\\\n-11;2");
			fail("Excetion expected.");
		}
		catch(RuntimeException e) {
			assertEquals("negatives not allowed: -11",e.getMessage());
		}
	}
	
	@Test
	public void ignoreGreaterThan1000() {
		assertEquals(2,Calculator.Add("//2;1001"));
	}
	
	@Test
	public void delimitersOfAnyLength() {
		assertEquals(6,Calculator.Add("//[***]\\n1***2***3"));
	}
	
	@Test
	public void multipleDelimiters() {
		assertEquals(6,Calculator.Add("//[*][%]\\n1*2%3"));
	}
	@Test
	public void multipleDelimitersOfLongerLength() {
		assertEquals(20,Calculator.Add("//[*][%]\\n10*7%3"));
	}

}
