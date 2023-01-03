package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_SearchHotelStep extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Perform SearchHotel Functionalities
	 * @Date 27-Dec-2022
	 */
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @see Method to Enter all the Fields in the SearchHotel Page
	 * @param location
	 * @param hotelName
	 * @param hotelType
	 * @param roomCount
	 * @param checkInDate
	 * @param checkOutDate
	 * @param persons
	 * @param child
	 * @throws AWTException
	 */
	@When("User should enter all fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterAllFieldsAnd(String location, String hotelName, String hotelType, String roomCount, String checkInDate, String checkOutDate, String persons, String child) throws AWTException {
	        pom.getSearchHotelPage().searchHotel(location, hotelName, hotelType, roomCount, checkInDate, checkOutDate, persons, child);
	       
	}
	/**
	 * @see Method to get the Success Message after SearchHotel
	 * @param expSearchHotelSuccessMessage
	 */
	@Then("User should verify after Search Hotel Success message {string}")
	public void userShouldVerifyAfterSearchHotelSuccessMessage(String expSearchHotelSuccessMessage) {
		WebElement textSearchHotelSuccessMessage = pom.getBookHotelPage().getTextSearchHotelSuccessMessage();
		String actSearchHotelSuccessMessage = getText(textSearchHotelSuccessMessage);
		Assert.assertEquals("verify after search hotel success message", expSearchHotelSuccessMessage, actSearchHotelSuccessMessage);
	    HooksClass.sc.log("verify after search hotel success message,  "+"expected value: "+expSearchHotelSuccessMessage+"  and  "+"actual value: "+actSearchHotelSuccessMessage);           
	}
	/**
	 * @see Method to Enter only Mandatory Fields in the SearchHotel Page
	 * @param location
	 * @param roomCount
	 * @param checkInDate
	 * @param checkOutDate
	 * @param persons
	 * @throws AWTException
	 */
	@When("User should enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFieldsAnd(String location, String roomCount, String checkInDate, String checkOutDate, String persons) throws AWTException {
	        pom.getSearchHotelPage().searchHotel(location, roomCount, checkInDate, checkOutDate, persons);
	       
	}
	/**
	 * @see Method to verify Date Error Message after Entering Expired Dates in SearchHotel Page
	 * @param expErrorChechInMessage
	 * @param expErrorChechOutMessage
	 * @throws AWTException
	 */
	@Then("User should verify after Search appearance of the date error message {string},{string}")
	public void userShouldVerifyAfterSearchAppearanceOfTheDateErrorMessage(String expErrorChechInMessage, String expErrorChechOutMessage) throws AWTException {
		   
	        WebElement textErrorCheckInMessage = pom.getSearchHotelPage().getTextCheckInErrorMessage();
	        String actErrorCheckInMessage = getText(textErrorCheckInMessage);
	        Assert.assertEquals("verify after search appearance of the date error message", expErrorChechInMessage,actErrorCheckInMessage );
	        HooksClass.sc.log("verify after search appearance of the date error message, "+"expected value: "+expErrorChechInMessage+"  and  "+"actual value: "+actErrorCheckInMessage);
	        WebElement textErrorCheckOutMessage = pom.getSearchHotelPage().getTextCheckOutErrorMessage();
	        String actErrorCheckOutMessage = getText(textErrorCheckOutMessage);
	        Assert.assertEquals("verify after search appearance of the date error message", expErrorChechOutMessage, actErrorCheckOutMessage);
	        HooksClass.sc.log("verify after search appearance of the date error message, "+"expected value: "+expErrorChechOutMessage+"  and  "+"actual value: "+actErrorCheckOutMessage);
	       
	}
	/**
	 * @see Method to SearchHotel without Entering any of the Fields in SearchHotel Page
	 */
	@When("User should go for Search without entering any of the fields")
	public void userShouldGoForSearchWithoutEnteringAnyOfTheFields() {
		pom.getSearchHotelPage().SearchHotelButton();
	        
	       
	}
	/**
	 * @see Method to verify SearchHotel Error Message after search without Entering any of the Fields in SearchHotel Page
	 * @param expSearchHotelErrorMessage
	 */
	@Then("User should verify after Search error message {string}")
	public void userShouldVerifyAfterSearchErrorMessage(String expSearchHotelErrorMessage) {
		WebElement textSearchHotelErrorMessage = pom.getSearchHotelPage().getTextLocationErrorMessage();
		String actSearchHotelErrorMessage = getText(textSearchHotelErrorMessage);
		Assert.assertEquals("verify after search hotel error message", expSearchHotelErrorMessage, actSearchHotelErrorMessage);
		HooksClass.sc.log("verify after search hotel error message, "+"expected value: "+expSearchHotelErrorMessage+"  and  "+"actual value: "+actSearchHotelErrorMessage);
	        
	       
	}










































































	
	


















}
