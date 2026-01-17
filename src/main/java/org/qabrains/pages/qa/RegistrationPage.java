package org.qabrains.pages.qa;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qabrains.base.qa.BaseTest;
import org.qabrains.utilities.qa.LogUtil;

public class RegistrationPage extends BaseTest {

	Logger log = LogUtil.getLogger(RegistrationPage.class);

	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath = "//span[text()='Registration']")
	WebElement registrationLink;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "account")
	WebElement account;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm_password")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[text()='Signup']")
	WebElement signUpBnt;

	@FindBy(xpath = "//h2[text()='Registration Successful']")
	WebElement regSucessMsg;

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public void registration() {
		wait.until(ExpectedConditions.elementToBeClickable(registrationLink));
		registrationLink.click();
		wait.until(ExpectedConditions.visibilityOf(name));
		log.info("Sucessfully click on Registration Link");
	}

	public void singUp(String FirstName, String countryName, String accType, String emailID, String userPassword,
			String confirmPwd) {
		name.sendKeys(FirstName);

		Select selectCountry = new Select(country);
		selectCountry.selectByValue(countryName);

		Select accountType = new Select(account);
		accountType.selectByValue(accType);

		email.sendKeys(emailID);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", password);

		password.sendKeys(userPassword);
	
		confirmPassword.sendKeys(confirmPwd);

		signUpBnt.click();
		wait.until(ExpectedConditions.visibilityOf(regSucessMsg));
		log.info("Sucessfully click on SingUp Link");

	}

}
