package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void returnZeroOnEmptyString() {
		assertEquals(0,Calculator.Add(""));
	}

}
