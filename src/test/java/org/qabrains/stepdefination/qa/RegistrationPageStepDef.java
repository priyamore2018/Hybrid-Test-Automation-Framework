package org.qabrains.stepdefination.qa;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.qabrains.pages.qa.RegistrationHomePage;
import org.qabrains.pages.qa.RegistrationPage;
import org.qabrains.utilities.qa.ExcelReader;
import org.qabrains.utilities.qa.LogUtil;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageStepDef {

	RegistrationPage regPage;
	RegistrationHomePage regHomePage;

	Logger log = LogUtil.getLogger(RegistrationPageStepDef.class);

	@Given("User is on click on Registration link")
	public void user_is_on_click_on_registration_link() throws InterruptedException {
		regPage = new RegistrationPage();
		regPage.registration();
		log.info("Step 1 : User is on click on Registration link");
	}

	@When("User is entering all deatils from Excel sheet and click on SignIn Button")
	public void user_is_entering_all_deatils_from_excel_sheet_and_click_on_sign_in_button()
			throws InterruptedException {

		// read data from excel

		String sheetName = "RegistrationTestData";
		Object[][] data;
		try {
			data = ExcelReader.getExcelData(sheetName);
			String name = data[0][0].toString();
			String country = data[0][1].toString();
			String account = data[0][2].toString();
			String email = data[0][3].toString();
			String password = data[0][4].toString();
			String confirmPassword = data[0][5].toString();

			Thread.sleep(5000);

			regPage = new RegistrationPage();
			regPage.singUp(name, country, account, email, password, confirmPassword);

		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		log.info("Step 2: User is entering all deatils and click on SignIn Button");
	}

	@Then("User will naviate to successful Registration Page")
	public void user_will_naviate_to_successful_registration_page() {
		regHomePage = new RegistrationHomePage();
		String regText = regHomePage.getRegSucessText();
		Assert.assertEquals(regText, "REGISTRATION SUCCESSFUL", "Incorrect Registration Name");
		log.info("Step 3: User will naviate to successful Registration Page");
	}
}
