package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testcases.Base;
import pageobject.LandingPage;
import pageobject.LoginPage;

@Test
public class HomePage extends Base {

	public WebDriver driver;
	public static Logger log= LogManager.getLogger(Base.class.getName());

	
	@Test(dataProvider = "getData")
	public void baseNavigation(String username, String password) throws IOException {

		driver = initializeDriver();
		log.info("Browser launched");
		driver.get(prop.getProperty("url"));
		LandingPage land = new LandingPage(driver);
		land.clickLogin().click();
		LoginPage login=new LoginPage(driver);
		login.getemail().sendKeys(username);
		login.getpassword().sendKeys(password);
		login.clickSubmit().click();
		log.info("Incorrect credentials");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "jSHfksa";
		data[0][1] = "12345";
		data[1][0] = "gasgtdj";
		data[1][1] = "56789";
		return data;

	}
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
