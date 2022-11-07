import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class ActiveCourse extends Course {
   private ArrayList<Student> students;
   private String semester;
   private int lectureStart;
   private int lectureDuration;
   private String lectureDay;

   
   public ActiveCourse(String name, String code, String descr, String fmt, String semester, ArrayList<Student> students,
         String lectureDay, int lectureStart, int lectureDuration) {
      super(name, code, descr, fmt);
      this.semester = semester;
      this.students = students;
      this.lectureDuration = lectureDuration;
      this.lectureStart = lectureStart;
      this.lectureDay = lectureDay;
   }

   public ArrayList<Student> ClassList() { // new method to return student array list
      return students;
   }

   public String getSemester() {
      return semester;
   }

   public void printClassList() {
      for (int i = 0; i < students.size(); i++) { // loop through students array list
         System.out.println("Student ID: " + students.get(i).getId() + " Name: " + students.get(i).getName()); // print
                                                                                                               // out
                                                                                                               // the
                                                                                                               // name
                                                                                                               // id
      }
   }

   public boolean checkStudent(String studentId) { // new method for add course to check if student is enrolled
      for (int i = 0; i < students.size(); i++) {// loop through student
         if (studentId.equals(students.get(i).getId())) {// if student id equals id of that in students arraylist
            return true;// return true
         }
      }
      return false;// otherwise return false
   }

   public void printGrades() {

      for (int i = 0; i < students.size(); i++) { // loop through students arraylist
         System.out.println(students.get(i).toString() + " " + getGrade(students.get(i).getId()));// print the grade and
                                                                                                  // name along with id
      }
   }

   
   public double getGrade(String studentId) {
      for (int i = 0; i < students.size(); i++) { // loop through students arraylist
         if (studentId.equals(students.get(i).getId())) { // if studentId equals the id in students array list
            ArrayList<CreditCourse> x = students.get(i).Courses(); // then set up a pointer to the array list method
                                                                   // Courses which returns courses
            for (int s = 0; s < x.size(); s++) { // loop through this list
               if (x.get(s).getCode().equals(this.getCode())) {// check to see if the coursecode equals the course code
                                                               // in the arraylist made by the pointer
                  return x.get(s).Grade(); // return the grade if it is equal to that of the one in the arraylist
               }
            }
         }
      }
      return 0;
   }


   public String getDescription() {
      int counter = 0; // set up a counter variable
      for (int i = 0; i < students.size(); i++) { // loop through students array list
         counter++; // count the number of students in array list

      }

      return super.getDescription() + "\n" + semester + " Enrollement: " + counter; // return the method get description
                                                                                    // from super class, semester and
                                                                                    // the number of students enrolled
   }

   public boolean enrolled(String studentId) {
      for (int i = 0; i < students.size(); i++) {
         if (studentId.equals(students.get(i).getId()))
            return true;
      }
      return false;
   }

   public String getCourseDescription() {
      return getDescr();
   }

   
   public void sortByName() {
      Collections.sort(students, new NameComparator()); // sort the array students using NameComparator
   }


   private class NameComparator implements Comparator<Student> // implement Name Comparotor for object student
   {
      public int compare(Student i, Student x) { // use the built in method compare to compare two students
         return i.getName().compareTo(x.getName());// compare two student names
      }
   }

   public void sortById() {
      Collections.sort(students, new IdComparator()); // sort the array students using IdComparator
   }


   private class IdComparator implements Comparator<Student> // implement IdComparator for object Student
   {
      public int compare(Student i, Student x) { // use the built in method compare to compare two students
         return i.getId().compareTo(x.getId()); // compare two student ids
      }
   }

   public void setDay(String i) { // method to set the day
      lectureDay = i;
   }

   public void setDuration(int x) { // method to set the duration
      lectureDuration = x;
   }

   public void setStart(int s) { // method to set the starttime
      lectureStart = s;
   }

   public String getDay() { // method to get the day
      return lectureDay;
   }

   public int getDuration() { // method to get the duration
      return lectureDuration;
   }

   public int getStartLecture() { // method to get the start time
      return lectureStart;
   }
}
