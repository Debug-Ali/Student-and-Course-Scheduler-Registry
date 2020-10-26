import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class Registry {
	TreeMap<String, Student> students = new TreeMap<String, Student>(); // students treemap
	TreeMap<String, ActiveCourse> courses = new TreeMap<String, ActiveCourse>(); // courses treemap

	public Registry() {
		ArrayList<Student> list = new ArrayList<Student>();

		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";
		courses.put(courseCode, new ActiveCourse(courseName, courseCode, descr, format, "W2020", list, "", 0, 0));
		// CPS511
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		courses.put(courseCode, new ActiveCourse(courseName, courseCode, descr, format, "F2020", list, "", 0, 0));
		// CPS643
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		courses.put(courseCode, new ActiveCourse(courseName, courseCode, descr, format, "W2020", list, "", 0, 0));
		// CPS706
		courseName = "Computer Networks";
		courseCode = "CPS706";
		descr = "Learn about Computer Networking";
		format = "3Lec 1Lab";
		courses.put(courseCode, new ActiveCourse(courseName, courseCode, descr, format, "W2020", list, "", 0, 0));
		// CPS616
		courseName = "Algorithms";
		courseCode = "CPS616";
		descr = "Learn about Algorithms";
		format = "3Lec 1Lab";
		courses.put(courseCode, new ActiveCourse(courseName, courseCode, descr, format, "W2020", list, "", 0, 0));

		try {
			Scanner read = new Scanner(new File("students.txt")); // create a scanner read to read from the student file
			while (read.hasNext()) { // while the next input is a string word
				try {
					String i = read.next(); // read i being the student name
					String x = read.next(); // read x being the student id
					if (isStringOnlyAlphabet(i)) { // check to see if the student name is all alphabetic
						if (isNumeric(x)) { // check to see if the id is all numbers
							
							Student S1 = new Student(i, x);// the student object including the name and student id
							students.put(x, S1); // add the student object into the students treemap
						}
						else 
							throw new NoSuchElementException();
					}
						else 
							throw new NoSuchElementException();
				}

				catch (NoSuchElementException e) { // no such element excepetion to check if any of the student names or
													// ids are played around with
					System.out.println("Bad File Format " + "students.txt"); // error message
				}

			}

		} catch (FileNotFoundException e) { // file not found exception to check if the file does not exist
			System.out.println("students.txt " + " file not found"); // error message
		}
	}

	// Add new student to the registry (students arraylist above)
	public boolean addNewStudent(String name, String id) {
		Student Peer = new Student(name, id); // Creates a new student object for students arraylist
		for (String i : students.keySet()) { // Loop through students arraylist
			if (id.equals(i) && name.equals(students.get(i).getName())) { // if the student is not in the arraylist by
																			// checking if their id matches any in the
																			// arraylist currently
				return false; // return false to show that student is already registered
			}
		}
		students.put(id, Peer);// add the student
		return true;// and return true
		

	}

	// Remove student from registry
	public boolean removeStudent(String studentId) {
		// Find student in students arraylist
		// If found, remove this student and return true
		for (String i : students.keySet()) { // Loop through the student array list
			if (studentId.equals(i)) { // if the student Id matches one of the Id's in students arraylist
				students.remove(i); // remove that student
				return true; // and return true
			}
		}
		return false; // otherwise return false
	}

	// Print all registered students
	public void printAllStudents() {
		for (String i : students.keySet()) {
			System.out.println("ID: " + i + " Name: " + students.get(i).getName());
		}

	}

	public void addCourse(String studentId, String courseCode) {
		Student s = findStudent(studentId);
		if (s == null)
			return;

		if (s.takenCourse(courseCode))
			return;

		ActiveCourse ac = findCourse(courseCode);
		if (ac == null)
			return;

		if (ac.enrolled(studentId))
			return;

		ac.ClassList().add(s);
		s.addCourse(ac.getName(), ac.getCode(), ac.getCourseDescription(), ac.getFormat(), ac.getSemester(), 0);
	}

	public void dropCourse(String studentId, String courseCode) {
		for (String i : courses.keySet()) { // loop through courses arraylist
			if (courseCode.equalsIgnoreCase(i)) { // check if the coursecode matches any of the coursecode in the
													// arraylist
				ArrayList<Student> List1 = courses.get(i).ClassList(); // Create a pointer that points to the arraylist
																		// in the ClassList() method which returns all
																		// the students
				for (int x = 0; x < List1.size(); x++) { // loop through this List1
					if (studentId.equals(List1.get(x).getId())) { // check to see if the studentId mathces with that of
																	// an id in the List1
						ArrayList<CreditCourse> List2 = students.get(studentId).Courses();// if it does, create another
																							// pointer called List2
																							// which points to the
																							// method Courses in Student
																							// which returns all courses
						for (int s = 0; s < List2.size(); s++) {// loop through this List2
							if (courseCode.equals(List2.get(s).getCode())) { // if the coursecode equals one of the
																				// coursecode in List2
								List1.remove(List1.get(x));// then remove the student students array list
								List2.remove(List2.get(s));// and remove the course from the creditcourse list of the
															// student
							}
						}

					}
				}
			}
		}
	}
	
	public void printActiveCourses() {
		for (String i : courses.keySet()) {
			ActiveCourse ac = courses.get(i);
			System.out.println(ac.getDescription());
		}
	}

	public void printClassList(String courseCode) {
		for (String i : courses.keySet()) // loop the courses array list
		{
			if (courseCode.equals(i)) { // if the coursecode equals a course in the arraylist
				courses.get(i).printClassList(); // call the method printClassList to print the students in a certain
													// course given the coursecode in this method
			}
		}
	}

	public void sortCourseByName(String courseCode) {
		for (String i : courses.keySet()) { // loop through courses arraylist
			if (courseCode.equals(i)) { // if the coursecode that of a course in coursecode
				courses.get(i).sortByName();// call the method from active course to sort by course name
			}
		}
	}

	public void sortCourseById(String courseCode) {
		for (String i : courses.keySet()) { // loop through the courses arraylist
			if (courseCode.equals(i)) { // if the coursecode that of a course in coursecode
				courses.get(i).sortById(); // call the method from active course to sort by student id
			}
		}

	}

	public void printGrades(String courseCode) {
		for (String i : courses.keySet()) {// loop through courses
			if (courseCode.equals(i)) {// if coursecode equals a coursecode in the arraylist courses
				courses.get(i).printGrades();// call the method printGrades to print the grades of a student in an
												// active course alongside name and student id
			}
		}
	}

	
	public void printStudentCourses(String studentId) {
		for (String i : students.keySet()) { // loop through the student arraylist
			if (studentId.equals(i)) {// check to see if studentId equals any of the student Id's in students
										// arraylist
				students.get(i).printActiveCourses();// use the PrintActiveCourses method in Student to print all active
														// course a particular student
			}
		}
	}

	public void printStudentTranscript(String studentId) {
		for (String i : students.keySet()) {// loop through the students arraylist
			if (studentId.equals(i)) {// check to see if studentId equals any of the Id's in student array list
				students.get(i).printTranscript();
			}
		}
	}


	public void setFinalGrade(String courseCode, String studentId, double grade) {
		for (String i : courses.keySet()) { // loop through courses arraylist
			if (courseCode.equalsIgnoreCase(i)) { // check to see if the coursecode matches with any of the courses in
													// the arraylist
				ArrayList<Student> List1 = courses.get(i).ClassList(); // create a pointer that points to the method
																		// ClassList which returns the students
																		// arraylist
				for (int x = 0; x < List1.size(); x++) { // loop through the List1 arraylist
					if (studentId.equals(List1.get(x).getId())) {// check to see if the studentId matches with any of
																	// the Id's in List1 array list
						ArrayList<CreditCourse> List2 = students.get(studentId).Courses();// create a new pointer
																							// variable List2 to point
																							// to the method Courses
																							// which returns the courses
																							// of students
						for (int s = 0; s < List2.size(); s++) {// loop through this List2
							if (courseCode.equalsIgnoreCase(List2.get(s).getCode())) {// check to see if the coursecode
																						// typed matches any of the
																						// coursecodes in List2
								List2.get(s).SetGrade(grade);// if it does match, set the grade for the course using the
																// SetGrade method created
								List2.get(s).setInactive();// finally set the course as inactive using the Setinactive
															// method

							}

						}
					}
				}
			}

		}
	}

	private ActiveCourse findCourse(String code) {
		for (String i : courses.keySet()) {
			if (i.equalsIgnoreCase(code))
				return courses.get(i);
		}
		return null;
	}

	private Student findStudent(String id) {
		for (String i : students.keySet()) {
			Student s = students.get(i);
			if (s.getId().equals(id))
				return s;
		}
		return null;
	}

	public TreeMap<String, ActiveCourse> getCourse() { // method to return the courses treemap
		return courses;
	}

	private static boolean isStringOnlyAlphabet(String str) {
		// write method to check if string str contains only alphabetic characters
		for (int i = 0; i < str.length(); i++) { // loop through the length of the string
			try {

				Integer.parseInt(str.substring(i)); // check to see if every index in string can be converted to int, if
													// possible
				return false; // return false
			}

			catch (Exception s) {// otherwise

			}
		}

		return true;// return true

	}

	public static boolean isNumeric(String str) {
		// write method to check if string str contains only numeric characters

		try {
			Integer.parseInt(str);// check to see if you can convert the string into an int, if possible
			return true; // return true
		} catch (Exception inputMismatchException) {// otherwise using in built exceptions

			return false;// return false
		}

	}

}
