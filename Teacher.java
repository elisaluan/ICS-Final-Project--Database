import java.util.*;

public class Teacher extends User{
   private final int MAX_COURSES = 3;
   private int numTeaching;
   private String [] coursesTeaching = new String [MAX_COURSES];
   private ArrayList <Course> courseArrayList = new ArrayList<Course>();
   private Date beginTeach;

   // Accessors
   public int getNumTeaching () {
      return numTeaching;
   }

   public String[] getCoursesTeaching() {

      return coursesTeaching;
   }

   public ArrayList<Course> getCourseArrayList() {
      return courseArrayList;
   }

   public int getMAX_COURSES() {
      return MAX_COURSES;
   }

   public Date getBeginTeach() {
      return beginTeach;
   }

   //Mutators
   public void setNumTeaching(int numTeaching) {
      this.numTeaching = numTeaching;
   }

   public void setCoursesTeaching(String[] coursesTeaching) {
      this.coursesTeaching = coursesTeaching;
   }

   public void setCourseArrayList(ArrayList<Course> courseArrayList) {
      this.courseArrayList = courseArrayList;
   }

   public void setBeginTeach(Date beginTeach) {
      this.beginTeach = beginTeach;
   }

   //Method

   public boolean updateAverage (Student other, Course course, String assessmentName, int assessmentMark )
   {
         MyCourse temp = other.getTranscript().searchByCourse((course.getCourseCode()));

         for (int i = 0; i < temp.getMarksList().size(); i ++)
         {
            if (temp.getMarksList().get(i).getAssessmentName().equalsIgnoreCase(assessmentName))
            {
               temp.getMarksList().get(i).setAssessmentNum(assessmentMark);
               return true;
            }
         }

         return false;
   }

   public void addAssessment (MyAssessment assessment)
   {
      
   }
   

}
