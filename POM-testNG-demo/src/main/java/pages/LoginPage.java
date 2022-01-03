package pages;

import org.openqa.selenium.By;

import components.global.BottomNavComponent;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class LoginPage {
	private final AppiumDriver<MobileElement> appiumDriver;
	private static final By userNameSel = MobileBy.AccessibilityId("input-email");
	private static final By passSel = MobileBy.AccessibilityId("input-password");
	private static final By btnLoginSel = MobileBy.AccessibilityId("button-LOGIN");
	
	public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
	}
	
	//maybe return elms ri goi elms o main va senkeys or click, hoac viet luon ham senkeys, click,..
	private MobileElement usernameElms() {
		return appiumDriver.findElement(userNameSel);
	}
	
//	public void inputUsernam(String username) {
//		appiumDriver.findElement(userNameSel).sendKeys(username);
//	}
//	
//	public void inputPassword(String pass) {
//		appiumDriver.findElement(passSel).sendKeys(pass);
//	}
//
//	public void clickBtnLogin() {
//		appiumDriver.findElement(btnLoginSel).click();
//	}
	
	// or de dung method chaining
	public LoginPage inputUsernam(String username) {
		appiumDriver.findElement(userNameSel).sendKeys(username);
		return this;
	}
	
	public LoginPage inputPassword(String pass) {
		appiumDriver.findElement(passSel).sendKeys(pass);
		return this;
	}

	public LoginPage clickBtnLogin() {
		appiumDriver.findElement(btnLoginSel).click();
		return this;
	}
	public BottomNavComponent bottonNavComponent() {
		return new BottomNavComponent(appiumDriver);
	}
	
}
