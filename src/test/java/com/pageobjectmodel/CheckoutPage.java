package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.CheckoutInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class CheckoutPage extends Base_Class implements CheckoutInterfaceElements {
	@FindBy(xpath=cart_xpath)
	private WebElement cart;
	
	@FindBy(xpath =placeOrder_xpath)
	private WebElement placeOrder;
	
	@FindBy(xpath=name_xpath)
	private WebElement name;
	
	@FindBy(xpath=country_xpath)
	private WebElement country;
	
	@FindBy(xpath=city_xpath)
	private WebElement city;
	
	@FindBy(xpath=card_xpath)
	private WebElement card;
	
	@FindBy(xpath=month_xpath)
	private WebElement month;
	
	@FindBy(xpath=year_xpath)
	private WebElement year;
	
	@FindBy(xpath=purchase_xpath)
	private WebElement purchase;
	
	@FindBy(xpath=thankyou_xpath)
	private WebElement thankyou;
	
	@FindBy(xpath=id_xpath)
	private WebElement id;
	
	@FindBy(xpath=ok_xpath)
	private WebElement ok;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkout() throws IOException, InterruptedException {
		clickOnElement(cart);
		Thread.sleep(5000);
		screenShot("cart page");
		clickOnElement(placeOrder);
		explicitWait("seconds", 30, name);
		passInputs(name, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
		passInputs(country, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("country"));
		passInputs(city, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("city"));
		passInputs(card, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("card"));
		passInputs(month, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("month"));
		passInputs(year, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("year"));
		clickOnElement(purchase);
		Thread.sleep(5000);
		getText(thankyou);
		getText(id);
		screenShot("thankyou");
		clickOnElement(ok);
		
	}
	

}
