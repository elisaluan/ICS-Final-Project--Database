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
   public String toString () {
      return "";
   }
}