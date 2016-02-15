package pages;

import org.openqa.selenium.WebDriver;

public class testc extends SuperPage {
	
	WebDriver driver;
	
	public testc(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void dosomthing() {
		// TODO Auto-generated method stub
		System.out.println("dosomthing");
	}

}
