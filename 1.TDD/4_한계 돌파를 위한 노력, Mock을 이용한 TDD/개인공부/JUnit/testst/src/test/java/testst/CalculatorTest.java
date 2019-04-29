package testst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculatorTest {
	
	private double expected;
	private double valueOne;
	private double valueTwo;
	
	@Parameters
	public static Collection <Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] {
			{2,1,1},
			{3,2,1},
			{4,3,1}
		});
	}
	
	public CalculatorTest( double expected, double valueOne, double valueTwo) {
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}
	
	@Test
	public void sum() {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.add(valueOne, valueTwo),0);
	}

}
