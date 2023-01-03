package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep extends BaseClass{
	/**
	 * @author SIVANATHAN
	 * @see Used to Perform Book Hotel Functionalities
	 * @Date 27-Dec-2022
	 */
	PageObjectManager pom = new PageObjectManager();
	/**
	 * @see Method to Perform Enter all the Fields in BookHotelPage
	 * @param firstName
	 * @param lastName
	 * @param txtAddress
	 * @param dataTable
	 */
	@When("User should enter all fields {string},{string} and {string}")
	public void userShouldEnterAllFieldsAnd(String firstName, String lastName, String txtAddress, io.cucumber.datatable.DataTable dataTable) {
	 List<Map<String, String>> cardFields = dataTable.asMaps();
	   Map<String, String> map = cardFields.get(1);
	   String cardNumber = map.get("CardNo");
	   String cardType = map.get("CardType");
	   String month = map.get("Month");
	   String year = map.get("Year");
	   String cvv = map.get("CVV");
	   pom.getBookHotelPage().bookHotel(firstName, lastName, txtAddress, cardNumber, cardType, month, year, cvv);
	       
	}
	/**
	 * @see Method to verify Success Message after Book a Hotel in BookHotel Page
	 * @param expBookingSuccessMessage
	 */
	@Then("User should verify after Book a Hotel Success message {string} and save the generated OrderId")
	public void userShouldVerifyAfterBookAHotelSuccessMessageAndSaveTheGeneratedOrderId(String expBookingSuccessMessage) {
		WebElement textBookingSuccessMessage = pom.getBookingConfirmPage().getTxtBookingSuccessMessage();
		String actBookingSuccessMessage = getText(textBookingSuccessMessage);
		boolean b = actBookingSuccessMessage.equals(expBookingSuccessMessage);
		Assert.assertTrue("verify after book hotel success message", b);
		HooksClass.sc.log("verify after book hotel success message, "+"expected value: "+expBookingSuccessMessage+"  and  "+"actual value: "+actBookingSuccessMessage);
		
		
		
	        
	       
	}
	/**
	 * @see Method to Book Hotel without Entering any of the Fields in BookHotel Page
	 */
	@When("User should Book Hotel Without entering any of the fields")
	public void userShouldBookHotelWithoutEnteringAnyOfTheFields() {
	        pom.getBookHotelPage().bookHotel();
	       
	}
	/**
	 * @see Method to verify error message after Book a Hotel without Entering any of the Fields in BookHotel Page
	 * @param expErrorFirstNameMessage
	 * @param expErrorLastNameMessage
	 * @param expErrorAddressMessage
	 * @param expErrorCardNumMessage
	 * @param expErrorCardTypeMessage
	 * @param expErrorMonthMessage
	 * @param expErrorCvvMessage
	 */
	@Then("User should verify error message after Book a Hotel {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessageAfterBookAHotelAnd(String expErrorFirstNameMessage, String expErrorLastNameMessage, String expErrorAddressMessage, String expErrorCardNumMessage, String expErrorCardTypeMessage, String expErrorMonthMessage, String expErrorCvvMessage) {
	  WebElement textErrorFirstNameMessage = pom.getBookHotelPage().getTextFirstNameErrorMessage(); 
	  String actErrorFirstNameMessage = getText(textErrorFirstNameMessage);
	  Assert.assertEquals("verify please enter your first name error message", expErrorFirstNameMessage, actErrorFirstNameMessage);
	  HooksClass.sc.log("verify please enter your first name error message, "+"expected value: "+expErrorFirstNameMessage+"  and  "+"actual value: "+actErrorFirstNameMessage);
	  
	  WebElement textErrorLastNameMessage = pom.getBookHotelPage().getTextLastNameErrorMessage();
	  String actErrorLastNameMessage = getText(textErrorLastNameMessage);
	  Assert.assertEquals("verify please enter your last name error message", expErrorLastNameMessage, actErrorLastNameMessage);
	  HooksClass.sc.log("verify please enter your last name error message, "+"expected value: "+expErrorLastNameMessage+"  and  "+"actual value: "+actErrorLastNameMessage);
	  
	  WebElement textErrorAddressMessage = pom.getBookHotelPage().getTextAddressErrorMessage();
	  String actErrorAddressMessage = getText(textErrorAddressMessage);
	  Assert.assertEquals("verify please enter your address error message",expErrorAddressMessage , actErrorAddressMessage);
	  HooksClass.sc.log("verify please enter your address error message, "+"expected value: "+expErrorAddressMessage+"  and  "+"actual value: "+actErrorAddressMessage);
	  
	  WebElement textErrorCardNumMessage = pom.getBookHotelPage().getTextCardNumErrorMessage();
	  String actErrorCardNumMessage = getText(textErrorCardNumMessage);
	  Assert.assertEquals("verify please enter your 16 digit credit card number error message",expErrorCardNumMessage , actErrorCardNumMessage);
	  HooksClass.sc.log("verify please enter your 16 digit credit card number error message, "+"expected value: "+expErrorCardNumMessage+"  and  "+"actual value: "+actErrorCardNumMessage);
	  
	  WebElement textErrorCardTypeMessage = pom.getBookHotelPage().getTextCardTypeErrorMessage();
	  String actErrorCardTypeMessage = getText(textErrorCardTypeMessage);
	  Assert.assertEquals("verify please select your credit card type error message",expErrorCardTypeMessage , actErrorCardTypeMessage); 
	  HooksClass.sc.log("verify please select your credit card type error message, "+"expected value: "+expErrorCardTypeMessage+"  and  "+"actual value: "+actErrorCardTypeMessage);
	  
	  WebElement textErrorMonthMessage = pom.getBookHotelPage().getTextMonthErrorMessage();
	  String actErrorMonthMessage = getText(textErrorMonthMessage);
	  Assert.assertEquals("verify please select your credit card expiry month error message",actErrorMonthMessage , actErrorMonthMessage); 
	  HooksClass.sc.log("verify please select your credit card expiry month error message, "+"expected value: "+actErrorMonthMessage+"  and  "+"actual value: "+actErrorMonthMessage);
	  
	  WebElement textErrorCvvMessage = pom.getBookHotelPage().getTextCvvErrorMessage();
	  String actErrorCvvMessage = getText(textErrorCvvMessage);
	  Assert.assertEquals("verify please enter your credit card CVV number error message",expErrorCvvMessage , actErrorCvvMessage);
	  HooksClass.sc.log("verify please enter your credit card CVV number error message, "+"expected value: "+expErrorCvvMessage+"  and  "+"actual value: "+actErrorCvvMessage);
	}


















	

}
