package org.qabrains.pages.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qabrains.base.qa.BaseTest;

public class RegistrationHomePage extends BaseTest {

	@FindBy(xpath = "//h2[text()='Registration Successful']")
	WebElement regSucessMsg;
	
	public RegistrationHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getRegSucessText() {

		String actualRegText = regSucessMsg.getText();
		return actualRegText;
	}
}
