package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends SuperPage {
	
	WebDriver driver;
	By textElement = By.xpath("//*[@id='noSlide']/h1");
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		
		if(!driver.getTitle().equals("Logowanie - GARDEN STORE") && 
				driver.findElement(textElement).getText().equals("Stw�rz konto"))
			printLog("Something went wrong it is not page with title - \"Logowanie - GARDEN STORE\" (Stw�rz konto)");
		else {
			printLog(OpenedPage(driver.getTitle() + " (Stw�rz konto)") + "by link");
		}
		
		this.driver = driver;
	}

}
