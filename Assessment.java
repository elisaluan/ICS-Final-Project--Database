import java.util.*;

public class Assessment {
   //creates an ArrayList of MyAssessment
   ArrayList<MyAssessment> assessmentList = new ArrayList<MyAssessment>();
   
   // constructor
   // accessor
   public ArrayList<MyAssessment> getAssessmentList () {
      return assessmentList;
   }
   
   // mutator
   public void setAssessmentList (ArrayList<MyAssessment> assessmentList) {
      this.assessmentList = assessmentList;
   }
   
   // method
   public String toString () {
      return "";
   }
}