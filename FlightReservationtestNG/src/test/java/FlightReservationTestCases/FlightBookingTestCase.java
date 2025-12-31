package FlightReservationTestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FlightResevationLibrary.FlightBooking;
import FlightResevationLibrary.RegisterUserLogin;

public class FlightBookingTestCase extends RegisterUserLogin {
	@Parameters({"email","password","date","flyfrom","flyto","flightname","DepTime","person_name","class_val"})
	@Test
	public void UserFlightBookingTestCase(String email,String pswd,String dob,String flyfrom,String flyto,String flightname,String deptime,String personname,String Flight_tier) throws InterruptedException {
		RegisteredUserlogin(email, pswd);
		
		FlightBooking fb = new FlightBooking();
		fb.UserFlightBooking(dob,flyfrom,flyto,flightname,deptime,personname,Flight_tier);
		
		Logout();
	}

}
