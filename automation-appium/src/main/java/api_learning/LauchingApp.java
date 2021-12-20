package api_learning;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LauchingApp {

	public static void main(String[] args) {
		try {
			AppiumDriver<MobileElement> appiumDriver = null;

			DesiredCapabilities desireCap = new DesiredCapabilities();
			desireCap.setCapability(MobileCapapilityTypeEx.PLATFORM_NAME, "android");
			desireCap.setCapability(MobileCapapilityTypeEx.AUTOMATION_NAME, "uiautomator2");
			desireCap.setCapability(MobileCapapilityTypeEx.UDID, "291d0dc1");
			desireCap.setCapability(MobileCapapilityTypeEx.APP_PACKSGE, "com.wdiodemoapp");
			desireCap.setCapability(MobileCapapilityTypeEx.APP_ACTIVITY, ".MainActivity");

			URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
			appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desireCap);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
