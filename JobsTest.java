import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;  // Import the File class
import java.util.Arrays;

class JobsTest {
	// Testing VALID inputs
	@Test
	void testCase1_allValidInputs() {
		boolean expectedMessage = true;		
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

	}
	
//This is testing Function 1, condition 1. 
		@Test // To test invalid character length
		void testCase2_CharacterLength() {
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs charLengthTest1 = new Jobs ("1234", "Data Analyst", "Google Intern", 
				"Melbourne, Victoria, Australia", "2023-10-01", "Junior", "Part-Time", 
				skills, 45000, "This person is an intern.");
			boolean expectedValue = false;
			boolean actualValue = charLengthTest1.invalidJobID(); 
			assertEquals(expectedValue,actualValue);
			
		}
		@Test // Test characters first 5 characters between 1 to 5
		void testCase2_CharacterBelowOne() {
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs charLengthTest2 = new Jobs ("000000", "Data Analyst", "Google Intern", 
				"Melbourne, Victoria, Australia", "2023-10-01", "Junior", "Part-Time", 
				skills, 45000, "This person is an intern.");
			boolean expectedValue2 = false;
			boolean actualValue2 = charLengthTest2.invalidJobID(); 
			assertEquals(expectedValue2,actualValue2);
		}
		
		@Test // Test characters if above 5
		void testCase2_CharacterAboveFive() {
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs charLengthTest3 = new Jobs ("999999999", "Data Analyst", 
			"Google Intern", "Melbourne, Victoria, Australia", "2023-10-01", 
			"Junior", "Part-Time", skills, 45000, "This person is an intern.");
			boolean expectedValue3 = false;
			boolean actualValue3 = charLengthTest3.invalidJobID(); 
			assertEquals(expectedValue3,actualValue3);
		}
		
		@Test // Test characters first 5 characters 6 and 8
		void testCase2_CharSixandEight() {
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs charLengthTest4 = new Jobs ("12345aaa", "Data Analyst", 
			"Google Intern", "Melbourne, Victoria, Australia", "2023-10-01", 
			"Junior", "Part-Time", skills, 45000, "This person is an intern.");
			boolean expectedValue4 = false;
			boolean actualValue4 = charLengthTest4.invalidJobID(); 
			assertEquals(expectedValue4,actualValue4);
		}
		
