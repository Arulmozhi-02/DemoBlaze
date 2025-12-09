package com.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class TestClass extends Base_Class{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		browserLaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		getUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
		PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
		PageObjectManager.getPageObjectManager().getSearchProduct().searchProduct();
		PageObjectManager.getPageObjectManager().getCheckout().checkout();
		PageObjectManager.getPageObjectManager().getLogout().logout();
		
		System.out.println("---PRODUCT PURCHASED SUCCESSFULLY---");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		browserLaunch("chrome");
//		getUrl("https://letcode.in/alert");
//		WebElement element = driver.findElement(By.xpath("//button[@id='accept']"));
//		clickOnElement(element);
//		getAlert("text");
		
//		getBrowserDetails("CURRENT URL");
//		navigatePage("refresh", null);
//		navigatePage("to", "https://letcode.in/dropdowns");
//		WebElement ele= driver.findElement(By.id("fruits"));
//		getAllOptions(ele);
//		WebElement element = driver.findElement(By.id("superheros"));
//		isMultiple("multiple", element);
//		navigatePage("to", "https://letcode.in/radio");
//		WebElement el = driver.findElement(By.id("one"));
//		el.click();
//		isSelected(el, "selected");
		
//		navigatePage("to", "https://letcode.in/frame");
//		iFrame("fname", 0, "google_esf");
		//closeBrowser();
		
	}

}
