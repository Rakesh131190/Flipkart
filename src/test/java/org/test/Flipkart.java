package org.test;

import org.base.BaseClass;
import org.login.LoginPage;

public class Flipkart extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		
	browserLaunch("chrome");
	urlLaunch("https://www.flipkart.com/");
	
	LoginPage l = new LoginPage();
	
	click(l.getClickLogin());
	
	sleep(3000);
	
	sendKeys(l.getTxtSearch(), "Iphone13");
	
	click(l.getBtnSearch());
	
	
	
	
	
	
	
	}
	
}
 