		@Test // Test the last character
		void testCase2_SpecialLastChar() {
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs charLengthTest5 = new Jobs ("12345AAA9", "Data Analyst", 
			"Google Intern", "Melbourne, Victoria, Australia", "2023-10-01", 
			"Junior", "Part-Time", skills, 45000, "This person is an intern.");
			boolean expectedValue5 = false;
			boolean actualValue5 = charLengthTest5.invalidJobID(); 
			assertEquals(expectedValue5,actualValue5);
		}	
		
		

//This is testing Function 1, condition 2. 
		@Test
		void testCase3_correctDateTest1() {
			Boolean expectedDateFormat = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Melbourne, Victoria, Australia", 
					"2023-10-01", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualDate = J1.invalidDate();
			assertEquals(expectedDateFormat, actualDate);
		}
		@Test
		void testCase3_correctDateTest2() {
			Boolean expectedDateFormat2 = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Melbourne, Victoria, Australia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualDate2 = J1.invalidDate();
			assertEquals(expectedDateFormat2, actualDate2);
		}
		@Test
		void testCase4_incorrectDateTest1() {
			Boolean expectedDateFormat3 = false;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Melbourne, Victoria, Australia", 
					"01-10-1999", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualDate3 = J1.invalidDate();
			assertEquals(expectedDateFormat3, actualDate3);
		}
		@Test
		void testCase4_incorrectDateTest2() {
			Boolean expectedDateFormat4 = false;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Melbourne, Victoria, Australia", 
					"01101999", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualDate4 = J1.invalidDate();
			assertEquals(expectedDateFormat4, actualDate4);
		}
			
		
		
//This is testing Function 1, condition 3.
		@Test
		void testCase5_correctAddress1() {
			Boolean expectedAddress = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Melbourne, Victoria, Australia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualAddress = J1.invalidAddress();
			assertEquals(expectedAddress, actualAddress);
		}
		@Test
		void testCase5_correctAddress2() {
			Boolean expectedAddress = true;
			//Test data 2
			String[] skills = {"SQL","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, sAustralia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualAddress = J1.invalidAddress();
			assertEquals(expectedAddress, actualAddress );
		}
		@Test
		void testCase6_incorrectAddressTest1() {
			Boolean expectedAddress = false;
			//Test data 3
			String[] skills = {"SQL","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Melbourne, Victoria, ", 
					"01-10-1999", "Junior",	"Part-Time", 
					skills, 45000, "This person is an intern."); 
			Boolean actualAddress2  = J1.invalidAddress();
			assertEquals(expectedAddress, actualAddress2);
			
		}
	    @Test
	    void testCase6_incorrectAddressTest2() {
	        boolean expectedAddress = false;
	        String[] skills = {"SQL", "Access", "Microsoft"};
	        Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern",
	                "Melbourne",
	                "01-10-1999", "Junior", "Part-Time",
	                skills, 45000, "This person is an intern.");
	        boolean actualAddress3 = J1.invalidAddress();
	        assertEquals(expectedAddress, actualAddress3);
	    }

//This is testing Function 1, condition 4. 
	    @Test
    	void testCase7_correctSalary1() {
	    	Boolean expectedSalary = true;
	    	//Test data 1
	    	String[] skills = {"SQl","Access", "Microsoft"};
	    	Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
	    	"Melbourne, Victoria, Australia", 
	    	"2023-09-01", "Senior",	"Part-Time", 
	    	skills, 100000, "This person is an intern."); 
	    	Boolean actualSalary = J1.invalidSeniorSalary();
	    	assertEquals(expectedSalary, actualSalary );
	    	}
	    @Test
	    void testCase7_correctSalary2() {
	    	Boolean expectedSalary = true;
	    	//Test data 1
	    	String[] skills = {"SQl","Access", "Microsoft"};
	    	Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
	    	"Melbourne, Victoria, Australia", 
	    	"2023-09-01", "Executives",	"Part-Time", 
	    	skills, 100000, "This person is an intern."); 
	    	Boolean actualSalary = J1.invalidSeniorSalary();
	   		assertEquals(expectedSalary, actualSalary );
	    	}
	    	@Test
	    void testCase8_incorrectSalary1() {
    		Boolean expectedSalary = false;
    		//Test data 1
    		String[] skills = {"SQl","Access", "Microsoft"};
    		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
    		"Melbourne, Victoria, Australia", 
			"2023-09-01", "Senior",	"Part-Time", 
			skills, 99999, "This person is an intern."); 
    		Boolean actualSalary = J1.invalidSeniorSalary();
    		assertEquals(expectedSalary, actualSalary );
	    	}
	    @Test
	    void testCase8_incorrectSalary2() {
    		Boolean expectedSalary = false;
    		//Test data 1
    		String[] skills = {"SQl","Access", "Microsoft"};
    		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
    		"Melbourne, Victoria, Australia", 
			"2023-09-01", "Executive",	"Part-Time", 
			skills, 99999, "This person is an intern."); 
    		Boolean actualSalary = J1.invalidSeniorSalary();
    		assertEquals(expectedSalary, actualSalary );
	    	}
	  
	    
	    
//This is testing Function 1, condition 5. 
		@Test
		void testCase9_correctSalary1() {
			Boolean expectedSalary = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
				"Melbourne, Victoria, Australia", 
				"2023-09-01", "Junior",	"Part-Time", 
				skills, 45000, "This person is an intern."); 
			Boolean actualSalary = J1.invalidJunior();
			assertEquals(expectedSalary, actualSalary );
		}
		@Test
		void testCase9_correctSalary2() {
			Boolean expectedSalary = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 70000, "This person is an intern."); 
			Boolean actualSalary = J1.invalidJunior();
			assertEquals(expectedSalary, actualSalary );
		}
		@Test
		void testCase10_incorrectSalary() {
			Boolean expectedSalary = false;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 39999, "This person is an intern."); 
			Boolean actualSalary = J1.invalidJunior();
			assertEquals(expectedSalary, actualSalary );
		}
		@Test
		void testCase10_incorrectSalary2() {
			Boolean expectedSalary = false;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 70001, "This person is an intern."); 
			Boolean actualSalary = J1.invalidJunior();
			assertEquals(expectedSalary, actualSalary );
		}
		
		
		

