package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	
	By itemCount = By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/p[1]/strong[1]");

	
	WebDriver driver;
	WebDriverWait wait;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}


	public String getItemsCount() {
		return driver.findElement(itemCount).getText();
	}

}