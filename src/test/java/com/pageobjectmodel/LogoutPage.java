package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LogoutInterfaceElements;

public class LogoutPage extends Base_Class implements LogoutInterfaceElements {
	
	@FindBy(xpath=logout_xpath)
	private WebElement logout;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		explicitWait("seconds", 20, logout);
		clickOnElement(logout);
	}

}