//This is testing Function 1, condition 6.
		@Test
		void testCase11_correctJobMatch1() {
			Boolean expectedJobMatch = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Junior",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualJobMatch = J1.invalidJobTypeforEXP();
			assertEquals(expectedJobMatch, actualJobMatch );
		}
		@Test
		void testCase11_correctJobMatch2() {
			Boolean expectedJobMatch = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Medium",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualJobMatch = J1.invalidJobTypeforEXP();
			assertEquals(expectedJobMatch, actualJobMatch );
		}
		@Test
		void testCase12_incorrectJobMatch1() {
			Boolean expectedSalary = false;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Senior",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualSalary = J1.invalidJobTypeforEXP();
			assertEquals(expectedSalary, actualSalary );
		}
		@Test
		void testCase12_incorrectJobMatch2() {
			Boolean expectedSalary = false;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Executive",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualSalary = J1.invalidJobTypeforEXP();
			assertEquals(expectedSalary, actualSalary );
		}
		
		

//This is testing Function 1, condition 7.	
		@Test
		void testCase13_correctSkillInput1() {
			Boolean expectedSkillInput = true;
			//Test data 1
			String[] skills = {"SQl","Access", "Microsoft"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Executives",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualSkillInput = J1.invalidWordCountSkill();
			assertEquals(expectedSkillInput , actualSkillInput );
		}
		@Test
		void testCase13_correctSkillInput2() {
			Boolean expectedSkillInput2 = true;
			//Test data 1
			String[] skills = {"C++","Sharp", "Python"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Executives",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualSkillInput2 = J1.invalidWordCountSkill();
			assertEquals(expectedSkillInput2 , actualSkillInput2 );
		}
		@Test
		void testCase14_incorrectcorrectSkillInput1() {
			Boolean expectedSkillInput3  = false;
			//Test data 1
			String[] skills = {"Excel","Microsoft", "SQL","Python"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Senior",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualSkillInput3 = J1.invalidWordCountSkill();
			assertEquals(expectedSkillInput3 , actualSkillInput3 );
		}
		@Test
		void testCase14_incorrectcorrectSkillInput2() {
			Boolean expectedSkillInput4  = false;
			//Test data 1
			String[] skills = {"Excels in SQL","Access", "Java"};
			Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
					"Sydney, New South Wales, Australia", 
					"2023-09-01", "Senior",	"Part-Time", 
					skills, 100000, "This person is an intern."); 
			Boolean actualSkillInput4 = J1.invalidWordCountSkill();
			assertEquals(expectedSkillInput4 , actualSkillInput4 );
		}


	
	    
//	This is testing Function 2, condition 1. 	
	@Test 
	void testCase15_correctAddJob1() {
		Boolean expectedJobMatch = true;
		//Test data 1
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
				"Sydney, New South Wales, Australia", 
				"2023-09-01", "Junior",	"Part-Time", 
				skills, 45000, "This person is an intern."); 
		Boolean actualJobMatch = J1.inputValid();
		assertEquals(expectedJobMatch, actualJobMatch );
	}
	
	@Test
	void testCase15_correctAddJob2() {
		Boolean expectedJobMatch = true;
		//Test data 1
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
				"Sydney, New South Wales, Australia", 
				"2023-09-01", "Medium",	"Part-Time", 
				skills, 100000, "This person is an intern."); 
		Boolean actualJobMatch = J1.inputValid();
		assertEquals(expectedJobMatch, actualJobMatch );
	}
	@Test
	void testCase16_incorrectAddJob1() {
		Boolean expectedSalary = false;
		//Test data 1
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs J1 = new Jobs("12345MMM!", "Data Analyst", "Google Intern", 
				"Sydney, New South Wales, Australia", 
				"2023-09-01", "Junior",	"Part-Time", 
				skills, 39000, "This person is an intern."); 
		Boolean actualSalary = J1.inputValid();
		assertEquals(expectedSalary, actualSalary );
	}
	@Test
	void testCase16_incorrectAddJob2() {
		Boolean expectedSalary = false;
		//Test data 1
		String[] skills = {"SQl","Access", "Microsoft"};
		Jobs J1 = new Jobs("12345M!", "Data Analyst", "Google Intern", 
				"Sydney, New South Wales, Australia", 
				"2023-09-01", "Junior",	"Part-Time", 
				skills, 45000, "This person is an intern."); 
		Boolean actualSalary = J1.inputValid();
		assertEquals(expectedSalary, actualSalary );
	}
	

	

}
