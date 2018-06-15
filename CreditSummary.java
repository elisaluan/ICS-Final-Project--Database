import java.util.*;

public class CreditSummary {
   private ArrayList <CoursesByYear> yearList = new ArrayList <CoursesByYear> ();
   
   // constructor
   // accessor
   public ArrayList<CoursesByYear> getYearList () {
      return yearList;
   }
   
   // mutator
   public void setYearList (ArrayList<CoursesByYear> yearList) {
      this.yearList = yearList;
   }
   
   // methods

   public MyCourse searchByCourse (String course)
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

   public String toString ()
   {
      String output = "";
      for (int i = 0; i < yearList.size(); i ++)
      {
         output = "Year #" + i + ":\n" + output + yearList.get(i) + "\n//////////////////////\n";
      }
   return output;
   }

}
