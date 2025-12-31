package Utilities;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Apputilites {
    public static String Url="http://orangehrm.qedgetech.com/";
	public static WebDriver driver;
	
	@BeforeSuite
	public static void open_Bsr() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	 public void loginpageDisplay() {
			boolean page=driver.findElement(By.linkText("LOGIN")).isDisplayed();
			if(page) {
				System.out.println("Test Pass");
			}else {
				System.out.println("Test Fail");
			}
		    
		}
	@AfterSuite
	public static void CloseWindow() {
		driver.close();
		
	}
	public static void waitTime() throws InterruptedException {
		Thread.sleep(3000);
	}

}
