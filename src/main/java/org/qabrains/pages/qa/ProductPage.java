package org.qabrains.pages.qa;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qabrains.base.qa.BaseTest;

public class ProductPage extends BaseTest {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Products']")
	WebElement productText;

	@FindBy(xpath = "//a[@class='text-lg block decoration-0 font-semibold font-oswald text-gray-900']")
	List<WebElement> products;

	@FindBy(xpath = "(//button[text()='Add to cart'])")
	List<WebElement> addtoCartBnt;

	String productName;

	public String ValidateProductPage() {

		String actualTextEcommProductText = productText.getText();
		return actualTextEcommProductText;
	}

	// Xpath --> (//button[text()='Add to cart'])[1]
	public void selectProduct() {
		for (int i = 0; i < products.size(); i++) {
			productName = products.get(i).getText();

			if (productName.contains("Sample Shirt Name")) {
				addtoCartBnt.get(i).click();
				break;
			}
		}
	}

}
