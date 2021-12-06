package projekatBase;

/*
For testing the site "demoqa.com" I used selenium with java, POM, and Apache Poi.
Selenium WebDriver is used for automating web-based application testing to verify that it performs expectedly.
This tool is a web framework that permits you to execute cross-browser tests.
Selenium WebDriver allows you to choose a programming language to create test scripts.
And I chose the Chrome browser because it is the most used search engine and I've been working in it for a long time , 
and the java programming language because from the  programming languages I only learned it for now.
The POM(Page Object Model) is a design pattern in Selenium that creates an object repository for storing
all web elements. It is useful in reducing code duplication and improves test case maintenance. ... 
Using these elements, testers can perform operations on the website under test.
Apache POI allows us to create, modify, and display MS Office files using Java programs,
for example, Excel which I used for this automatization of this website, 
by entering the data I need for logging in, registration, etc. 
into an excel spreadsheet and then just calling in programs  methods from there.
*/

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import projekatPages.AddRecordRegistrationForm;
import projekatPages.BookStoreApplicationBookStoreItem;
import projekatPages.BookStoreApplicationLoginItem;
import projekatPages.BookStoreApplicationProfileItem;
import projekatPages.CardsOnToolsQaHomePage;
import projekatPages.ChromeBrowser;
import projekatPages.ElementCardButtonsItem;
import projekatPages.ElementCardCheckBoxItem;
import projekatPages.ElementCardItem;
import projekatPages.ElementCardRadioButtonItem;
import projekatPages.ElementCardTextBoxItem;
import projekatPages.ElementCardLinksItem;
import projekatPages.ElementWebTablesItem;
import projekatPages.FormCardPracticeFormsItem;
import projekatPages.OpenRegistrationPage;
import projekatPages.Registration;
import projekatPages.WidgetsCard;

public class ProjekatBase {

	public WebDriver driver;
	public ExcelReader excelReader;
	public WebDriverWait wdwait;
	public ChromeBrowser chromeBrowser;
	public OpenRegistrationPage openRegistrationPage;
	public Registration registration;
	public CardsOnToolsQaHomePage cardsOnToolsQaHomePage;
	public ElementCardItem elementCardItem;
	public ElementCardTextBoxItem elementCardTextBoxItem;
	public ElementCardCheckBoxItem elementCardCheckBoxItem;
	public ElementCardRadioButtonItem elementCardRadioButtonItem;
	public ElementWebTablesItem elementWebTablesItem;
	public AddRecordRegistrationForm addRecordRegistrationForm;
	public ElementCardButtonsItem elementCardButtonsItem;
	public ElementCardLinksItem elementCardLinksItem;
	public FormCardPracticeFormsItem formCardPracticeFormsItem;
	public WidgetsCard widgetsCard;
	public BookStoreApplicationLoginItem bookStoreApplicationLoginItem;
	public BookStoreApplicationBookStoreItem bookStoreApplicationBookStoreItem;
	public BookStoreApplicationProfileItem bookStoreApplicationProfileItem;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wdwait = new WebDriverWait(driver, 20);
		excelReader = new ExcelReader("D:\\Eclipse-workspace\\ProjekatITBootcamp\\ITBootcamp project.xlsx");
		chromeBrowser = new ChromeBrowser(driver);
		openRegistrationPage = new OpenRegistrationPage(driver);
		registration = new Registration(driver);
		cardsOnToolsQaHomePage = new CardsOnToolsQaHomePage(driver);
		elementCardItem = new ElementCardItem(driver);
		elementCardTextBoxItem = new ElementCardTextBoxItem(driver);
		elementCardCheckBoxItem = new ElementCardCheckBoxItem(driver);
		elementCardRadioButtonItem = new ElementCardRadioButtonItem(driver);
		elementWebTablesItem = new ElementWebTablesItem(driver);
		addRecordRegistrationForm = new AddRecordRegistrationForm(driver);
		elementCardButtonsItem = new ElementCardButtonsItem(driver);
		elementCardLinksItem = new ElementCardLinksItem(driver);
		formCardPracticeFormsItem = new FormCardPracticeFormsItem(driver);
		widgetsCard = new WidgetsCard(driver, wdwait);
		bookStoreApplicationLoginItem = new BookStoreApplicationLoginItem(driver, wdwait);
		bookStoreApplicationBookStoreItem = new BookStoreApplicationBookStoreItem(driver);
		bookStoreApplicationProfileItem = new BookStoreApplicationProfileItem(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
