package OrangeHRMTestcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import OrangeHRMLogin.AdminLogin;
import Utilities.Apputilites;

public class AdminLoginTestCase extends Apputilites{
	@Parameters({"uname","upswd"})
	@Test
	public void LoginInputs(String uname,String upswd) {
		AdminLogin lp = new AdminLogin();
		lp.AdminwithvalidInputs(uname, upswd);
		boolean res =lp.IsadminModuel();
		Assert.assertTrue(res);
		lp.LogOut();
		 
	}
		

}