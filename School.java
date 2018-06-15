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
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
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
    
    public School (String name, String ID, Principal principal, Date date) {
    	schoolName = name;
    	schoolID = ID;
    	this.principal = principal;
    	dateEstablished = date;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // ACCESSORS

    public String getSchoolID() {
        return schoolID;

    }

    public String getSchoolName() {
        return schoolName;
    }
    
    public ArrayList<Student> getListOfStudents(){
    	return listOfStudents;
    }
    
    public ArrayList<Teacher> getListOfTeachers()
    {
    	return listOfTeachers;
    }
    
    public ArrayList<GuidanceCounsellor> getListOfGuidanceCouns()
    {
    	return listOfGuidanceCouns;
    }
    
    public Date getDateEstablished()
    {
    	return dateEstablished;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // METHODS
    
    // Selection sort to sort through ArrayList of students alphabetically
    public void sortStudentLastAZ()
    {
    	int length = listOfStudents.size(); // length of the ArrayList

    	
    	for(int i = 0 ; i < length-1 ; i++)
    	{
        	Student stud1 = null; // set stud1 and stud 2 to null after each pass
        	Student stud2 = null; // optional
        	
    		int idx = i; //to use  for swapping, makes swapping ineffective if kept as i
    		for(int j = i+1 ; j < length ; j++)
    		{
    			stud1 = listOfStudents.get(j); // initializes stud1-3 as students from  the ArrayList
    			stud2 = listOfStudents.get(idx);
    			
    			if(stud1.getLastName().compareTo(stud2.getLastName()) < 0) // compares the last name of students
    			{
    				idx = j; // changes idx to make swap effective
    			}
    			else if(stud1.getLastName().compareTo(stud2.getLastName()) == 0) //compares the first name if the students have the same last name
    			{
    				if(stud1.getFirstName().compareTo(stud2.getFirstName()) < 0)
    				{
    					idx = j; // chages idx to make swap effective
    				}
    			}
    		}
    	
    		// swapping
    		// only effective if  idx  becomes j
    		Student temp = stud2;
    		stud2 = listOfStudents.get(i);
    		listOfStudents.set(i, temp);
    	}
    }
    
    public void sortStudentMarkHL()
    {
    	int length = listOfStudents.size(); // to get length of ArrayList
    	boolean sorted = false; // initialization of boolean to check if array is sorted
    	
    	for(int i = 0 ; i < length && sorted == false ; i++)
    	{
    		
    		for(int j = 0 ; j < length-i-1; j++)
    		{
    			// intializes two students to avoid repetitive method calling
    			Student stud1 = listOfStudents.get(j);
    			Student stud2 = listOfStudents.get(j+1);
    			
    			if(stud1.getTranscript().getYearList().get(stud1.getTranscript().getYearList().size()-1).calcYearAverage()
    					< stud2.getTranscript().getYearList().get(stud1.getTranscript().getYearList().size()-1).calcYearAverage())
    			{
    				// set sorted to false to allow the method another pass on the array
    				sorted = false;
    				
    				//swaps the two students
    				listOfStudents.set(j, stud2);
    				listOfStudents.set(j+1, stud1);
    			}
    		}
    	}
    }
    
    public void sortStudentMarkLH()
    {
    	int length = listOfStudents.size(); // to get length of ArrayList
    	boolean sorted = false; // initialization of boolean to check if array is sorted
    	
    	for(int i = 0 ; i < length && sorted == false ; i++)
    	{
    		
    		for(int j = 0 ; j < length-i-1; j++)
    		{
    			// intializes two students to avoid repetitive method calling
    			Student stud1 = listOfStudents.get(j);
    			Student stud2 = listOfStudents.get(j+1);
    			
    			if(stud1.getTranscript().getYearList().get(stud1.getTranscript().getYearList().size()-1).calcYearAverage()
    					> stud2.getTranscript().getYearList().get(stud1.getTranscript().getYearList().size()-1).calcYearAverage())
    			{
    				// set sorted to false to allow the method another pass on the array
    				sorted = false;
    				
    				//swaps the two students
    				listOfStudents.set(j, stud2);
    				listOfStudents.set(j+1, stud1);
    			}
    		
    		}
    	}
    }
    
    // sorts the ArrayList of students by their Age using their birthdays
    public void sortStudentAgeLH()
    {
    	int length = listOfStudents.size(); // to get length of ArrayList
    	boolean sorted  = false; // initialization of boolean to check if ArrayList is sorted
    	
    	for(int i = 0 ; i > length - i - 1 && sorted == false ; i++) // outer for loop  to keep track of remaining passes
    	{
    		sorted = true;
    		
    		for(int j = 0 ; j < length - i - 1 ; j++) // inner loop to check and swap correspondingly until the outer loop
    		{
    			Student stud1 = listOfStudents.get(j); // initializes new variables to avoid repetitive method calling
    			Student stud2 = listOfStudents.get(j+1);
    			
    			Date date1 = stud1.getBirthDate(); // initializes a new date to avoid repetitive method calling
    			Date date2 = stud2.getBirthDate();
    			
    			if(date1.compareToDate(date2) > 0) // checks which one is older in termms of  year
    			{
    				sorted = false;								//<--- makes sorted false to enable one more pass in the outer loop
    				
    				listOfStudents.set(j, stud2);				//<--- swapping students
    				listOfStudents.set(j+1, stud1);				//^^^^
    			}
    		}
    	}
    }
    
    // sorts the students by age from oldest to youngest using bubble sort
    public void sortStudentAgeHL()
    {
    	int length = listOfStudents.size(); // to get length of ArrayList
    	boolean sorted  = false; // initialization of boolean to check if ArrayList is sorted
    	
    	for(int i = 0 ; i > length - i - 1 && sorted == false ; i++) // outer for loop  to keep track of remaining passes
    	{
    		sorted = true;
    		
    		for(int j = 0 ; j < length - i - 1 ; j++) // inner loop to check and swap correspondingly until the outer loop
    		{
    			Student stud1 = listOfStudents.get(j); // initializes new variables to avoid repetitive method calling
    			Student stud2 = listOfStudents.get(j+1);
    			
    			Date date1 = stud1.getBirthDate(); // initializes a new date to avoid repetitive method calling
    			Date date2 = stud2.getBirthDate();
    			
    			if(date1.compareToDate(date2) < 0) {
    				sorted = false;
    				
    				listOfStudents.set(j, stud2);
    				listOfStudents.set(j+1, stud1);
    			}
    		}
    	}
    }
    
    // sorting method to sort teacher alphabetically using bubble sort
    public void sortTeachersAlpha()
    {
    	int length = listOfTeachers.size();
    	boolean sorted = false;
    	
    	for(int i = 0 ; i < length && sorted == false ; i++) //outer loop for the bubble sort
    	{
    		sorted = true; //controls if one more  pass SHOULD be made
    		for(int j = 0 ; j < length - i - 1 ; j++)
    		{
    			Teacher teach1 = listOfTeachers.get(j); // initalizes new variables to avoid  repetitive method calling
    			Teacher teach2 = listOfTeachers.get(j+1);
    			
    			if(teach1.getLastName().compareTo(teach2.getLastName()) < 0) //compares the teachers last name
    			{
    				sorted = false;								//turned false to allow one more pass in the outer loop 
    				
    				listOfTeachers.set(j, teach2);				//swapping students
    				listOfTeachers.set(j+1, teach1);			//^^^^
    			}
    			else if(teach1.getLastName().compareTo(teach2.getLastName()) == 0)
    			{
    				if(teach1.getFirstName().compareTo(teach2.getFirstName()) < 0) // compares the teachers first name if they have the same last name
    				{
    					sorted = false;							//turned false to allow one more pass in the outer loop 
    					
    					listOfTeachers.set(j, teach2);			//swapping students
    					listOfTeachers.set(j+1, teach1);		//^^^^
    				}
    			}
    		}
    	}
    }
    
    // sorting for Guidance Counselors using bubble sort
    public void sortGuidanceAlpha()
    {
    	int length = listOfGuidanceCouns.size();
    	boolean sorted = false;
    	
    	for(int i = 0 ; i < length && sorted == false ; i++) //outer loop for the bubble sort
    	{
    		sorted = true; //controls if one more  pass SHOULD be made
    		for(int j = 0 ; j < length - i - 1 ; j++)
    		{
    			GuidanceCounsellor guide1 = listOfGuidanceCouns.get(j); // initalizes new variables to avoid  repetitive method calling
    			GuidanceCounsellor guide2 = listOfGuidanceCouns.get(j+1);
    			
    			if(guide1.getLastName().compareTo(guide2.getLastName()) < 0) //compares the teachers last name
    			{
    				sorted = false;								//turned false to allow one more pass in the outer loop 
    				
    				listOfGuidanceCouns.set(j, guide2);				//swapping students
    				listOfGuidanceCouns.set(j+1, guide1);			//^^^^
    			}
    			else if(guide1.getLastName().compareTo(guide2.getLastName()) == 0)
    			{
    				if(guide1.getFirstName().compareTo(guide2.getFirstName()) < 0) // compares the teachers first name if they have the same last name
    				{
    					sorted = false;							//turned false to allow one more pass in the outer loop 
    					
    					listOfGuidanceCouns.set(j, guide2);			//swapping students
    					listOfGuidanceCouns.set(j+1, guide1);		//^^^^
    				}
    			}
    		}
    	}
    }

    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Searching methods begin here
	//Method to search for student given first name and last name using sequential search. Returns array of matching students
	public Student[] searchForStudent(String firstName, String lastName)
	{
		boolean found = false;
		int count = 0;
		Student[] matches = new Student[listOfStudents.size()];
		for (int i = 0; i < listOfStudents.size() && found == false; i++)
		{
			if (listOfStudents.get(i).getFirstName() == firstName && listOfStudents.get(i).getLastName() == lastName)
			{
				matches[count] = listOfStudents.get(i);
				count++;
			}
		}    
    	return matches;
	}
	
	//Method to search for teacher given first name and last name using sequential search. Returns array of matching teachers
	public Teacher[] searchForTeacher(String firstName, String lastName)
	{
		boolean found = false;
		int count = 0;
		Teacher[] matches = new Teacher[listOfTeachers.size()];
		for (int i = 0; i < listOfTeachers.size() && found == false; i++)
		{
			if (listOfTeachers.get(i).getFirstName() == firstName && listOfTeachers.get(i).getLastName() == lastName)
			{
				matches[count] = listOfTeachers.get(i);
				count++;
			}
		}    
    	return matches;
	}
	
	//Method to search for guidance counesllor given first name and last name using sequential search. Returns array of matching counsellors
	public GuidanceCounsellor[] searchForGuidanceCounsellor(String firstName, String lastName)
	{
		boolean found = false;
		int count = 0;
		GuidanceCounsellor[] matches = new GuidanceCounsellor[listOfGuidanceCouns.size()];
		for (int i = 0; i < listOfGuidanceCouns.size() && found == false; i++)
		{
			if (listOfGuidanceCouns.get(i).getFirstName() == firstName && listOfGuidanceCouns.get(i).getLastName() == lastName)
			{
				matches[count] = listOfGuidanceCouns.get(i);
				count++;
			}
		}    
    	return matches;
	}
	
	//Method to search for Student by their Student ID
	public Student searchForStudentID(String ID) {
		
		int length = listOfStudents.size();
		
		for(int i = 0 ; i < length ; i++) { //traverses the whole ArrayList
			
			Student stud = listOfStudents.get(i); // to avoid repetitive method calling
			
			if(stud.getUserID() == ID) { //if the ID matches, it return that student object
				return stud;
			}
		}
		return null; // returns nothing if not found;
	}
	
	// Method to search for Teacher by their Teacher ID
	public Teacher searchForTeacherID(String ID) {
		
		int bot = 0;									//make bot 0
		int top = listOfTeachers.size() - 1;			//make top the last index of the array
		boolean found = false;							//initializes a boolean to control when to exit the loop when found
		
		while(bot <= top  && found == false) {			//loop through the lowerbound index up to the upperbound index
			int mid  = (bot +  top) / 2;				// sets the mid to be the middle in of the upperbound and lowerbound index
			
			if(ID.equals(listOfTeachers.get(mid).getUserID())) {
				
				found = true;							//makes found true to enable an exit in the loop
				return listOfTeachers.get(mid);			//returns the Teacher object if found
				
			}else if(listOfTeachers.get(mid).getUserID().compareTo(ID) > 0) {	//if the ID of the current index comes after the searched ID, it cuts everything before the middle index 
			
				bot = mid + 1;													//makes the lowerbound index to the index after mid index to cut the segment of the array that needs to be traversed into half
				
			}else{																//if the ID of the current index comes before the searched ID, it cuts everything after the middle index
				
				top = mid - 1;													//makes the upperbound index to the index before the middle index.

			}
		}
		
		return null;		// returns null if the ID was not found
		
	}
    
	
	
}

