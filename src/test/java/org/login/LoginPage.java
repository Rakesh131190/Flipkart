package org.login;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
		
		public LoginPage()  {
			PageFactory.initElements(driver, this);
		}

		@CacheLookup
		
		@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
		private WebElement clickLogin;
		
		public WebElement getClickLogin() {
			return clickLogin;
		}
		
		
		@FindBy(xpath="//input[@type='text']")
		private WebElement txtSearch;
		
		public WebElement getTxtSearch() {
			return txtSearch;
		}
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement btnSearch;
		
		public WebElement getBtnSearch() {
			return btnSearch;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
