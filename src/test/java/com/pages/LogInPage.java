package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LogInPage extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Maintain the LogInPage WebElements and it's Respective Methods
	 * @Date 27-Dec-2022
	 */

	/**
	 * @see Constructor to Initialize LogInPage Page WebElements
	 */
	public LogInPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBys({ @FindBy(id = "username"), @FindBy(xpath = "//input[@id='username']") })
	private WebElement txtUserName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement textLoginErrorMessage;

	public WebElement getTextLoginErrorMessage() {
		return textLoginErrorMessage;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @see Method to Perform Common Steps in the Login page
	 * @param userName
	 * @param password
	 */
	public void commonLoginSteps(String userName, String password) {
		sendkeys(getTxtUserName(), userName);
		sendkeys(getTxtPassword(), password);

	}

	/**
	 * @see Method to Perform Login in LogIn Page
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) {
		commonLoginSteps(userName, password);
		click(getBtnLogin());
	}

	/**
	 * @see Method to Perform Login using Enter Key in LogIn Page
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	public void loginWithEnterKey(String userName, String password) throws AWTException {
		commonLoginSteps(userName, password);
		Robot robo = new Robot();
		for (int i = 1; i <= 2; i++) {
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
		}
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

}
