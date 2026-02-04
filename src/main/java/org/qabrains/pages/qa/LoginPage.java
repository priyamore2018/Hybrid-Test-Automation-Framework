package org.qabrains.pages.qa;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qabrains.base.qa.BaseTest;
import org.qabrains.utilities.qa.LogUtil;

public class LoginPage extends BaseTest {

	Logger log = LogUtil.getLogger(LoginPage.class);
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBnt;

	@FindBy(xpath = "//h2[text()='Login Successful']")
	WebElement loginSucessText;


	public void login(String username, String passWord) {
		email.sendKeys(username);
		password.sendKeys(passWord);
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(loginBnt));
		
		loginBnt.click();

		wait.until(ExpectedConditions.visibilityOf(loginSucessText));
		log.info("Sucessfully click on Login Button.");
	}

}
