package basetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import driver.DriverFactoty;
import driver.DriverFactotyV2;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTestV2 {
	private AppiumDriver<MobileElement> appiumDriver;
	private DriverFactotyV2 driverFactory;
	
	private final List<DriverFactotyV2> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
	private ThreadLocal<DriverFactotyV2> driverThread;
	
	private String udid;
	private String systemPort;

	@BeforeTest(alwaysRun = true)
	@Parameters({ "udid", "systemPort" })

	public void beforeTest(String udid, String systemPort) {
		this.udid = udid;
		this.systemPort = systemPort;
		//System.out.println("udid:" + udid + ", port:" + systemPort);
		driverThread = ThreadLocal.withInitial(() -> {
			DriverFactotyV2 driverThread = new DriverFactotyV2();
			driverThreadPool.add(driverThread);
			return driverThread;
		});

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driverThread.get().quitSession();
		// goi get() để gọi đúng appium session để tắt	
	}

	protected AppiumDriver<MobileElement> getAndroidDriver() {
		if (appiumDriver == null) {
			appiumDriver = driverThread.get().getAndroidDriver(udid, systemPort);
		}

		return appiumDriver;
	}

}
