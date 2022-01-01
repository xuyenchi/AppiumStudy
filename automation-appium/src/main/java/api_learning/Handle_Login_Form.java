package api_learning;

import driver.DriverFactoty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Handle_Login_Form {

	public static void main(String[] args) throws MalformedURLException {
//		DriverFactoty.startAppiumServer();
//		AndroidDriver<MobileElement> androidDriver = DriverFactoty.getAndroidDriver();
		AppiumDriver<MobileElement> appiumDriver = null;

		DesiredCapabilities desireCap = new DesiredCapabilities();
		desireCap.setCapability(MobileCapapilityTypeEx.PLATFORM_NAME, "android");
		desireCap.setCapability(MobileCapapilityTypeEx.AUTOMATION_NAME, "uiautomator2");
		desireCap.setCapability(MobileCapapilityTypeEx.UDID, "3200bad15ec4b55f");
		desireCap.setCapability(MobileCapapilityTypeEx.APP_PACKSGE, "com.wdiodemoapp");
		desireCap.setCapability(MobileCapapilityTypeEx.APP_ACTIVITY, ".MainActivity");

		URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
		appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desireCap);

		appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// click login tab
		MobileElement loginLable = appiumDriver.findElementByAccessibilityId("Login");
		loginLable.click();
		// input username
		MobileElement inputUsername = appiumDriver.findElementByAccessibilityId("input-email");
		inputUsername.sendKeys("xuyenltn@gmail.com");
		// input pass
		MobileElement inputPass = appiumDriver.findElementByAccessibilityId("input-password");
		inputPass.sendKeys("999999");
		// btn login click
		MobileElement btnLogin = appiumDriver.findElementByAccessibilityId("button-LOGIN");
		btnLogin.click();

		//androidDriver.quit();
	}

}
