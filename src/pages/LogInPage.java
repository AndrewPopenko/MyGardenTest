package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends SuperPage{
	
	WebDriver driver;
	String strEmail;
	String strPasswordS;
	By inputEmail = By.id("email");
	By inputEmailCreate = By.id("email_create");
	By inputPswd = By.id("passwd");
	By buttonSubmit = By.id("SubmitLogin");
	By buttonSubmitCreate = By.id("SubmitCreate");
	By divEmailWrrap = By.xpath("//*[@id='login_form']/div/div[1]");
	By divEmailCreateWrrap = By.xpath("//*[@id='create-account_form']/div/div[2]");
	//By labelEmail = By.xpath("(//label[contains(text(), 'Email address')])[2]");
	By labelEmail = By.xpath("//*[@id='login_form']/div/div[1]/label");
	
	public LogInPage(WebDriver driver, PlaceOnPage place) {
		super(driver);
		this.driver = driver;
		
		if(!driver.getTitle().equals("Logowanie - GARDEN STORE"))
			printLog("Something went wrong it is not page with title - \"Logowanie - GARDEN STORE\"");
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
	
	public AccountPage jSigIn(String email, String pswd) {
		boolean isEmailCorrect = typeEmail(inputEmail, email);
		typePassword(pswd);
		
		if(isEmailCorrect) {
			driver.findElement(buttonSubmit).click();
			
			isLogged = true;
		
			return new AccountPage(driver);
		}
		else 
			return null;			
	}
	
	public CreateAccountPage jCreateAccount(String email) {
		typeEmail(inputEmailCreate, email);
		driver.findElement(buttonSubmitCreate).click();
		
		return new CreateAccountPage(driver);
	}
	
	protected void typePassword(String pswd) {
		WebElement element = driver.findElement(inputPswd);
		
		element.sendKeys(pswd);
	}

	protected boolean typeEmail(By by, String email) {
		WebElement element = driver.findElement(by);
		
		WebElement div = null;
		
		if(by.equals(inputEmail))
			div = driver.findElement(divEmailWrrap);
		else
			div = driver.findElement(divEmailCreateWrrap);
		
		element.click();
		element.sendKeys(email);
		div.click();
		
		//check attribute for div form-group form-ok
		if(div.getAttribute("class").equals("form-group form-ok")) {
			printLog("info: " + driver.getTitle() + " page - e-mail address is correct");
			
			return true;
		}
		else {
			printLog(driver.getTitle() + " page - e-mail address is wrong");
			
			return false;
		}			
	}
}