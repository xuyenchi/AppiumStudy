package api_learning;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import api_learning.MobileCapapilityTypeEx;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverFactoty {

	private static AppiumDriverLocalService appiumServer;
	private static AndroidDriver<MobileElement> androidDriver;

	public static void startAppiumServer() {
//		AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
//		appiumServiceBuilder.withIPAddress("127.0.0.1").usingAnyFreePort();
		
		//appiumServer = AppiumDriverLocalService.buildService(appiumServiceBuilder);
		AppiumServiceBuilder appiumServerBuilder = new AppiumServiceBuilder();
       // appiumServerBuilder.withArgument(AndroidServerFlagEx.ALLOW_INSECURE, "chromedriver_autodownload");
        appiumServerBuilder.withIPAddress("127.0.0.1").usingAnyFreePort();
        appiumServerBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
        appiumServerBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium"));
        appiumServer = AppiumDriverLocalService.buildService(appiumServerBuilder);
       // appiumServer.start();
		appiumServer.start();
	}

	private static void initAndroidDriver() {
		DesiredCapabilities desireCap = new DesiredCapabilities();
		desireCap.setCapability(MobileCapapilityTypeEx.PLATFORM_NAME, "android");
		desireCap.setCapability(MobileCapapilityTypeEx.AUTOMATION_NAME, "uiautomator2");
		desireCap.setCapability(MobileCapapilityTypeEx.UDID, "3200bad15ec4b55f");
		desireCap.setCapability(MobileCapapilityTypeEx.APP_PACKSGE, "com.wdiodemoapp");
		desireCap.setCapability(MobileCapapilityTypeEx.APP_ACTIVITY, ".MainActivity");

		androidDriver = new AndroidDriver<MobileElement>(appiumServer.getUrl(), desireCap);
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static AndroidDriver<MobileElement> getAndroidDriver() {
		initAndroidDriver();
		return androidDriver;
	}

}
