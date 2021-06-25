package com.template.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Movies {

	@FindBy(xpath = "//thead//th")
	private ElementsCollection tableHeaders;

	@FindBy(xpath = "//tbody/tr")
	private ElementsCollection rowData;

	public ArrayList<String> getTableHeaders() {

		ArrayList<String> actualHeaders = new ArrayList<String>();
		tableHeaders.shouldHave(CollectionCondition.sizeGreaterThan(1));
		for (SelenideElement eachHeader : tableHeaders) {
			actualHeaders.add(eachHeader.getText());
		}

		return actualHeaders;
	}

	public ArrayList<HashMap<String, String>> constructTableData() {

		int rowCount = rowData.size();
		ArrayList<String> headers = getTableHeaders();
		ArrayList<HashMap<String, String>> tableData = new ArrayList<HashMap<String, String>>();

		for (int i = 1; i <= rowCount; i++) {
			HashMap<String, String> eachRowData = new HashMap<String, String>();
			for (int j = 0; j < headers.size(); j++) {
				
				if (j == 3) {
					eachRowData.put(headers.get(j), $(By.xpath("//tbody/tr["+i+"]/td/div/a")).getAttribute("href"));
				} else if (j == 4) {
					eachRowData.put(headers.get(j), $(By.xpath("//tbody/tr["+i+"]/td/div/img")).getAttribute("src"));
				} else {
					int index = j+1;
					eachRowData.put(headers.get(j), $(By.xpath("(//tbody/tr["+i+"]/td/div)["+index+"]")).getText());
				}
			}
			tableData.add(eachRowData);
		}
		
		return tableData;
	}
	
	public void selectMovie (int rowNo) {
		$(By.xpath("(//tbody/tr["+rowNo+"]/td/div)[6]")).click();
	}
	
	public void selectMovie (String movieName) {
		int rowCount = rowData.size();
		
		for (int j = 1; j <= rowCount; j++) {
			String actualMovieName = $(By.xpath("(//tbody/tr["+j+"]/td/div)[6]")).getText();
			if(actualMovieName.equalsIgnoreCase(movieName)) {
				$(By.xpath("(//tbody/tr["+j+"]/td/div)[6]")).click();
			}
			
		}
	}

}
