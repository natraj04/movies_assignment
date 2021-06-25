package com.template.template;

import static com.codeborne.selenide.Selenide.page;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.template.library.BaseTest;
import com.template.pageObjects.CommonElements;
import com.template.pageObjects.FeaturesFilter;
import com.template.pageObjects.HomePage;
import com.template.pageObjects.MovieForm;
import com.template.pageObjects.Movies;
import com.template.utils.CommonUtils.Item;

public class TC03_ItemsList_Ability_to_add_and_edit_a_new_movie extends BaseTest{
	
	FeaturesFilter featureList = page(FeaturesFilter.class);
	CommonElements commonElements = page(CommonElements.class);
	HomePage homePage = page(HomePage.class);
	Movies movies = page(Movies.class);
	ArrayList<HashMap<String, String>> tableData ;
	MovieForm movieForm = page(MovieForm.class);
	
	@Test
	public void TC03_ItemsList_Ability_to_add_and_edit_a_new_movie() {
		
		homePage.validateTitle();
		
		featureList.expandItemList();
		featureList.isItemPresentInList("Movies");
		featureList.selectItem(Item.Movies);
		
		commonElements.validateSearchFieldCategory("movies...");
		tableData = movies.constructTableData();
		
		movies.selectMovie(1);
		
		movieForm.hasMovieFormLoaded();
		movieForm.clickCreateNewButton();
		
		movieForm.validateTextBoxState("name", true);
		movieForm.validateTextBoxState("filename", true);
		movieForm.validateTextBoxState("releasedate", true);
		movieForm.validateTextBoxState("wiki", true);
		
		movieForm.fillTextBox("name", "test movie");
		movieForm.clickSaveButton();
		movieForm.getId();
		
		featureList.isItemPresentInList("Movies");
		featureList.selectItem(Item.Movies);
		commonElements.validateSearchFieldCategory("movies...");
		commonElements.fillSearchField("test movie");
		commonElements.clickSearchButton();
		movies.selectMovie("test movie");


	}

}
