package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WidgetsCard {

	WebDriver driver;
	WebDriverWait wdwait;
	WebElement widgets;
	WebElement slider;
	WebElement sliderPointer;

	public WidgetsCard(WebDriver driver, WebDriverWait wdwait) {
		super();
		this.driver = driver;
		this.wdwait = wdwait;
	}

	public WebElement getWidgets() {
		return driver.findElement(By
				.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]/div[1]"));
	}

	public WebElement getSlider() {
		return driver.findElement(By.xpath("//span[contains(text(),'Slider')]"));
	}

	public WebElement getSliderPointer() {
		return driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
	}

	public void clickOnWidgetsCard() {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/span[1]/div[1]/div[1]")));
		getWidgets().click();
	}

	public void clickOnSliderItem() {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Slider')]")));
		getSlider().click();
	}

	public void moveSlider() {
		Actions actions = new Actions(driver);
		actions.moveToElement(getSliderPointer(), 45, 0).perform();
		getSliderPointer().click();
	}

}
