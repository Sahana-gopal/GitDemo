package testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Base {
	
	public Properties prop;
	public WebDriver driver;
	//private String browser;
	
	public WebDriver initializeDriver() throws IOException
	{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Sahana\\eclipse-workspace\\EndtoEndTest\\src\\test\\java\\utilities\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");

	if(browserName.equals("chrome")) {	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sahana\\eclipse-workspace\\EndtoEndTest\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	
	}
	else if(browserName.equals("firefox")) {	
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Sahana\\eclipse-workspace\\EndtoEndTest\\Drivers\\geckodriver.exe");
	driver=new FirefoxDriver();
	}	

	//driver.get("url");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	
}
	
	
	public String getScreenshot(String testmethodname, WebDriver driver) throws Exception {
		
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destfile=System.getProperty("user.dir")+"\\reports\\" +testmethodname +".png";
	FileUtils.copyFile(source, new File(destfile));
	return destfile;
	}
}