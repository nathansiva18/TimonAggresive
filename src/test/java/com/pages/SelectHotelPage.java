package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Maintain the SelectHotelPage WebElements and it's Respective Methods
	 * @Date 27-Dec-2022
	 */

	/**
	 * @see Constructor to Initialize SelectHotel Page WebElements
	 */
	public SelectHotelPage() {
		 PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='radiobutton_0']")
	private WebElement rdoButton;
	@FindBy(xpath = "//input[@name='continue']")
	private WebElement btnContinue;
	public WebElement getRdoButton() {
		return rdoButton;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	/**
	 * @see Method to Enter all Fields and Click Continue in SelectHotelPage 
	 */
	public void selectHotel() {
		click(getRdoButton());
		click(getBtnContinue());
	}
	/**
	 * @see Method to Click Continue alone in SelectHotelPage 
	 */
	public void clickContinue() {
		click(getBtnContinue());

	}
	

}
