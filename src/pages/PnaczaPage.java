package pages;

import org.openqa.selenium.WebDriver;

public class PnaczaPage extends SuperPage{
	
	WebDriver driver;

	public PnaczaPage(WebDriver driver, PlaceOnPage place) {
		super(driver);
		this.driver = driver;

		if (!driver.getTitle().equals("Pn�cza - GARDEN STORE"))
			printLog("Something went wrong it is not page with title - \"Pn�cza - GARDEN STORE\"");
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
