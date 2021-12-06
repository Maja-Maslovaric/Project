package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormCardPracticeFormsItem {
	WebDriver driver;
	WebElement practiceForm;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement email;
	WebElement male;
	WebElement female;
	WebElement other;
	WebElement mobile;
	WebElement dateOfBirth;
	WebElement month;
	WebElement year;
	WebElement date;
	WebElement subjects;
	WebElement inputSub;
	WebElement sport;
	WebElement reading;
	WebElement music;
	WebElement chooseFile;
	WebElement currentAddress;
	WebElement selectState;
	WebElement selectCity;
	WebElement submitButton;

	public FormCardPracticeFormsItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getPracticeForm() {
		return driver.findElement(By.cssSelector(".btn.btn-light.active"));
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstName"));
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastName"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("userEmail"));
	}

	public WebElement getMale() {
		return driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
	}

	public WebElement getFemale() {
		return driver.findElement(By.id("gender-radio-2"));
	}

	public WebElement getOther() {
		return driver.findElement(By.id("gender-radio-3"));
	}

	public WebElement getMobile() {
		return driver.findElement(By.id("userNumber"));
	}

	public WebElement getDateOfBirth() {
		return driver.findElement(By.id("dateOfBirthInput"));
	}

	public WebElement getMonth() {
		return driver.findElement(By.className("react-datepicker__month-select"));
	}

	public WebElement getYear() {
		return driver.findElement(By.className("react-datepicker__year-select"));
	}

	public WebElement getDate() {
		return driver
				.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]"));
	}

	public WebElement getSubjects() {
		return driver.findElement(By.id("subjectsContainer"));
	}

	public WebElement getInputSub() {
		return driver.findElement(By.id("subjectsInput"));
	}

	public WebElement getSport() {
		return driver.findElement(By.id("hobbies-checkbox-1"));
	}

	public WebElement getReading() {
		return driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label"));
	}

	public WebElement getMusic() {
		return driver.findElement(By.id("hobbies-checkbox-3"));
	}

	public WebElement getChooseFile() {
		return driver.findElement(By.className("form-control-file"));
	}

	public WebElement getCurrentAddress() {
		return driver.findElement(By.id("currentAddress"));
	}

	public WebElement getSelectState() {
		return driver.findElement(By.id("state"));
	}

	public WebElement getSelectCity() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.id("submit"));
	}

	public void inputFirstName(String firstName) {
		getFirstNameField().sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		getLastNameField().sendKeys(lastName);
	}

	public void inputEmail(String email) {
		getEmail().sendKeys(email);
	}

	public void clickMale() {
		getMale().click();
	}

	public void clickFemale() {
		getFemale().click();
	}

	public void clickOther() {
		getOther().click();
	}

	public void inputMobile(String mobile) {
		getMobile().sendKeys(mobile);
	}

	public void chooseDateOfBirth() {
		getDateOfBirth().click();
	}

	public void choseDate() {
		getDate().click();
	}

	public void clickSubjects() {
		getSubjects().click();
	}

	public void inputSubjects(String subject) {
		getInputSub().sendKeys(subject);
		getInputSub().sendKeys(Keys.ENTER);
	}

	public void clickSport() {
		getSport().click();
	}

	public void clickReading() {
		getReading().click();
	}

	public void clickMusic() {
		getMusic().click();
	}

	public void uploadFile() {
		getChooseFile().click();
	}

	public void inputCurrentAddress(String currentAddress) {
		getCurrentAddress().sendKeys(currentAddress);
	}

	public void selectState() {
		getSelectState().click();
	}

	public void selectCity() {
		getSelectCity();
	}

	public void clickSubmit() {
		getSubmitButton().click();
	}

}
