package api_learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HandleMultiApp {
	public static void main(String[] args) throws MalformedURLException {
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

		MobileElement loginLable = appiumDriver.findElementByAccessibilityId("Login");
		loginLable.click();
		// input username
		MobileElement inputUsername = appiumDriver.findElementByAccessibilityId("input-email");
		inputUsername.sendKeys("xuyenltn@gmail.com");
		// input pass
		MobileElement inputPass = appiumDriver.findElementByAccessibilityId("input-password");
		inputPass.sendKeys("999999");
		// btn login click
		MobileElement btnLogin = appiumDriver.findElementByAccessibilityId("button-LOGIN");
		btnLogin.click();

		// click ve background
		appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

		 //open setting=> mơ app khác phai active app do
		appiumDriver.activateApp("com.android.settings");

		// click vao wifi va kiem tra on/off
		MobileElement connectElms = appiumDriver.findElement(By.xpath("//*[@text='Kết nối']"));
		connectElms.click();

		MobileElement wifiElms = appiumDriver.findElement(By.xpath("//*[@text='Wi-Fi']"));
		wifiElms.click();

		MobileElement statusWifiElms = appiumDriver.findElement(By.id("com.android.settings:id/switch_text"));
		MobileElement btnWifi = appiumDriver.findElement(By.id("com.android.settings:id/switch_widget"));
		btnWifi.click();
		boolean isOnWifi = statusWifiElms.getText().equals("Bật");
		if(!isOnWifi)
			btnWifi.click();
		appiumDriver.activateApp("com.wdiodemoapp");
		
		
		
		
	}
}
