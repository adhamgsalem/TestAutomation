package pages;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

//CONFIGURATION CLASS TO RUN CHROME-WEBDRIVER - NAVIGATE TO URL AND CHECKS FOR THE TITLE OF THE PAGE
//TAKES SCREENSHOT ON EVERY TEST WITH STATUS = FAILED
public class BaseClass {
	public WebDriver driver;
	protected Faker faker = new Faker();

	@BeforeMethod
	@Parameters("browser")
	// Browser Driver (parallel)
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adham\\Desktop\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("http://demo-store.seleniumacademy.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Madison Island";
		assertEquals(expectedTitle, actualTitle);
	}

	@AfterMethod
	// Screenshot failed methods and save them on my desktop
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C://Users//adham//Desktop//SS" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
		driver.quit();
	}
}