package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccountPage {
	
	By registrationSuccessMsg = By.xpath("//span[contains(text(),'Thank you for registering with Madison Island.')]");
	By searchBox = By.xpath("//input[@id='search']");
	By searchBtn = By.xpath("//header/div[1]/div[4]/form[1]/div[1]/button[1]");
	
	WebDriver driver;
	WebDriverWait wait;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}


	public boolean getRegistrationSuccessMsg() {
		return driver.findElement(registrationSuccessMsg).isDisplayed();
	}
	
	public void typeSearchQuery() {
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys("sports");
	}
	
	public void clickSearchBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		driver.findElement(searchBtn).click();
	}

}
