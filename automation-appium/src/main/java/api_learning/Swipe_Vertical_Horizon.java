package api_learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Swipe_Vertical_Horizon {
	public static void main(String[] args) {
		DriverFactoty.startAppiumServer();
		AndroidDriver<MobileElement> androidDriver = DriverFactoty.getAndroidDriver();

//		MobileElement tabForms = androidDriver.findElementByAccessibilityId("Forms");
//		tabForms.click();
//
//		WebDriverWait explicitWait = new WebDriverWait(androidDriver, 10L);
//		explicitWait.until(ExpectedConditions.visibilityOf(androidDriver.findElementByAccessibilityId("switch")));
//		Dimension windowSize = androidDriver.manage().window().getSize();
//
//		int screenHeight = windowSize.getHeight();
//		int screenWidth = windowSize.getWidth();
//
//		int xStartPoint = 50 * screenWidth / 100;
//		int xEndPoint = xStartPoint;
//		int yStartPoint = 90 * screenHeight / 100;
//		int yEndPoint = 10 * screenHeight / 100;
//
//		PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
//		PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
//
//		TouchAction touchAction = new TouchAction(androidDriver);
//		touchAction
//				.press(startPoint)
//				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
//				.moveTo(endPoint)
//				.release()
//				.perform();
//		
//		try {
//			Thread.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		MobileElement tabSwipe = androidDriver.findElementByAccessibilityId("Swipe");
		tabSwipe.click();

		WebDriverWait explicitWait = new WebDriverWait(androidDriver, 10L);
		explicitWait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath("//*[@text='Swipe horizontal']"))));
		Dimension windowSize = androidDriver.manage().window().getSize();

		int screenHeight = windowSize.getHeight();
		int screenWidth = windowSize.getWidth();

		int xStartPoint = 70 * screenWidth / 100;
		int xEndPoint = 20 * screenWidth / 100;
		int yStartPoint = 50 * screenHeight / 100;
		int yEndPoint = yStartPoint;

		PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
		PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

		TouchAction touchAction = new TouchAction(androidDriver);
		final int MAX_TRY_SWIPE = 10;
		int swipeTime = 0;
		while(swipeTime < MAX_TRY_SWIPE) {
			List<MobileElement> expectedElems = androidDriver.findElementsByXPath("//*[@text='You found me!!!']");
			if(!expectedElems.isEmpty()) 
			{
				System.out.print("FIND XXXXXXXXXXXXXXXXXXXXXXXX");
				break;
			}
				
			touchAction
					.press(startPoint)
					.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
					.moveTo(endPoint)
					.release()
					.perform();
			swipeTime++;
		}
		
		if(swipeTime==MAX_TRY_SWIPE) {
			throw new RuntimeException("Elems not found!!!!");
		}
		
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
