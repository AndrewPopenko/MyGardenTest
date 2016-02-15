package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtSuperPage extends SuperPage {
	WebDriver driver;
	
	//Checkbox for category Availability -> Not available
	@FindBy(id="layered_quantity_0")
	WebElement checkboxNotAvailable;
	
	//Checkbox for category Availability -> In Stock
	@FindBy(id="layered_quantity_1")
	WebElement checkboxInStock;
	
	//Checkbox for category Condition -> New
	@FindBy(id="layered_condition_new")
	WebElement checkboxNew;
	
	//Left slider for Price	
	@FindBy(xpath="//*[@id='layered_price_slider']/a[1]")
	WebElement sliderPriceLeft;
	
	//Right slider for Price	
	@FindBy(xpath="//*[@id='layered_price_slider']/a[2]")
	WebElement sliderPriceRight;
	
	@FindBy(id="selectProductSort")
	WebElement selectProductSort;
	
	@FindBy(id="nb_item")
	WebElement selectItemsPerPage;
	
	//Parameter which available in the () for category Availability -> Not available
	@FindBy(xpath="//*[@id='ul_layered_quantity_0']/li[1]/label/a/span")
	WebElement textNotAvailable;
	
	//Parameter which available in the () for category Availability -> In Stock 
	@FindBy(xpath="//*[@id='ul_layered_quantity_0']/li[2]/label/a/span")
	WebElement textInStock;
	
	//Parameter which available in the () for category Condition -> New
	@FindBy(xpath="//*[@id='ul_layered_condition_0']/li/label/a/span")
	WebElement textNew;
	
	@FindBy(id="layered_price_range")
	WebElement textRange;
	
	//@FindBy(id="grid")
	@FindBy(xpath="//*[@id='grid']/a/i")
	WebElement setGridView;
	
	//@FindBy(id="list")
	@FindBy(xpath="//*[@id='list']/a/i")
	WebElement setListView;
	
	@FindBy(id="pagination_previous")
	WebElement linkPreviousPage;
	
	@FindBy(xpath="//*[@id='center_column']/ul")
	WebElement listItems;
	
	@FindBy(xpath="//*[@id='center_column']/ul/p")
	WebElement imgLoad;
	
	public ExtSuperPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String getNumberOfNotAvailable() {
		//elementHighlight(textNotAvailable);
		return textNotAvailable.getText();
	}
	
	public String getNumberOfInStock() {
		//elementHighlight(textNotAvailable);
		return textInStock.getText();
	}
	
	public String getNumberOfNew() {
		//elementHighlight(textNotAvailable);
		return textNew.getText();
	}
	
	private float getLeftRange(String str) {
		
		int index = str.indexOf('z');
		
		return Float.parseFloat((str.substring(0, index)).replace(',', '.'));
	}
	
	private float getRightRange(String str) {
		int index = str.indexOf('z');
		
		return Float.parseFloat((str.substring((index + 4), str.indexOf('z', index+1))).replace(',', '.'));	
	}
	
	/*
	 * price:asc - Price: Lowest first
	 * price:desc - Price: Highest first
	 * name:asc - Product Name: A to Z
	 * name:desc - Product Name: Z to A
	 * quantity:desc - In stock
	 * reference:asc - Reference: Lowest first
	 * reference:desc - Reference: Highest first
	 */
	public void setProductSort(String value) {
		Select select = new Select(selectProductSort);
		
		if(!value.isEmpty()) {
			select.selectByValue(value);
			
			(new WebDriverWait(driver, 2)).
				until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='center_column']/ul/p")));
		}
		else {
			select.selectByValue("price:asc");
			(new WebDriverWait(driver, 2)).
			until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='center_column']/ul/p")));
		}
	}
	
	/*
	 * 12, 24, 60
	 */
	public void setItemsPerPage(String value) {
		Select select = new Select(selectItemsPerPage);
		
		if(!value.isEmpty()) {
			select.selectByVisibleText(value);
			
			printLog(driver.getTitle() + " - selected " + value + " items per page");
			
			boolean b = (new WebDriverWait(driver, 5)).
				until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='center_column']/ul/p")));
			
			if(b)
				printLog(driver.getTitle() + " - Load img found : b = " + b);
			else
				printLog(driver.getTitle() + " - Load img did't find : b = " + b);
		}
		
		else {
			select.selectByVisibleText("12");
		
			boolean b = (new WebDriverWait(driver, 2)).
				until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='center_column']/ul/p")));
			
			if(b)
				printLog(driver.getTitle() + " - Load img found");
			else
				printLog(driver.getTitle() + " - Load img did't find");
		}
	}
	
	/*true = Grid, false = List*/
	public boolean setViewStyle(boolean isGrid) {
		Actions builder = new Actions(driver);
		
		if(isGrid) {
			if(true && !setGridView.getAttribute("class").equals("selected")) {
				//setGridView.click();// product_list row list
				builder.moveToElement(setGridView).click(setGridView).click().build().perform();
				
				//sleep(1000);
						
				printLog(driver.getTitle() + " - view type - Grid");
				return true;
			}
			else {
				printLog(driver.getTitle() + " - view type - Grid cannot be set");
				return false;
			}
		}
					
		if(!isGrid) {
			if(!setListView.getAttribute("class").equals("selected")) {
				//setListView.click();
				builder.moveToElement(setListView).click(setListView).click().build().perform();
				
				//sleep(1000);
				
				printLog(driver.getTitle() + " - view type - List");
				return true;
			}
			else {
				printLog(driver.getTitle() + " - view type - List cannot be set");
				return false;
			}
		}
		
		return false;
	}
	
	public boolean goToPreviousPage() {
		if(!linkPreviousPage.getAttribute("class").equals("disabled pagination_previous")) {
			linkPreviousPage.click();
			return true;
		}
		else {
			printLog(driver.getTitle() + " cannot navigate to the previous page due to it is first page");
			return false;
		}
	}
	
	public void setMaxPrice(float maxprice) throws InterruptedException {
		setSliderPosition(maxprice, false);
		
		//String strRange = range.getText();
		
		//float leftrange = getLeftRange(strRange);
		//float rightrange = getRightRange(strRange);
		
		/*if(maxprice <= leftrange) {
			printLog(driver.getTitle() + " - maximum price cannot be less than current minimum price");
		}
		else {		
			Actions actions = new Actions(driver);

			//actions.clickAndHold(sliderPriceRight).build().perform();

			while (rightrange >= maxprice) {
				//actions.moveByOffset(-2, 0).build().perform();
				actions.dragAndDropBy(sliderPriceRight, -1, 0).build().perform();
				
				//int xx = sliderPriceRight.getLocation().x;
				//Thread.sleep(1000);
				sleep();
				
				rightrange = getRightRange(range.getText());
			}

			//actions.release(sliderPriceRight).build().perform();
		}*/
	}
	
	public void setMinPrice(float minprice) {		
		setSliderPosition(minprice, true);
		/*String strRange = range.getText();
		
		float leftrange = getLeftRange(strRange);
		float rightrange = getRightRange(strRange);*/
		
		/*if(minprice >= rightrange) {
			printLog(driver.getTitle() + " - minimal price cannot be greater than current maximum price");
		}
		else {		
			Actions actions = new Actions(driver);

			actions.clickAndHold(sliderPriceLeft).build().perform();
			
			Action action = actions.moveByOffset(1, 0).build();

			while (leftrange <= minprice) {
				action.perform();
				
				leftrange = getLeftRange(range.getText());
				
				sleep();
			}

			actions.release(sliderPriceLeft).build().perform();			
		}*/
	}
	
	/*boolean isLeft - if true we use left slider else right*/
	private void setSliderPosition(float price, boolean isLeft) {
		String strRange = textRange.getText();
		
		float leftrange = getLeftRange(strRange);
		float rightrange = getRightRange(strRange);
		
		if(price >= rightrange && isLeft) {
			printLog(driver.getTitle() + " - minimal price cannot be greater than current maximum price");
		}
		
		else if(price <= leftrange && !isLeft) {
			printLog(driver.getTitle() + " - maximum price cannot be less than current minimum price");
		}
		else {
			
			WebElement slider = isLeft ? sliderPriceLeft : sliderPriceRight;
			int xOffset = isLeft ? 3 : -1;
			float frange = isLeft ? leftrange : rightrange;
			boolean isRun = true;			
			
			Actions actions = new Actions(driver);

			while (isRun) {
				actions.dragAndDropBy(slider, xOffset, 0).build().perform();
				
				if(isLeft) {
					if(frange <= price) {
						frange = getLeftRange(textRange.getText());
					}
					else
						isRun = false;
				}
					
				if(!isLeft) {
					if(frange >= price) {
						frange = getRightRange(textRange.getText());
					}
					else
						isRun = false;
				}
				
				sleep(500);
			}
		}
	}
	
	private void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}
