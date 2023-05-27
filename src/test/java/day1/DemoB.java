package day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoB extends BaseTest{
	@Test
	public void testC()
	{
		eTest.info("Hi this is testC");
	}

	@Test
	public void testD()
	{
		eTest.info("Hi this is testD");
		Assert.fail("Something");
	}
}
