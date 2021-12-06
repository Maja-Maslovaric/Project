package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRecordRegistrationForm {

	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement emailField;
	WebElement ageField;
	WebElement salaryField;
	WebElement departmentField;
	WebElement submitButtonField;

	public AddRecordRegistrationForm(WebDriver driver) { // create contructor 
		super();
		this.driver = driver;
	}

	public WebElement getFirstNameField() {  // create webElement using locator
		return driver.findElement(By.id("firstName"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastName"));
	}

	public WebElement getEmailField() {
		return driver.findElement(By.id("userEmail"));
	}

	public WebElement getAgeField() {
		return driver.findElement(By.id("age"));
	}

	public WebElement getSalaryField() {
		return driver.findElement(By.id("salary"));
	}

	public WebElement getDepartmentField() {
		return driver.findElement(By.id("department"));
	}

	public WebElement getSubmitButtonField() {
		return driver.findElement(By.id("submit"));
	}

	public void inputFirstName(String firstName) { // create method for input first name field
		getFirstNameField().sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		getLastNameField().sendKeys(lastName);
	}

	public void inputEmail(String email) {
		getEmailField().sendKeys(email);
	}

	public void inputAge(String age) {
		getAgeField().sendKeys(age);
	}

	public void inputSalary(String salary) {
		getSalaryField().sendKeys(salary);
	}

	public void inputDepartment(String department) {
		getDepartmentField().sendKeys(department);
	}

	public void clickOnSubmitButton() {
		getSubmitButtonField().click();
	}

}
