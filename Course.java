public class Course 

{
	private String code;
	private String name;
	private String description;
	private String format;
	
	   
	public Course()
	{
	  this.code        = "";
	  this.name        = "";
	  this.description = "";
	  this.format      = "";
	}
	   
	public Course(String name, String code, String descr, String fmt)
	{
	  this.code        = code;
	  this.name        = name;
	  this.description = descr;
	  this.format      = fmt;
	}
	   
	public String getCode()
	{
	   return code;
	}
	   
	public String getName()
	{
	  return name;
	}
	   
	public String getFormat()
	{
	  return format;
	}
	   
	public String getDescription()
	{
	  return code +" - " + name + "\n" + description + "\n" + format;
	}
	
	 public String getInfo()
	 {
	   return code +" - " + name;
	 }
	 public String getDescr()
   {
	   return description;
   }
	
	 public static String convertNumericGrade(double score)
	 {					
		 
     	 if(score>=91.0 && score<=100.0){//letter grade system from A to F depending on what score ranges, the letter grade is given using if statements and one else statement 
			return "A+";
		}
		 else if(score>=85.0 && score<=90.0){
			return "A";
		}
		 else if(score>=80.0 && score<=84.0){
			return "A-";
		}
		 else if(score>=77.0 && score<=79.0){
			return "B+";
		}
		 else if(score>=73.0 && score<=76.0){
			return "B";
		}
		 else if(score>=70.0 && score<=72.0){
			return "B-";
		}
		 else if(score>=67.0 && score<=69.0){
			return "C+";
		}
		 else if(score>=63.0 && score<=66.0){
			return "C";
		}
		 else if(score>=60.0 && score<=62.0){
			return "C-";
		}
		 else if(score>=57.0 && score<=59.0){
			return "D+";
		}
		 else if(score>=53.0 && score<=56.0){
			return "D";
		}
		 else if(score>=50.0 && score<=52.0){
			 return "D-";
		}
		  //otherwise return a score of F
		{
			return "F";
		}
	 }
	 
	}
