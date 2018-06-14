import java.util.*;

public class Student extends User {
   private int numCourse;
   private CreditSummary transcript;
   private int grade;
   private boolean esl;
   private boolean internationalStudent;
   private boolean iep;
   private ArrayList<MyCourse> coursesTaking = new ArrayList<MyCourse> (); 
   
   // accessors
   public int getNumCourse () {
      return numCourse;
   }
   public CreditSummary getTranscript () {
      return transcript;
   }
   public int getGrade () {
      return grade;
   }
   public boolean getEsl () {
      return esl;
   }
   public boolean getInternationalStudent () {
      return internationalStudent;
   }
   public boolean getIep () {
      return iep;
   }
   public ArrayList<MyCourse> getCoursesTaking () {
      return coursesTaking;
   }
   
   // mutators
   public void setNumCourse (int numCourse) {
      this.numCourse = numCourse;
   }
   public void setTranscript (CreditSummary transcript) {
      this.transcript = transcript;
   }
   public void setGrade (int grade) {
      this.grade = grade;
   }
   public void setEsl (boolean esl) {
      this.esl = esl;
   }
   public void setInternationalStudent (boolean internationalStudent) {
      this.internationalStudent = internationalStudent;
   }
   public void setIep (boolean iep) {
      this.iep = iep;
   }
   public void setCoursesTaking (ArrayList<MyCourse> coursesTaking) {
      this.coursesTaking = coursesTaking;
   }
   
   // methods
   public void viewCourseMark (MyCourse course) {
      
   }
   
   public void viewTranscript () {
   } 
}