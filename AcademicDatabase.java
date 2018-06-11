public class AcademicDatabase {
  
  //sorts students alphabetically by last name
  public void sortStudentLastAZ
  {	
    //initializes variables
	  boolean sorted = false;
	
	  //outer for loop to sort each school
	  for (int school = 0; school < tdsbSchoolList.length; school++)
	  {	
		  //outer for loop for the bubble sort
		  for (int i = 0; i < listOfStudents.size() - 1 && i == false; student++)
		  {
			  sorted = true;
			
			  //inner for loop for the bubble sort
			  for (int j = 0; j < listOfStudents.size() - 1 - i; j++)
			  {
				  //Takes students from the array and puts them into variables
				  Student stud1 = schoolArrayList.get(school).listOfStudents.get(j);
				  Student stud2 = schoolArrayList.get(school).listOfStudents.get(j+1);
				
				  //If two students are not sorted, sorts them
				  if (stud1.getLastName.charAt(0) > stud2.getLastName.charAt(0)
				  {
					  //sets sorted to false if a switch has been made
					  sorted = false
					
					  //sets the first student as the second student
					  schoolArrayList.get(school).listOfStudents.get(j).set(stud2);
					
					  //sets the second student as temp which contains the first student
					  schoolArrayList.get(school).listOfStudents.get(j+1).set(stud1);
				  }
			  }
		  }
	  }
  }
}
