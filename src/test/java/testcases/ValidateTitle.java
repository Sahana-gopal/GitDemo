package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testcases.Base;
import pageobject.LandingPage;

@Test
public class ValidateTitle extends Base {
    
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	public void verifyTitle() throws Exception {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage land = new LandingPage(driver);
		System.out.println(land.getTitle().getText());
		Assert.assertEquals(land.getTitle().getText(), "FEATURED 123COURSES");
		log.info("Title is matched");	
		

	}
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
