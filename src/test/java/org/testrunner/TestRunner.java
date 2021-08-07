package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdef.JVMReportingClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources"}, glue= {"org.stepdef"}, monochrome = true, dryRun = false, plugin = {"pretty", "json:E:\\Selenium-Java\\Programs Exection code\\ANZTest\\Report\\ReportFile.json"})


public class TestRunner {
	
	@AfterClass
	public static void jvmReport() {
		JVMReportingClass.jvmreporter("E:\\Selenium-Java\\Programs Exection code\\ANZTest\\Report\\ReportFile.json");

	}

}
