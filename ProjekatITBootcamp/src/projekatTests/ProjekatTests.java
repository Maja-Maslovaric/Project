package projekatTests;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import projekatBase.ProjekatBase;

public class ProjekatTests extends ProjekatBase {

	@BeforeMethod // Everything that is performed before each method
	public void pageSetUp() {
		driver.navigate().to("https://www.google.com"); // navigation to Url or open webpage
		driver.manage().window().maximize(); // window maximization

	}

	@Test(priority = 10)
	public void goToDemoQaWebsite() { // website page opening
		String url = excelReader.getStringData("TestCases", 2, 9); // read data from Excel using ApachePOI
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
	}

	@Test(priority = 20)
	public void openRegistrationPage() throws InterruptedException { // verify if the registration page is opened
		String url = excelReader.getStringData("TestCases", 6, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		openRegistrationPage.clickJoinNowButton();

		ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles()); // I use this to be able to
																							// switch to another tab
																							// because clicking
																							// the join button opens a
																							// new tab with a
																							// registration button
		driver.switchTo().window(listaTabova.get(1)); // Closing that new tab

		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("advertisement-image"))); // waiting for the
																									// presence of the
																									// element
		driver.navigate().refresh(); // page's refresh
		openRegistrationPage.clickRegistrationButton();
		Thread.sleep(1000); // wait for 1 second
		openRegistrationPage.scrollToRegistrationForm(); // use the scroll to navigate the page

	}

	@Test(priority = 30)
	public void joinNowAndRegistration() throws InterruptedException { // Filling the registration form
		String url = excelReader.getStringData("TestCases", 12, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		openRegistrationPage.clickJoinNowButton();

		ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(listaTabova.get(2));

		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("advertisement-image")));
		Thread.sleep(7000);
		driver.navigate().refresh();
		openRegistrationPage.clickRegistrationButton();
		Thread.sleep(1000);
		openRegistrationPage.scrollToRegistrationForm();

		String firstName = excelReader.getStringData("TestCases", 16, 9);
		String lastName = excelReader.getStringData("TestCases", 17, 9);
		String email = excelReader.getStringData("TestCases", 18, 9);
		String mobile = excelReader.getStringData("TestCases", 19, 9);
		String city = excelReader.getStringData("TestCases", 21, 9);
		String message = excelReader.getStringData("TestCases", 22, 9);
		registration.inputFirstName(firstName);
		registration.inputLastName(lastName);
		registration.inputEmail(email);
		registration.inputMobile(mobile);
		Select country = new Select(registration.getCountryField()); // using Select to select country by dropdown meni
		country.selectByValue("105");
		registration.inputCity(city);
		registration.inputMessage(message);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				registration.getCountryField());
		Thread.sleep(3000);
		registration.inputCode();
		Thread.sleep(15000); // 15 seconds for manual populating this field
		registration.clickSendButton();

	}

	@Test(priority = 40)
	public void cardsOnToolsQaHomePageAreClickable() throws InterruptedException { // verify that all cards in
																					// "ToolsQA" homepage are clickable
		String url = excelReader.getStringData("TestCases", 27, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		for (int i = 0; i < 6; i++) { // cards navigation
			cardsOnToolsQaHomePage.clickableCard(i);
			cardsOnToolsQaHomePage.clickableCard(i);
			Thread.sleep(2000);
			cardsOnToolsQaHomePage.scroll();
		}
	}

	@Test(priority = 50)
	public void itemsOnElementsCardAreClickable() throws InterruptedException { // verify that all items in Element Card
																				// are clickable
		String url = excelReader.getStringData("TestCases", 37, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(j);
			Thread.sleep(2000);
			elementCardItem.clickOnItems(j);
			Thread.sleep(2000);
			elementCardItem.scrollToElementsItem();
		}
	}

	@Test(priority = 60)
	public void populateFormWhichAppearWhenUserClickOnTextBoxItemAndThenClickSubmitButton() { // Verify that form which
																								// appear in Text Box
																								// item in
																								// Elements card,
																								// successfully
																								// populated and submit
		String url = excelReader.getStringData("TestCases", 51, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(0);
		}

		String fullName = excelReader.getStringData("TestCases", 55, 9);
		String email = excelReader.getStringData("TestCases", 56, 9);
		String currentAddress = excelReader.getStringData("TestCases", 57, 9);
		String permanentAddress = excelReader.getStringData("TestCases", 58, 9);

		elementCardTextBoxItem.inputFullName(fullName);
		elementCardTextBoxItem.inputEmail(email);
		elementCardTextBoxItem.inputCurrentAddress(currentAddress);
		elementCardTextBoxItem.inputPermanentAddress(permanentAddress);
		elementCardTextBoxItem.clickOnSubmitButton();

	}

	@Test(priority = 70)
	public void dataEnteredInTextBoxFormBeforeAndAfterSubmit() { // verify that all the fields that the user is
																	// filled in and then clicked submit have appeared
																	// below in the window and
																	// all data is the same as that entered by the user
		String url = excelReader.getStringData("TestCases", 62, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(0);
		}

		String fullName = excelReader.getStringData("TestCases", 66, 9);
		String email = excelReader.getStringData("TestCases", 67, 9);
		String currentAddress = excelReader.getStringData("TestCases", 68, 9);
		String permanentAddress = excelReader.getStringData("TestCases", 69, 9);

		elementCardTextBoxItem.inputFullName(fullName);
		elementCardTextBoxItem.inputEmail(email);
		elementCardTextBoxItem.inputCurrentAddress(currentAddress);
		elementCardTextBoxItem.inputPermanentAddress(permanentAddress);
		elementCardTextBoxItem.clickOnSubmitButton();

		// Using assert to compare data before and after submit

		Assert.assertEquals(elementCardTextBoxItem.fullNameText(), fullName);
		Assert.assertEquals(elementCardTextBoxItem.emailText(), email);
		Assert.assertEquals(elementCardTextBoxItem.currentAddressText(), currentAddress);
		Assert.assertEquals(elementCardTextBoxItem.permanentAddressText(), permanentAddress);
	}

	@Test(priority = 80)
	public void selectHomeFromCheckBoxItem() throws InterruptedException { // select only Home button
		String url = excelReader.getStringData("TestCases", 77, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(1);
		}
		Thread.sleep(3000);
		elementCardCheckBoxItem.getHome().click();

		Assert.assertTrue(elementCardCheckBoxItem.getHome().isSelected()); // Check if the button is selected
	}

	@Test(priority = 90)
	public void selectHomeArrow() throws InterruptedException { // select arrow near home button
		String url = excelReader.getStringData("TestCases", 84, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(1);
		}
		Thread.sleep(3000);
		elementCardCheckBoxItem.getHomeArrow().click();

		// Checks if all the new button are displayed

		Assert.assertTrue(elementCardCheckBoxItem.getDesktop().isDisplayed());
		Assert.assertTrue(elementCardCheckBoxItem.getDownloads().isDisplayed());
		Assert.assertTrue(elementCardCheckBoxItem.getDocuments().isDisplayed());
	}

	@Test(priority = 100)
	public void selectDesktop() throws InterruptedException { // select only Desctop from Home menu
		String url = excelReader.getStringData("TestCases", 91, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(1);
		}
		Thread.sleep(3000);
		elementCardCheckBoxItem.getHomeArrow().click();
		Thread.sleep(3000);
		elementCardCheckBoxItem.getDesktop().click();
		Assert.assertTrue(elementCardCheckBoxItem.getDesktop().isSelected()); // check if only Desktop is selected
	}

	@Test(priority = 110)
	public void selectDocuments() throws InterruptedException { // Select only Documents from Home menu
		String url = excelReader.getStringData("TestCases", 99, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(1);
		}
		Thread.sleep(3000);
		elementCardCheckBoxItem.getHomeArrow().click();
		Thread.sleep(3000);
		elementCardCheckBoxItem.getDocuments().click();
		Assert.assertTrue(elementCardCheckBoxItem.getDocuments().isSelected()); // Check if only Documents is selected
	}

	@Test(priority = 120)
	public void selectDownloads() throws InterruptedException { // Select only Downloads from Home menu
		String url = excelReader.getStringData("TestCases", 107, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(1);
		}
		Thread.sleep(3000);
		elementCardCheckBoxItem.getHomeArrow().click();
		Thread.sleep(3000);
		elementCardCheckBoxItem.getDownloads().click();
		Assert.assertTrue(elementCardCheckBoxItem.getDownloads().isSelected());
	}

	@Test(priority = 130)
	public void openRadioButtonPage() throws InterruptedException { // click on Radio Button item
		String url = excelReader.getStringData("TestCases", 115, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(2);
		}
	}

	@Test(priority = 140)
	public void userOnlyCanCliksOnTheOneRadioButton() throws InterruptedException { // verify that user can only clicks
																					// on the one button
		String url = excelReader.getStringData("TestCases", 122, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(2);
		}
		elementCardRadioButtonItem.clickYes(); // first click on yes
		Thread.sleep(3000);
		elementCardRadioButtonItem.clickImpressive(); // second click on impressive

		Assert.assertEquals(elementCardRadioButtonItem.selectedImpressive(), "You have selected Impressive"); // Check
																												// if
																												// only
																												// the
																												// Second
																												// click
																												// button
																												// is
																												// selected
	}

	@Test(priority = 150)
	public void WebTableIsShowed() throws InterruptedException { // Verify that when user click on the WebTables
																	// appeared page with table
		String url = excelReader.getStringData("TestCases", 133, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(3);
		}
	}

	@Test(priority = 160)
	public void opeAddingRecordForm() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 139, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(3);
		}
		elementWebTablesItem.addRecord();
	}

	@Test(priority = 170)
	public void addRecordInTable() throws InterruptedException { // add some record in the table
		String url = excelReader.getStringData("TestCases", 146, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(3);
		}
		elementWebTablesItem.addRecord();
		String firstName = excelReader.getStringData("TestCases", 151, 9); // data about the person you want to add to
																			// the table using from Excel
		String lastName = excelReader.getStringData("TestCases", 152, 9);
		String email = excelReader.getStringData("TestCases", 153, 9);
		String age = excelReader.getStringData("TestCases", 154, 9);
		String salary = excelReader.getStringData("TestCases", 155, 9);
		String department = excelReader.getStringData("TestCases", 156, 9);
		addRecordRegistrationForm.inputFirstName(firstName);
		addRecordRegistrationForm.inputLastName(lastName);
		addRecordRegistrationForm.inputEmail(email);
		addRecordRegistrationForm.inputAge(age);
		addRecordRegistrationForm.inputSalary(salary);
		addRecordRegistrationForm.inputDepartment(department);
		addRecordRegistrationForm.clickOnSubmitButton();
	}

	@Test(priority = 180)
	public void deleteRecordFromTable() throws InterruptedException { // delete same record from table
		String url = excelReader.getStringData("TestCases", 160, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(3);
		}
		elementWebTablesItem.deleteRecord();

	}

	@Test(priority = 190)
	public void searchRecord() throws InterruptedException { // searching record
		String url = excelReader.getStringData("TestCases", 167, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(3);
		}
		elementWebTablesItem.searchRecord("Kierra"); // record for search
	}

	@Test(priority = 200)
	public void clickButtons() throws InterruptedException { //// buttons for clicking
		String url = excelReader.getStringData("TestCases", 176, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			elementCardItem.clickOnItems(4);
		}
	}

	@Test(priority = 210)
	public void doubleClik() throws InterruptedException { // Verify that the user has double-clicked
		String url = excelReader.getStringData("TestCases", 185, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", // scrolling into page
					elementCardButtonsItem.getButtons());
			elementCardItem.clickOnItems(4);
		}
		Thread.sleep(3000);
		elementCardButtonsItem.doubleClick();

		Assert.assertEquals(elementCardButtonsItem.doubleClickText(), "You have done a double click");
	}

	@Test(priority = 220)
	public void rightClick() throws InterruptedException { // check if the user has right-click
		String url = excelReader.getStringData("TestCases", 195, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardButtonsItem.getButtons());
			elementCardItem.clickOnItems(4);
		}
		Thread.sleep(3000);
		elementCardButtonsItem.rightClick();

		Assert.assertEquals(elementCardButtonsItem.rightClickText(), "You have done a right click");
	}

	@Test(priority = 230)
	public void click() throws InterruptedException { // Check if the user has click
		String url = excelReader.getStringData("TestCases", 205, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardButtonsItem.getButtons());
			elementCardItem.clickOnItems(4);
		}
		Thread.sleep(3000);
		elementCardButtonsItem.clickMe();

		Assert.assertEquals(elementCardButtonsItem.clickMeText(), "You have done a dynamic click");
	}

	@Test(priority = 240)
	public void openLinksItem() throws InterruptedException { // opening page with links
		String url = excelReader.getStringData("TestCases", 215, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
	}

	@Test(priority = 250)
	public void clickOnHomeInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 223, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickHome();
		ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(listaTabova.get(3));
	}

	@Test(priority = 260)
	public void clickOnHome2InOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 234, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickHome2();
		ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(listaTabova.get(3));
	}

	@Test(priority = 270)
	public void clickOnCreatedInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 243, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickCreated();
	}

	@Test(priority = 280)
	public void clickOnNoContentInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 252, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickNoContent();
	}

	@Test(priority = 290)
	public void clickOnMovedInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 261, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickMoved();
	}

	@Test(priority = 300)
	public void clickOnBadRequestInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 270, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickBadRequest();
	}

	@Test(priority = 310)
	public void clickOnUnauthorizedtInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 279, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickUnauthorized();
	}

	@Test(priority = 320)
	public void clickOnForbiddenInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 288, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickForbidden();
	}

	@Test(priority = 330)
	public void clickOnNotFaundInOpenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 297, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(5);
		}
		elementCardLinksItem.clickNotFound();
	}

	@Test(priority = 340)
	public void openBrokenLinksItem() throws InterruptedException {
		String url = excelReader.getStringData("TestCases", 306, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(0);
		Thread.sleep(3000);
		for (int j = 0; j < 9; j++) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					elementCardLinksItem.getLinks());
			elementCardItem.clickOnItems(6);
		}
	}

	@Test(priority = 350)
	public void fillingOutTheStudentRegistrationForm() throws InterruptedException { // filling out a student form
		String url = excelReader.getStringData("TestCases", 313, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(1);
		Thread.sleep(3000);
		formCardPracticeFormsItem.getPracticeForm().click();

		String firstName = excelReader.getStringData("TestCases", 317, 9);
		String lastName = excelReader.getStringData("TestCases", 318, 9);
		String email = excelReader.getStringData("TestCases", 319, 9);
		String mobile = excelReader.getStringData("TestCases", 321, 9);
		String subject = excelReader.getStringData("TestCases", 323, 9);
		String currentaddress = excelReader.getStringData("TestCases", 326, 9);

		formCardPracticeFormsItem.inputFirstName(firstName);

		formCardPracticeFormsItem.inputLastName(lastName);

		formCardPracticeFormsItem.inputEmail(email);

		formCardPracticeFormsItem.clickMale();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				formCardPracticeFormsItem.getMale());

		formCardPracticeFormsItem.inputMobile(mobile);

		formCardPracticeFormsItem.chooseDateOfBirth();
		formCardPracticeFormsItem.getMonth().click();
		Select selectMonth = new Select(formCardPracticeFormsItem.getMonth()); // use select to choose months from the
																				// dropdown
		selectMonth.selectByIndex(5);
		formCardPracticeFormsItem.getYear().click();
		Select selectYear = new Select(formCardPracticeFormsItem.getYear());
		selectYear.selectByValue("1989");
		formCardPracticeFormsItem.choseDate();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				formCardPracticeFormsItem.getSubjects());

		formCardPracticeFormsItem.clickSubjects();
		formCardPracticeFormsItem.inputSubjects(subject);

		formCardPracticeFormsItem.clickReading();

		formCardPracticeFormsItem.inputCurrentAddress(currentaddress);
		formCardPracticeFormsItem.selectState();
