package api_learning;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class TakingScreenshot {

	public static void main(String[] args) {
		try {
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

			WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 10L);
			// co the file elems truc tiep bang ham wait de do hao phi 1 request
			WebElement btnLogin =  explicitWait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("button-LOGIN")));

			// Taking screenshot toan man hinh
			// de luu anh screenshot phai luu anh vao 1 file
			// ham screenshot se get ra dang base64 PNG string
			
			File base64Screnshot = appiumDriver.getScreenshotAs(OutputType.FILE);
			String fileScreenshotLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginForm.png");
			FileUtils.copyFile(base64Screnshot, new File(fileScreenshotLocation));
			
			
			//Taking screenshot 1 elements => thay the appiumDriver = elems muon screenshot
			//MobileElement btnLogin = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
			File btnLoginbase64Screnshot = btnLogin.getScreenshotAs(OutputType.FILE);
			String btnLoginfileScreenshotLocation = System.getProperty("user.dir").concat("/screenshots/").concat("btnLogin.png");
			FileUtils.copyFile(btnLoginbase64Screnshot, new File(btnLoginfileScreenshotLocation));
			
			//Taking screenshot area
			MobileElement loginScreen = appiumDriver.findElementByAccessibilityId("Login-screen");
			File loginScreenbase64 = loginScreen.getScreenshotAs(OutputType.FILE);
			String loginScreenFileLocaion = System.getProperty("user.dir").concat("/screenshots/").concat("LoginScreen.png");
			FileUtils.copyFile(loginScreenbase64, new File(loginScreenFileLocaion));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
