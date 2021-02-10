import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankumbar\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
		 
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();

		 driver.get("https://freecrm.co.in/");
		 // adding comments to new file
	}
	

}
