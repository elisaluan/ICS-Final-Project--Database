public class AcademicDatabase {
  
	//Initializes the array lists
	ArrayList<School> tdsbSchoolList;
	ArrayList<Admin> adminList;
	ArrayList<User> allUsers;
	
	//Initializes constant for length of userID
	final int IDLENGTH = 9;
	
	private fileInputOutput saveAndLoad;
	
	//Constructors
	public AcademicDatabase()
	{
		tdsbSchoolList = new ArrayList<School>();
		adminList = new ArrayList<Admin>();
		allUsers = new ArrayList<User>();
		saveAndLoad = null;
	}
	
	public AcademicDatabase(ArrayList<School> tdsbSchoolList, ArrayList<Admin> adminList, ArrayList<User> allUsers, fileInputOutput saveAndLoad)
	{
		this.tdsbSchoolList = tdsbSchoolList;
		this.adminList = adminList;
		this.allUsers = allUsers;
		this.saveAndLoad = saveAndLoad;
	}
	
	//Accessors
	public ArrayList<School> getTdsbSchoolList()
	{
		return tdsbSchoolList;
	}
	
	public ArrayList<Admin> getAdminList()
	{
		return adminList;
	}
	
	public ArrayList<User> getAllUsers()
	{
		return allUsers;
	}
	
	public fileInputOutput getSaveAndLoad()
	{
		return saveAndLoad;
	}
	
	//Mutators
	public void setTdsbSchoolList(ArrayList<School> tdsbSchoolList)
	{
		this.tdsbSchoolList = tdsbSchoolList;
	}
	
	public void setAdminList(ArrayList<Admin> adminList)
	{
		this.adminList = adminList;
	}
	
	public void setAllUsers(ArrayList<User> allUsers)
	{
		this.allUsers = allUsers;
	}
	
	public void setSaveAndLoad(fileInputOutput saveAndLoad)
	{
		this.saveAndLoad = saveAndLoad;
	}
	
  //Class to sort students at every school by their last name in alphabetical order using bubble sort
  public void sortStudentLastAZ()
  {
    //For loop to loop through every school
    for (int school = 0; school < tdsbSchoolList.size(); school++)
    {
      //variable to check if array is sorted
      boolean sorted = false;

      //Outer for loop for bubble sort
      for (int i = 0; i < tdsbSchoolList.get(school).listOfStudents.size() && sorted == false; i++)
      {
        sorted = true;

        //Inner for loop for bubble sort
        for (int j = 0; j < tdsbSchoolList.get(school).listOfStudents.size() - i - 1; j++)
        {
          //Initializes two Students to be sorted
          Student stud1 = tdsbSchoolList.get(school).listOfStudents.get(j);
          Student stud2 = tdsbSchoolList.get(school).listOfStudents.get(j+1);

          //Determines if the first student should be put after the second student
          if (stud1.getFirstName.charAt(0) > stud2.getFirstName.charAt(0))
          {
            //If a sort happens sets indicates that the array is not yet sorted
            sorted = false;

            //swaps the two students
            tdsbSchoolList.get(school).listOfStudents.get(j).set(stud2);
            tdsbSchoolList.get(school).listOfStudents.get(j+1).set(stud1);
          }
        }
      }
    }
  }
  
  //Class to sort students at every school by their current year's average in decreasing order by bubble sort
  public void sortStudentHL()
  {
    //For loop to loop through every school
    for (int school = 0; school < tdsbSchoolList.size(); school++)
    {
      //Boolean to check if array is sorted
      boolean sorted = false;

      //Outer for loop for bubble sort
      for (int i = 0; i < tdsbSchoolList.get(school).listOfStudents.size() && sorted == false; i++)
      {
        sorted = true;

        //Inner for loop for bubble sort
        for (int j = 0; j < tdsbSchoolList.get(school).listOfStudents.size() - i - 1; j++)
        {
          //Initializes two Students to be sorted
          Student stud1 = tdsbSchoolList.get(school).listOfStudents.get(j);
          Student stud2 = tdsbSchoolList.get(school).listOfStudents.get(j+1);

          //Determines if the first student has a lower average than the second student
          if (stud1.getTranscript().getYearList.get(stud1.getTranscript().getYearList.size()-1).calcYearAverage() 
            < stud2.getTranscript().getYearList.get(stud1.getTranscript().getYearList.size()-1).calcYearAverage())
          {
            //If a sort happens sets indicates that the array is not yet sorted
            sorted = false;

            //swaps the two students
            tdsbSchoolList.get(school).listOfStudents.set(j,stud2);
            tdsbSchoolList.get(school).listOfStudents.set(j+1,stud1);
          }
        }
      }
    }
  }
  
  //Method to change all names to lower case
  public String standardizeName(String name)
  {
	  //returns the name all in lower case
	  return name.toLowerCase();
  }
  
  //Method to take in an ID and check if no other user has this ID
  public boolean checkUnique(String ID)
  {
    //loops through all users
    for (int userIndex = 0; userIndex < allUsers.size(); userIndex++)
    {
      //returns false if a user already has this ID
      if (ID == allUsers.get(userIndex).getUserID())
        return false;
    }

    //if no other user has this ID, returns true
    return true;
  }
}
