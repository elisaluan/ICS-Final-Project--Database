import java.util.*;
public class CoursesByYear {
   private final int NUM_SEMESTERS = 2;
   private CoursesBySemester[] semesterList = new CoursesBySemester[NUM_SEMESTERS];
   // constructor
   // accessor
   public CoursesBySemester [] getSemesterList () {
      return semesterList;
   }
   
   // mutator
   public void setSemesterList (CoursesBySemester[] semesterList) {
      this.semesterList = semesterList;
   }
   
   // method
   public String toString () {
      return "";
   }

   public double calcYearAverage ()
   {
      double totalSum = 0, average;

      for (int i = 0; i < NUM_SEMESTERS; i ++)
      {
         totalSum = semesterList[i].calcSemAverage() + totalSum;
      }
      average = totalSum/NUM_SEMESTERS;
      return average;
   }
}
