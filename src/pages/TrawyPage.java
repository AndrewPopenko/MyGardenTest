package pages;

import org.openqa.selenium.WebDriver;

public class TrawyPage extends SuperPage{
	WebDriver driver;

	public TrawyPage(WebDriver driver, PlaceOnPage place) {
		super(driver);
		this.driver = driver;

		if (!driver.getTitle().equals("Trawy ozdobne - GARDEN STORE"))
			printLog("Something went wrong it is not page with title - \"Trawy ozdobne - GARDEN STORE\"");
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
