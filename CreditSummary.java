import java.util.ArrayList;

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
  
  // ACCESSORS
  
  public ArrayList<CoursesByYear> getYearList()
  {
	  return yearList;
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////
  
  // METHODS
  
  public String toString ()
   {
      String output = "";
      for (int i = 0; i < yearList.size(); i ++)
      {
         output = "Year #" + i + ":\n" + output + yearList.get(i) + "\n//////////////////////\n";
      }
   return output;
   }

   public MyCourse searhByCourse (String course)
   {
      for (int i =0; i < yearList.size(); i ++)
      {
         for (int j = 0; j < yearList.get(i).getSemesterList().length; j ++)
         {
            for (int k = 0; k < yearList.get(i).getSemesterList()[j].getCourseList().size(); k ++)
            {
               if (yearList.get(i).getSemesterList()[j].getCourseList().get(k).getCourseCode().equalsIgnoreCase(course))
               {
                  return (yearList.get(i).getSemesterList()[j].getCourseList().get(k));
               }
            }
         }
      }
      return null;
   }
}

