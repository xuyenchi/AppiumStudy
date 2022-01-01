package api_learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class HandleHydridContext {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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

		MobileElement tabWbviewElems = appiumDriver.findElementByAccessibilityId("Webview");

		tabWbviewElems.click();

		WebDriverWait explicitwait = new WebDriverWait(appiumDriver, 10);
		explicitwait.until(moreThanContext(appiumDriver));
		// Thread.sleep(2000);
		appiumDriver.getContextHandles().forEach(context -> {
			System.out.println("CONTEXTTTTTT:" + context);
		});

		// chuyên qua context webview de handle
		appiumDriver.context("WEBVIEW_com.wdiodemoapp");
		Thread.sleep(5000);
		WebElement btnNavToggle = appiumDriver.findElement(By.xpath("//button[@aria-label='Navigation bar toggle']"));
		btnNavToggle.click();
		List<MobileElement> menuListItemElms = appiumDriver.findElements(By.xpath("//li[@class='menu__list-item']//a"));
		if (menuListItemElms.isEmpty()) {
			throw new RuntimeException("menulist is null");
		}
		List<MenuItem> menuItems = new ArrayList<>();
		for (MobileElement data : menuListItemElms) {
			String itemName = data.getText();
			String itemLink = data.getAttribute("href");
			if (itemName.isEmpty()) {
				menuItems.add(new MenuItem("Github", itemLink));
			} else {
				menuItems.add(new MenuItem(itemName, itemLink));
			}
		}

		System.out.println("menu list:" + menuItems);

		//switch tro lại context app
		appiumDriver.context("NATIVE_APP");
		MobileElement tabLoginElems = appiumDriver.findElementByAccessibilityId("Login");

		tabLoginElems.click();

		appiumDriver.runAppInBackground(Duration.ofSeconds(3));

	}

	private static ExpectedCondition<Boolean> moreThanContext(AppiumDriver<MobileElement> appiumDriver) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return appiumDriver.getContextHandles().size() > 1;
			}
		};
	}

	public static class MenuItem {
		private String name;
		private String hyperLink;

		public MenuItem(String name, String hyperLink) {
			this.name = name;
			this.hyperLink = hyperLink;
		}

		@Override
		public String toString() {
			return "MenuItem : {" + "text:" + this.name + ",link:" + this.hyperLink + "}\n";
		}
	}

}
