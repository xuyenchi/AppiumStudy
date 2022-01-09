package driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import maintest.MobileCapapilityTypeEx;

public class DriverFactoty {

	private static AppiumDriver<MobileElement> appiumDriver;

	public AppiumDriver<MobileElement> getAndroidDriver() {
		initAndroidDriver();
		return appiumDriver;
	}

	private void initAndroidDriver() {
		try {

			DesiredCapabilities desireCap = new DesiredCapabilities();
			desireCap.setCapability(MobileCapapilityTypeEx.PLATFORM_NAME, "android");
			desireCap.setCapability(MobileCapapilityTypeEx.AUTOMATION_NAME, "uiautomator2");
			desireCap.setCapability(MobileCapapilityTypeEx.UDID, "3200bad15ec4b55f");
			desireCap.setCapability(MobileCapapilityTypeEx.APP_PACKSGE, "com.wdiodemoapp");
			desireCap.setCapability(MobileCapapilityTypeEx.APP_ACTIVITY, ".MainActivity");

			URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
			appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desireCap);
			appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void quitSession() {
		if (appiumDriver != null) {
			appiumDriver.quit();
			appiumDriver = null;
		}
	}

}
