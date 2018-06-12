public class AcademicDatabase {
  
  //Class to sort students at every school by their last name in alphabetical order using bubble sort
  public void sortStudentLastAZ()
  {
    //For loop to loop through every school
    for (int school = 0; school < tdsbSchoolList.size(); school++)
    {
      //variable to check if array is sorted
      boolean sorted = false;

      //Outer for loop for bubble sort
      for (int i = 0; i < listOfStudents.size() && sorted == false; i++)
      {
        sorted = true;

        //Inner for loop for bubble sort
        for (int j = 0; j < listOfStudents.size() - i - 1; j++)
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
      for (int i = 0; i < listOfStudents.size() && sorted == false; i++)
      {
        sorted = true;

        //Inner for loop for bubble sort
        for (int j = 0; j < listOfStudents.size() - i - 1; j++)
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
}
