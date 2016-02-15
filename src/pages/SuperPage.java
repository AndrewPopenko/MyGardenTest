package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuperPage {
	
	static boolean isLogged = false;
	
	WebDriver driver;
	
	public enum PlaceOnPage {
		TOP, BOTTOM
	}
	
	String curentlang;
	
	By KontaktZnamiTopMenu = By.id("contact-link");
	By KontaktZnamiBottomMenu = By.xpath("//*[@id='block_various_links_footer']/ul/li[3]/a");
	
	@FindBy(id="languages-block-top") WebElement langMenu;
	//By language = By.id("languages-block-top");
	
	By LogInTopMenu = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By LogInBottoMenu = By.xpath("//*[@id='footer']/div/section[3]/h4/a");
	By LogoImage = By.id("header_logo");
	
	//Perennials - Byliny
	By BylinyLinkTopMenu = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	By BylinyLinkBottompMenu = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	//By BylinyLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Byliny')])[2]");
	
	
	By KrzewyLinkTopMenu = By.xpath("//a[@title=\"Krzewy\"]");
	By KrzewyLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Krzewy')])[2]");
	
	//Paprocie
	By PaprocieLinkTopMenu = By.xpath("//a[@title=\"Paprocie\"]");
	By PaprocieLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Paprocie')])[2]");
	//Pnącza
	By PnaczaLinkTopMenu = By.xpath("//a[@title=\"Pnącza\"]");
	By PnaczaLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Pnącza')])[2]");
	//Krzewinki
	By KrzewinkiLinkTopMenu = By.xpath("//a[@title=\"Krzewinki\"]");
	By KrzewinkiLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Krzewinki')])[2]");
	//Zioła
	By ZiolaLinkTopMenu = By.xpath("//a[@title=\"Zioła\"]");
	By ZiolaLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Zioła')])[2]");
	//Kwiaty
	By KwiatyLinkTopMenu = By.xpath("//a[@title=\"Kwiaty\"]");
	By KwiatyLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Kwiaty')])[6]");
	//Trawy ozdobne
	By TrawyLinkTopMenu = By.xpath("//a[@title=\"Trawy ozdobne\"]");
	By TrawyLinkBottompMenu = By.xpath("(//li/a[contains(text(),'Trawy ozdobne')])[2]");
	
	public SuperPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		curentlang = langMenu.getText();
		//than we can load necessary lang pack
	}
	
	public ContactUsPage jOpenContactUsTopMenu() {
		driver.findElement(KontaktZnamiTopMenu).click();
		
		return new ContactUsPage(driver, PlaceOnPage.TOP);
	}
	
	public ContactUsPage jOpenContactUsBottomMenu() {
		driver.findElement(KontaktZnamiBottomMenu).click();
		
		return new ContactUsPage(driver, PlaceOnPage.BOTTOM);
	}
	
	//функция которая загружает нужные языковые настрйки:
	//досточно прочитать что находится в langMenu
	
	//this function can change language of the site
	public void jChangeLanguage() {
		langMenu.click();
		WebElement element = 
				driver.findElement(By.xpath(".//*[@id='first-languages']/li[1]"));
		if(element.getAttribute("class").equals("selected"))
			element = 
			driver.findElement(By.xpath(".//*[@id='first-languages']/li[2]/a"));
		else
			element = 
			driver.findElement(By.xpath(".//*[@id='first-languages']/li[1]/a"));
		
		element.click();
		//Вызов фу-ции смены языковых настроек
		
		//Actions actions = new Actions(driver);
		//actions.moveToElement(langMenu);
		//langMenu.click();
		//actions.click().build().perform();
	}
	
	public LogInPage jOpenLogInTopMenu() {
		driver.findElement(LogInTopMenu).click();
		
		return new LogInPage(driver, PlaceOnPage.TOP);
	}
	
	public LogInPage jOpenLogInBottomMenu() {
		driver.findElement(LogInBottoMenu).click();
		
		return new LogInPage(driver, PlaceOnPage.BOTTOM);		
	}
	
	public SuperPage jOpenHomePage() {
		driver.findElement(LogoImage).click();
		
		printLog(OpenedPage(driver.getTitle()) + "home page");
		
		return this;
	}
	
	public BylinyPage jOpenBylinyPageTopMenu() {
		WebElement link = driver.findElement(BylinyLinkTopMenu);
		elementHighlight(link);
		link.click();
		
		return new BylinyPage(driver, PlaceOnPage.TOP);
	}
	
	public BylinyPage jOpenBylinyPageBottomMenu() {
		WebElement link = driver.findElement(BylinyLinkBottompMenu);
		elementHighlight(link);
		link.click();
		
		return new BylinyPage(driver, PlaceOnPage.BOTTOM);
	}
	
	//////////////////////////////
	
	public KrzewyPage jOpenKrzewyPageTopMenu() {
		WebElement link = driver.findElement(KrzewyLinkTopMenu);
		elementHighlight(link);
		link.click();
		
		return new KrzewyPage(driver, PlaceOnPage.TOP);
	}
	
	public KrzewyPage jOpenKrzewyPageBottomMenu() {
		WebElement link = driver.findElement(KrzewyLinkBottompMenu);
		elementHighlight(link);
		link.click();
		
		return new KrzewyPage(driver, PlaceOnPage.BOTTOM);
	}
	
	////////////////////////////Paprocie

	public PaprociePage jOpenPaprociePageTopMenu() {
		WebElement link = driver.findElement(PaprocieLinkTopMenu);
		elementHighlight(link);
		link.click();

		return new PaprociePage(driver, PlaceOnPage.TOP);
	}

	public PaprociePage jOpenPaprociePageBottomMenu() {
		WebElement link = driver.findElement(PaprocieLinkBottompMenu);
		elementHighlight(link);
		link.click();

		return new PaprociePage(driver, PlaceOnPage.BOTTOM);
	}
	
	//Pnącza
	public PnaczaPage jOpenPnaczaPageTopMenu() {
		WebElement link = driver.findElement(PnaczaLinkTopMenu);
		elementHighlight(link);
		link.click();

		return new PnaczaPage(driver, PlaceOnPage.TOP);
	}

	public PnaczaPage jOpenPnaczaPageBottomMenu() {
		WebElement link = driver.findElement(PnaczaLinkBottompMenu);
		elementHighlight(link);
		link.click();

		return new PnaczaPage(driver, PlaceOnPage.BOTTOM);
	}
	
	//Krzewinki
	public KrzewinkiPage jOpenKrzewinkiPageTopMenu() {
		WebElement link = driver.findElement(KrzewinkiLinkTopMenu);
		elementHighlight(link);
		link.click();

		return new KrzewinkiPage(driver, PlaceOnPage.TOP);
	}

	public KrzewinkiPage jOpenKrzewinkiPageBottomMenu() {
		WebElement link = driver.findElement(KrzewinkiLinkBottompMenu);
		elementHighlight(link);
		link.click();

		return new KrzewinkiPage(driver, PlaceOnPage.BOTTOM);
	}
	
	//Ziola
	public ZiolaPage jOpenZiolaPageTopMenu() {
		WebElement link = driver.findElement(ZiolaLinkTopMenu);
		elementHighlight(link);
		link.click();

		return new ZiolaPage(driver, PlaceOnPage.TOP);
	}

	public ZiolaPage jOpenZiolaPageBottomMenu() {
		WebElement link = driver.findElement(ZiolaLinkBottompMenu);
		elementHighlight(link);
		link.click();

		return new ZiolaPage(driver, PlaceOnPage.BOTTOM);
	}
	
	//Kwiaty
	public KwiatyPage jOpenKwiatyPageTopMenu() {
		WebElement link = driver.findElement(KwiatyLinkTopMenu);
		elementHighlight(link);
		link.click();

		return new KwiatyPage(driver, PlaceOnPage.TOP);
	}

	public KwiatyPage jOpenKwiatyPageBottomMenu() {
		WebElement link = driver.findElement(KwiatyLinkBottompMenu);
		elementHighlight(link);
		link.click();

		return new KwiatyPage(driver, PlaceOnPage.BOTTOM);
	}
	
	//Trawy ozdobne
	public TrawyPage jOpenTrawyPageTopMenu() {
		WebElement link = driver.findElement(TrawyLinkTopMenu);
		elementHighlight(link);
		link.click();

		return new TrawyPage(driver, PlaceOnPage.TOP);
	}

	public TrawyPage jOpenTrawyPageBottomMenu() {
		WebElement link = driver.findElement(TrawyLinkBottompMenu);
		elementHighlight(link);
		link.click();

		return new TrawyPage(driver, PlaceOnPage.BOTTOM);
	}
	
	public static void printLog(String str) {
		System.out.println(str);
	}
	
	protected String OpenedPage(String str) {
		return "Opened page: " + str  + " ";
	}
	
	protected void elementHighlight(WebElement element) {
		for (int i = 0; i < 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: Red; border: 3px solid Red;");	
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}
}
