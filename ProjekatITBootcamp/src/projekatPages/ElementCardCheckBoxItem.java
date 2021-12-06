package projekatPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementCardCheckBoxItem {

	WebDriver driver;
	WebElement home;
	WebElement homeArrow;
	WebElement desktop;
	WebElement documents;
	WebElement downloads;

	public ElementCardCheckBoxItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getHome() {
		return driver.findElement(By.className("rct-checkbox"));
	}

	public WebElement getHomeArrow() {
		return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
	}

	public List<WebElement> homeElements() {
		return driver.findElements(By.cssSelector(".rct-icon.rct-icon-parent-close"));
	}

	public void clickableCard(int i) {
		this.homeElements().get(i).click();
	}

	public void clickOnHome() {
		getHome().click();
	}

	public void clickOnArrow() {
		getHomeArrow().click();
	}

	public WebElement getDesktop() {
		return driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]"));
	}

	public WebElement getDocuments() {
		return driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[2]/span[1]/label[1]/span[1]/*[1]"));
	}

	public WebElement getDownloads() {
		return driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/ol[1]/li[3]/span[1]/label[1]/span[1]/*[1]"));
	}

//	public void selectDesktop() {
//		homeElements.get(0).click();
//	}
//
//	public void selectDocuments() {
//		homeElements.get(1).click();
//	}
//
//	public void selectDownloads() {
//		homeElements.get(2).click();
//	}

}
