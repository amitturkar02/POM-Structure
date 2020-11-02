package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import util.Constants;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	@Test(priority = 1)
	public void homePageHeaderTest() {
		String header = homePage.getHomePageHeaderValue();
		System.out.println("home page header is : " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER); 
	}

	@Test(priority = 2)
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void userAccountNameTest() {
		String accountName = homePage.getUserAccountName();
		System.out.println("loggedIn user account name : " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname").trim());
	}

	@Test(priority = 4)
	public void settingIconExistsTest() {
		Assert.assertTrue(homePage.isExistSettingsIcon());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
