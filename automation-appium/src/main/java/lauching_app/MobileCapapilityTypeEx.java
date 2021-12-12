package lauching_app;

import io.appium.java_client.remote.MobileCapabilityType;

public interface MobileCapapilityTypeEx extends MobileCapabilityType {
	String PLATFORM_NAME = "platformName";
	String AUTOMATION_NAME = "automationName";
	String UDID = "udid";
	String APP_PACKSGE = "appPackage";
	String APP_ACTIVITY = "appActivity";
}
