import java.util.*;

public class Teacher {
   private final int MAX_COURSES = 3;
   private int numTeaching;
   private ArrayList<Course> coursesTeaching = new ArrayList<Course> ();
   private Date beginTeach;
   
   // accessors
   public int getNumTeaching () {
      return numTeaching;
   } 
   public Arraylist<String> getCoursesTeaching () {
      return coursesTeaching;
   }
   public Date getBeginTeach () {
      return beginTeach;
   }
   
   // mutators
   public void setNumTeaching (int numTeaching) {
      this.numTeaching = numTeaching;
   }
   public void setCoursesTeaching (ArrayList<String> coursesTeaching) {
      this.coursesTeaching = coursesTeaching;
   }
   public void setBeginTeach(Date beginTeach) {
      this.beginTeach = beginTeach;
   }
   
   public void updateAverage (Student forStudent, Course thisCourse, double toAverage) {
      forStu
   }
}
