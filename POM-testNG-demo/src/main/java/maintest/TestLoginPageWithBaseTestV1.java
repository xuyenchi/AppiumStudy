package maintest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTestFirstVersion;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.components.global.BottomNavComponent;
import models.pages.LoginPage;
import testGson.Login;
import testflow.LoginFlow;
import utils.data.DataObjectBuilder;

public class TestLoginPageWithBaseTestV1 extends BaseTestFirstVersion {

	@Test()
	public void TC01_validLogin() {
		AppiumDriver<MobileElement> appiumDriver = getAndroidDriver();
		Login loginData = DataObjectBuilder.builderDataOject("/data/ValidLoginData.json", Login[].class)[0];
		LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData);
		loginFlow.login().verifyLogin();
		Assert.assertEquals("hello", "success");
	}

	@Test
	public void TC02() {
		LoginPage loginPage = new LoginPage(getAndroidDriver());
		loginPage.bottonNavComponent().clickLoginTab();
		loginPage.inputPassword("123456789").clickBtnLogin();

	}

}
