package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChromeBrowser {

	WebDriver driver;
	WebElement searchBox;
	WebElement demoQa;

	public ChromeBrowser(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSearchBox() {
		return driver.findElement(By.cssSelector(".gLFyf.gsfi"));
	}

	public WebElement getDemoQa() {
		return driver.findElement(By.cssSelector(".LC20lb.DKV0Md"));
	}

	public void inputURL(String url) {

		getSearchBox().sendKeys(url);
		getSearchBox().sendKeys(Keys.ENTER);
	}

	public void demoQaClick() {
		getDemoQa().click();
	}
}
