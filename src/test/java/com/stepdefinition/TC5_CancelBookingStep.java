package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC5_CancelBookingStep extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Perform Cancel Booking Functionalities
	 * @Date 27-Dec-2022
	 */

	PageObjectManager pom = new PageObjectManager();
	
    /**
     * @see Method to Perform Canceling Order Id in CancelBooking Page
     */
	@Then("User should cancel generated Order id")
	public void userShouldCancelGeneratedOrderId() {
		String orderDetails = pom.getBookingConfirmPage().getOrderDetails();
		pom.getCancelBookingPage().cancelOrderId(orderDetails);

	}
    /**
     * @see Method to verify after Cancel Order Id Success Message in CancelBooking Page
     * @param expBookingCancelSuccessMessage
     */
	@Then("User should verify after cancel order id success message {string}")
	public void userShouldVerifyAfterCancelOrderIdSuccessMessage(String expBookingCancelSuccessMessage) {
		WebElement textBookingCancelSuccessMessage = pom.getCancelBookingPage().getTxtBookingCancelSuccessMessage();
		String actBookingCancelSuccessMessage = getText(textBookingCancelSuccessMessage);
		boolean b = actBookingCancelSuccessMessage.equals(expBookingCancelSuccessMessage);
		Assert.assertTrue("verify after cancel booking success message", b);
		HooksClass.sc.log("verify after cancel booking success message, "+"expected value: "+expBookingCancelSuccessMessage+"  and  "+"actual value: "+actBookingCancelSuccessMessage);

	}
    /**
     * @see Method to Cancel Existing Order Id in CancelBooking Page
     * @param orderId
     */
	@Then("User should Cancel existing order id {string}")
	public void userShouldCancelExistingOrderId(String orderId) {
		pom.getCancelBookingPage().cancelOrderId(orderId);

	}

}
