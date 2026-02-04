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

public class EcommercePage extends BaseTest{

	@FindBy(xpath = "//span[normalize-space()='E-Commerce Site']") WebElement ecommerceLink;
	
	@FindBy(linkText = "Visit Demo Site") WebElement visitDemoLink;
	@FindBy(xpath = "//h2[normalize-space()='Login']")  WebElement ecommerceloginText ;
	
	Wait<WebDriver> wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	

	public EcommercePage() {
		PageFactory.initElements(driver, this);
	}
	

	public void ecommerceLinkClick() {
		wait.until(ExpectedConditions.elementToBeClickable(ecommerceLink));
		ecommerceLink.click();
		
	}
	public void visitDemoLinkClick() {
		wait.until(ExpectedConditions.elementToBeClickable(visitDemoLink));
		visitDemoLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(ecommerceloginText));
	}
	
	
	
	
}
