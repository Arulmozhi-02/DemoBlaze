package com.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Class {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	protected static WebDriver browserLaunch(String browserName){
		try {
			
			if(browserName.equalsIgnoreCase("chrome")){
				driver = new ChromeDriver();
			
			}else if(browserName.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		}
		catch(Exception e){
			Assert.fail("ERROR: OCCURS DURING BROWSER LAUNCH");
			
		}
		driver.manage().window().maximize();
		return driver;
		}
	protected static void closeBrowser()
	{
		try {
		driver.close();
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING CLOSING BROWSER");
		}
	}
	protected static void quitBrowser()
	{
		try {
			driver.quit();
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING QUITING BROWSER");
		}
		}
	
	protected static void getUrl(String url)
	{
		try {
			driver.get(url);
			}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS WHILE GETTING THE URL");
		}
		}
	protected static void passInputs(WebElement element, String value)
	{
		try {
			element.sendKeys(value);
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS WHILE PASSING THE INPUT");
		}
	}
	
	protected static void selectOptions(WebElement element, String type, String value)
	{
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("value")) {
				select.selectByValue("value");
			}else if(type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}
		}
		catch(Exception e) {
			Assert.fail("ERROR: OCCURS DURING SELECTING THE OPTION");
			
		}
	}
	
	protected static void deSelectOptions(WebElement element, String type, String value)
	{
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("value")) {
				select.deselectByValue("value");
			}else if(type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			}
		}
		catch(Exception e) {
			Assert.fail("ERROR: OCCURS DURING DESELECTING THE OPTION");
			
		}
	}
	
	protected static void getBrowserDetails(String details)
	{
		try {
			if(details.equalsIgnoreCase("title")) {
				String title =driver.getTitle();
				System.out.println("Title is "+title);
			}else if(details.equalsIgnoreCase("current url")) {
				String current_Url=driver.getCurrentUrl();
				System.out.println("Current Url is "+current_Url);
			}else if(details.equalsIgnoreCase("pagesource")) {
				String page_Source=driver.getPageSource();
				System.out.println("Page Source is "+page_Source);
			}
			}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING WHILE GETTING THE DETAILS");	
		}
	}
	protected static void navigatePage(String type,String url)
	{
		try {
			if(type.equalsIgnoreCase("to")) {
				driver.navigate().to(url);
			}else if(type.equalsIgnoreCase("back")) {
				driver.navigate().back();
			}else if(type.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}else if(type.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
			}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING WHILE NAVIGATING TO THE URL");
		}
	}
	
	protected static List<WebElement> getAllOptions(WebElement element) {
		try {
			Select select = new Select(element);
		
			List<WebElement> options = select.getOptions();
			for(WebElement option:options) {
				System.out.println(option.getText());
			}
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING WHILE GETTING THE OPTIONS");
		}
		return null;
	}
	protected static void getAllSelectedOptions(WebElement element) {
		try {
			Select select = new Select(element);
		
			List<WebElement> options = select.getAllSelectedOptions();
			for(WebElement option:options) {
				System.out.println(option.getText());
			}
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING WHILE GETTING THE SELECTED OPTIONS");
		}
	}
	protected static void getFirstSelectedOptions(WebElement element) {
		try {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption);
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING WHILE GETTING THE FIRST SELECTED OPTIONS");
		}
	}
	
	protected static void clickOnElement(WebElement element)
	{
		try {
			element.click();
		}
		catch(Exception e)
		{
			Assert.fail("ERROR: OCCURS DURING WHILE CLICKING THE ELEMENT");
		}
	}
	
	protected static void isMultiple(String type,WebElement element)
	{
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("multiple")) {
				boolean multiple = select.isMultiple();
				System.out.println(multiple);
			}else {
				System.out.println("false");
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE CHECKING THE MULTIPLE SELECTED ELEMENTS");
		}
		
	}
	protected static void isSelected(WebElement element,String type) {
		try {
			if(type.equalsIgnoreCase("selected")) {
				boolean selected = element.isSelected();
				System.out.println(selected);
			}else if(type.equalsIgnoreCase("enabled")) {
				boolean enabled = element.isEnabled();
				System.out.println(enabled);
			}else if(type.equalsIgnoreCase("displayed")) {
				boolean displayed = element.isDisplayed();
				System.out.println(displayed);
			}
			}
		catch(Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE CHECKING THE ELEMENT");
		}
	}
	
	protected static void windowsHandling(int num) {
		try {
			List<String> allWindow= new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(0));
		}
		catch(Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE HANDLING THE WINDOW");
		}
	}
	
	protected static void implicitWait(int num)
	{
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
		}
		catch(Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE IMPLICIT WAIT");
		}
	}
	
	protected static void explicitWait(String time,int num,WebElement element) {
		try {
			if(time.equalsIgnoreCase("seconds")) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(num));
				wait.until(ExpectedConditions.visibilityOf(element));
			}else if(time.equalsIgnoreCase("minutes")) {
				wait = new WebDriverWait(driver, Duration.ofMinutes(num));
				wait.until(ExpectedConditions.visibilityOf(element));
			}else if(time.equalsIgnoreCase("hours")) {
				wait= new WebDriverWait(driver, Duration.ofHours(1));
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			}
		catch(Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE EXPLICIT WAIT");
			}
	}
	
	protected static void getAlert(String type) {
		try {
			if(type.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
			}else if(type.equals("dismiss")) {
				driver.switchTo().alert().dismiss();
			}else if(type.equalsIgnoreCase("text")) {
			String text = driver.switchTo().alert().getText();
			System.out.println(text);
				}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE ALERT");
		}
	}
	protected static void iFrame(String type,int index, String fname) {
		try {
			if(type.equalsIgnoreCase("fname")) {
				driver.switchTo().frame(fname);
			}else if(type.equalsIgnoreCase("index")) {
				driver.switchTo().frame(index);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE FINDING THE FRAME");
		}
	}
	protected static void mouseActions(String type, WebElement element) {
		try {
			Actions action = new Actions(driver);
			if(type.equalsIgnoreCase("click")) {
				action.click(element).perform();
				}else if(type.equalsIgnoreCase("contextclick")) {
					action.contextClick(element).perform();
				}else if(type.equalsIgnoreCase("doubleclick")) {
					action.doubleClick(element).perform();
				}else if(type.equalsIgnoreCase("moveto")) {
					action.moveToElement(element).perform();
				}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE DOING THE MOUSE ACTIONS");
		}
	}
	protected static void scroll_JavaScript(String type, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			if(type.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click();", element);
			}else if(type.equalsIgnoreCase("value")) {
				js.executeScript("arguments[0].value='';", element);
			}else if(type.equalsIgnoreCase("scrollintoview")) {
				js.executeScript("arguments[0].scrollIntoView();", element);			
				}
				} catch (Exception e) {
					Assert.fail("ERROR: OCCURS DURING WHILE SCROLLING THE PAGE");
		}
	}
	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WHILE GETTING THE TEXT");
		}
	}
	protected static void screenShot(String name) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source,new File("D:\\GREENS SELENIUM COURSE\\Maven_Project\\ScreenShot\\"+name+".jpg"));
		
	}
}
	


