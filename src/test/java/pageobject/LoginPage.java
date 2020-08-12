package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testcases.Base;

public class LoginPage extends Base {

	By email = By.id("user_email");
	By password = By.id("user_password");
	By submit = By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getemail() {
		return driver.findElement(email);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement clickSubmit() {
		return driver.findElement(submit);
	}
}
