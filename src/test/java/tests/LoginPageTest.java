package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import util.Constants;

public class LoginPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
//	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browser);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String titleLoginPage = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + titleLoginPage);
		Assert.assertEquals(titleLoginPage, Constants.LOGIN_PAGE_TITLE, Constants.LOGIN_TITLE_ERROR_MESSG);
	}

	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExist(), Constants.SIGNUP_LINK_ERROR_MESSG);
	}

	@Test(priority = 3)
	public void loginTest() {
		HomePage homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
