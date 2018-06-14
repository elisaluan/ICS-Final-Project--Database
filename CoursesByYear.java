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
}