package driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestDriverFactory {

	public static void main(String[] args) {
		DriverFactoty.startAppiumServer();
		AndroidDriver<MobileElement> androidDriver = DriverFactoty.getAndroidDriver();

	}

}
