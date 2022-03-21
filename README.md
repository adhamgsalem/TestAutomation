# TestAutomation
The framework is used to automate the testing of the functionality and UI for http://demo-store.seleniumacademy.com/.

# Prerequisites
- Eclipse IDE<br />
- Java JRE version 1.7<br />
- TestNG version 7.4.0<br />
- Maven<br />
- WebDriver (Chrome, Firefox, ..etc)

# Project setup and test execution
To setup the project locally and execute tests, you will need to: 
<br />
<br />
1- Clone the project via https://github.com/adhamgsalem/TestAutomation.git (use Eclipse, GitHub desktop or SourceTree)
<br />
2- Change the path for the chromedriver found at src/main/java/pages/BaseClass.java to the path of your chromedirver
<br />
```
System.setProperty("webdriver.chrome.driver", "/Users/adhamsalem/git/TestAutomation/drivers/chromedriver");
```
3- An executable chromedriver file is found at TestAutomation/drivers/ (this driver is for MacOS users else go to https://chromedriver.chromium.org/downloads)
<br />
4- Change the path for the screenshot of failed tests found src/main/java/pages/BaseClass.java to the path you wish to add screenshots to
<br />
```
FileUtils.copyFile(scrFile, new File("/Users/adhamsalem/git/TestAutomation/failedtests" + testResult.getName() + "-"

```
5- Run Eclipse, click file > open project from file system and locate the cloned project
<br />
6- Right click on the project and select run as: Maven clean then run as: Maven test.
<br />
7- We can run tests via command line but will need Maven to be installed on the machine.

# Test Reports
Test reports are written to the "test-output/index.html" and can be emailed after test execution is comeplted.

