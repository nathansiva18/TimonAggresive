package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Maintain the SearchHotelPage WebElements and it's Respective
	 *      Methods
	 * @Date 27-Dec-2022
	 */

	/**
	 * @see Constructor to Initialize SearchHotel Page WebElements
	 */
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='location']")
	private WebElement ddnLocation;
	@FindBy(xpath = "//select[@name='hotels']")
	private WebElement ddnHotels;
	@FindBy(xpath = "//select[@name='room_type']")
	private WebElement ddnHotelType;
	@FindBy(xpath = "//select[@name='room_nos']")
	private WebElement ddnRoomNo;
	@FindBy(xpath = "//input[@name='datepick_in']")
	private WebElement txtCheckIn;
	@FindBy(xpath = "//input[@name='datepick_out']")
	private WebElement txtCheckout;
	@FindBy(xpath = "//select[@name='adult_room']")
	private WebElement ddnAdults;
	@FindBy(xpath = "//select[@name='child_room']")
	private WebElement ddnChild;
	@FindBy(xpath = "//input[@name='Submit']")
	private WebElement btnSearch;
	@FindBy(xpath = "//input[@id='username_show']")
	private WebElement textSuccesLoginMessage;
	@FindBy(xpath = "//span[@id='checkin_span']")
	private WebElement textCheckInErrorMessage;
	@FindBy(xpath = "//span[@id='checkout_span']")
	private WebElement textCheckOutErrorMessage;
	@FindBy(xpath = "//span[@id='location_span']")
	private WebElement textLocationErrorMessage;

	public WebElement getTextLocationErrorMessage() {
		return textLocationErrorMessage;
	}

	public WebElement getTextCheckInErrorMessage() {
		return textCheckInErrorMessage;
	}

	public WebElement getTextCheckOutErrorMessage() {
		return textCheckOutErrorMessage;
	}

	public WebElement getTextSuccesLoginMessage() {
		return textSuccesLoginMessage;
	}

	public WebElement getDdnLocation() {
		return ddnLocation;
	}

	public WebElement getDdnHotels() {
		return ddnHotels;
	}

	public WebElement getDdnHotelType() {
		return ddnHotelType;
	}

	public WebElement getDdnRoomNo() {
		return ddnRoomNo;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckout() {
		return txtCheckout;
	}

	public WebElement getDdnAdults() {
		return ddnAdults;
	}

	public WebElement getDdnChild() {
		return ddnChild;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	/**
	 * @see Method to Perform Common Steps in SearchHotelPage
	 * @param location
	 * @param roomCount
	 * @param checkInDate
	 * @param checkOutDate
	 * @param persons
	 * @throws AWTException
	 */
	public void searchHotelcommonSteps(String location, String roomCount, String checkInDate, String checkOutDate,
			String persons) throws AWTException {
		dateReset();
		selectByVisibleText(getDdnLocation(), location);
		selectByVisibleText(getDdnRoomNo(), roomCount);
		sendkeys(getTxtCheckIn(), checkInDate);
		sendkeys(getTxtCheckout(), checkOutDate);
		selectByVisibleText(getDdnAdults(), persons);
	}

	/**
	 * @see Method to Pass all the Fields in the SearchHotelPage
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
	public void searchHotel(String location, String hotelName, String hotelType, String roomCount, String checkInDate,
			String checkOutDate, String persons, String child) throws AWTException {
		searchHotelcommonSteps(location, roomCount, checkInDate, checkOutDate, persons);
		selectByVisibleText(getDdnHotels(), hotelName);
		selectByVisibleText(getDdnHotelType(), hotelType);
		selectByVisibleText(getDdnChild(), child);
		click(getBtnSearch());

	}

	/**
	 * @see Method to Pass only the Mandatory Fields in the SearchHotelPage
	 * @param location
	 * @param roomCount
	 * @param checkInDate
	 * @param checkOutDate
	 * @param persons
	 * @throws AWTException
	 */
	public void searchHotel(String location, String roomCount, String checkInDate, String checkOutDate, String persons)
			throws AWTException {
		searchHotelcommonSteps(location, roomCount, checkInDate, checkOutDate, persons);
		click(getBtnSearch());

	}

	/**
	 * @see Method to Perform Click Search Hotel in SearchHotelPage
	 */
	public void SearchHotelButton() {

		click(getBtnSearch());
	}

	/**
	 * @see Mthod to Clear or Reset the Date Fields in SearchHotelPage
	 * @throws AWTException
	 */
	public void dateReset() throws AWTException {
		getTxtCheckIn().clear();
		getTxtCheckout().clear();
		

	}

}