//		Select selectState = new Select(practiceForm.getSelectState());
//		selectState.selectByIndex(3);
		formCardPracticeFormsItem.selectCity();
//		Select selectCity = new Select(practiceForm.getSelectCity());
//		selectCity.selectByIndex(0);
		formCardPracticeFormsItem.clickSubmit();

	}

	@Test(priority = 360)
	public void moveSliderPointer() { // move slider
		String url = excelReader.getStringData("TestCases", 332, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		cardsOnToolsQaHomePage.clickableCard(3);
		widgetsCard.clickOnWidgetsCard();
		widgetsCard.clickOnSliderItem();
		widgetsCard.moveSlider();
	}

	@Test(priority = 370)
	public void createNewUserForBookStoreApplication() {
		String url = excelReader.getStringData("TestCases", 339, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]")));
		cardsOnToolsQaHomePage.clickableCard(5);
		bookStoreApplicationLoginItem.getLogin();
		bookStoreApplicationLoginItem.clickOnNewUser();

		String firstName = excelReader.getStringData("TestCases", 344, 9);
		String lastName = excelReader.getStringData("TestCases", 345, 9);
		String userName = excelReader.getStringData("TestCases", 346, 9);
		String password = excelReader.getStringData("TestCases", 347, 9);

		bookStoreApplicationLoginItem.inputFirstName(firstName);
		bookStoreApplicationLoginItem.inputLastName(lastName);
		bookStoreApplicationLoginItem.inputUserName(userName);
		bookStoreApplicationLoginItem.inputPassword(password);
		bookStoreApplicationLoginItem.clickOnRecaptcha();
		bookStoreApplicationLoginItem.clickOnRegisterButton();

	}

	@Test(priority = 380)
	public void usersLoginAfterRegistration() {
		String url = excelReader.getStringData("TestCases", 352, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]")));
		cardsOnToolsQaHomePage.clickableCard(5);
		bookStoreApplicationLoginItem.getLogin();
		String userNameAfterRegistration = excelReader.getStringData("TestCases", 356, 9);
		String passwordAfterRegistration = excelReader.getStringData("TestCases", 357, 9);

		bookStoreApplicationLoginItem.inputUserNameAfterRegistration(userNameAfterRegistration);
		bookStoreApplicationLoginItem.inputPasswordAfterRegistration(passwordAfterRegistration);
		bookStoreApplicationLoginItem.clickOnLoginButton();

	}

	@Test(priority = 390)
	public void userAddedBookInHisCollection() {
		String url = excelReader.getStringData("TestCases", 361, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]")));
		cardsOnToolsQaHomePage.clickableCard(5);
		bookStoreApplicationLoginItem.getLogin();
		String userNameAfterRegistration = excelReader.getStringData("TestCases", 365, 9);
		String passwordAfterRegistration = excelReader.getStringData("TestCases", 366, 9);

		bookStoreApplicationLoginItem.inputUserNameAfterRegistration(userNameAfterRegistration);
		bookStoreApplicationLoginItem.inputPasswordAfterRegistration(passwordAfterRegistration);
		bookStoreApplicationLoginItem.clickOnLoginButton();
		bookStoreApplicationBookStoreItem.clickOnBookStoreItem();
		bookStoreApplicationBookStoreItem.clickOnBookToAddedInCollection();
		bookStoreApplicationBookStoreItem.clickOnAddButton();
		driver.navigate().refresh();
	}

	@Test(priority = 400)
	public void userProfileInBookStoreApplicationAfterBookAdded() {
		String url = excelReader.getStringData("TestCases", 374, 9);
		chromeBrowser.inputURL(url);
		chromeBrowser.demoQaClick();
		cardsOnToolsQaHomePage.clickOnCard();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]")));
		cardsOnToolsQaHomePage.clickableCard(5);
		bookStoreApplicationLoginItem.getLogin();
		String userNameAfterRegistration = excelReader.getStringData("TestCases", 378, 9);
		String passwordAfterRegistration = excelReader.getStringData("TestCases", 379, 9);

		bookStoreApplicationLoginItem.inputUserNameAfterRegistration(userNameAfterRegistration);
		bookStoreApplicationLoginItem.inputPasswordAfterRegistration(passwordAfterRegistration);
		bookStoreApplicationLoginItem.clickOnLoginButton();
		bookStoreApplicationBookStoreItem.clickOnBookStoreItem();
		bookStoreApplicationBookStoreItem.clickOnBookToAddedInCollection();
		bookStoreApplicationBookStoreItem.clickOnAddButton();
		driver.navigate().refresh();
		bookStoreApplicationProfileItem.clickOnProfileItem();
	}

	@AfterMethod
	public void afterMethod() {
		driver.navigate().forward();
	}
}
