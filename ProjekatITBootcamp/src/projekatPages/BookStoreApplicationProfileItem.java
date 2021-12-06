package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreApplicationProfileItem {
	WebDriver driver;
	WebElement profile;

	public BookStoreApplicationProfileItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getProfile() {
		return driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
	}

	public void clickOnProfileItem() {
		getProfile().click();
	}

}
