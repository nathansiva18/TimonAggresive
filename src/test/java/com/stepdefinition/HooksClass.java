package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	static Scenario sc;
	/**
	 * @author SIVANATHAN
	 * @see Used to Perform Intializing the Browser,Quiting the Browser and Take ScreenShot
	 */
	
	/**
	 * @see Method to Initialize the WebPage
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Before
	public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		get(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWait(20);
		sc = scenario;
	}
    /**
     * @see Method to Take ScreenShots
     * @param s
     */
	@After
	public void afterScenario(Scenario s) {

		s.attach(screenShot(), "images/png", "Every Scenario");
		driver.quit();
	}

}
