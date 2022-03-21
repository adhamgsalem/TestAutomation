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
1- Clone the project via https://github.com/adhamgsalem/TestAutomation.git
<br />
2- Change the path for the chromedriver found at TestAutomation/src/main/java/pages/BaseClass.java - LINE: 31 to the path of your chromedirver
<br />
```
System.setProperty("webdriver.chrome.driver", "/Users/adhamsalem/git/TestAutomation/drivers/chromedriver");
```
3- An executable chromedriver file is found at TestAutomation/drivers/ (for MacOS users)
<br />
4- change the path for the screenshot of failed tests found TestAutomation/src/main/java/pages/BaseClass.java - LINE: 48 to the path you wish to add screenshots to
<br />
```
FileUtils.copyFile(scrFile, new File("/Users/adhamsalem/git/TestAutomation/failedtests" + testResult.getName() + "-"

```
5- Open terminal (for MacOs users)
<br />
6- Locate the project directory 
```
cd /Users/adhamsalem/git/TestAutomation/
```
7- Clean project by running the below maven command 
```
mvn clean
```
8- Execute tests by running the below maven command
```
mvn test
```
