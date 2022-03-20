package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	By welcomeMsg = By.xpath ("//p[contains(text(),'Welcome')]");
	By accountIcon = By.xpath ("//header/div[1]/div[2]/div[1]/a[1]/span[1]");
	By cartIcon = By.xpath ("//header/div[1]/div[2]/div[1]/div[1]/a[1]/span[2]");
	By registerButton = By.xpath ("//a[contains(text(),'Register')]");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getWelcomeMsg () {
		return driver.findElement(welcomeMsg).isDisplayed();
	}
	
	public void clickAccountIcon () {
		wait.until(ExpectedConditions.elementToBeClickable(accountIcon));
		driver.findElement(accountIcon).click();
	}

	public void clickRegisterBtn () {
		 wait.until(ExpectedConditions.elementToBeClickable(registerButton));
		driver.findElement(registerButton).click();
	}

}
