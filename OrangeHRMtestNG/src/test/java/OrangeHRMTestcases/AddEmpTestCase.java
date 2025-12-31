package OrangeHRMTestcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import OrangeHRMLogin.AddEmp;
import OrangeHRMLogin.AdminLogin;
import Utilities.Apputilites;

public class AddEmpTestCase extends Apputilites {
	@Parameters({"uname","upswd","firstname","lastname"})
	@Test
	public void LoginAdmin(String uname,String pswd,String fname,String lname) {
		AdminLogin lp = new AdminLogin();
		lp.AdminwithvalidInputs(uname,pswd);
		
		AddEmp emp = new AddEmp();
	    boolean	res=emp.Addemployee(fname,lname);
	    Assert.assertTrue(res);
	    lp.LogOut();
		
	    
		
		}
	
	

}
