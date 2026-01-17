package org.qabrains.pages.qa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qabrains.base.qa.BaseTest;

public class EcommerceLoginPage extends BaseTest{

	public EcommerceLoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h2[text()='Login']")  WebElement ecommerceloginText ;
	
	@FindBy(id = "email") WebElement email;
	@FindBy(id = "password") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement ecommerceLoginBnt;
	@FindBy(xpath = "//h3[text()='Products']") WebElement productPageHeader;
	
	//public String actualTextEcommLoginText=ecommerceloginText.getText();
	
	public String ValidateEcommerceloginPage() {
		
		String actualTextEcommLoginText=ecommerceloginText.getText();
		return actualTextEcommLoginText;
	}

	public void ecommerceLoginClick(String email,String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		
		ecommerceLoginBnt.click();
		Wait<WebDriver> wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(productPageHeader));
		
	}
	
}
