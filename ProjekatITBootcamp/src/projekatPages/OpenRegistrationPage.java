package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenRegistrationPage {
	WebDriver driver;
	WebElement joinNowButton;
	WebElement goToRegistrationButton;
	WebElement registrationForm;

	public OpenRegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getJoinNowButton() {
		return driver.findElement(By.className("banner-image"));
	}

	public WebElement getGoToRegistrationButton() {
		return driver.findElement(By.cssSelector(".btn.btn-primary-shadow.btn-block"));
	}

	public WebElement getRegistrationForm() {
		return driver.findElement(By.cssSelector(".text-center.upcoming__registration--heading"));
	}

	public void clickJoinNowButton() {
		getJoinNowButton().click();
	}

	public void clickRegistrationButton() {
		getGoToRegistrationButton().click();
	}

	public void scrollToRegistrationForm() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.getRegistrationForm());
	}
}
