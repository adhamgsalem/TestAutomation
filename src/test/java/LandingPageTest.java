import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LandingPage;


public class LandingPageTest extends BaseClass {
	
	@Test(priority = 1, description = "Landing Page | Check that landing page is displayed after navigating to the website")
	public void validateLandingPageIsDisplayed() {
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getWelcomeMsg());
	}
}
