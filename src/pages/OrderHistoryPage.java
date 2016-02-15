package pages;

import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends SuperPage{
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
	}

}
