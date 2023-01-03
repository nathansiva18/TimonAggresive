package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to generate the Jvm Report
	 * @Date 27-Dec-2022
	 */
	
	
	/**
	 * @see Method to Generate Jvm Report for the Project
	 * @param jsonFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		File f = new File(getProjectPath()+getPropertyFileValue("jvmPath"));
		Configuration c = new Configuration(f,"OMRBranchAdactinAutomation");
		c.addClassifications("Browser", "Chrome");
		c.addClassifications("Version", "109");
		c.addClassifications("Os", "Windows11");
		c.addClassifications("Sprint", "01");
		List<String>jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder b = new ReportBuilder(jsonFiles, c);
		b.generateReports();

	}

}
