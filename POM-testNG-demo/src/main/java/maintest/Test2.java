package maintest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2 {

	@Test(priority = 2)
	public void tcA() {
		System.out.println("hello Jenies");
	}
	@Test(priority = 1)
	public void tcB() {
		System.out.println("hello Lisa");
	}
	@Test(dependsOnMethods = {"tcA"})
	public void tcC() {
		System.out.println("hello Rose");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Happiness", "Excellant");
		softAssert.assertTrue(false);
		softAssert.assertAll();
	}

}
