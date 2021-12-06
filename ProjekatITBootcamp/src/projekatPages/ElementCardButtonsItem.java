package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementCardButtonsItem {

	WebDriver driver;
	WebElement buttons;
	WebElement doubleClickMe;
	WebElement rightClickMe;
	WebElement clickMe;
	WebElement doubbleClickMessage;
	WebElement rightClickMessage;
	WebElement clickMessage;

	public ElementCardButtonsItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getButtons() {
		return driver.findElement(
				By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]"));
	}

	public WebElement getDoubleClickMe() {
		return driver.findElement(By.id("doubleClickBtn"));
	}

	public WebElement getRightClickMe() {
		return driver.findElement(By.id("rightClickBtn"));
	}

	public WebElement getClickMe() {
		return driver.findElement(By.id("EfIPl"));
	}

	public WebElement getDoubleClickMessage() {
		return driver.findElement(By.id("doubleClickMessage"));
	}

	public WebElement getRightClickMessage() {
		return driver.findElement(By.id("rightClickBtn"));
	}

	public WebElement getClickMessage() {
		return driver.findElement(By.xpath("//contains(@name,'Click Me')"));
	}

	public void doubleClick() {
		Actions actions = new Actions(driver);
		actions.doubleClick(getDoubleClickMe()).perform();
	}

	public void rightClick() {
		Actions actions = new Actions(driver);
		actions.contextClick(getRightClickMe()).perform();
	}

	public void clickMe() {
		getClickMe().click();
	}

	public String doubleClickText() {
		return getDoubleClickMessage().getText();
	}

	public String rightClickText() {
		return getRightClickMessage().getText();
	}

	public String clickMeText() {
		return getClickMessage().getText();
	}

}
