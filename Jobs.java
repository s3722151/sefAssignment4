import java.io.File; // https://www.w3schools.com/java/java_files_create.asp
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; // This is to accept user input
import java.util.StringTokenizer; // This is to count the words
import java.util.regex.*; // This is to deploy regular patterns
import java.util.regex.Pattern; // This is to deploy regular patterns
import java.util.regex.Matcher; // This is to deploy regular patterns
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
	
//	Constructor - used to create instance of the class(preparing to use it)
	public Jobs (String number, String title, String postername, String posteraddress, String date,
			String experiencelevel, String type, String[] skills, double salary, String description)
	{
//		This references class Jobs - to intialise the variables. 
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
	
//	MAIN FUNCTION 1
	public boolean addJob()
	{
		if(!inputValid()) {
			return false;
		}
		System.out.println("All inputs are valid!");
		writeToFile();
		return true;		
	}				
		
//	MAIN FUNCTION 2
	public boolean updateJob()
	{	
		if(!inputValid()) {
			return false;
		}
		if(inputValid() && !invalidJobTypeChange()) {
			return false;
		}
		if(inputValid() && !invalidSalaryIncrease()) {
			return false;
		}	
		appendToFile();
		return true;
	}	
		
		 public static void main(String[]args){
		    //Auto-generated method stub
		    String [] array ={"AA AA","AA","AA"}; // @@ This is IMPORTANT to initialise array 
		    }
		 
//		 Calculation Function 1 
		 public boolean inputValid() {
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
				else if(invalidWordCountSkill()==false) { // Cond. 7
					System.out.println("There should be between 1 to 3 job skills.");
					return false;
				}
				
				return true;
			}
//		 Method to write to file
		 private void writeToFile() {
			try {
//			FileWriter myWriter = new FileWriter("C:\\Users\\User\\eclipse-workspace\\Assignment4\\.filename.txt", true);
			FileWriter myWriter = new FileWriter("filename.txt");
		      myWriter.write(jobNumber +"\n");
		      myWriter.write(jobTitle+"\n");
		      myWriter.write(jobPosterName+"\n");
		      myWriter.write(jobPosterAddress+"\n");
		      myWriter.write(jobPostedDate+"\n");
		      myWriter.write(joExperienceLevel+"\n");
		      myWriter.write(jobType+"\n");
		      //Convert array to String - Digital Ocean
		      String convertArray = jobRequiredSkills.toString(); 
		      myWriter.write(convertArray+"\n");
		      myWriter.write(Double.toString(jobSalary)+"\n");
		      myWriter.write(jobDescription+"\n");	
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();	
	      // Print the results to a TEXT file. https://www.w3schools.com/java/java_files_create.asp
			}
 }
//		 Method to append to file
		 private void appendToFile() {
			try {
			FileWriter myWriter = new FileWriter("filename.txt", true);
		      myWriter.append(joExperienceLevel+"\n");
		      myWriter.append(jobType+"\n");
		      myWriter.append((int) jobSalary+"\n");
		      myWriter.close();
		      System.out.println("Successfully appended to the file.");
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();	
	      // Print the results to a TEXT file. https://www.w3schools.com/java/java_files_create.asp
			}
 }
		 
//		    Calculation Function 1 Condition 1:Check if the input for Job Number is correct. 
//			Source: Baeldung - Check IF A String is numeric in Java
			public boolean invalidJobID() {
				if(jobNumber.length()!=9) {
					System.out.println("The job number does not have 9 characters");
					return false; //invalid id 
				}
				Boolean checkNumber = jobNumber.substring(0,4).matches("[1-5]+");
				if(checkNumber == false) {
					System.out.println("Job Number needs numbers in characters 1-5");
					return false;
				}
				Boolean checkCharacter = jobNumber.substring(5,7).matches("[A-Z]+");
				if(checkCharacter == false) {
					System.out.println("Job Number needs numbers thrugh characters 6-8");
					return false;
				}
				Boolean checkSpecial = jobNumber.substring(8).matches("^[!@#$%^&*(),.?\":{}|<>]*$");
				if(checkSpecial == false) {
					System.out.println("Job Number needs a special character on the 9th");
					return false;
				}
				return true; // this means the id Valid
				}
			
//			Calculation Function 1 Condition 2:Check if the date is in the right format.
			public boolean invalidDate() {
				Boolean checkDateFormat = jobPostedDate.matches("(^20[0-9]{2})(-)([0-9]{2})(-)([0-9]{2})+");{
					if(checkDateFormat == false) {
						System.out.println("Date needs to be in YYYY-MM-DD format");
						return false;
					}			
				}
				return true;			
			}
			
//			Calculation Function 1 Condition 3:Check if the jobPosterAddress is in the correct format 
			public boolean invalidAddress() {
				if(jobPosterAddress.matches("^[A-Z][A-Za-z]*(?:\\\\s[A-Z][A-Za-z]*)*,\\\\s[A-Z][A-Za-z]*(?:\\\\s[A-Z][A-Za-z]*)*,\\\\s[A-Z][A-Za-z]*(?:\\\\s[A-Z][A-Za-z]*)*\\\\.$")) {
					System.out.println("Address format is: City, State, Country.");
					return false;
				}
				return true;
			}
//			Calculation Function 1 Condition 4: Check if the salary for executives is less than 100000 
			public boolean invalidSeniorSalary() {
					if(this.joExperienceLevel.equalsIgnoreCase("Executive") && this.jobSalary < 100000 ) {
					System.out.println("An Executive salary must be 100000 or more");
					return false;
				}
					else if(this.joExperienceLevel.equalsIgnoreCase("Senior") && this.jobSalary < 100000 ) {
					System.out.println("A Senior salary must be 100000 or more");
					return false;
				}
				return true;
			}
//			Calculation Function 1 Condition 5:Check if the salary for juniors is between 40000 and 70000 
			public boolean invalidJunior() {
					if(this.joExperienceLevel.equalsIgnoreCase("Junior") && (this.jobSalary < 40000 || this.jobSalary > 70000)) {
					System.out.println("A junior salary must be between 40000 and 70000.");
					return false;
				}
				return true;
			}
//			Calculation Function 1 Condition 6:Check if Job Type matches the Job Experience
			public boolean invalidJobTypeforEXP() {
					if(this.jobType.equalsIgnoreCase("Part-Time") && (this.joExperienceLevel.equalsIgnoreCase("Executive"))) {
					System.out.println("A part timer cannot have Executive experience."); 
					return false;				
			}
					else if(this.jobType.equalsIgnoreCase("Part-Time") && this.joExperienceLevel.equalsIgnoreCase("Senior")) {
					System.out.println("A part timer cannot have Senior experience."); 
					return false;				
			}
				return true;
			}
			
//			Calculation Function 1 Condition 7
			public boolean invalidWordCountSkill() {
//				1.Count the words, make invalid when more than 3 or less than 0
				if (jobRequiredSkills.length > 3 || jobRequiredSkills.length <=0 ) {
					System.out.println("Invalid input. You must enter 1 to 3 jobskills.");
					return false;
				}
//				2.Count the words per index, make invalid when greater than 3
				for (String skill : jobRequiredSkills) {
					StringTokenizer tokenizer = new StringTokenizer(skill);
					int wordCount = tokenizer.countTokens();
					if (wordCount > 2) {
						System.out.println("Invalid input. Each skill should have a maximum of two words.");
						return false;
					}
				}
				return true;
			}							

				
			// Calculation Function 2: Condition 2
			public boolean invalidSalaryIncrease() {
			    // Create an object to contain input
			    Scanner salaryObj = new Scanner(System.in);
			    // Ask for new salary
			    System.out.println("Enter your salary increase!");
			    // Input into a scanner
			    Double newSalary = salaryObj.nextDouble();
			    // Check the job experience level
			    String checkExperience = this.joExperienceLevel;
			    // Make a variable = first salary (A)
			    double initialSalary = this.jobSalary;
			    // Make a variable = added to salary (B)
			    double addedSalary = newSalary;
			    // 3rd variable = raise percentage(X)
			    double raisePercentage = (initialSalary / addedSalary) * 100;
			    double salaryPercent10 = jobSalary * 0.1;
			    double salaryPercent20 = jobSalary * 0.2;
			    double salaryPercent40 = jobSalary * 0.4;
			    if (((joExperienceLevel.equalsIgnoreCase("Medium")) ||
			            (joExperienceLevel.equalsIgnoreCase("Internship")) ||
			            (joExperienceLevel.equalsIgnoreCase("Volunteer")))) {
			        if (!(raisePercentage >= salaryPercent20) && !(raisePercentage <= salaryPercent40)) {
			            System.out.println("Invalid salary. " + joExperienceLevel + " can only have an increase between 20 - 40%");
			            return false;
			        }
			        double highSalaryIncrease = newSalary; // This needs to pass in the append method
			        return true;
			    }
			    if (joExperienceLevel.equalsIgnoreCase("Junior")) {
			        if (!(raisePercentage <= salaryPercent10)) {
			            System.out.println("A junior can only have an increase under 10% of their salary");
			            return false;
			        }
			        double juniorSalaryIncrease = newSalary; //  This needs to pass in the append method
			       return true;
			    }
			    return true;
			}					
						
					
				
//			Calculation Function 2: Condition 3	
			private String updatedJobType;
				public boolean invalidJobTypeChange() {
//					Create an object to contain input
					Scanner jobChangeObj = new Scanner (System.in); 
//					Ask to to enter a new job type
					System.out.println("Please Enter the job type you would like to update");
					System.out.println("Options are: Full-Time, Part-Time, Internship, Volunteer.");	
//					Make a scanner line to accept user input
					String updatedJobType = jobChangeObj.nextLine().trim();				
//					We use these as case-insensitive cases			
					String jobType1 = ("Full-Time");
					String jobType2 = ("Part-Time");
					String jobType3 = ("Internship");
					String jobType4 = ("Volunteer");
//					When there is invalid input
					if (!updatedJobType.equalsIgnoreCase(jobType1)&& !updatedJobType.equalsIgnoreCase(jobType2)&&!updatedJobType.equalsIgnoreCase(jobType3)&& !updatedJobType.equalsIgnoreCase(jobType4) ) {
						System.out.println("Invalid input: Please change your job type to Full-Time, Part-Time, Internship, Volunteer");
						return false;				
						}	
//					Response if job type is full time
					else if(jobType.equalsIgnoreCase("Full-Time") && updatedJobType.equalsIgnoreCase(jobType1)) {
						System.out.println("You are already Full-Time"); 
						System.out.println("Please try again!");
//						String input2 = jobChangeObj.nextLine();
						return false;
					}
//					If the changed job is the same
					else if(jobType.equalsIgnoreCase(updatedJobType)) {
						System.out.println("That is your current Job Type!"); 
						return false;
					}
					
//					Response if job type is full-time
					else if (jobType.equalsIgnoreCase("Full-Time") && updatedJobType.equalsIgnoreCase(jobType2)|| updatedJobType.equalsIgnoreCase(jobType4)){
						System.out.println("A Full-Timer cannot change to Part-Time or Volunteer ");
						return false;
					}					
//					Otherwise accept the change
					else {
						System.out.println("You have changed job type to " + updatedJobType); 
						this.updatedJobType = updatedJobType; // We assign the updated job type to the instance variable.
						return true;
					}

				}

		 

}


