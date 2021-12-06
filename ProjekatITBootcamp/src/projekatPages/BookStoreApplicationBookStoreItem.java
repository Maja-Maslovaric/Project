package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreApplicationBookStoreItem {

	WebDriver driver;
	WebElement bookStoreItem;
	WebElement bookName;
	WebElement addToYourCollectionButton;

	public BookStoreApplicationBookStoreItem(WebDriver driver) { // create constructor
		super();
		this.driver = driver;
	}

	public WebElement getBookStoreItem() { // create webElement using locator
		return driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[2]/span[1]"));
	}

	public WebElement getBookName() {
		return driver.findElement(By.xpath("//a[contains(text(),'Learning JavaScript Design Patterns')]"));
	}

	public WebElement getAddToYourCollectionButton() {
		return driver.findElement(By.cssSelector(".text-right.fullButton"));
	}

	public void clickOnBookStoreItem() {
		getBookStoreItem().click();
	}

	public void clickOnBookToAddedInCollection() {
		getBookName().click();
	}

	public void clickOnAddButton() {
		getAddToYourCollectionButton().click();
	}

}
