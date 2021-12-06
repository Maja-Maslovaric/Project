package projekatPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardsOnToolsQaHomePage {
	WebDriver driver;
	WebElement bookStoreItem;

	public CardsOnToolsQaHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getBookStoreItem() {
		return driver.findElement(By
				.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/span[1]/div[1]/div[1]"));
	}

	public List<WebElement> getNavigation() {
		return driver.findElements(By.cssSelector(".card.mt-4.top-card"));
	}

	public void clickOnCard() {

		this.getNavigation().get(1).click();

	}

	public List<WebElement> getNavigateCard() {
		return driver.findElements(By.className("element-group"));

	}

	public void clickableCard(int i) {
		this.getNavigateCard().get(i).click();
	}

	public void scroll() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getBookStoreItem());
	}
}
