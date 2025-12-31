package FlightResevationLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Common_Utilities.AppUtility;

public class FlightBooking extends AppUtility{
	
	
	public boolean UserFlightBooking(String dob,String flyfrom,String flyto,String flightname,String deptime,String personname,String Flight_tier) throws InterruptedException{
		String BookDate = dob;
		String[] split_date =BookDate.split("-");
		String day =split_date[0];
		String mnth =split_date[1];
		String year =split_date[2];
		
		
		driver.findElement(By.xpath("//input[@id='search-date']")).click();
		
	
	  //year 
		    String cal_yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		    while (!cal_yr.equals(year)) {
		   	 driver.findElement(By.xpath("//span[text()='Next']")).click();
		   	 cal_yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		   	 }
		    
	  //mnth
		    String cal_mnth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		    while(!cal_mnth.equals(mnth)) {
		    	driver.findElement(By.xpath("//span[text()='Next']")).click();
		    	cal_mnth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		    	
		    }
	  //day
		    
		   List<WebElement>day_list= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		   for(WebElement day_element : day_list) {
			   if(day_element.getText().equals(day)) {
				   day_element.click();
				   break;
			   }
		   }
		   
	  //flyfrom
		   
		  WebElement select_fly =driver.findElement(By.xpath("//select[@class='form-control col-md-3 search_fileds  sf2']"));
		  Select sc = new Select(select_fly);
		  sc.selectByVisibleText(flyfrom);
		    
     //flyTo
		  WebElement select_flyto =driver.findElement(By.xpath("//select[@class='form-control col-md-3 search_fileds  sf3']"));
		  Select sc1 = new Select(select_flyto);
		  sc1.selectByVisibleText(flyto);
		  
	//click search
		  
		  driver.findElement(By.xpath("//div[@class='col-md-2 no-padding']")).click();
		  Thread.sleep(3000);
		  
	//flighttable
		  
		  WebElement tablElement = driver.findElement(By.xpath("//div[@class='modal-content']//table[@class='flights_table']"));
		   List<WebElement> tabrows= tablElement.findElements(By.xpath("//table[@class='flights_table']//tr//td[1]"));
		   List<WebElement> tabrows2= tablElement.findElements(By.xpath("//table[@class='flights_table']//tr//td[3]"));
		   for(int i=1;i<tabrows.size();i++){
			  String flight_name=tabrows.get(i).getText().trim();
			  String Dep_name=tabrows2.get(i).getText().trim();
			  
				  if(flight_name.equalsIgnoreCase(flightname)&& Dep_name.equalsIgnoreCase(deptime)) {
					  WebElement target=tabrows.get(i).findElement(By.xpath("./parent::tr/td[9]"));
					  Thread.sleep(2000);
					  target.click();
					  break;
				  }
			  }
		   
	//name 
		   driver.findElement(By.xpath("//input[@id='name']")).sendKeys(personname);
		   
	//typeofclass
		   List<WebElement> radio= driver.findElements(By.xpath("//div[@class='radio_b']//input"));
			  for(WebElement element :radio) {
				  String flight_Class = element.getAttribute("value");
				  if(flight_Class.equalsIgnoreCase(Flight_tier)) {
					  element.click();
					  
				  }
				  
			  }
			  
			  
	//click insert
			  driver.findElement(By.xpath("//button[text()='Insert Order']")).click();
			   
	//click view ticket
			  driver.findElement(By.xpath("//a[text()='View Ticket']")).click();
			  
			  
			   //orderid
			   
			  String order_txt= driver.findElement(By.xpath("(//div[@class='stats']/div)[1]")).getText();
			  String Order_Id=order_txt.replace("Order ID", "").trim();
			  
			    
			   
			   //flight bookings
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//i[contains(@class,'fa fa-list')]")).click();
			   
			   //loop for page
			  boolean OrderId = false;
			  List<WebElement> pages= driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
			  if(pages.isEmpty()) {
				  return current_order(Order_Id);
			  }
			  
			 
			  for(int i=1;i<pages.size();i++) {
				
				  if(current_order(Order_Id)) {
					  OrderId=true;
					  break;
				  }
				  if(i<pages.size()) {
					  pages= driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
					  pages.get(i).click();
				  }
			    	   
			       }
			 
		    return OrderId;

		}        
		
		
		private boolean current_order(String Order_Id) {
			List<WebElement> row = driver.findElements(By.xpath("//table[@class='flights_table']//tr"));
		       for(int j=1;j<row.size();j++) {
		    	  WebElement firstCol = row.get(j).findElement(By.xpath("./td[1]"));
		    	  String rowOrder = firstCol.getText().trim();
		    	   if(rowOrder.equalsIgnoreCase(Order_Id)) {
		    		  row.get(j).findElement(By.xpath("./td[10]/a[3]")).click();
		    		  driver.switchTo().alert().accept();
		    			
		    			return true;
		    		   }
		    	   }
		       return false;
			
			
		}

		   
		  
		   
		   
		    
		    
	}
		



