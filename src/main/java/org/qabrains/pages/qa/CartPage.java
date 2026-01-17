package org.qabrains.pages.qa;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qabrains.base.qa.BaseTest;

public class CartPage extends BaseTest {
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@role='button'])[1]") WebElement cart;
	
	@FindBy(xpath = "//h3[@class='font-bold font-oswald text-lg']") 
	List<WebElement> selectedProducts;
	
	public void cart() {
		cart.click();
	}
	
	public String productVerify() {
		ProductPage productPage=new ProductPage();
		String actualText=productPage.productName;
		String cartproduct = null;
		
		for(WebElement i:selectedProducts) {
			 cartproduct=i.getText();
		}
		
		return cartproduct;
		
	}
}
