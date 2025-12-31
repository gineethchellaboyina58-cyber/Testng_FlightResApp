package FlightReservationTestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FlightResevationLibrary.RegisterUserLogin;

public class ResterUserTestCase extends RegisterUserLogin{
	@Parameters({"email","password"})
	@Test
	
	public void ResterUsertestcase(String email, String pswd) {
	boolean	res=RegisteredUserlogin(email, pswd);
	Assert.assertTrue(res);
	Logout();
	
		
	}

}
