package OrangeHRMLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Apputilites;

public class AddEmp extends Apputilites{
	String Emp_Id;
	public boolean Addemployee(String fname,String lname) {
		//click PIM
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		//click addemp
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		//first name field
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
		//last name field
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
		//caputring empID
		  Emp_Id =driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value");
		//click save
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
	
	//public boolean SearchEmp() {
		//click empList
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		//enter value in empInfromation
		driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys(Emp_Id);
		//search
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	boolean res = false;
	  List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']//tr"));
	  for(int i=1;i<rows.size();i++) {
		 List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
		 if(cols.get(1).getText().equals(Emp_Id)) {
			 res = true;
			 
		 }
		 }
	  return res;
	}
	  
	
	//methodOverLoading..
	  
	  public boolean Addemployee(String fname,String mname,String lname) {
			//click PIM
			driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
			//click addemp
			driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
			//first name field
			driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
			//middlename
			driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(lname);
			
			//last name field
			driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
			//caputring empID
			  Emp_Id =driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value");
			//click save
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			
		
		//public boolean SearchEmp() {
			//click empList
			driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
			//enter value in empInfromation
			driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys(Emp_Id);
			//search
			driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
			boolean res = false;
		  List<WebElement> rows=driver.findElements(By.xpath("//table[@id='resultTable']//tr"));
		  for(int i=1;i<rows.size();i++) {
			 List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			 if(cols.get(1).getText().equals(Emp_Id)) {
				 res = true;
				 
			 }
		  }
		  return res;
	  }
}
		  


