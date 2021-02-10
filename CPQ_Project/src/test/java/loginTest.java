import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginTest {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException
	{ 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumbar\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 
		 driver.get("https://freecrm.co.in/");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
	}
	
	
	@DataProvider
	public Object[][] getLoginData()
	{
		return TestUtil.getTestData("login");
	}
	
	//parameterization and prioritisation 
	@Test(priority = 1)
	@Parameters({"author","searchKey"})
	public void Paramenter(String author, String searchKey) throws InterruptedException
	{
		
		 System.out.println("hello");
		 System.out.println(author+"   "+searchKey);
		
	}
	
	//Data provider 
	@Test(dataProvider = "getLoginData")
	public void loginTest(String email, String password) throws InterruptedException
	{
		
		 System.out.println("hello");
		 System.out.println(email+"   "+password);
		 driver.findElement(By.xpath("//input[@name='email']")).clear();
		 driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		 
		 driver.findElement(By.xpath("//input[@name='password']")).clear();
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);	
		 driver.findElement(By.xpath("//div[text()='Login']")).click();
		 Thread.sleep(2000);
	}
	
	//parallel execution
	@Test()
	public void loginTest2() throws InterruptedException
	{
		WebDriver driver1;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumbar\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
		 driver1 = new ChromeDriver();
		 driver1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver1.manage().deleteAllCookies();
		 driver1.manage().window().maximize();
		 
		 driver1.get("https://freecrm.co.in/");
		 Thread.sleep(2000);
		 driver1.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
	}
	
	@Test(groups = {"smoketest"})
	public void loginTest3() throws InterruptedException
	{
		//Creating a driver object referencing WebDriver interface
        WebDriver driver;
        
        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ankumbar\\Desktop\\Driver\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        
        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        
	}
	
	//grouping 
	@Test(groups = {"smoketest"})
	public void loginTest4() throws InterruptedException
	{
		System.out.println("loginTest4");
        
	}
	
	
	@AfterTest(groups = {"smoketest"})
	public void afterTest()
	{
		System.out.println("aftertest");
		
	}

}
