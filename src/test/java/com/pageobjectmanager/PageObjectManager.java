package com.pageobjectmanager;

import com.pageobjectmodel.CheckoutPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.LogoutPage;
import com.pageobjectmodel.SearchProductPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
	private FileReaderManager fileReader;
	private LoginPage loginPage;
	private static PageObjectManager pageObjectManager;
	private SearchProductPage searchProduct;
	private CheckoutPage checkout;
	private LogoutPage logout;
	

	
	public LogoutPage getLogout() {
		if(logout==null) {
			logout= new LogoutPage();
		}
		return logout;
	}

	public CheckoutPage getCheckout() {
		if(checkout==null) {
			checkout=new CheckoutPage();
		}
		return checkout;
	}

	public FileReaderManager getFileReader() {
		if(fileReader==null) {
			fileReader=new FileReaderManager();
		}
		return fileReader;
	}

	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	public SearchProductPage getSearchProduct() {
		if(searchProduct==null) {
			searchProduct=new SearchProductPage();
		}
		return searchProduct;
	}


	public static PageObjectManager getPageObjectManager() {
		if(pageObjectManager==null) {
			pageObjectManager= new PageObjectManager();		
			}
		return pageObjectManager;
	}

}
