package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Execute the Common Methods in all the StepDefinition Classes
	 * @Date 27-Dec-2022
	 */
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see Method to Verify Login Success Message afer Login
	 * @param expLoginSuccessMessage
	 */
	@Then("User should verify after login Success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMessage) {
		WebElement textLoginMessage = pom.getSearchHotelPage().getTextSuccesLoginMessage();
		String actloginMessage = getAttribute(textLoginMessage, "Value");
		Assert.assertEquals("verify after login success message", expLoginSuccessMessage, actloginMessage);
		HooksClass.sc.log("verify after login success message, " + "expected value:  " + expLoginSuccessMessage + "  and  "
				+ " actual value:  " + actloginMessage);

	}

}
