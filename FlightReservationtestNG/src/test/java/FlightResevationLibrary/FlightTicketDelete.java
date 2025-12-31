package FlightResevationLibrary;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common_Utilities.AppUtility;

public class FlightTicketDelete extends RegisterUserLogin{
	public boolean FlightTicketDeletedmethod(String orderIdTxt) {
		driver.findElement(By.xpath("//a/i[@class='fa fa-list']")).click();
		
		
		

	
	/*	// Now locate again
		List<WebElement> orderid_td =driver.findElements(By.xpath("//table//tr/td[1]"));
		for(int i=0;i<orderid_td.size();i++) {
			if(orderid_td.get(i).getText().equals(orderIdTxt)) {
				orderid_td.get(i).findElement(By.xpath("./following-sibling::td/a[text()=' Delete']")).click();
				driver.switchTo().alert().accept();
			}
		}*/
		//driver.findelement(by.xpath("//table//tr/td[1][text()='"+orderIdTxt+']"+"/following-sibling::td/a[text()=' Delete']"))
		
		
		
		driver.findElement(By.xpath("//table//tr/td[1][text()='"+orderIdTxt+"']"+"/following-sibling::td/a[text()=' Delete']")).click();
        driver.switchTo().alert().accept();

		
		
		
	   String txtmsg =driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	  
	   boolean res=false;
	   if(txtmsg.contains("deleted!")) {
		   res=true;
	   }
	   return res;
		
		
	}

}
