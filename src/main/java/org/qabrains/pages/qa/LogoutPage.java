package org.qabrains.pages.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qabrains.base.qa.BaseTest;

public class LogoutPage extends BaseTest{
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='user-name font-bold text-xs sm:text-[15px]']")
	WebElement userProfile;
	
@FindBy(xpath = "//div[contains(text(),'Log out')]") WebElement logoutBnt;


//alert
@FindBy(xpath = "//div[@role='dialog']") WebElement alertLogout;
@FindBy(xpath = "//button[text()='Logout']") WebElement alertLogoutBnt;

public void logout() {
	userProfile.click();
	logoutBnt.click();
	
	alertLogout.click();
	alertLogoutBnt.click();
}

}
