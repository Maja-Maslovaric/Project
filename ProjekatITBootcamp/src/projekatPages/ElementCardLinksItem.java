package projekatPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementCardLinksItem {

	WebDriver driver;
	WebElement links;
	WebElement followingLinksWillOpenInNewTab;
	WebElement followingLinksWillSendAnApiCall;
	WebElement Home;
	WebElement Home2;
	WebElement Created;
	WebElement noContent;
	WebElement moved;
	WebElement badRequest;
	WebElement unauthorized;
	WebElement forbidden;
	WebElement notFound;
	WebElement statusText;
	WebElement newPageToolsqa;

	public ElementCardLinksItem(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getLinks() {
		return driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/span[1]"));
	}

	public WebElement getFollowingLinksWillOpenInNewTab() {
		return driver.findElement(By.cssSelector("#linkWrapper > h5:nth-child(1) > strong"));
	}

	public WebElement getFollowingLinksWillSendAnApiCall() {
		return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/h5[2]/strong"));
	}

	public WebElement getHome() {
		return driver.findElement(By.id("simpleLink"));
	}

	public WebElement getHome2() {
		return driver.findElement(By.id("dynamicLink"));
	}

	public WebElement getCreated() {
		return driver.findElement(By.id("created"));
	}

	public WebElement getNoContent() {
		return driver.findElement(By.id("no-content"));
	}

	public WebElement getMoved() {
		return driver.findElement(By.id("moved"));
	}

	public WebElement getBadRequest() {
		return driver.findElement(By.id("bad-request"));
	}

	public WebElement getUnauthorized() {
		return driver.findElement(By.id("unauthorized"));
	}

	public WebElement getForbidden() {
		return driver.findElement(By.id("forbidden"));
	}

	public WebElement getNotFound() {
		return driver.findElement(By.id("invalid-url"));
	}

	public WebElement getStatusText() {
		return driver.findElement(By.id("linkResponse"));
	}

	public WebElement getNewPageToolsqa() {
		return driver.findElement(By.xpath("ewPageToolsqa"));
	}

	public void clickHome() {
		getHome().click();
	}

	public void clickHome2() {
		getHome2().click();
	}

	public void clickCreated() {
		getCreated().click();
	}

	public void clickNoContent() {
		getNoContent().click();
	}

	public void clickMoved() {
		getMoved().click();
	}

	public void clickBadRequest() {
		getBadRequest().click();
	}

	public void clickUnauthorized() {
		getUnauthorized().click();
	}

	public void clickForbidden() {
		getForbidden().click();
	}

	public void clickNotFound() {
		getNotFound().click();
	}

	public void statusText() {
		getStatusText().getText();
	}

	public void newPagetitle() {
		getNewPageToolsqa().getText();

	}

}
