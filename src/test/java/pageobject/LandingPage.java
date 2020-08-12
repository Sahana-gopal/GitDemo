package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testcases.Base;

public class LandingPage extends Base {

	public WebDriver driver;
	By login = By.xpath("//*[span='Login']");
	By title = By.xpath("//h2[text()='Featured Courses']");
	By practice=By.xpath("//a[text()='Practice']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;// TODO Auto-generated constructor stub
	}

	public WebElement clickLogin() {
		return driver.findElement(login);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement clickPractice() {
		return driver.findElement(practice);
	}
}
