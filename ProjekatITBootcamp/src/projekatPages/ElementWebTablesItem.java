package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementWebTablesItem {

	WebDriver driver;
	WebElement table;
	WebElement addButton;
	WebElement deleteIcon;
	WebElement searchBoxField;

	public ElementWebTablesItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getTable() {
		return driver.findElement(By.cssSelector(".ReactTable.-striped.-highlight"));
	}

	public WebElement getAddButton() {
		return driver.findElement(By.id("addNewRecordButton"));
	}

	public WebElement getDeleteIcon() {
		return driver.findElement(By.id("delete-record-1"));
	}

	public WebElement getSearchBoxField() {
		return driver.findElement(By.id("searchBox"));
	}

	public void addRecord() {
		getAddButton().click();
	}

	public void deleteRecord() {
		getDeleteIcon().click();
	}

	public void searchRecord(String searchCriterium) {
		getSearchBoxField().sendKeys(searchCriterium);
		getSearchBoxField().click();
	}

}
