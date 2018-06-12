import java.util.*;

public class CreditSummary {
  
	// FIELDS
	
  private ArrayList<CoursesByYear> yearList = new ArrayList<CoursesByYear>();
  
////////////////////////////////////////////////////////////////////////////////////////////////////
  
  // CONSTRUCTORS
  
  public CreditSummary(ArrayList<CoursesByYear> course)
  {
	  int length = course.size();
	  
	  for(int i = 0 ; i < length ; i++)
	  {
		  yearList.add(course.get(i));
	  }
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////
  
  // METHODS
  
  public String toString()
  {
	String output = "";
	int length = yearList.size();
	
	for(int i = 0 ; i < length ; i++)
	{
		output += yearList.get(i).toString();
	}
	return output;
  }
  
}
