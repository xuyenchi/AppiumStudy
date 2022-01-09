package testflow;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import testGson.Login;

public class LoginFlow {
	private final AppiumDriver<MobileElement> appiumDriver;
	private Login loginData;

	public LoginFlow(AppiumDriver<MobileElement> appiumDriver, Login loginData) {
		this.appiumDriver = appiumDriver;
		this.loginData = loginData;
		
	}

	public LoginFlow login() {
		if(loginData==null)
			throw new RuntimeException("Please set loginData");
		LoginPage loginPage = new LoginPage(appiumDriver);
		loginPage.bottonNavComponent().clickLoginTab();
		loginPage.inputUsernam(loginData.getUsernam()).inputPassword(loginData.getPassword()).clickBtnLogin();
		return this;
	}
	
	public void verifyLogin() {
		boolean isCheckUsername = isCheckUSernameValid();
		boolean isCheckPass = isCheckPassValid();
		if(!isCheckPass)
			verifyUsernameInvalid();
		if(!isCheckPass)
			verifyPassInvalid();
		if(isCheckPass && isCheckUsername)
			verifySuccess();
	}

	private void verifySuccess() {
		// TODO Auto-generated method stub
		
	}

	private void verifyPassInvalid() {
		// TODO Auto-generated method stub
		
	}

	private void verifyUsernameInvalid() {
		// TODO Auto-generated method stub
		
	}

	private boolean isCheckPassValid() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isCheckUSernameValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
