package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends SuperPage {
	WebDriver driver;
	
	By linkOrders = By.xpath("//a[@title='Zamówienia']");

	public AccountPage(WebDriver driver) {
		super(driver);
		
		if(!driver.getTitle().equals("Moje konto - GARDEN STORE"))
			printLog("Something went wrong it is not page with title - \"Moje konto - GARDEN STORE\"");
		else {
			printLog(OpenedPage(driver.getTitle()) + "by link");
		}
		
		this.driver = driver;
	}
	
	public OrderHistoryPage jOpenOrderHistoryPage() {
		WebElement link = driver.findElement(linkOrders);
		link.click();
	
		return new OrderHistoryPage(driver);
	}

}
