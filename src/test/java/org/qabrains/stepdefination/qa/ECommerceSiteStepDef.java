package org.qabrains.stepdefination.qa;

import org.apache.logging.log4j.Logger;
import org.qabrains.pages.qa.CartPage;
import org.qabrains.pages.qa.EcommerceLoginPage;
import org.qabrains.pages.qa.EcommercePage;
import org.qabrains.pages.qa.LogoutPage;
import org.qabrains.pages.qa.ProductPage;
import org.qabrains.utilities.qa.LogUtil;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ECommerceSiteStepDef {

	Logger log = LogUtil.getLogger(ECommerceSiteStepDef.class);
	
	EcommercePage ecommercePage;
	EcommerceLoginPage ecommerceLoginPage;
	ProductPage productPage;
	CartPage cartPage;
	LogoutPage logoutPage;
	
	@Given("User should on Home Page")
	public void user_should_on_home_page() {
		log.info("User is on Home Page");
	}

	@When("User should land to E-Commerce Site by clicking on link")
	public void user_should_land_to_e_commerce_site_by_clicking_on_link() {
		ecommercePage=new EcommercePage();
		ecommercePage.ecommerceLinkClick();
	}

	@Then("User click on Visit Demo Site")
	public void user_click_on_visit_demo_site() {
		ecommercePage=new EcommercePage();
		ecommercePage.visitDemoLinkClick();
	}

	@Then("User will successful naviate to Login Page of E-Commerce")
	public void user_will_successful_naviate_to_login_page_of_e_commerce() {
		
		ecommerceLoginPage=new EcommerceLoginPage();
		String actualText= ecommerceLoginPage.ValidateEcommerceloginPage();
		
		Assert.assertEquals(actualText, "LOGIN","Text not matching on E-commerce Login Page");
	}

	@Then("User should enter {string}, {string} and click on Login button")
	public void user_should_enter_and_click_on_login_button(String string, String string2) {
		
		ecommerceLoginPage=new EcommerceLoginPage();
		ecommerceLoginPage.ecommerceLoginClick(string,string2);
	}

	@Then("User should sucessful land on Product page.")
	public void user_should_sucessful_land_on_product_page() {
		productPage=new ProductPage();
		String actaulText=productPage.ValidateProductPage();
		
		Assert.assertEquals(actaulText, "Products", "Product Page : actual text is not matching");
	}

	@Then("User select product and Add to cart")
	public void user_select_product_and_add_to_cart() {
		 productPage=new ProductPage();
		 productPage.selectProduct();

	}

	@Then("User click on cart")
	public void user_click_on_cart() {
		cartPage=new CartPage();
		cartPage.cart();
	}

	@Then("Verify selected product")
	public void verify_selected_product() {
		
		cartPage=new CartPage();
		cartPage.productVerify();
	}

	@Then("User click on logout")
	public void user_click_on_logout() {
		logoutPage=new LogoutPage();
		logoutPage.logout();
		
	}

}
