package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testcases.Base;
import pageobject.LandingPage;
import pageobject.PracticePage;

@Test
public class HeaderVerification extends Base{

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public void verifyHeader() throws Exception {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage land = new LandingPage(driver);
        land.clickPractice().click();
        PracticePage pract=new PracticePage(driver);
        Assert.assertEquals(pract.getHeader().getText(), "Practice Page");
        log.info("practice page is successfully opened");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
}
