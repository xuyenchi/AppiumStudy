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

public class DriverFactotyV2 {

	private static AppiumDriver<MobileElement> appiumDriver;

	public AppiumDriver<MobileElement> getAndroidDriver(String udid, String systemPort) {
		initAndroidDriver(udid, systemPort);
		return appiumDriver;
	}

	private void initAndroidDriver(String udid, String systemPort) {
		try {

			DesiredCapabilities desireCap = new DesiredCapabilities();
			desireCap.setCapability(MobileCapapilityTypeEx.PLATFORM_NAME, "android");
			desireCap.setCapability(MobileCapapilityTypeEx.AUTOMATION_NAME, "uiautomator2");
			desireCap.setCapability(MobileCapapilityTypeEx.UDID, udid);
			desireCap.setCapability(MobileCapapilityTypeEx.SYSTEM_PORT, systemPort);
			desireCap.setCapability(MobileCapapilityTypeEx.APP_PACKSGE, "com.wdiodemoapp");
			desireCap.setCapability(MobileCapapilityTypeEx.APP_ACTIVITY, ".MainActivity");

			//URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
			//URL sau apply khi chạy hub parallel selenium-grid truyền địa chỉ ip của hub vào
			URL appiumServer = new URL("http://192.168.1.97:4444/wd/hub");
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
