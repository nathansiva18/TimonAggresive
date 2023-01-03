package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_SelectHotelStep extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Perform SelectHotel Functionalities
	 * @Date 27-Dec-2022
	 */
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @see Method to Select Hotel in SelectHotel Page
	 */
	@Then("User should Select Hotel and Continue")
	public void userShouldSelectHotelAndContinue() {
		pom.getSelectHotelPage().selectHotel();
	        
	       
	}
	/**
	 * @see Method to verify Success Message after Select Hotel in SelectHotel Page
	 * @param expBookHotelSuccessMessage
	 */
	@Then("User should verify after Select Hotel Success message {string}")
	public void userShouldVerifyAfterSelectHotelSuccessMessage(String expBookHotelSuccessMessage) {
	        WebElement textBookHotelSuccessMessage = pom.getBookHotelPage().getTextBookHotelSuccessMessage();
	        String actBookHotelSuccessMessage = getText(textBookHotelSuccessMessage);
	        Assert.assertEquals("verify after select hotel success message", expBookHotelSuccessMessage, actBookHotelSuccessMessage);
	        HooksClass.sc.log("verify after select hotel success message, "+"expected value: "+expBookHotelSuccessMessage+"  and  "+"actual value: "+actBookHotelSuccessMessage);
	       
	}
	/**
	 * @see Method to Click Continue without Select Hotel in SelectHotel Page
	 */
	@Then("User should Click continue Without Selecting Hotel")
	public void userShouldClickContinueWithoutSelectingHotel() {
		pom.getSelectHotelPage().clickContinue();
	        
	       
	}
	/**
	 * @see Method to verify Select Hotel Error Message after without Selecting Hotel in SelectHotel Page
	 * @param expErrorBookHotelMessage
	 */
	@Then("User should verify the Select Hotel error message {string}")
	public void userShouldVerifyTheSelectHotelErrorMessage(String expErrorBookHotelMessage) {
		WebElement textErrorBookHotelMessage = pom.getBookHotelPage().getTextBookHotelErrorMessage();
		String actErrorBookHotelMessage = getText(textErrorBookHotelMessage);
		Assert.assertEquals("verify after select hotel Error message", expErrorBookHotelMessage, actErrorBookHotelMessage);
		HooksClass.sc.log("verify after select hotel Error message, "+"expected value: "+expErrorBookHotelMessage+"  and  "+"actual value: "+actErrorBookHotelMessage);
	        
	       
	}







	







	






	

	
	






	






	





}
