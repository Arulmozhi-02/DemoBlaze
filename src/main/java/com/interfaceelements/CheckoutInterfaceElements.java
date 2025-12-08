package com.interfaceelements;

public interface CheckoutInterfaceElements {
	
	String cart_xpath="//a[text()='Cart']";
	String placeOrder_xpath="//button[text()='Place Order']";
	String name_xpath="//input[@id='name']";
	String country_xpath="//input[@id='country']";
	String city_xpath="//input[@id='city']";
	String card_xpath="//input[@id='card']";
	String month_xpath="//input[@id='month']";
	String year_xpath="//input[@id='year']";
	String purchase_xpath="//button[text()='Purchase']";
	String thankyou_xpath="//h2[text()='Thank you for your purchase!']";
	String id_xpath="//p[contains(text(),'Id:')]";
	String ok_xpath="//button[text()='OK']";

}
