package Common_Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class AppUtility {
	
	public static WebDriver driver; 
	public static String Url="https://flights.qedgetech.com/";
	@BeforeSuite
	public static void OpenBswr() {
		driver =  new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
    @AfterSuite
    public static void CloseBswr() {
    	driver.close();
    }

}
