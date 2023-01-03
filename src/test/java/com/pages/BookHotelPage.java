package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Maintain the BookHotel WebElements and it's Respective Methods
	 * @Date 27-Dec-2022
	 */

	/**
	 * @see Constructor to Initialize BookHotel Page WebElements
	 */
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastName;
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement txtBillingAddress;
	@FindBy(xpath = "//input[@name='cc_num']")
	private WebElement txtCard;
	@FindBy(xpath = "//select[@name='cc_type']")
	private WebElement ddnCardType;
	@FindBy(xpath = "//select[@name='cc_exp_month']")
	private WebElement ddnMonth;
	@FindBy(xpath = "//select[@name='cc_exp_year']")
	private WebElement ddnYear;
	@FindBy(xpath = "//input[@name='cc_cvv']")
	private WebElement txtCvv;
	@FindBy(xpath = "//input[@name='book_now']")
	private WebElement btnBook;
	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement textSearchHotelSuccessMessage;
	@FindBy(xpath = "(//td[@class='login_title'])[2]")
	private WebElement textBookHotelSuccessMessage;
	@FindBy(xpath = "//label[@class='reg_error']")
	private WebElement textBookHotelErrorMessage;
	@FindBy(xpath = "//label[@id='first_name_span']")
	private WebElement textFirstNameErrorMessage;
	@FindBy(xpath = "//label[@id='last_name_span']")
	private WebElement textLastNameErrorMessage;
	@FindBy(xpath = "//label[@id='address_span']")
	private WebElement textAddressErrorMessage;
	@FindBy(xpath = "//label[@id='cc_num_span']")
	private WebElement textCardNumErrorMessage;
	@FindBy(xpath = "//label[@id='cc_type_span']")
	private WebElement textCardTypeErrorMessage;
	@FindBy(xpath = "//label[@id='cc_expiry_span']")
	private WebElement textMonthErrorMessage;
	@FindBy(xpath = "//label[@id='cc_cvv_span']")
	private WebElement textCvvErrorMessage;

	public WebElement getTextFirstNameErrorMessage() {
		return textFirstNameErrorMessage;
	}

	public WebElement getTextLastNameErrorMessage() {
		return textLastNameErrorMessage;
	}

	public WebElement getTextAddressErrorMessage() {
		return textAddressErrorMessage;
	}

	public WebElement getTextCardNumErrorMessage() {
		return textCardNumErrorMessage;
	}

	public WebElement getTextCardTypeErrorMessage() {
		return textCardTypeErrorMessage;
	}

	public WebElement getTextMonthErrorMessage() {
		return textMonthErrorMessage;
	}

	public WebElement getTextCvvErrorMessage() {
		return textCvvErrorMessage;
	}

	public WebElement getTextBookHotelErrorMessage() {
		return textBookHotelErrorMessage;
	}

	public WebElement getTextBookHotelSuccessMessage() {
		return textBookHotelSuccessMessage;
	}

	public WebElement getTextSearchHotelSuccessMessage() {
		return textSearchHotelSuccessMessage;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getTxtBillingAddress() {
		return txtBillingAddress;
	}

	public WebElement getTxtCard() {
		return txtCard;
	}

	public WebElement getDdnCardType() {
		return ddnCardType;
	}

	public WebElement getDdnMonth() {
		return ddnMonth;
	}

	public WebElement getDdnYear() {
		return ddnYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	/**
	 * @see Method to pass Values to the all Fields in BookHotelPage
	 * @param firstName
	 * @param lastName
	 * @param txtAddress
	 * @param cardNumber
	 * @param cardtype
	 * @param month
	 * @param year
	 * @param cvv
	 */
	public void bookHotel(String firstName, String lastName, String txtAddress, String cardNumber, String cardtype,
			String month, String year, String cvv) {
		sendkeys(getFirstName(), firstName);
		sendkeys(getLastName(), lastName);
		sendkeys(getTxtBillingAddress(), txtAddress);
		sendkeys(getTxtCard(), cardNumber);
		selectByVisibleText(getDdnCardType(), cardtype);
		selectByVisibleText(getDdnMonth(), month);
		selectByVisibleText(getDdnYear(), year);
		sendkeys(getTxtCvv(), cvv);
		click(getBtnBook());

	}

	/**
	 * @see Method to Click the BookHotel Button in the BookHotel Page
	 */
	public void bookHotel() {
		click(getBtnBook());

	}

}
