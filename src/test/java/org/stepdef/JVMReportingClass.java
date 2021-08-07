package org.stepdef;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.Configuration;

import net.masterthought.cucumber.ReportBuilder;

public class JVMReportingClass {
	
	public static void jvmreporter(String json) {
		
		File file = new File("E:\\Selenium-Java\\Programs Exection code\\ANZTest\\Report");
		
		net.masterthought.cucumber.Configuration configuration = new net.masterthought.cucumber.Configuration(file, "ANZReport");
		
		List<String> li = new ArrayList<String>();
		li.add(json);
		
		ReportBuilder builder = new ReportBuilder(li, configuration);
		builder.generateReports();
	}

}
