package maintest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.components.global.BottomNavComponent;
import models.pages.LoginPage;

public class TestLoginPage {

//	public static void main(String[] args) throws MalformedURLException {
//		AppiumDriver<MobileElement> appiumDriver = null;
//		try {
//
//			DesiredCapabilities desireCap = new DesiredCapabilities();
//			desireCap.setCapability(MobileCapapilityTypeEx.PLATFORM_NAME, "android");
//			desireCap.setCapability(MobileCapapilityTypeEx.AUTOMATION_NAME, "uiautomator2");
//			desireCap.setCapability(MobileCapapilityTypeEx.UDID, "3200bad15ec4b55f");
//			desireCap.setCapability(MobileCapapilityTypeEx.APP_PACKSGE, "com.wdiodemoapp");
//			desireCap.setCapability(MobileCapapilityTypeEx.APP_ACTIVITY, ".MainActivity");
//
//			URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
//			appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desireCap);
//			appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//			
//
//			LoginPage loginPage = new LoginPage(appiumDriver);
//			loginPage.bottonNavComponent().clickLoginTab();
//			loginPage.inputUsernam("Jennie Le").inputPassword("123456789").clickBtnLogin();
//		} finally {
//			appiumDriver.quit();
//		}
//	}
	
	@Test
	public void TC01_startLoginPage() throws MalformedURLException {
		AppiumDriver<MobileElement> appiumDriver = null;
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

			

			LoginPage loginPage = new LoginPage(appiumDriver);
			loginPage.bottonNavComponent().clickLoginTab();
			loginPage.inputUsernam("Jennie Le").inputPassword("123456789").clickBtnLogin();
		} finally {
			appiumDriver.quit();
		}
	}

}
