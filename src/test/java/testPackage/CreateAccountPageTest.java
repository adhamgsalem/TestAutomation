package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.SearchResultsPage;
import pages.UserAccountPage;

public class CreateAccountPageTest extends BaseClass {

	@Test(priority = 2, description = "Registration Page | Check that registration page is displayed ")
	public void validateRegistrationPageIsDisplayed() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		CreateAccountPage registrationPage = new CreateAccountPage(driver);
		Assert.assertTrue(registrationPage.getCreateAccounteMsg());
	}

	@Test(priority = 3, description = "Registration Page | Check that warning message is displayed when user misses to input a value in a mandatory field")
	public void validateMandatoryFieldsOnRegistration() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		CreateAccountPage registrationPage = new CreateAccountPage(driver);
		registrationPage.clickRegisterBtn();
		Assert.assertTrue(registrationPage.firstNameRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.lastNameRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.emailAddressRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.passwordConfirmationRequiredMsgDisplayed());
		Assert.assertTrue(registrationPage.passwordRequiredMsgDisplayed());
	}

	@Test(priority = 4, description = "Registration Page | Check that warning message is displayed when user inputs pswd1 different from pswd2")
	public void validatePasswordMatchingOnRegistration() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		CreateAccountPage registrationPage = new CreateAccountPage(driver);
		registrationPage.typePassword();
		registrationPage.typePasswordConfirmationWrong();
		registrationPage.clickRegisterBtn();
		Assert.assertTrue(registrationPage.passwordDoesNotMatchMsgDisplayed());
	}

	@Test(priority = 5, description = "Registration Page | Check that warning message is displayed when user inputs a weak password")
	public void validatePasswordComplexityOnRegistration() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		CreateAccountPage registrationPage = new CreateAccountPage(driver);
		registrationPage.typePasswordIncorrect();
		registrationPage.clickRegisterBtn();
		Assert.assertTrue(registrationPage.passwordComplixtyMsgDisplayed());
	}

	@Test(priority = 6, description = "Registration Page | Check that after successful registration the user gets a registration success message")
	public void validateValidRegistration() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickAccountIcon();
		landingPage.clickRegisterBtn();
		CreateAccountPage registrationPage = new CreateAccountPage(driver);
		registrationPage.typeFirstName();
		registrationPage.typeMiddleName();
		registrationPage.typeLastName();
		registrationPage.typeEmailAddress();
		registrationPage.typePassword();
		registrationPage.typePasswordConfirmation();
		registrationPage.subscripeToNewsLetter();
		registrationPage.clickRegisterBtn();
		UserAccountPage userAccountPage = new UserAccountPage(driver);
		Assert.assertTrue(userAccountPage.getRegistrationSuccessMsg());
		userAccountPage.typeSearchQuery();
		userAccountPage.clickSearchBtn();
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		Assert.assertEquals(searchResultsPage.getItemsCount(), "1 Item(s)");
	}

}
