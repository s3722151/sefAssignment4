import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;  // Import the File class
import java.util.Arrays;

class JobsTest {

	@Test
	void testCase1_validInputs() {
		//Calling the addJob function
		boolean expectedMessage = false;
		//String expectedMessage ="All job information is valid";
		
		//Test data 1
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
				"Melbourne, Victoria, Australia.", 
				"2023-10-01", "Junior",	"Part-Time", 
				skills, 45000, "This person is an intern."); 
		boolean actualMessage = J1.addJob();
		assertEquals(expectedMessage, actualMessage);
		
		//Test Data 2
		String[] skills2 = {"Sl","Access", "Microsoft"};
		Jobs J2 = new Jobs("12345MMM!", "Marketing Manager", "Google Manager", 
				"Melbourne, Victoria, Australia", 
				"2023-10-01", "Senior",
				"Part-Time", skills2, 100000, "This person is a manager."); 
		boolean actualMessage2 = J2.addJob();
		assertEquals(expectedMessage, actualMessage);
//		assertAll ("",()->assertEquals("This cannot work",J1.addJob()),
//				()->assertEquals("This cannot work",J2.addJob())
//				);
//		
	}
	

	

}
