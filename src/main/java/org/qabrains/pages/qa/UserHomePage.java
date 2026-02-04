package org.qabrains.pages.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qabrains.base.qa.BaseTest;

public class UserHomePage extends BaseTest {

	@FindBy(xpath = "//h2[normalize-space()='Login Successful']")
	WebElement loginSucessText;

	@FindBy(xpath = "(//button[normalize-space()='Logout'])[1]")
	WebElement logoutBnt;

	public UserHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getText() {
		String actualText = loginSucessText.getText();
		return actualText;
	}

	public void logout() {
		try {
			logoutBnt.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
