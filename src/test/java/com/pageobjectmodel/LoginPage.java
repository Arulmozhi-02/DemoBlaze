package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {
	
	@FindBy(linkText =login_linkText)
	private WebElement login;
	
	@FindBy(id=username_id)
	private WebElement username;
	
	@FindBy(id=password_id)
	private WebElement password;
	
	@FindBy(xpath=sign_xpath)
	private WebElement signin;
	
	@FindBy(id=title_id)
	private WebElement title;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validLogin() throws IOException {
		clickOnElement(login);
		explicitWait("seconds", 30, username);
		passInputs(username, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
		passInputs(password, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		clickOnElement(signin);
		explicitWait("seconds", 30, title);
		screenShot("homepage");
		getText(title);
		
		
	}
	

}
