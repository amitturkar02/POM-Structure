package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Constants;
import util.ElementUtil;

public class LoginPage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1. Page Locators: By locators
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//2. Create the constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3. page actions/page methods
	public String getLoginPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	public HomePage doLogin(String username, String pwd) {
		System.out.println("login with : " + username + " : " + pwd);
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new HomePage(driver);
	}
}
