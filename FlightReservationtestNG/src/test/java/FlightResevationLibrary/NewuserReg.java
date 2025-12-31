package FlightResevationLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common_Utilities.AppUtility;

public class NewuserReg extends AppUtility {
	public void NewUserRegistartion(String name,String contact,String email,String password,String gender,String date) {
		//Click Register
		driver.findElement(By.xpath("//a[text()='Register ']")).click();
		//name
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		//contact
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys(contact);
		//email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		//password
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(password);
		//gender
		WebElement	select_element=driver.findElement(By.xpath("//div[@class='col-lg-6']//select"));
		Select items = new Select(select_element);
		items.selectByVisibleText(gender);
		//date
		driver.findElement(By.xpath("//input[@id='popupDatepicker']")).sendKeys(date);
		//click checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//click register
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

}
