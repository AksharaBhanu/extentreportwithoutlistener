package day1;

import org.testng.annotations.Test;

public class DemoA extends BaseTest{
	@Test
	public void testA()
	{
		eTest.info("Hi this is testA");
	}

	@Test
	public void testB()
	{
		eTest.info("Hi this is testB");
	}
}
