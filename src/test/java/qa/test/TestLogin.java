package qa.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.HomePage;
import qa.base.Basee;
import qa.utils.utility;

public class TestLogin extends Basee {

	WebDriver driver;
	HomePage homePage;
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		System.out.println("1st change by 2nd person");
		System.out.println("2nd change by 2nd person");
		loadProperties();
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	}
	
	@BeforeClass
	public void pomClassObject()
	{
		homePage = new HomePage(driver);
		//driver.get(prop.getProperty("url"));
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void checkUrl()
	{
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(dataProvider="testData")
	public void Login(String email, String pass)
	{
		homePage.sendEmail(email);
		homePage.sendPass(pass);
//		homePage.clickOnLoginButton();
//		System.out.println(homePage.getErrorMessage());
	}
	
	@DataProvider(name="testData")
	public Object[][] supplyTestData() throws IOException
	{
		Object[][] data = utility.getTestDataFromexcel("zfac");
		return data;
	}
	
//	@AfterMethod	
//	public void afterMethod()
//	{
//		System.out.println("afterMethod");
//	}
	
//	@AfterClass
//	public void makePOMObjectNull()
//	{
//		homePage = null;
//	}
	
//	@AfterTest
//	public void closeBrowser()
//	{
//		System.gc();
//		driver.quit();
//	}
	
}
