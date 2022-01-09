package basetest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driver.DriverFactoty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTestFirstVersion {
	private AppiumDriver<MobileElement> appiumDriver;
	private DriverFactoty driverFactory;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		driverFactory = new DriverFactoty();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driverFactory.quitSession();
	}

	protected AppiumDriver<MobileElement> getAndroidDriver() {
		if (appiumDriver == null) {
			appiumDriver = driverFactory.getAndroidDriver();
		}

		return appiumDriver;
	}

}
