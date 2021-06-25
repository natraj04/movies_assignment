package com.template.template;

import static com.codeborne.selenide.Selenide.page;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.template.library.BaseTest;
import com.template.pageObjects.CommonElements;
import com.template.pageObjects.FeaturesFilter;
import com.template.pageObjects.HomePage;
import com.template.pageObjects.MovieForm;
import com.template.pageObjects.Movies;
import com.template.utils.CommonUtils.Item;

public class TC02_ItemsList_Validate_Movies_list_view extends BaseTest{
	
	FeaturesFilter featureList = page(FeaturesFilter.class);
	CommonElements commonElements = page(CommonElements.class);
	HomePage homePage = page(HomePage.class);
	Movies movies = page(Movies.class);
	ArrayList<HashMap<String, String>> tableData ;
	MovieForm movieForm = page(MovieForm.class);
	
	@Test
	public void validateFeatureItemList() {
		homePage.validateTitle();
		Assert.assertFalse(featureList.isCollapsed(), "Items list is not collapsed by default");
		featureList.expandItemList();
		featureList.isItemPresentInList("Movies");
		
	}
	
	@Test(dependsOnMethods = "validateFeatureItemList")
	public void selectMoviesFromTheList() {
		featureList.selectItem(Item.Movies);
		commonElements.validateSearchFieldCategory("movies...");
		tableData = movies.constructTableData();
		movies.selectMovie(1);
		
	}
	
	@Test(dependsOnMethods = "selectMoviesFromTheList")
	public void validatedMovieFormLoaded() {
		movieForm.hasMovieFormLoaded();
		
	}
	

}
