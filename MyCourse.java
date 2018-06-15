/*
* MyCourse.java
*  
*
*
*/

import java.util.*;

public class MyCourse {
   private String courseCode;
   private Student student;
   private CourseStatistics currentCourseStats;
   private static int PASS_BOUND = 50;
   private int weightDen;
   private double weightedAverage = 0;
   private int numAssessment = 0;
   private boolean passingCourse = false;
   private ArrayList <MyAssessment> marksList = new ArrayList <MyAssessment> (); 

   // mutators
   public void setStudent (Student student) {
      this.student = student;
   }
   public void setCurrentCourseStats (CourseStatistics currentCourseStats) {
      this.currentCourseStats = currentCourseStats;
   }
   public void setWeightDen (int weightDen) {
      this.weightDen = weightDen;
   }
   public void setWeightedAverage (double weightedAverage) {
      this.weightedAverage = weightedAverage;
   }
   public void setMarksList (ArrayList<MyAssessment> marksList) {
      this.marksList = marksList;
   }
   
   // accessors
   public Student getStudent () {
      return student;
   }
   public CourseStatistics getCurrentCourseStats () {
      return currentCourseStats;
   }
   public double getWeightDen () {
      return weightDen;
   }
   public double getWeightedAverage() {
      return weightedAverage;
   }
   public ArrayList<MyAssessment> getMarksList () {
      return marksList;
   }
   public String getCourseCode ()
   {
      return courseCode;
   }
   
   // methods
   public void calcWeightedAverage () {
      int weightSum = 0;
      for (int i = 0; i < numAssessment; i++) {
         weightSum  += marksList.get(i).getAssessmentWeight(); /////////////////////////
      }
      for (int j = 0; j < numAssessment; j++) {
         weightedAverage += marksList.get(j).getAssessmentMark() *  /////////////////
                            (marksList.get(j).getAssessmentWeight() *///////////////////
                            1.0 / weightSum);
      }
   }
   
   
   public boolean passCourse () {
      calcWeightedAverage();
      
      if (weightedAverage >= PASS_BOUND) {
         passingCourse = true;
      } else {
         passingCourse = false;
      }
      
      return passingCourse;
   }
   
   public double devFromAvg () {
      return weightedAverage - currentCourseStats.getClassMedian();
   }
   
   private double standDev () {
      double squareSumDev = 0;
      double standardDeviation;
      for (int i = 0; i < numAssessment; i++) {
         squareSumDev += Math.pow(((marksList.get(i)).getAssessmentMark() -
                          weightedAverage),2);
      }
      standardDeviation = Math.sqrt(squareSumDev / (numAssessment - 1));
      return standardDeviation;
   }
   
   public int compareAverageToStudentInCourse(MyCourse other) {
      double otherWeightedAvg; 
      other.calcWeightedAverage();
      otherWeightedAvg = other.getWeightedAverage();
      
      if (currentCourseStats == other.getCurrentCourseStats()) {
         if (this.weightedAverage > otherWeightedAvg) {
            return 1;
         } else if (this.weightedAverage == otherWeightedAvg) {
            return 0;
         } else {
            return -1;
         }
      } else {
         System.out.println("Incomparable Data: Students taking different courses");
         return 2;
      }
   }
   
   public int compareToAverage() {
      double classMedian = currentCourseStats.getClassMedian(); 
      
      if (weightedAverage > classMedian) {
         return 1;
      } else if (weightedAverage == classMedian) {
         return 0;
      } else {
         return -1;
      }
   }
   
   public String toString () {

      String output = "Course Code: " + courseCode + "\nAverage: " + weightedAverage + "\nPassing Couse: " + passingCourse
              + "\n Assessments: \n";
      for (int i = 0; i < marksList.size(); i ++)
      {
         output = output + marksList.get(i) + "\n/////////////////////////////\n";
      }

      return output;
   }
   
}
