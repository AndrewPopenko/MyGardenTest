package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends SuperPage{
	
	public class UserMessage {
		public String typeOfContact;
		public boolean byText;
		public String email;
		public String idOredr;
		public String textMeMessage;
		public String filePath;
		
		//public UserMessage() {}
	}
	
	WebDriver driver;
	
	@FindBy(id="id_contact")
	WebElement selectTypeOfContact;
	//By selectTypeOfContact = By.id("id_contact");
	
	@FindBy(id="email")
	WebElement inputEmail;
	//By inputEmail = By.id("email");
	
	@FindBy(id="id_order")
	WebElement inputIdOrder;
	//By inputIdOrder = By.id("id_order");
	
	@FindBy(id="fileUpload")
	WebElement inputFileUpload; 
	//By inputFileUpload = By.id("fileUpload");
	
	@FindBy(id="submitMessage")
	WebElement buttonSubmit;
	//By buttonSubmit = By.id("submitMessage");
	
	@FindBy(id = "message")
	WebElement textarea;
	//By textarea = By.id("message");
	
	Select select;
	
	public ContactUsPage(WebDriver driver, PlaceOnPage place) {
		super(driver);
		this.driver = driver;
		
		if(!driver.getTitle().equals("Skontaktuj siê z nami - GARDEN STORE"))
			printLog("Something went wrong it is not page with title - \"Skontaktuj siê z nami - GARDEN STORE\"");
		else {
			switch (place) {
			case TOP:
				printLog(OpenedPage(driver.getTitle()) + "through top menu");
				break;

			case BOTTOM:
				printLog(OpenedPage(driver.getTitle()) + "through bottom menu");
				break;
			}
			
			PageFactory.initElements(driver, this);
			
			select = new Select(selectTypeOfContact);
		}
	}
	
	private void selectTypeOfContact(String str, /*true = text, false = value*/ boolean param) {
		//if param is true select by visible text 
		if(param)
			select.selectByVisibleText(str);
		//else select by value
		else
			select.selectByValue(str);
	}
	
	//private void selectTypeOfContact(int index) {
		//select.selectByIndex(index);
	//}
	
	private void setEmailAddress(String email) {
		inputEmail.sendKeys(email);
	}
	
	private void setIdOrder(String str) {
		inputIdOrder.sendKeys(str);
	}
	
	private void setTextMessage(String str) {
		textarea.sendKeys(str);
	}
	
	private void selectFileForUpload(String str) {
		inputFileUpload.sendKeys(str);
	}
	
	private void submit() {
		buttonSubmit.click();
	}
	
	public void jFillAndSendForm(UserMessage message) {
		selectTypeOfContact(message.typeOfContact, message.byText);
		setEmailAddress(message.email);
		setIdOrder(message.idOredr);
		setTextMessage(message.textMeMessage);
		selectFileForUpload(message.filePath);
		submit();		
	}
}
