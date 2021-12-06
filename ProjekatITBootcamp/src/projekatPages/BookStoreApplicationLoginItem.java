package projekatPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreApplicationLoginItem {

	WebDriver driver;
	WebDriverWait wdwait;
	WebElement login;
	WebElement newUser;
	WebElement firstName;
	WebElement lastName;
	WebElement userName;
	WebElement password;
	WebElement recaptcha;
	WebElement register;
	WebElement userNameAfterRegistration;
	WebElement passwordAfterRegistration;
	WebElement loginButton;

	public BookStoreApplicationLoginItem(WebDriver driver, WebDriverWait wdwait) {
		super();
		this.driver = driver;
		this.wdwait = wdwait;
	}

	public WebElement getLogin() {
		return driver.findElement(
				By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[1]"));
	}

	public WebElement getNewUser() {
		return driver.findElement(By.id("newUser"));
	}

	public WebElement getFirstName() {
		return driver.findElement(By.xpath("//input[@id='firstname']"));
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getRecaptcha() {
		return driver.findElement(By.className("recaptcha-checkbox-borderAnimation"));
	}

	public WebElement getRegister() {
		return driver.findElement(By.xpath("//button[@id='register']"));
	}

	public WebElement getUserNameAfterRegistration() {
		return driver.findElement(By.xpath("//input[@id='userName']"));
	}

	public WebElement getPasswordAfterRegistration() {
		return driver.findElement(By.xpath("//input[@id='password']"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//button[@id='login']"));
	}

	public List<WebElement> registerFormField() { // create list of elements
		return driver.findElements(By.cssSelector(".col-md-9.col-sm-12"));
	}

	public void clickOnNewUser() {
		getNewUser().click();
	}

	public void getNavigationRegisterFormField(int i) { // using elements from list
		for (i = 0; i < 4; i++) {
			registerFormField().get(i).click();
		}
	}

	public void inputFirstName(String firstName) {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='firstname']")));
		getNavigationRegisterFormField(0);
		registerFormField().get(0).sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='lastname']")));
		getNavigationRegisterFormField(1);
		registerFormField().get(1).sendKeys(lastName);
	}

	public void inputUserName(String userName) {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='userName']")));
		getNavigationRegisterFormField(2);
		registerFormField().get(2).sendKeys(userName);
	}

	public void inputPassword(String password) {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
		getNavigationRegisterFormField(3);
		registerFormField().get(3).sendKeys(password);
	}

	public void clickOnRecaptcha() {
		getRecaptcha().click();
	}

	public void clickOnRegisterButton() {
		getRegister().click();
	}

	public void inputUserNameAfterRegistration(String userNameAfterRegistration) {
		getUserNameAfterRegistration().sendKeys(userNameAfterRegistration);
	}

	public void inputPasswordAfterRegistration(String passwordAfterRegistration) {
		getPasswordAfterRegistration().sendKeys(passwordAfterRegistration);
	}

	public void clickOnLoginButton() {
		getLoginButton().click();
	}
}
