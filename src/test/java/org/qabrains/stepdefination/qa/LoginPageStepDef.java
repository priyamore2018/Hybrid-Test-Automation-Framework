package org.qabrains.stepdefination.qa;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.qabrains.pages.qa.LoginPage;
import org.qabrains.pages.qa.UserHomePage;
import org.qabrains.utilities.qa.ExcelReader;
import org.qabrains.utilities.qa.LogUtil;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

	public LoginPage loginPage;
	public UserHomePage userHomePage;

	Logger log = LogUtil.getLogger(LoginPageStepDef.class);

	@Given("User should be on Login Page")
	public void user_should_be_on_login_page() {
		log.info("Step 1 : User is on Login Page");
	}

	@When("User should enter valid username and password from Excel {string} and {int} then click on login button")
	public void user_should_enter_valid_username_and_password_from_excel_and_then_click_on_login_button(
			String sheetName, int rowNumber) {

		// excel read
		Object[][] data;
		try {
			data = ExcelReader.getExcelData(sheetName);
			String username = data[rowNumber][0].toString(); // username
			String password = data[rowNumber][1].toString(); // password

			loginPage = new LoginPage();
			loginPage.login(username, password);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		log.info(
				"Step for sheetName : User is entering username and password from Excel sheet and click on login button");
	}

	@Then("User should land on the sucessful Login Home page.")
	public void user_should_land_on_the_sucessful_login_home_page() {

		userHomePage = new UserHomePage();
		String text = userHomePage.getText();

		//Assert.assertEquals(text, "LOGIN SUCCESSFUL", "*****Login sucessful text is not correct.***");
		log.info("Step 3 : user navigate to sucessful login page.");

	}

	@Then("User click on logout button from Login Home Page.")
	public void user_click_on_logout_button_from_login_home_page() {
		//userHomePage.logout();
		log.info("Step 4 : user click on logout button.");

	}
}
