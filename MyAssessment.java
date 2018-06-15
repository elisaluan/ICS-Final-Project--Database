/*
* MyAssessment.java
*  
*
*
*/

public class MyAssessment {
   private String assessmentName;
   private double assessmentMark;
   private int assessmentNum;
   private int assessmentDen;
   private int assessmentWeight;
   
   // mutators
   public void setAssessmentName (String assessmentName) {
      this.assessmentName = assessmentName;
   }
   public void setAssessmentMark (double assessmentMark) {
      this.assessmentMark = assessmentMark;
   }
   public void setAssessmentNum (int assessmentNum){
      this.assessmentNum = assessmentNum;
   }
   public void setAssessmentDen (int assessmentDen) {
      this.assessmentDen = assessmentDen;
   }
   public void setAssessmentWeight (int assessmentWeight) {
      this.assessmentWeight = assessmentWeight;
   }
   
   // accessors
   public String getAssessmentName () {
      return assessmentName; 
   }
   public double getAssessmentMark () {
      return assessmentMark;
   }
   public int getAssessmentNum () {
      return assessmentNum;
   }
   public int getAssessmentDen () {
      return assessmentDen;
   }
   public int getAssessmentWeight () {
      return assessmentWeight;
   }
   
   public void calcMark () {
      assessmentMark = assessmentNum * 1.0 / assessmentDen;
   }
   public String toString () {
     String output = "Assessment Name: " + assessmentName + "\nAssessment Percent: " + assessmentMark + "\nAssessment Mark: "
             + assessmentNum + "\nAssessment Total: " + assessmentDen + "\nAssessment Weight: " + assessmentWeight;
     return output;
   }
}

