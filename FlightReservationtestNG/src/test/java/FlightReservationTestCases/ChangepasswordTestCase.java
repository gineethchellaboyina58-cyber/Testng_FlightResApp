package FlightReservationTestCases;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FlightResevationLibrary.ChangePassword;

public class ChangepasswordTestCase extends ChangePassword {
	@Parameters({"email","password","oldpswd","newpswd","cofpswd","email2","password2"})
	@Test
	public void Changepasswordtest(String email, String pswd, String oldpswd,String newpswd, String cofpswd,String email1, String cofpswd1){
		
		RegisteredUserlogin(email, pswd);
		ChangepasswordMethod(oldpswd, newpswd, cofpswd);
		Logout();
		boolean res=RegisteredUserlogin(email, cofpswd);
		Assert.assertTrue(res);
		
		Logout();
	}
	

}
