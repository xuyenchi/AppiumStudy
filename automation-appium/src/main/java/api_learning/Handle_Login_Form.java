package api_learning;

import driver.DriverFactoty;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Handle_Login_Form {

	public static void main(String[] args) {
		DriverFactoty.startAppiumServer();
		AndroidDriver<MobileElement> androidDriver = DriverFactoty.getAndroidDriver();

		// click login tab
		MobileElement loginLable = androidDriver.findElementByAccessibilityId("Login");
		loginLable.click();
		// input username
		MobileElement inputUsername = androidDriver.findElementByAccessibilityId("input-email");
		inputUsername.sendKeys("xuyenltn@gmail.com");
		// input pass
		MobileElement inputPass = androidDriver.findElementByAccessibilityId("input-password");
		inputPass.sendKeys("999999");
		// btn login click
		MobileElement btnLogin = androidDriver.findElementByAccessibilityId("button-LOGIN");
		btnLogin.click();

		//androidDriver.quit();
	}

}
