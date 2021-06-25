package com.template.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.template.utils.CommonUtils;

public class FeaturesFilter {
	
	SoftAssert softAssertion= new SoftAssert();
	
	@FindBy(xpath = "//div[text()='Items List ']")
	private SelenideElement itemsList;
	
	@FindBy(xpath = "//div[text()='Items List ']/parent::a")
	private SelenideElement itemsListStatus;
	
	@FindBy(xpath = "//li[@class = 'list-group-item text-primary']/a")
	private ElementsCollection listItem;
	
	public void expandItemList() {

		if (!isCollapsed()){
			itemsList.shouldBe(Condition.visible).click();
		} else {
			softAssertion.fail("List is already expanded");
			
		}
	}
	
	public void colapseItemList () {

		if (isCollapsed()) {
			itemsList.shouldBe(Condition.visible).click();
		} else {
			softAssertion.fail("List is already colapsed");
			
		}
	}
	
	public void toggleItemList() {
		itemsList.shouldBe(Condition.visible).click();
	}
	
	
	public boolean isCollapsed() {
		String isCollapsed = itemsListStatus.getAttribute("aria-expanded");	
		return isCollapsed == "true" ? true : false;
	}
	
	public void selectItem(CommonUtils.Item input) {
		listItem.shouldHave(CollectionCondition.size(4));
		listItem.find(Condition.exactText(input.toString())).click();
	}
	
	public void isItemPresentInList (String expectedString) {
		ArrayList<String> actualItems = new ArrayList<String>();
		listItem.shouldHave(CollectionCondition.size(4));
		
		for (SelenideElement eachItem : listItem) {
			actualItems.add(eachItem.shouldBe(Condition.visible).getText());
		}
		
		Assert.assertTrue(actualItems.contains(expectedString), "Actual list of string is :: "+actualItems+" Expected string is :: "+expectedString);
		
	}
}
