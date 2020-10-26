import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

public class Scheduler {

String[][] table = { { "0800", "", "", "", "", "" }, // the nested array for the times including their slots
{ "0900", "", "", "", "", "" },
{ "1000", "", "", "", "", "" },
{ "1100", "", "", "", "", "" },
{ "1200", "", "", "", "", "" },
{ "1300", "", "", "", "", "" },
{ "1400", "", "", "", "", "" },
{ "1500", "", "", "", "", "" },
{ "1600", "","", "", "", "" } };

String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri" }; // the array days that include the weekdays
	TreeMap<String, ActiveCourse> courses;

	public Scheduler(TreeMap<String, ActiveCourse> courses) {
		this.courses = courses;
	}

	public void setDayAndTime(String courseCode, String day, int startTime, int duration) {
		if (courses.containsKey(courseCode.toUpperCase()) == false) { //based on the input if the courses treemap contains a coursecode thats is not present in the treemap
			System.out.println("Unknown Course " + courseCode);//print the following error message
			return;//return nothing
		}
		for (String x : courses.keySet()) { // Loop through courses keyset
			if (courseCode.toUpperCase().equals(x) == false && day.equals(courses.get(x).getDay())) { // check to see if  the day input equals one of the days in an active course object, and also make sure to check the coursecode so that there is not an inconvenient collision of common courses already registered
				int durr = courses.get(x).getDuration(); // reference a duration variable for an active course
				int time = courses.get(x).getStartLecture();// reference the start time for an active course
				int end = time + (durr * 100);// create a new end time variable by duration to the start time to
												// find the end time
				for (int i = 0; i < duration; i++) {// loop through the duration of the course input
					int beginTime = startTime; // this is done to not reset start time, but rather just be used as a
												// temporary variable
					beginTime += 100; // add 100 each time to the course input start time for every hour of the
										// duration
					if (beginTime <= end && beginTime >= time) { // check to see if the starttime is in between or equal
																	// to the end time or start time of the other
																	// course, if this true then there is a collision,
																	// otherwise continue looping until the loop exits.
						System.out.print("Lecture Time Collision"); // print the collision error message
						return;
					}

				}

			}

		}
		courses.get(courseCode.toUpperCase()).setDay(day); // setting the day
		courses.get(courseCode.toUpperCase()).setStart(startTime); // setting the start time
		courses.get(courseCode.toUpperCase()).setDuration(duration);// setting the duration
		constructTable(courseCode, day, startTime, duration); // calls the method construct table
	}

	public void clearSchedule(String courseCode) {
		for (String i : courses.keySet()) {// loop throup course treemap keys
			if (courseCode.equals(i)) { // if the coursecode equals any of the coursecodes in the courses treemap
				courses.get(courseCode.toUpperCase()).setDay(""); // set the day to empty string using method from active course
				courses.get(courseCode.toUpperCase()).setStart(0);// set the starttime to 0 using method from active course
				courses.get(courseCode.toUpperCase()).setDuration(0);// set the duration to 0 using method from active course
			}
		}
		for(int i = 0 ; i<table.length; i++){
			for(int s = 0 ; s<table[i].length;s++){
				if(table[i][s].equalsIgnoreCase(courseCode)){
					table[i][s] = "";
				}
			}
		}
	}


	public void printSchedule() {
		for (int l = 0; l < days.length; l++) { // loop through the days array
            
			System.out.format("%8s",days[l]); // print out the days, including the format with 8 spaces to delete the white spaces

		}
		System.out.print("\n"); // new line of space to organize schedule
		for (int i = 0; i < table.length; i++) { // loop through the first array

			for (int s = 0; s < table[i].length; s++) { // then loop through the nested array
				if(s==0){ //at element zero print the schedule normally without formatting
					System.out.print(table[i][s]);//print the schedule normally (Times)
				}
				else

				System.out.format("%8s",(table[i][s])); // else print out the nested table array with formatting 
 
			}
			System.out.print("\n"); // print a new line of space to organize schedule

		}
	} 
	public void constructTable(String courseCode, String day, int startTime, int duration){
		int x = 0; //create a variable int x to store the element days adding a 1 to 
		for(int s = 0 ; s<days.length; s++){//loop through the days array 
			if(days[s].equals(day)){    //if the variable s equals the day inputed 
				x = s + 1; //add this day to x and increment by 1 
			}

		}
		for(int i = 0; i<table.length; i++){ //loop through table 
			if(table[i][0].equals(Integer.toString(startTime))){ //if the table at element 0 is equal to the start time input
				table[i][x] =courseCode; //the table i and x which gives you the column depending on the day of the week will be set to the coursecode input in the schedule 
			}
		}

		for(int l = 1 ; l<duration; l++){ //loop through duration
			startTime+=100; //add 100 each time to duration 
			for(int a = 0; a<table.length; a++){ //loop through table 
				if(table[a][0].equals(Integer.toString(startTime) )){//again if the table a at element 0 is equal to the start time input 
					table[a][x] = courseCode;// the table i and x which gives you the column depending on the on the day of week will be set to the coursecode input in the schedule 
				}
			}

		}
			
		}
	}

