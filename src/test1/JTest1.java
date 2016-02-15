package test1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;

import pages.AccountPage;
import pages.BylinyPage;
import pages.LogInPage;
import pages.OrderHistoryPage;
import pages.SuperPage;
import pages.*;
import pages.ContactUsPage.UserMessage;

public class JTest1 {
	
	WebDriver driver = new FirefoxDriver();
	
	String baseURL = "http://testy.forprogress.com.pl:8000/gardenstore/pl/";
	
	SuperPage page = null;
	
	@BeforeTest
	public void setBaseURL() {
				
		//print("Test has been started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		page = new SuperPage(driver);
	}
	
	@Test
	public void testContactPage() {
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
	}
	
	
	//@Test
	/*public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		String baseURL = "http://testy.forprogress.com.pl:8000/gardenstore/pl/";
		
		//print("Test has been started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		SuperPage page = new SuperPage(driver);
		
		//ContactUsPage kontakt = page.jOpenContactUsTopMenu();
		
		ContactUsPage.UserMessage message = kontakt.new UserMessage();
		//message.byText = true;
		//message.typeOfContact = "Webmaster";
		//message.email = "tester@tester.pl";
		//message.idOredr = "123abc";
		//message.textMeMessage = "1111111111111111111111"
				+ "22222222222222222222222222222222"
				+ "3333333333333333333333333333333"
				+ "4444444444444444444444444444444444444"
				+ "5555555555555555555555555555555555555555555555"
				+ "66666666666666666666666666666666666666666666666"
				+ "777777777777777777777777777777777777777777777777"
				+ "8888888888888888888888888888888888888888888888888"
				+ "9999999999999999999999999999999999999999999999999999999"
				+ "00000000000000000000000000000000000000000000000000000000000000000000000000000";
		//message.filePath = "C:\\text.txt";
		
		
		//kontakt.jFillAndSendForm(message);*/
		
		//kontakt.jOpenKontaktZNamiBottomMenu();
		//LogInPage login = page.jOpenLogInTopMenu();
		/*page.jOpenLogInBottomMenu();
		SuperPage page1 = login.jOpenHomePage();
		BylinyPage byliny = page1.jOpenBylinyPageTopMenu();
		byliny.jOpenBylinyPageBottomMenu();
		page.jOpenKrzewyPageTopMenu();
		page.jOpenKrzewyPageBottomMenu();
		page.jOpenPaprociePageTopMenu();
		page.jOpenPaprociePageBottomMenu();
		page.jOpenPnaczaPageTopMenu();
		page.jOpenPnaczaPageBottomMenu();
		page.jOpenKrzewinkiPageTopMenu();
		page.jOpenKrzewinkiPageBottomMenu();
		page.jOpenZiolaPageTopMenu();
		page.jOpenZiolaPageBottomMenu();
		page.jOpenKwiatyPageTopMenu();
		page.jOpenKwiatyPageBottomMenu();
		page.jOpenTrawyPageTopMenu();
		page.jOpenTrawyPageBottomMenu();
		login = page.jOpenLogInTopMenu();*/
		//AccountPage acc = login.jSigIn("tester@tester.pl", "tester");
		//OrderHistoryPage orderhistory = acc.jOpenOrderHistoryPage();
		
		//login.jCreateAccount("teter1@tester.pl");
		
		
		/*		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		print("Title of page is: " + driver.getTitle());
		
		List<WebElement> linksElements = driver.findElements(By.tagName("a"));
		
		int i = 0;
		
		for(WebElement element : linksElements) {
			if(!element.getText().isEmpty()) {
				i++;
			}
		}
		
		String[] linksTexts = new String[i];
		
		i = 0;
		
		for(WebElement element : linksElements) {
			if(!element.getText().isEmpty()) {
				linksTexts[i] = element.getText();
				i++;				
			}
		}
		
		for(String str : linksTexts) {
			driver.findElement(By.linkText(str)).click();
			
			/*try {
				
				if(driver.findElement(By.xpath(".//*[@id='center_column']/div/h1")).getText().equals("Strona niedostêpna")) {
					print("\"" + str + "\"" + " is under construction.");
				}
				else {*/
					//print("\"" + str + "\"" + " is working.");
				/*}
				
			} catch (NoSuchElementException e) {
				print(e.toString());
			}*/
			
			
		/*	driver.navigate().back();
		}
		
		driver.get("http://newtours.demoaut.com/");
		
		WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver
                .findElement(By
                .xpath("//html/body/div"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr"));    
         
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .build();
         
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);        
        mouseOverHome.perform();        
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);*/
		
		//driver.close();
		
		//print("Test has been ended");
//	}
	
/*	public static void print(String str) {
		System.out.println(str);
	}*/

}
