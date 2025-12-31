package OrangeHRMLogin;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utilities.Apputilites;

public class AdminLogin extends Apputilites {
	
	
	public void AdminwithvalidInputs(String uname,String upswd) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(upswd);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
	}
	public boolean IsadminModuel() {
		boolean res=false;
		String curl =driver.getCurrentUrl().toLowerCase();
		if(curl.contains("dashboard")) {
			res=true;
		}
		return res;
	}
	public void LogOut() {
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
