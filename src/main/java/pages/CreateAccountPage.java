package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
	
	By createAccountMsg = By.xpath ("//h1[contains(text(),'Create an Account')]");
	By firstName = By.xpath ("//input[@id='firstname']");
	By middleName = By.xpath ("//input[@id='middlename']");
	By lastName = By.xpath ("//input[@id='lastname']");
	By emailAddress = By.xpath ("//input[@id='email_address']");
	By password = By.xpath ("//input[@id='password']");
	By passwordConfirm = By.xpath ("//input[@id='confirmation']");
	By newLetterCheckBox = By.xpath ("//input[@id='is_subscribed']");
	By backBtn = By.xpath ("//body/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/p[1]/a[1]");
	By registerBtn = By.xpath ("//span[contains(text(),'Register')]");
	By firstNameRequired = By.xpath ("//div[@id='advice-required-entry-firstname']");
	By lastNameRequired = By.xpath ("//div[@id='advice-required-entry-lastname']");
	By emailAddressRequired = By.xpath ("//div[@id='advice-required-entry-email_address']");
	By passwordRequired = By.xpath ("//div[@id='advice-required-entry-email_address']");
	By passwordConfrimRequired = By.xpath ("//div[@id='advice-required-entry-confirmation']");
	By passwordComplexityMsg = By.xpath ("//div[@id='advice-validate-password-password']");
	By passwordMatchMsg = By.xpath ("//div[@id='advice-validate-cpassword-confirmation']");

	
	WebDriver driver;
	WebDriverWait wait;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean geCreateAccounteMsg () {
		return driver.findElement(createAccountMsg).isDisplayed();
	}
	
	public boolean firstNameRequiredMsgDisplayed () {
		return driver.findElement(firstNameRequired).isDisplayed();
	}
	
	public boolean lastNameRequiredMsgDisplayed () {
		return driver.findElement(lastNameRequired).isDisplayed();
	}
	
	public boolean emailAddressRequiredMsgDisplayed () {
		return driver.findElement(emailAddressRequired).isDisplayed();
	}
	
	public boolean passwordRequiredMsgDisplayed () {
		return driver.findElement(passwordRequired).isDisplayed();
	}
	
	public boolean passwordConfirmationRequiredMsgDisplayed () {
		return driver.findElement(passwordConfrimRequired).isDisplayed();
	}
	
	public boolean passwordDoesNotMatchMsgDisplayed () {
		return driver.findElement(passwordMatchMsg).isDisplayed();
	}
	
	public boolean passwordComplixtyMsgDisplayed () {
		return driver.findElement(passwordComplexityMsg).isDisplayed();
	}
	
	public void typeFirstName () {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys("Adham");
	}

	public void typeMiddleName () {
		driver.findElement(middleName).clear();
		driver.findElement(middleName).sendKeys("Gomaa");
	}
	
	public void typeLastName () {
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys("Salem");
	}
	
	public void typeEmailAddress () {
		driver.findElement(emailAddress).clear();
		driver.findElement(emailAddress).sendKeys("adhamgsalem@mailinator.com");
	}
	
	public void typePassword () {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("TestPassword");
	}
	
	public void typePasswordIncorrect () {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("AA");
	}
	
	public void typePasswordConfirmation () {
		driver.findElement(passwordConfirm).clear();
		driver.findElement(passwordConfirm).sendKeys("TestPassword");
	}
	
	public void typePasswordConfirmationWrong () {
		driver.findElement(passwordConfirm).clear();
		driver.findElement(passwordConfirm).sendKeys("TestPasswor");
	}
	
	public void subscripeToNewsLetter () {
		wait.until(ExpectedConditions.elementToBeClickable(newLetterCheckBox));
		driver.findElement(newLetterCheckBox).click();
	}
	
	public void clickBackBtn () {
		wait.until(ExpectedConditions.elementToBeClickable(backBtn));
		driver.findElement(firstName).sendKeys("Adham");
	}
	
	public void clickRegisterBtn () {
		wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
		driver.findElement(registerBtn).click();
	}


}
