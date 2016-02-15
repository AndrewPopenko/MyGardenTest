package test1;

import org.testng.annotations.Test;

import pages.AccountPage;
import pages.BylinyPage;
import pages.ContactUsPage;
import pages.SuperPage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class NewTest {
WebDriver driver = new FirefoxDriver();
	
	String baseURL = "http://testy.forprogress.com.pl:8000/gardenstore/pl/";
	
	SuperPage page = null;
	
	@Test
	public void test1() {
		BylinyPage byp = page.jOpenBylinyPageBottomMenu();
		//byp.setProductSort("reference:asc");
		//byp.setProductSort("");
		byp.setItemsPerPage("60");
		byp.setViewStyle(false);
		byp.setItemsPerPage("24");
		byp.setViewStyle(true);
		byp.setItemsPerPage("12");
		byp.setViewStyle(false);
		byp.setItemsPerPage("24");
		byp.setViewStyle(true);
		byp.setItemsPerPage("60");
		byp.setViewStyle(false);
		byp.setItemsPerPage("12");
		byp.setViewStyle(true);
	}
	
	//@Test
	public void test() throws InterruptedException {
		BylinyPage byp = page.jOpenBylinyPageBottomMenu();
		System.out.println("number = " + byp.getNumberOfNotAvailable());
		System.out.println("number = " + byp.getNumberOfInStock());
		System.out.println("number = " + byp.getNumberOfNew());
		//byp.setPositionSlider(5);
		
		byp.setMinPrice(20);
		byp.setMaxPrice(80);
	}
	
	//@Test
	public void changeLang() {
		page.jChangeLanguage();		
	}

	//@Test
	public void contactUs() {
		ContactUsPage kontakt = page.jOpenContactUsTopMenu();
		
		ContactUsPage.UserMessage message = kontakt.new UserMessage();
		message.byText = true;
		message.typeOfContact = "Webmaster";
		message.email = "tester@tester.pl";
		message.idOredr = "123abc";
		message.textMeMessage = "1111111111111111111111"
			+ "22222222222222222222222222222222"
			+ "3333333333333333333333333333333"
			+ "4444444444444444444444444444444444444"
			+ "5555555555555555555555555555555555555555555555"
			+ "66666666666666666666666666666666666666666666666"
			+ "777777777777777777777777777777777777777777777777"
			+ "8888888888888888888888888888888888888888888888888"
			+ "9999999999999999999999999999999999999999999999999999999"
			+ "00000000000000000000000000000000000000000000000000000000000000000000000000000";
		message.filePath = "C:\\text.txt";
				
		kontakt.jFillAndSendForm(message);	
		kontakt.jOpenHomePage();
	}
	
	//@Test
	public void CheckOrders() {
		signIn().jOpenOrderHistoryPage();
	}
	
	@BeforeTest
	public void beforeTest() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		page = new SuperPage(driver);
	}
	
	public AccountPage signIn() {
		//LogInPage login = page.jOpenLogInTopMenu();
		
		//return login.jSigIn("tester@tester.pl", "tester");
		
		return page.jOpenLogInTopMenu().jSigIn("tester@tester.pl", "tester");
	}
}
