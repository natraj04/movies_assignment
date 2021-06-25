package com.template.library;

import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SimpleReport;


public class BaseTest {
	
	protected SimpleReport report;
	
	@BeforeTest
	public void launchUrl() {
		Configuration.timeout = 30000;
		Configuration.fastSetValue = true;
		Configuration.browser = "chrome";
		Configuration.startMaximized = true;
		
		report = new SimpleReport();
		report.start();
		
		
		open("http://3.134.135.231:4000/");
	}
	
	@AfterTest
	public void tearDown() {
		report.finish(getClass().getSimpleName());
	}
	
	

}
