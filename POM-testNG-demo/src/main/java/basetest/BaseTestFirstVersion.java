package basetest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import driver.DriverFactoty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

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
	@AfterMethod(description = "Screenshot tcs fail")
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			// 1. get method name
			String testMethodName = result.getName();
			System.out.print(testMethodName);

			// 2.get taken time
			Calendar calendar = new GregorianCalendar();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int date = calendar.get(Calendar.DATE);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			String dateTaken = year + "-" + month + "-" + date + "-" + hour + "-" + minute + "-" + second;

			// 3. LOcation save screenshot
			String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testMethodName + "_" + dateTaken
					+ ".png";
			
			//4. save file
			File  screenShot = driverFactory.getAndroidDriver().getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenShot, new File(fileLocation));
				Path content = Paths.get(fileLocation);
				InputStream inputStream = Files.newInputStream(content);
				Allure.addAttachment(testMethodName, inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
