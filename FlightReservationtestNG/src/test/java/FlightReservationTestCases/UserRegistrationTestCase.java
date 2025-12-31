package FlightReservationTestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common_Utilities.AppUtility;

import FlightResevationLibrary.NewuserReg;

public class UserRegistrationTestCase extends NewuserReg {
	@Parameters({"name","contact","email","password","gender","date"})
	@Test
	public void UserLogin(String name,String contact,String email,String pswd,String gender, String date) {
		
		NewUserRegistartion(name, contact, email, pswd, gender, date);
		
	}

}
