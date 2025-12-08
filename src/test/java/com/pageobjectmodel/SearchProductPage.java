package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.SearchProductInterfaceElements;

public class SearchProductPage extends Base_Class implements SearchProductInterfaceElements {
	@FindBy(xpath=laptop_xpath)
	private WebElement laptop;
	
	@FindBy(linkText=model_linkText)
	private WebElement model;
	
	@FindBy(xpath=cart_xpath)
	private WebElement cart;
	
	public SearchProductPage() {
		PageFactory.initElements(driver, this);
	}
	public void searchProduct() throws InterruptedException {
		clickOnElement(laptop);
		clickOnElement(model);
		explicitWait("seconds", 20, cart);
		clickOnElement(cart);
		Thread.sleep(4000);
		getAlert("text");
		getAlert("accept");
	}
	

}
