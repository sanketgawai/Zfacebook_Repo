package qa.test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class temp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='booking_engine_cabs']")).click();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		System.out.println(driver.getCurrentUrl()); 
		
		Thread.sleep(3000);
		WebElement frm = driver.findElement(By.xpath("//iframe[@id='ifd']"));
		driver.switchTo().frame(frm);
		
		WebElement transfer = driver.findElement(By.xpath("//select[@id='travelTypeSelect']"));
		Select s = new Select(transfer);
		s.selectByVisibleText("International Transfers");
		
		
	}
	
}
