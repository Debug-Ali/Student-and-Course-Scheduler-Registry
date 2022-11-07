public class CreditCourse extends Course 
{
	private String semester;
	private double grade;
	public boolean active;

	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		super(name, code, descr, fmt); 
		this.semester = semester; 
		this.grade = grade; 
	}
	public boolean getActive()
	{
		
		return active; 
	}
	public double Grade(){ 
		return grade;
	} 
	
	public void setActive()
	{
	
		active = true; 
	}
	
	public void setInactive()
	{
		active = false; 
		
	}
	
	public String displayGrade()
	{
		
		return super.getCode() + " " + super.getName() + " " + semester + " " + "Grade " + convertNumericGrade(grade); 
	}
	

	public void SetGrade(double mark){ 	
		grade = mark;  
	}
	
}
