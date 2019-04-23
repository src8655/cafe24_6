package testst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalTest2 {

	private int num1;
	private int num2;
	
	@Before
	public void setUp() {
		num1 = 10;
		num2 = 20;
	}
	
	@Test
	public void cal() {
		assertEquals(20, num1+num2);
	}
}
