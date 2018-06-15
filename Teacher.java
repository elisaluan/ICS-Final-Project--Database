import java.util.*;

public class Teacher extends User {
   private final int MAX_COURSES = 3;
   private int numTeaching;
   private ArrayList<Course> coursesTeaching = new ArrayList<Course> ();
   private Date beginTeach;

   // accessors
   public int getNumTeaching () {
      return numTeaching;
   }
   public ArrayList<Course> getCoursesTeaching () {
      return coursesTeaching;
   }
   public Date getBeginTeach () {
      return beginTeach;
   }

   // mutators
   public void setNumTeaching (int numTeaching) {
      this.numTeaching = numTeaching;
   }
   public void setCoursesTeaching (ArrayList<Course> coursesTeaching) {
      this.coursesTeaching = coursesTeaching;
   }
   public void setBeginTeach(Date beginTeach) {
      this.beginTeach = beginTeach;
   }
   /*
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
   */
   public void updateOverallAverage (Student forStudent, Course thisCourse, double toAverage) {
      MyCourse editMyCourse = thisCourse.searchMyCourseForStudent(forStudent);
      if (editMyCourse != null) {
         editMyCourse.setWeightedAverage(toAverage);
      }
   }
   public void updateAssessmentMark (Student forStudent, Course thisCourse, int markNum, int markDen, String assessmentName) {
      MyCourse editMyCourse = thisCourse.searchMyCourseForStudent(forStudent);
      if (editMyCourse!= null) {
         MyAssessment editMyAssessment = editMyCourse.searchMyAssessmentForStudent(assessmentName);
         if (editMyAssessment != null) {
            editMyAssessment.setAssessmentNum(markNum);
            editMyAssessment.setAssessmentDen(markDen);
            editMyAssessment.calcMark();
         }
      }
   }
   public void updateAssessmentWeight (Student forStudent, Course thisCourse, int weight, String assessmentName) {
      MyCourse editMyCourse = thisCourse.searchMyCourseForStudent(forStudent);
      if (editMyCourse!= null) {
         MyAssessment editMyAssessment = editMyCourse.searchMyAssessmentForStudent(assessmentName);
         if (editMyAssessment != null) {
            editMyAssessment.setAssessmentWeight(weight);
            editMyAssessment.calcMark();
         }
      }
   }
   public void addAssessment (Course forCourse, String assessmentName) {
      Scanner sc = new Scanner (System.in);
      int num, den, weight;
      int numStudent = forCourse.getNumStudent();
      forCourse.getAllAssess().getAssessmentList().add(assessmentName);
      for (int i = 0; i < numStudent; i++) {
         System.out.print("Num Mark for Student " + forCourse.getStudentInCourseList().get(i).getStudent().getFirstName() + " : ");
         num = Integer.parseInt(sc.nextLine());
         System.out.print("Den Mark for Student " + forCourse.getStudentInCourseList().get(i).getStudent().getFirstName() + " : ");
         den = Integer.parseInt(sc.nextLine());
         System.out.print("Weight for Student " + forCourse.getStudentInCourseList().get(i).getStudent().getFirstName() + " : ");
         weight = Integer.parseInt(sc.nextLine());
      }
   }
   public void addAssessment (Student forStudent, Course forCourse, MyAssessment personalAssess){
      MyCourse studentCourse = forCourse.searchMyCourseForStudent(forStudent);
      studentCourse.getMarksList().add(personalAssess);
   }
   public int compareToExp (Teacher other) {
      return this.beginTeach.compareToDate(other.getBeginTeach());
   }


   public String toString ()
   {
      String output = super.toString();
      output = output + "\nBegin Teaching: " + beginTeach;
      return output;
   }
}
