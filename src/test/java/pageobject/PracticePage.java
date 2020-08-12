package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testcases.Base;

public class PracticePage extends Base{
  
	public WebDriver driver;
	
	By header=By.xpath("//h1[text()='Practice Page']");
	
	public PracticePage(WebDriver driver2) {
		
		this.driver=driver2;
	}

	public WebElement getHeader() {
		
		return driver.findElement(header);
	}
}
