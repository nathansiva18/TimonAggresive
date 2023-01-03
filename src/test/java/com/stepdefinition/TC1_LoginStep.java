package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Perform Login Functionalities
	 * @Date 27-Dec-2022
	 */
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Method to launch the Adactin LoginPage
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User is on the Adactin page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException {

	}

	/**
	 * @see Method to Perform Login in Adactin LoginPage
	 * @param userName
	 * @param password
	 */
	@When("User should perform Login {string} and {string}")
	public void userShouldPerformLoginAnd(String userName, String password) {
		pom.getLoginpage().login(userName, password);

	}

	/**
	 * @see Method to Perform Login using EnterKey in Adactin LoginPage
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	@When("User should perform Login {string} and {string} with Enter Key")
	public void userShouldPerformLoginAndWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginpage().loginWithEnterKey(userName, password);

	}

	/**
	 * @see Method to Perform Login with Invalid Credentials in Adactin LogPage
	 * @param expErrorLoginMessage
	 */
	@Then("User should verify after login with Invalid Credential error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String expErrorLoginMessage) {
		WebElement textErroLoginMessage = pom.getLoginpage().getTextLoginErrorMessage();
		String textErrorMessage = getText(textErroLoginMessage);
		boolean b = textErrorMessage.contains(expErrorLoginMessage);
		Assert.assertTrue("verify after login with invalid credentials error message contains", b);
        HooksClass.sc.log("verify after login with invalid credentials error message contains, "+"expected value: "+expErrorLoginMessage+"  and  "+"actual value: "+textErrorMessage);
	}

}
