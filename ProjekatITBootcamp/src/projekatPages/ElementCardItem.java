package projekatPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementCardItem {

	WebDriver driver;
	WebElement elementCard;
	WebElement textBox;
	WebElement checkBox;
	WebElement radioButton;
	WebElement webTables;
	WebElement buttons;
	WebElement links;
	WebElement brokenLiknsImages;
	WebElement uploadAndDownload;
	WebElement dynamicProperties;
	WebElement navigation;

	public ElementCardItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getElementCard() {
		return driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/svg[1]/path[1]"));
	}

	public WebElement getTextBox() {
		return driver.findElement(By.xpath("//span[contains(text(),'Text Box')]"));
	}

//	public WebElement getCheckBox() {
//		return checkBox;
//	}
//
//	public WebElement getRadioButton() {
//		return radioButton;
//	}
//
//	public WebElement getWebTables() {
//		return webTables;
//	}
//
//	public WebElement getButtons() {
//		return buttons;
//	}
//
//	public WebElement getLinks() {
//		return links;
//	}
//
//	public WebElement getBrokenLiknsImages() {
//		return brokenLiknsImages;
//	}
//
//	public WebElement getUploadAndDownload() {
//		return uploadAndDownload;
//	}

	public WebElement getDynamicProperties() {
		return driver.findElement(By.xpath("//span[contains(text(),'Dynamic Properties')]"));
	}

	public List<WebElement> getNavigation() {
		return driver.findElements(By.cssSelector(".btn.btn-light"));
	}

	public void clickOnElementCard() {
		getElementCard().click();
	}

	public void clickOnItems(int j) {
		this.getNavigation().get(j).click();
	}

	public void scrollToElementsItem() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getDynamicProperties());
	}
}