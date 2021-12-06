package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementCardTextBoxItem {

	WebDriver driver;
	WebElement fullName;
	WebElement email;
	WebElement currentAddress;
	WebElement permanentAddress;
	WebElement submitButton;
	WebElement nameAppearAfterSubmit;
	WebElement emailAppearAfterSubmit;
	WebElement currentAddressAppearAfterSubmit;
	WebElement permanentAddressAppearAfterSubmit;

	public ElementCardTextBoxItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getFullName() {
		return driver.findElement(By.xpath("//input[@id='userName']"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.xpath("//input[@id='userEmail']"));
	}

	public WebElement getCurrentAddress() {
		return driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
	}

	public WebElement getPermanentAddress() {
		return driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.id("submit"));
	}

	public WebElement getNameAppearAfterSubmit() {
		return driver.findElement(By.xpath("//p[@id='name']"));
	}

	public WebElement getEmailAppearAfterSubmit() {
		return driver.findElement(By.xpath("//p[@id='email']"));
	}

	public WebElement getCurrentAddressAppearAfterSubmit() {
		return driver.findElement(By.xpath("//p[@id='currentAddress']"));
	}

	public WebElement getPermanentAddressAppearAfterSubmit() {
		return driver.findElement(By.xpath("//p[@id='permanentAddress']"));
	}

	public void inputFullName(String fullName) {
		getFullName().sendKeys(fullName);
	}

	public void inputEmail(String email) {
		getEmail().sendKeys(email);
	}

	public void inputCurrentAddress(String currentAddress) {
		getCurrentAddress().sendKeys(currentAddress);
	}

	public void inputPermanentAddress(String permanentAddress) {
		getPermanentAddress().sendKeys(permanentAddress);
	}

	public void clickOnSubmitButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getSubmitButton()); // scrolling
																												// to
																												// find
																												// element
		getSubmitButton().click();
	}

	public String fullNameText() {
		return getNameAppearAfterSubmit().getAttribute("value");
	}

	public String emailText() {
		return getEmailAppearAfterSubmit().getAttribute("value");
	}

	public String currentAddressText() {
		return getCurrentAddressAppearAfterSubmit().getAttribute("value");
	}

	public String permanentAddressText() {
		return getPermanentAddressAppearAfterSubmit().getAttribute("value");
	}
}
