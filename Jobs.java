import java.io.File; // https://www.w3schools.com/java/java_files_create.asp
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.StringTokenizer;
import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*; // This to make a new line when writing to the TXT file. 

public class Jobs {
	private String jobNumber;
	private String jobTitle;
	private String jobPosterName;
	private String jobPosterAddress;
	private String jobPostedDate;
	private String joExperienceLevel; // Four job experience level: Junior, Medium, Senior, Executive
	private String jobType; //Four job types: Full-time, Part-time, Internship, Volunteer
	private String[] jobRequiredSkills; //A set of skills; each skill is 1 word (e.g., C#) or a maximum if two words (e.g., Software Architecture)
	private double jobSalary;
	private String jobDescription;
	
	//Constructor. 
	public Jobs (String number, String title, String postername, String posteraddress, String date,
			String experiencelevel, String type, String[] skills, double salary, String description)
	{
		//This references class Jobs - to intialise the variables. 
		jobNumber = number;
		jobTitle = title;
		jobPosterName = postername;
		jobPosterAddress = posteraddress;
		jobPostedDate = date;
		joExperienceLevel = experiencelevel;
		jobType = type;
		jobRequiredSkills = skills;
		jobSalary = salary;
		jobDescription = description;
	}
	public boolean addJob()
	{
		if(invalidJobID()==false) { // Cond. 1
			System.out.println("Job Number should have 9 numbers, the first 5 being numbers.");
			return false;
		}
		else if(invalidDate()==false) { // Cond. 2
			System.out.println("A Senior or Executive should make over 100000.");
			return false;
		}
		
		else if(invalidAddress()==false) { // Cond. 3
			System.out.println("The address format follows: City, State, Country.");
			return false;
		}
		else if(invalidSeniorSalary()==false) { // Cond. 4
			System.out.println("A Senior or Executive should make over 100000.");
			return false;
		}
		else if(invalidJunior()==false) { // Cond. 5
			System.out.println("A Junior should make between 40000 to 70000.");
			return false;
		}	
		else if(invalidJobTypeforEXP()==false) { // Cond. 6
			System.out.println("A Senior or Executive should make over 100000.");
			return false;
		}
		else {
			System.out.println("All inputs are valid. Writing to the file!");
			try {
				FileWriter myWriter = new FileWriter("C:\\Users\\User\\eclipse-workspace\\Assignment4\\.filename.txt");
//			      myWriter.write(jobNumber +"\n");
//			      myWriter.write(jobTitle+"\n");
//			      myWriter.write(jobPosterName+"\n");
//			      myWriter.write(jobPosterAddress+"\n");
//			      myWriter.write(jobPostedDate+"\n");
//			      myWriter.write(joExperienceLevel+"\n");
//			      myWriter.write(jobType+"\n");
//			      //Convert array to String - Digital Ocean
//			      String convertArray = jobRequiredSkills.toString(); 
//			      myWriter.write(convertArray+"\n");
//			      myWriter.write((int) jobSalary+"\n");
//			      myWriter.write(jobDescription+"\n");	
//			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
				}
			catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();			
		}
		return true;
	}
		
		 // Print the results to a TEXT file. https://www.w3schools.com/java/java_files_create.asp
		
	}// End of addJOB

			//Condition 1:Check if the input for Job Number is correct. 
			//Source: Baeldung - Check IF A String is numeric in Java
			public boolean invalidJobID() {
				if(jobNumber.length()!=9) {
					System.out.println("The job number does not have 9 characters");
					return false; //invalid id 
				}
				Boolean checkNumber = jobNumber.substring(0,4).matches("[0-5]");
				if(checkNumber == false) {
					System.out.println("Job Number needs numbers in characters 1-5");
					return false;
				}
				Boolean checkCharacter = jobNumber.substring(5,7).matches("[A-Z]");
				if(checkCharacter == false) {
					System.out.println("Job Number needs numbers thrugh characters 6-8");
					return false;
				}
				Boolean checkSpecial = jobNumber.substring(8).matches("[^a-zA-Z0-9]");
				if(checkSpecial == false) {
					System.out.println("Job Number needs a special character on the 9th");
					return false;
				}
				return true; // this means the id Valid
				}
			
			//Condition 2:Check if the date is in the right format.
			public boolean invalidDate() {
				Boolean checkDateFormat = jobPostedDate.matches("(^20[0-9]{2})(-)([0-9]{2})(-)([0-9]{2})");{
					if(checkDateFormat == false) {
						System.out.println("Date needs to be in YYYY-MM-DD format");
						return false;
					}			
				}
				return true;			
			}
			
			//Condition 3:Check if the jobPosterAddress is in the correct format 
			public boolean invalidAddress() {
				if(jobPosterAddress.equals("^[A-Za-z ]+, [A-Za-z ]+(, [A-Za-z ]+?\\.?$")) {
					System.out.println("Address format is: City, State, County.");
					return false;
				}
				return true;
			}
			//Condition 4: Check if the salary for executives is less than 100000 
			public boolean invalidSeniorSalary() {
					if(this.joExperienceLevel.equals("Executve") && this.jobSalary < 100000 ) {
					System.out.println("An Executive salary must be 100000 or more");
					return false;
				}
					else if(this.joExperienceLevel.equals("Senior") && this.jobSalary < 100000 ) {
					System.out.println("A Senior salary must be 100000 or more");
					return false;
				}
				return true;
			}
			//Condition 5:Check if the salary for juniors is between 40000 and 70000 
			public boolean invalidJunior() {
					if(this.joExperienceLevel.equals("Junior") && (this.jobSalary < 40000 || this.jobSalary > 70000)) {
					System.out.println("A junior salary must be between 40000 and 70000.");
					return false;
				}
				return true;
			}
			//Condition 6:Check if Job Type matches the Job Experience
			public boolean invalidJobTypeforEXP() {
					if(this.jobType.equals("Part-Time") && (this.joExperienceLevel.equals("Executive"))) {
					System.out.println("A part timer cannot have Executive experience."); 
					return false;				
			}
					else if(this.jobType.equals("Part-Time") && this.joExperienceLevel.equals("Senior")) {
					System.out.println("A part timer cannot have Senior experience."); 
					return false;				
			}
				return true;
			}
			//Condition 7:This is to count number of words in skills
			public boolean invalidWordCountSkill() {
				return true;
			}							
				public int countWordsRequiredSkills (String jobRequiredSkills)
				{
				StringTokenizer stringTokenizer1 = new StringTokenizer(jobRequiredSkills);
				return stringTokenizer1.countTokens();
				}
		
	public boolean updateJob()
	{
	
		return true;
	}
		         public boolean invalidAddJob() {
		        	 if (addJob()==false) {
		        		 System.out.println("The addJob condition has not been accomplished");
		        		 return false;
		        	 }			
					return true;
				}
				public boolean invalidSalaryIncrease() {
					return true;
				}
				public boolean invalidJobTypeChange() {
					return true;
				}
	
		
		 public static void main(String[]args){
		    //Auto-generated method stub
		    String [] array ={"AA AA","AA,AA"}; // @@ This is IMPORTANT to initialise array 
		   // Jobs job = new Jobs("12345AAA!","A","B","C","2023-10-01","E","F",array,40000,"This is text");
		    
		    // This prints out the memory location of the object
		    //System.out.println(job);
		    }

		 

}


