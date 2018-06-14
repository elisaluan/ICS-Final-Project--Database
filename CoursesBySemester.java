import java.util.*;

public class CoursesBySemester {
   private ArrayList<MyCourse> courseList = new ArrayList<MyCourse>();

   // accessor
   public ArrayList<MyCourse> getCourseList () {
      return courseList;
   }
   
   // mutator
   public void setCourseList (ArrayList<MyCourse> courseList) {
      this.courseList = courseList;
   }
   
   // method

   public double calcSemAverage ()
   {
      double average, totalSum = 0;

      for (int i = 0; i < courseList.size(); i  ++)
      {
         totalSum += courseList.get(i).getWeightedAverage();
      }
      average = totalSum/ courseList.size();

      return average;
   }
   public String toString () {
      return "";
   }
}
