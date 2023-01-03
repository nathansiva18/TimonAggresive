package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass{
	/**
	 * @author SIVANATHAN
	 * @see Used to Maintain the CancelBookingPage WebElements and it's Respective Methods
	 * @Date 27-Dec-2022
	 */

	/**
	 * @see Constructor to Initialize CancelBooking Page WebElements
	 */
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnItinerary;
	@FindBy(xpath="//input[@name='order_id_text']")
	private WebElement txtOrderId;
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement btnGo;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCancel;
	@FindBy(xpath="//label[@id='search_result_error']")
	private WebElement texttBookingCancelSuccessMessage;
	public WebElement getTxtBookingCancelSuccessMessage() {
		return texttBookingCancelSuccessMessage;
	}
	public WebElement getBtnItinerary() {
		return btnItinerary;
	}
	public WebElement getTxtOrderId() {
		return txtOrderId;
	}
	public WebElement getBtnGo() {
		return btnGo;
	}
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	/**
	 * @see Method to Cancel Order Id in CancelBookingPage
	 * @param orderId
	 */
	public void cancelOrderId(String orderId) {
		click(getBtnItinerary());
		sendkeys(getTxtOrderId(),orderId );
		click(getBtnGo());
		click(getBtnCancel());
		accept();
		

	}
	
	

}
