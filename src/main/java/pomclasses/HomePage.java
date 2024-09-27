package pomclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	@FindBy(id="email")
	private WebElement emailAddress;
	
	@FindBy(xpath="//div[@id='passContainer']")
	private WebElement pass;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@id='u_0_0_yE']")
	private WebElement createNewAccount;
	
	@FindBy(xpath="//div[@id='u_0_0_9f']/parent::div")
	private WebElement errorMessage; 
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,10);
	}
	
	public void sendEmail(String email)
	{
		//emailAddress.sendKeys("kaido@gmail.com");
		emailAddress.sendKeys(email);
		
	}
	public void sendPass(String pas)
	{
		Actions act = new Actions(driver);
		//act.moveToElement(pass).doubleClick().sendKeys("kaido1234").build().perform();
		act.moveToElement(pass).doubleClick().sendKeys(pas).build().perform();
		//pass.click();
		//js.executeScript("arguments[0].value='kaido1234';", pass);
		//pass.sendKeys("kaido1234");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
		
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	
	public void clickOnCreateNewAccount()
	{
		createNewAccount.click();
	}

	
}