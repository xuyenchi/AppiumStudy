package dataDriven.authentication;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import maintest.MobileCapapilityTypeEx;
import models.components.global.BottomNavComponent;
import models.pages.LoginPage;
import testGson.Login;
import testflow.LoginFlow;
import utils.data.DataObjectBuilder;

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
	// private static List<Login> loginData = Arrays.asList(new Login("", ""), new
	// Login("xuyen","999999"), new Login("jennie@gmail.com","11111111"));
	@Test(dataProvider = "invalidLoginData")
	public void TC01_invalidLogin(Login loginData) throws MalformedURLException {
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
//
//			for(Login item : loginData) {
//				LoginPage loginPage = new LoginPage(appiumDriver);
//				loginPage.bottonNavComponent().clickLoginTab();
//				loginPage.inputUsernam(item.getUsernam()).inputPassword(item.getPassword()).clickBtnLogin();
//			}

//			LoginPage loginPage = new LoginPage(appiumDriver);
//			loginPage.bottonNavComponent().clickLoginTab();
//			loginPage.inputUsernam(loginData.getUsernam()).inputPassword(loginData.getPassword()).clickBtnLogin();
			LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData);
			loginFlow.login().verifyLogin();
		} finally {
			appiumDriver.quit();
		}
	}

	@Test
	public void TC02_validLogin() throws MalformedURLException {
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
			Login loginData = DataObjectBuilder.builderDataOject("/data/ValidLoginData.json", Login[].class)[0];

//			LoginPage loginPage = new LoginPage(appiumDriver);
//			loginPage.bottonNavComponent().clickLoginTab();
//			loginPage.inputUsernam(loginData.getUsernam()).inputPassword(loginData.getPassword()).clickBtnLogin();
			LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData);
			loginFlow.login().verifyLogin();
		} finally {
			appiumDriver.quit();
		}
	}

	@DataProvider
	public Login[] invalidLoginData() {
		return DataObjectBuilder.builderDataOject("/data/InvalidLoginData.json", Login[].class);
	}

}
