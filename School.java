import java.util.ArrayList;

public class School {
	
	// FIELDS
	
    String schoolName;
    String schoolID;
    ArrayList <Student> listOfStudents = new ArrayList <Student>();
    ArrayList <Teacher> listOfTeachers = new ArrayList <Teacher>();
    ArrayList <GuidanceCounsellor> listOfGuidanceCouns = new ArrayList <GuidanceCounsellor>();
    Principal principal;
    Date dateEstablished;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // CONSTRUCTORS
    
    public School (String name, String ID, ArrayList <Student> students, ArrayList <Teacher> teachers, ArrayList <GuidanceCounsellor> guidance, Principal principal, Date date)
    {
    	schoolName = name;
    	schoolID = ID;
    	listOfStudents = students;
    	listOfTeachers = teachers;
    	listOfGuidanceCouns = guidance;
    	this.principal = principal;
    	dateEstablished = date;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // ACCESSORS

    public String getSchoolID() {
        return schoolID;

    }

    public String getSchoolName() {
        return schoolName;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // MUTATORS
    
    public void setSchoolName(String name)
    {
    	schoolName = name;
    }

    public void setSchoolID(String ID)
    {
    	schoolID = ID;
    }
    
    public void setPrincipal (Principal principal)
    {
    	this.principal = principal;
    }
    
    public void setDate(Date date) 
    {
    	dateEstablished = date;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // METHODS
    
    public void sortStudentLastAZ()
    {
    	int length = listOfStudents.size();
    	String stud1 = "";
    	String stud2 = "";
    	String stud3 = "";
    	
    	for(int i = 0 ; i < length-1 ; i++)
    	{
    		int idx = i;
    		for(int j = 0 ; j < length ; j++)
    		{
    			stud1 = listOfStudents.get(j).getLastName();
    			stud2 = listOfStudents.get(idx).getLastName();
    			stud3 = listOfStudents.get(i).getLastName();
    			
    			if(stud1.compareTo(stud2) < 0)
    			{
    				idx = j;
    			}
    			else if(stud1.compareTo(stud2) == 0)
    			{
    				
    			}
    		}
    		String temp = stud1;
    		listOfStudents.get(idx).setLasName(stud3);
    		listOfStudents.get(i).setLasName(temp);
    		
    	}
    }
    
/////////////////////////////////////////////////////////////////
	//Searching methods begin here
	//Method to search for student given first name and last name using sequential search. Returns array of matching students
	public ArrayList<Student> searchForStudent(String firstName, String lastName)
	{
		ArrayList<Student> matches = new ArrayList<Student>;
		for (int i = 0; i < listOfStudents.size() && found = false; i++)
		{
			if (listOfStudents.get(i).getFirstName == firstName && listOfStudents.get(i).getLastName == lastName)
			{
				matches.add(listOfStudents.get(i));
			}
		}    
    	return matches;
	}
	
	//Method to search for teacher given first name and last name using sequential search. Returns array of matching teachers
	public ArrayList<Teacher> searchForTeacher(String firstName, String lastName)
	{
		ArrayList<Teacher> matches = new ArrayList<Teacher>;
		for (int i = 0; i < listOfTeachers.size() && found = false; i++)
		{
			if (listOfTeachers.get(i).getFirstName == firstName && listOfTeachers.get(i).getLastName == lastName)
			{
				matches.add(listOfTeachers.get(i));
			}
		}    
    	return matches;
	}
	
	//Method to search for guidance counesllor given first name and last name using sequential search. Returns array of matching counsellors
	public ArrayList<GuidanceCounsellor> searchForGuidanceCounsellor(String firstName, String lastName)
	{
		ArrayList<GuidanceCounsellor> matches = new ArrayList<GuidanceCounsellor>;
		for (int i = 0; i < listOfGuidanceCouncellor.size() && found = false; i++)
		{
			if (listOfGuidanceCounsellor.get(i).getFirstName == firstName && listOfGuidanceCounsellor.get(i).getLastName == lastName)
			{
				matches.add(listOfGuidanceCounsellor.get(i));
			}
		}    
    	return matches;
	}
	
	
    
}
