import java.util.ArrayList;

public class Student
{
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses;
  
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }
  public  ArrayList<CreditCourse>Courses(){ //new arraylist method to return courses
    return courses;
  }
 
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
    CreditCourse Completed = new CreditCourse(courseName,courseCode, descr, format, sem, grade); // created a creditcourse object with the parameters included
    Completed.setActive(); //set the creditcourse object to active
    // add to courses array list
    courses.add(Completed); //add this credit course object to the courses arraylist
  }
  
  
  public void printTranscript()
  {
	  for(int i =0;i<courses.size();i++){ //loops through courses arraylists  
      if(courses.get(i).getActive() == false){ //if the course is indeed active proceed to the next step
       System.out.println(courses.get(i).displayGrade()); //print out the the method called to return the diplayInfo method which contains coursecode, name, semester, and grade 
      }
    }
  }
  

  public void printActiveCourses()
  {
    for(int i =0; i<courses.size(); i++){ // loops through the courses arraylist
      if(courses.get(i).getActive() == true){ // if the courses is indeed active from the pointer
        System.out.println(courses.get(i).getDescription()); //then print all active courses 
      }
    }
	 
  }
  
  public void removeActiveCourse(String courseCode)
  {
	 for(int i = 0; i<courses.size(); i++){ //loops through courses arraylist
      if(courseCode == courses.get(i).getCode() && courses.get(i).getActive()==true){ // if the coursecode is equal to the to one of the coursecodes in the course list, and if that course is active
        courses.remove(i); //remove the course
      }
      }
   }
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  public boolean equals(Object other)
  {
   
    if (this.name == other && this.id ==other){ //if name and id equal to their other variables 
      return true; //Then return true
    }

	  return false; //otherwise return false
  }
  
  public boolean takenCourse(String courseCode)
  {
    for (int j = 0; j < courses.size(); j++)
    {
      if (courses.get(j).getCode().equalsIgnoreCase(courseCode))
        return true;
	}
    return false;
  }
}
  

