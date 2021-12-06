package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement emailField;
	WebElement mobileField;
	WebElement countryField;
	WebElement cityField;
	WebElement yourMessageField;
	WebElement code;
	WebElement inputCode;
	WebElement sendButton;

	public Registration(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("last-name"));
	}

	public WebElement getEmailField() {
		return driver.findElement(By.xpath("//*[@id=\"email\"]"));
	}

	public WebElement getMobileField() {
		return driver.findElement(By.id("mobile"));
	}

	public WebElement getCountryField() {
		return driver.findElement(By.id("country"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getYourMessageField() {
		return driver.findElement(By.xpath("//*[@id=\"message\"]"));
	}

	public WebElement getInputCode() {
		return driver.findElement(By.xpath("//body/div[1]/div[5]/div[1]/div[3]/form[1]/div[8]/img[1]"));
	}

	public WebElement getSendButton() {
		return driver.findElement(By.cssSelector(".btn.btn-block.btn-primary"));
	}

	public WebElement getCode() {
		return driver.findElement(By.className("upcoming__registration--captcha"));
	}

	public void inputFirstName(String firstName) {
		getFirstNameField().sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		getLastNameField().sendKeys(lastName);
	}

	public void inputEmail(String email) {
		getEmailField().sendKeys(email);
	}

	public void inputMobile(String mobile) {
		getMobileField().sendKeys(mobile);
	}

	public void selectCountry() {
		getCountryField().click();
//		String choosenCountry = getCountryField().getAttribute("8");
//		getCountryField().sendKeys(Keys.ENTER);
	}

	public void inputCity(String city) {
		getCityField().sendKeys(city);
	}

	public void inputMessage(String message) {
		getYourMessageField().sendKeys(message);
	}

	public void inputCode() {
		getInputCode().click();

	}

	public void clickSendButton() {
		getSendButton().click();
	}

}
