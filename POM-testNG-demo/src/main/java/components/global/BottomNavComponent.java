package components.global;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BottomNavComponent {
	private final AppiumDriver<MobileElement> appiumDriver;
	private static final By tabLoginSel = MobileBy.AccessibilityId("Login");

	public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {

		this.appiumDriver = appiumDriver;
	}
	
	public void clickLoginTab() {
		appiumDriver.findElement(tabLoginSel).click();
	}
	
	

}
