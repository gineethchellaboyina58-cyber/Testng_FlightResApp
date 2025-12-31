package FlightReservationTestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import FlightResevationLibrary.FlightTicketDelete;

public class FlightTicketDeleteTestCase extends FlightTicketDelete {
	@Parameters({"email","password","orderID"})
	@Test
	public void TicketDeletedtestCase(String email,String pswd,String orderIdTxt) {
		RegisteredUserlogin(email, pswd);
	  
	  boolean res= FlightTicketDeletedmethod(orderIdTxt);
	  Assert.assertTrue(res);
	  Logout();
		
		
		
		
	}
	

}
