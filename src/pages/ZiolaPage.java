package pages;

import org.openqa.selenium.WebDriver;


public class ZiolaPage extends SuperPage{
	WebDriver driver;

	public ZiolaPage(WebDriver driver, PlaceOnPage place) {
		super(driver);
		this.driver = driver;

		if (!driver.getTitle().equals("Zio³a - GARDEN STORE"))
			printLog("Something went wrong it is not page with title - \"Zio³a - GARDEN STORE\"");
		else {
			switch (place) {
			case TOP:
				printLog(OpenedPage(driver.getTitle()) + "through top menu");
				break;

			case BOTTOM:
				printLog(OpenedPage(driver.getTitle()) + "through bottom menu");
				break;
			}
		}
	}
}
