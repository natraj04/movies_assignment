package com.template.pageObjects;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class MovieForm {
	
	@FindBy(xpath = "//span[text()='Movie Form']")
	private SelenideElement formName;
	
	@FindBy(xpath = "//button/i[@class='fas fa-plus fa-lg']")
	private SelenideElement plusButton;
	
	@FindBy(xpath = "//button/i[@class='fas fa-copy fa-lg']")
	private SelenideElement copyButton;
	
	@FindBy(xpath = "//button/i[@class='fas fa-trash-alt fa-lg']")
	private SelenideElement deleteButton;
	
	@FindBy(xpath = "//button/i[@class='fas fa-save fa-lg']")
	private SelenideElement saveButton;
	
	@FindBy(id = "id")
	private SelenideElement idTextBox;
	
	@FindBy(id = "name")
	private SelenideElement nameTextBox;
	
	@FindBy(id = "fileName")
	private SelenideElement fileNameTextBox;
	
	@FindBy(id = "releaseDate")
	private SelenideElement releaseDateTextBox;
	
	@FindBy(id = "wikipediaLink")
	private SelenideElement wikiTextBox;
	
	@FindBy(id = "movie")
	private SelenideElement movieCheckBox;
	
	@FindBy(id = "show")
	private SelenideElement showCheckBox;
	
	public void hasMovieFormLoaded() {
		Assert.assertTrue(formName.shouldBe(Condition.visible).isDisplayed());
		Assert.assertTrue(plusButton.shouldBe(Condition.visible).isDisplayed());
		Assert.assertTrue(copyButton.shouldBe(Condition.visible).isDisplayed());
		Assert.assertTrue(deleteButton.shouldBe(Condition.visible).isDisplayed());
		Assert.assertTrue(saveButton.shouldBe(Condition.visible).isDisplayed());
	}
	
	public void clickSaveButton() {
		saveButton.shouldBe(Condition.visible).click();
	}
	
	public void clickCreateNewButton() {
		plusButton.shouldBe(Condition.visible).click();
		
		// TODO to be removed once a proper element is added
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void clickCopyButton() {
		copyButton.shouldBe(Condition.visible).click();
	}
	
	public void clickDeleteButton() {
		deleteButton.shouldBe(Condition.visible).click();
	}
	
	public void validateButtonStatus(String buttonName, boolean expectedState) {

		boolean actualStatus = false;
		switch (buttonName.toLowerCase()) {

		case "plus":
			actualStatus = plusButton.getAttribute("disabled") == null ? false : true;
			break;

		case "copy":
			actualStatus = copyButton.isEnabled();
			break;
		case "delete":
			actualStatus = deleteButton.isEnabled();
			break;
		case "save":
			actualStatus = saveButton.isEnabled();
			break;

		default:
			Assert.fail(buttonName + " invaid input");
		}
		
		Assert.assertEquals(actualStatus, expectedState, buttonName + " state not as expected");
	}
	
	public boolean isFieldIsEditable(String name) {

		boolean isEditable = false;

		switch (name.toLowerCase()) {

		case "name":
			isEditable = nameTextBox.isEnabled();
			break;

		case "filename":
			isEditable = fileNameTextBox.isEnabled();
			break;
		case "releasedate":
			isEditable = releaseDateTextBox.isEnabled();
			break;
		case "wiki":
			isEditable = wikiTextBox.isEnabled();
			break;

		default:
			Assert.fail(name + " not part of a text box to check if its editable");

		}
		
		return isEditable;
		
	}
	
	public void validateTextBoxState(String name, boolean isEditable) {	
		if (name.equalsIgnoreCase("id")) {
			String isReadonly = idTextBox.getAttribute("readonly");
			Assert.assertEquals(isReadonly.equals("true"), isEditable, "Field state not macthing as expected");
		} else {
			Assert.assertEquals(isFieldIsEditable(name), isEditable, "Field state not macthing as expected");
		}
		
	}
	
	public void fillTextBox(String name, String inputText) {

		switch (name.toLowerCase()) {

		case "name":
			nameTextBox.sendKeys(inputText);
			break;

		case "filename":
			fileNameTextBox.sendKeys(inputText);
			break;
		case "releasedate":
			releaseDateTextBox.sendKeys(inputText);
			break;
		case "wiki":
			wikiTextBox.sendKeys(inputText);
			break;

		default:
			Assert.fail(name + " not part of a text box to check if its editable");

		}
	}
	
	public String getId() {
		
		String id = null;
		int count = 0;
		while (true && count < 10) {
		id = idTextBox.getText();
		if (id != "" || id != " ") {
			break;
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
		}
		
		return id;
	}

}
