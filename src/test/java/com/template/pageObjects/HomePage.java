package com.template.pageObjects;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class HomePage {
	
	@FindBy(xpath = "//a[text()='Sign in']")
	private SelenideElement title;
	
	
	
	public void validateTitle () {

		Assert.assertEquals(WebDriverRunner.getWebDriver().getTitle(), "New Movies: angular.movies");
		
	}
	
	
	
	

}
