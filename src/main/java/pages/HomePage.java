package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;
	
	By header = By.cssSelector("h1.private-header__heading");
	By accountName = By.className("account-name ");
	By settingsIcon = By.id("navSetting");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderValue() {
		if(driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}
	
	public String getUserAccountName() {
		if(driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText();
		}
		return null;
	}
	
	public boolean isExistSettingsIcon() {
		return driver.findElement(settingsIcon).isDisplayed();
	}
}
