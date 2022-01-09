package models.components.global;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BottomNavComponent {
	private final AppiumDriver<MobileElement> appiumDriver;
	private static final By tabLoginSel = MobileBy.AccessibilityId("Login");
	private static final By tabHome = MobileBy.AccessibilityId("Home");

	private static final By tabSwipe = MobileBy.AccessibilityId("Swipe");

	public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {

		this.appiumDriver = appiumDriver;
	}
	
	public void clickLoginTab() {
		appiumDriver.findElement(tabLoginSel).click();
	}
	
	public void clickHomeTab() {
		appiumDriver.findElement(tabHome).click();
	}
	 public void clickSwipeTab() {
		 appiumDriver.findElement(tabSwipe).click();
	 }
	

}
