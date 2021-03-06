import java.util.*;

public class CoursesBySemester {
   private ArrayList<MyCourse> courseList = new ArrayList<MyCourse>();

   // accessor
   public ArrayList<MyCourse> getCourseList () {
      return courseList;
   }
   
   // mutator
   public void setCourseList (ArrayList<MyCourse> CourseList) {
      this.courseList = courseList;
   }
   
   // method

   public double calcSemAverage ()
   {
      double average, totalSum = 0;

      for (int i = 0; i < courseList.size(); i  ++)
      {
         totalSum = totalSum = courseList.get(i).getWeightedAverage();
      }
      average = totalSum/ courseList.size();

      return average;
   }
   public String toString () {
      String output = "";
      for (int i = 0; i < courseList.size(); i ++)
      {
         output = output + courseList.get(i) + "\n//////////////////////////////////////////\n";
      }
      return output;
   }
}
