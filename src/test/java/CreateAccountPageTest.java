import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.CreateAccountPage;
import pages.LandingPage;

public class CreateAccountPageTest extends BaseClass {
	
	CreateAccountPage registrationPage = new CreateAccountPage(driver);
	LandingPage landingPage = new LandingPage(driver);
	
	@Test(priority = 2, description = "Registration Page | Check that registration page is displayed ")
	public void validateRegistrationPageIsDisplayed() {
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		Assert.assertTrue(registrationPage.geCreateAccounteMsg());
	}
	
	@Test(priority = 3, description = "Registration Page | Check that warning message is displayed when user misses to input a value in a mandatory field")
	public void validateMandatoryFields() {
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		registrationPage.clickRegisterBtn();
		Assert.assertTrue(registrationPage.firstNameRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.lastNameRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.emailAddressRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.passwordConfirmationRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.passwordRequiredMsgDisplayed());
	}
	
	@Test(priority = 4, description = "Registration Page | Check that warning message is displayed when user inputs pswd1 different from pswd2")
	public void validatePasswordMatching() {
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		registrationPage.clickRegisterBtn();
		registrationPage.typePassword();
		registrationPage.typePasswordConfirmationWrong();
		registrationPage.clickRegisterBtn();
		Assert.assertTrue(registrationPage.passwordDoesNotMatchMsgDisplayed());
	}

}
