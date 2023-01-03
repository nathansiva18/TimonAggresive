package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags=("@BookHotel"),snippets=SnippetType.CAMELCASE,dryRun=false,publish = true,monochrome= true,plugin = {"pretty","json:target\\output.json"}, features = "src\\test\\resources\\Features",glue = "com.stepdefinition")
public class TestRunner extends BaseClass{
	/**
	 * @author SIVANATHAN
	 * @see Used to Execute the Classes in Suite Level
	 * @Date 27-Dec-2022
	 */
	
	
	/**
	 * @see Method to generate Jvm Report After the Execution on StepDefinition Classes
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectPath()+getPropertyFileValue("jsonPath"));
		
		
	}
	
}
