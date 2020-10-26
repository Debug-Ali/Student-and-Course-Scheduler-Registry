public class CreditCourse extends Course //extend course so that credit course is a subclass of Course
{
	private String semester;
	private double grade;
	public boolean active;

	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		super(name, code, descr, fmt); //call the inherited variables
		this.semester = semester; //initalize semester
		this.grade = grade; //initialize grade
	}
	public boolean getActive()
	{
		// add code and remove line below
		return active; //method to check if active
	}
	public double Grade(){ //new method added to return grade 
		return grade;
	} 
	
	public void setActive()
	{
		// add code
		active = true; // Sets course to active when this method is called
	}
	
	public void setInactive()
	{
		active = false; //sets course to inactive when this method is called 
		
	}
	
	public String displayGrade()
	{
		
		return super.getCode() + " " + super.getName() + " " + semester + " " + "Grade " + convertNumericGrade(grade); //added to return code, name, semester and grade of a student
		
	}
	

	public void SetGrade(double mark){ //new method added to set the grade of a student		
		grade = mark;  //set grade equal to mark 
	}
	
}