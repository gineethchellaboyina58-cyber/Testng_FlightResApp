package FlightResevationLibrary;

import org.openqa.selenium.By;

public class ChangePassword extends RegisterUserLogin{
	public void ChangepasswordMethod(String oldpswd,String newpswd,String cfpswd) {
		//click settings
		driver.findElement(By.xpath("//i[@class='fa fa-gear']")).click();
		//click change pswd
		driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-lock']")).click();
		//oldpwd
		driver.findElement(By.xpath("//input[@name='old_password']")).sendKeys(oldpswd);
		//newpwd
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(newpswd);
		//confrom pswd
		driver.findElement(By.xpath("//input[@name='c_password']")).sendKeys(cfpswd);
		//click save
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}

}
