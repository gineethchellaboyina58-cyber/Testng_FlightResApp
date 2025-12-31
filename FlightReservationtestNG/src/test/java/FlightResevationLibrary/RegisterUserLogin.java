package FlightResevationLibrary;

import org.openqa.selenium.By;

import Common_Utilities.AppUtility;

public class RegisterUserLogin extends AppUtility{
	public boolean RegisteredUserlogin(String email, String pswd) {
		//email & pswd then click
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pswd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean res=false;
		String ptitle =driver.getTitle().toLowerCase();
		if(ptitle.contains("dashboard")) {
			res=true;
		}
		return res;
	}
	
	public void Logout() {
		driver.findElement(By.xpath("//div[@class='dropdown account-menu-dropdown']")).click();
	    driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		
	}

}
