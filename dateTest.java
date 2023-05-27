import static org.junit.Assert.assertEquals;

import java.io.File; // https://www.w3schools.com/java/java_files_create.asp
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.StringTokenizer;
import java.util.regex.*;
import java.util.regex.Pattern;
import org.junit.Test;

import java.util.regex.Matcher;

class dateTest {

	@Test
	void correctDateTest() {
		Boolean expectedDateFormat = true;
		//Test data 1
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
				"Melbourne, Victoria, Australia", 
				"2023-10-01", "Junior",	"Part-Time", 
				skills, 45000, "This person is an intern."); 
		Boolean actualMessage = J1.addJob();
		assertEquals(expectedDateFormat, actualMessage);
	}



}
