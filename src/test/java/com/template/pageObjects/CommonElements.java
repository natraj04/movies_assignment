package com.template.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class CommonElements {
	
	@FindBy(id = "searchField")
	private SelenideElement searchField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private SelenideElement searchButton;
	
	@FindBy(xpath = "//thead//th")
	private ElementsCollection tableHeaders;
	
	public void fillSearchField(String inputText) {
		searchField.shouldBe(Condition.visible).sendKeys(inputText);
	}
	
	public void validateSearchFieldCategory(String expectedText) {
		waitForPageLoad();
		Assert.assertEquals(getSearchField(), expectedText); 
	}
	
	public void clickSearchButton() {
		searchButton.shouldBe(Condition.visible).click();
	}
	
	private String getSearchField() {
		
		return searchField.shouldBe(Condition.visible).getAttribute("placeholder");
	}
	
	public void validateTableHeaders() {
		ArrayList<String> actualHeaders = new ArrayList<String>();
		tableHeaders.shouldHave(CollectionCondition.sizeGreaterThan(1));
		for (SelenideElement eachHeader : tableHeaders) {
			actualHeaders.add(eachHeader.getText());
		}
		System.out.println("List of headers \n"+actualHeaders);
	}
	
	public void waitForPageLoad () {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tableHeaders.shouldHave(CollectionCondition.sizeGreaterThan(2));
	}
}
