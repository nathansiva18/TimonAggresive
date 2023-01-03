package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Maintain the BookingConfirm Page WebElements and it's Respective
	 *      Methods
	 * @Date 27-Dec-2022
	 */

	/**
	 * @see Constructor to Initialize BookingConfirm Page WebElements
	 */
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement txtOrderNo;
	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement texttBookingSuccessMessage;

	public WebElement getTxtBookingSuccessMessage() {
		return texttBookingSuccessMessage;
	}

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	/**
	 * @see Method to get the Generated Order Id
	 * @return
	 */
	public String getOrderDetails() {
		String attribute = getAttribute(getTxtOrderNo(), "value");
		return attribute;
	}

}
