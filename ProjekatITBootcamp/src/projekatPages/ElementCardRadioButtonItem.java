package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementCardRadioButtonItem {

	WebDriver driver;
	WebElement yesButton;
	WebElement impressiveButton;
	WebElement textForSelectedYesButton;
	WebElement textForSelectedImpressiveButton;

	public ElementCardRadioButtonItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getYesButton() {
		return driver.findElement(By.className("custom-control-label"));
	}

	public WebElement getImpressiveButton() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]"));
	}

	public WebElement getTextForSelectedYesButton() {
		return driver.findElement(By.className("mt-3"));
	}

	public WebElement getTextForSelectedImpressiveButton() {
		return driver.findElement(By.className("mt-3"));
	}

	public void clickYes() {
		getYesButton().click();
	}

	public void clickImpressive() {
		getImpressiveButton().click();
	}

	public String selectedYes() {
		return getTextForSelectedYesButton().getText();
	}

	public String selectedImpressive() {
		return getTextForSelectedImpressiveButton().getText();
	}

}
