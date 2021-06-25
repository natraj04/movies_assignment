package com.template.template;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.template.library.BaseTest;
import com.template.pageObjects.CommonElements;
import com.template.pageObjects.FeaturesFilter;
import com.template.pageObjects.HomePage;
import com.template.utils.CommonUtils.Item;

import static com.codeborne.selenide.Selenide.page;

public class TC01_ItemsList_Validate_the_ability_to_use_items_list_filter_features extends BaseTest{
	
	FeaturesFilter featureList = page(FeaturesFilter.class);
	CommonElements commonElements = page(CommonElements.class);
	HomePage homePage = page(HomePage.class);
	
	@Test
	public void validateFeatureItemList() {
		homePage.validateTitle();
		Assert.assertFalse(featureList.isCollapsed(), "Items list is not collapsed by default");
		featureList.expandItemList();
		featureList.isItemPresentInList("Movies");
		featureList.isItemPresentInList("Cities");
		featureList.isItemPresentInList("Countries");
		featureList.isItemPresentInList("Continents");
		
	}
	
	@Test(dependsOnMethods = "validateFeatureItemList")
	public void selectMoviesFromTheList() {
		featureList.selectItem(Item.Movies);
		commonElements.validateSearchFieldCategory("movies...");

	}
	
	@Test(dependsOnMethods = "validateFeatureItemList")
	public void selectCitiesFromTheList() {
		featureList.selectItem(Item.Cities);
		commonElements.validateSearchFieldCategory("cities...");
	}
	
	@Test(dependsOnMethods = "validateFeatureItemList")
	public void selectCountriesFromTheList() {
		featureList.selectItem(Item.Countries);
		commonElements.validateSearchFieldCategory("countries...");
	}
	
	@Test(dependsOnMethods = "validateFeatureItemList")
	public void selectContinentsFromTheList() {
		featureList.selectItem(Item.Continents);
		commonElements.validateSearchFieldCategory("continents...");
	}

}
