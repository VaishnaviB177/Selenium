package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver driver;
//	 WebDriver driver = new ChromeDriver();
	PropertyFileUtil putil= new PropertyFileUtil();
	
	WebDriverUtil wutil= new WebDriverUtil();
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass									
	public void BC() throws IOException
	{
		//@BeforeClass	 annotation is use to lauch application
		
		//To read data from property file
		String URL =putil.getDataFromPropertyFile("Url");
		
		//To launch empty browser
        WebDriver driver= new ChromeDriver();
		
		//To maximize the window
		wutil.maximize(driver);
		
		//To apply wait for findelement()
		wutil.impliciteWait(driver);
		

		//To launch the application
		driver.get(URL);
	}
	
	@BeforeMethod
	public void BM() throws IOException
	{
		// @BeforeMethod is use to login to the application
		
		String USERNAME= putil.getDataFromPropertyFile("Username");
		String PASSWORD= putil.getDataFromPropertyFile("Password");
		
		 WebDriver driver = new ChromeDriver();
	
		
		//To login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("DisConnect to Data Base");
	}
	
	@AfterClass
	public void AC()
	{
		WebDriver driver= new ChromeDriver();;
		//@AfterClass is use to xlose the browser
		driver.quit();
	}
	@AfterMethod
	public void AM() throws InterruptedException
	{
		//@AfterMethod is use to sign out from the application
		
		Thread.sleep(2000);
		WebDriver driver= new ChromeDriver();;
		// Mousehover on image
		WebElement image = driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\"]"));
		wutil.mouseHover(driver, image);

		// Click to sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	

}
