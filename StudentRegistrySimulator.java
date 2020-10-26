import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.*;

public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  {
	  try{
		Registry registry = new Registry();
	  }
	  catch(Exception e){
		  return;
	  }

	  Registry registry = new Registry();
	  Scheduler Schedule = new Scheduler(registry.getCourse()); //created a new scheduler object 
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
			  return;
		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			 
				String id=""; //set id to string
				String name= "";//set name to string 

				if(commandLine.hasNext()){ //if the next input is a string word  
					name = commandLine.next(); //name is the next string word 
				}
				
				if(commandLine.hasNext()){ //if the next input is a string word 
					id = commandLine.next(); // id is the next string word 
				}
				

				if(id.equals("") && name.equals("")){ //checks to see if the string is empty 
					return; //returns nothing if the string is empty 
				}
			
		if(isStringOnlyAlphabet(name)==true){//checks to see if the string word name is only alphabetical charachters so return true
				if(isNumeric(id)==true){ //checks to see if the string word id is only numeric charachters so return true 
						if(registry.addNewStudent(name,id) == false){ //student being registered is set to false, if this condition is met then 
							System.out.println("Student " + name + " is already registered.");//print out the following that the student is already registered
						}
					}
					else
						System.out.println("Invalid Characters in " + " ID " + id);//otherwise print for id loop, that there are invalid charachters in name if first condition fails
					}
					else
						System.out.println("Invalid Characters in " + " Name " + name);//otherwise print for name loop, that there are invalid charachters in name if first condition fails
					}
			
			  
		  
		  else if(command.equalsIgnoreCase("DEL"))
		  {
			String id = ""; //set id to string 
			if(commandLine.hasNext()){ //if the next input is a string word 
				id = commandLine.next(); //set id as the next input 
			}

			if(isNumeric(id)==true){ //if id contains only numeric charachters return set to true 
			 registry.removeStudent(id);// then remove the student id 
				}
				else 
					System.out.println("Invalid Characters in" + id); //print this error statement if first condition fails 
			  
		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			  String id = ""; //set id to string
			  String CourseCode = ""; //set coursecode to string 
			  
			  if(commandLine.hasNext()){ //if the next input is a string word 
				id = commandLine.next();//set id as the next input string word
			  }
			if(commandLine.hasNext()){//if the next input is a string word 
				CourseCode = commandLine.next();//set coursecode as the next input string word
			}
			if(isNumeric(id)==true){//if id is only numeric charachters then 
				registry.addCourse(id,CourseCode.toUpperCase());//add the new course with courscode set to all uppercase and id
			}
			 
			  
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			  String id = "";//set id to string
			  String CourseCode= "";//set coursecode to string 
			  if(commandLine.hasNext()){//if the next input is a string word 
				id = commandLine.next();//set id to the next string word input 
			  }	
			if(commandLine.hasNext()){//if the next input is a string word 
				CourseCode = commandLine.next();//set coursecode to the next string word input
			}
				if(isNumeric(id)==true){//if id is only numeric charachters then 
					registry.dropCourse(id, CourseCode.toUpperCase());//drop the course with courscode set to all uppercase and id
				}
			  
		
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
				registry.printActiveCourses();// print all active courses from method in registry 
			  // print all active courses
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			 String CourseCode = ""; //set coursecode to string  
			 if(commandLine.hasNext()){//if the next input is a string word 
				CourseCode = commandLine.next();//set coursecode as the next input string wod 
			 }
			 registry.printClassList(CourseCode.toUpperCase()); //print the class list with coursecode set all uppercases 
			// get course code string
			  // print class list (i.e. students) for this course
			  
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
		    String CourseCode = ""; //set coursecode to string
			if(commandLine.hasNext()){ //if the next input is a string word 
				CourseCode = commandLine.next(); //set coursecode as the next input string wordv 
			}
				registry.printGrades(CourseCode.toUpperCase());//print the grades name and id from method in registry with coursecode set to all uppercase
			// get course code string
			  // print name, id and grade of all students in active course
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			String id = ""; //set id to string 
			if(commandLine.hasNext()){ //if the next input is a string word 
				id = commandLine.next();//set id as the next input string word 
			}
			if(isNumeric(id)){ //if id contains only numeric charachters 
			registry.printStudentCourses(id); //then print all credit courses of a student from method in registry 
			}
			else 
				System.out.println("Invalid charachters in" + id);//otherwise if condition fails print the error message 
			
			  
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
		    String id = "";//set id to string 
			if(commandLine.hasNext()){//if the next input is a string word 
				id = commandLine.next();//set id to the next string word input 
			}
			if(isNumeric(id)){//if id contains only numeric charachters 
			
				registry.printStudentTranscript(id);//print the student transcript from the method in registry 
			}
			else 
				System.out.println("Invalid charachters in " + id);//otherwise print the following error message 
			 
			
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
				String CourseCode =""; //set coursecode to string 
				String id = "";//set id to string 
			    String grade = "";//set grade to string 
				if(commandLine.hasNext()){ //if the next input is a string word 
					CourseCode = commandLine.next(); //set id as the next input string word 
				}
					if(commandLine.hasNext()){ //if the next input is a string word 
						id = commandLine.next();//set coursecode as the next string word input
					}
						if(commandLine.hasNext()){//if the next input is a string word 
							 grade = commandLine.next(); //set grade as the next string word input   
							}
							  if(isNumeric(id)){ // if id is only numeric charachters   
								double grades = Double.parseDouble(grade); // convert grade from string into double when read by command line
								  registry.setFinalGrade(CourseCode.toUpperCase(), id, grades);//then set the final grade of the student using the course code in all upper case, id, and double grades
			
							  }

		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			  String CourseCode = ""; //set coursecode to string 
			  if(commandLine.hasNext()){ // if the next input is a string word 
				CourseCode = commandLine.next();//set coursecode as the next string word input 
			  }
				registry.sortCourseByName(CourseCode); //sort lists of students in course by name using the method from registry 
			  
			  
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			String CourseCode = ""; //set coursecode to string 
			if(commandLine.hasNext()){ //if the next input is a string word 
				CourseCode = commandLine.next(); // set the coursecode as the next input string word  
			}
				registry.sortCourseById(CourseCode); // sort lists of students in course by id from method in registry 
			
		  }
		  else if(command.equalsIgnoreCase("SCH")){
			String courseCode = ""; //set coursecode to string 
			String day = ""; //set day to string 
			int startTime =0 ; //set start time to string
			int duration   = 0; //set duration to string 
			try{
			if(commandLine.hasNext()){  //if the next input is a string word 
				  courseCode = commandLine.next(); //set courseCode to input 
				}
			  if(commandLine.hasNext()){ //if the next input is a string word 
				  day = commandLine.next(); //set day to input 
				  if(day.equals("Mon") == false  && day.equals("Tue") == false && day.equals("Wed") == false && day.equals("Thu") == false && day.equals("Fri") == false){ //day does not equal these certain days
					throw new InvalidDayException(); // throw the invalid day exception 
				  }
			  }

			  if(commandLine.hasNext()){//if the next input is a string word 
				  startTime = Integer.parseInt(commandLine.next()); //set start time to the next input 
				  ; //convert start time to a int
				  if(startTime<800 || startTime > 1700){ //if the start time is less then 800 or greater than 1700
					throw new IncorrectstartException();  //throw the incorrect start time exception 
				  }
			  }
			  
			  if(commandLine.hasNext()){//if the next input is a string word 
				  duration = Integer.parseInt(commandLine.next()); //set duration to the next input 
				   //convert duration to a int 
				  if(duration!=1 && duration!=2 && duration!=3){ // if duration does not equal 1 2 or 3 hours  
					throw new IncorrectDurationException(); //throw the incorrect duration exception 
				  }
				  Schedule.setDayAndTime(courseCode.toUpperCase(), day, startTime, duration);
			  }
			}
			catch(IncorrectDurationException e){ //catch excepetion for incorrect lecture duration 
				System.out.println("Invalid Lecture Duration.");
			}
			catch(IncorrectstartException e){//catch excepetion for incorrect lecture start time
				System.out.println("Invalid Lecture Start Time.");
			}
			catch(InvalidDayException e){//catch excepetion for incorrect lecture day  
				System.out.println("Invalid Lecture Day.");
			}
			
			

		  }
		  else if(command.equalsIgnoreCase("CSCH")){
			  String courseCode = ""; // set courseCode to string 
			  if(commandLine.hasNext()){ //if the next input is a string word 
				  courseCode = commandLine.next(); //set coursecode to the input 
			  }
			  Schedule.clearSchedule(courseCode.toUpperCase()); //call the method to clear the schedule from scheduler 
			}
		  else if(command.equalsIgnoreCase("PSCH")){
				 Schedule.printSchedule(); //call the method to print the schedule from scheduler 
		}
		  System.out.print("\n>");
	  }
	}

  
  
  private static boolean isStringOnlyAlphabet(String str) 
  { 
	   
	  for(int i =0; i<str.length(); i++){ // loop through the length of the string 
	  try{

			
				Integer.parseInt(str.substring(i)); //check to see if every index in string can be converted to int, if possible 
		          return false;  //return false
			}

	  
	  catch(Exception s){// otherwise

	}
	  }
  
		return true;//return true 
  

}
  public static boolean isNumeric(String str)
  {

	try{
		Integer.parseInt(str);//check to see if you can convert the string into an int, if possible
		return true; //return true 
	}
	catch(Exception inputMismatchException){//otherwise using in built exceptions

		return false;//return false 
	}
	
		
	}


}

class IncorrectDurationException extends RuntimeException{ 
	public IncorrectDurationException() {}
	public IncorrectDurationException(String message) {
		super(message);//the message printed for exception
	}

}

class IncorrectstartException extends RuntimeException{
	public IncorrectstartException() {}
	public IncorrectstartException(String message) {
		super(message); //the message printed for exception
	}
	
}
class InvalidDayException extends RuntimeException{
	public InvalidDayException () {}
	public InvalidDayException(String message) {
		super(message); //the message printed for exception
	}
	
}

  
  
