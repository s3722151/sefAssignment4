import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class jobIDTest {	
	@Test // To test invalid character length
	void testCharacterLength() {
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs charLengthTest1 = new Jobs ("1234", "Data Analyst", "Google Intern", 
			"Melbourne, Victoria, Australia", "2023-10-01", "Junior", "Part-Time", 
			skills, 45000, "This person is an intern.");
		boolean expectedValue = false;
		boolean actualValue = charLengthTest1.invalidJobID(); 
		assertEquals(expectedValue,actualValue);
		
	}
	void testCharacterBelowOne() {
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs charLengthTest2 = new Jobs ("000000", "Data Analyst", "Google Intern", 
			"Melbourne, Victoria, Australia", "2023-10-01", "Junior", "Part-Time", 
			skills, 45000, "This person is an intern.");
		boolean expectedValue2 = false;
		boolean actualValue2 = charLengthTest2.invalidJobID(); 
		assertEquals(expectedValue2,actualValue2);
	}
		
	void testCharacterAboveFive() {
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs charLengthTest3 = new Jobs ("999999999", "Data Analyst", 
		"Google Intern", "Melbourne, Victoria, Australia", "2023-10-01", 
		"Junior", "Part-Time", skills, 45000, "This person is an intern.");
		boolean expectedValue3 = false;
		boolean actualValue3 = charLengthTest3.invalidJobID(); 
		assertEquals(expectedValue3,actualValue3);
	}
	
	void testCharSixandEight() {
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs charLengthTest4 = new Jobs ("12345aaa", "Data Analyst", 
		"Google Intern", "Melbourne, Victoria, Australia", "2023-10-01", 
		"Junior", "Part-Time", skills, 45000, "This person is an intern.");
		boolean expectedValue4 = false;
		boolean actualValue4 = charLengthTest4.invalidJobID(); 
		assertEquals(expectedValue4,actualValue4);
	}
	void testSpecialLastChar() {
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs charLengthTest5 = new Jobs ("12345AAA9", "Data Analyst", 
		"Google Intern", "Melbourne, Victoria, Australia", "2023-10-01", 
		"Junior", "Part-Time", skills, 45000, "This person is an intern.");
		boolean expectedValue5 = false;
		boolean actualValue5 = charLengthTest5.invalidJobID(); 
		assertEquals(expectedValue5,actualValue5);
	}	

}
