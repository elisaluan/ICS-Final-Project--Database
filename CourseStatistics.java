import java.util.*;

public class CourseStatistics {
   private double classMean;
   private double classMedian;
   private Course thisCourse;
   
   // accessors
   public double getClassMean () {
      return classMean;
   }
   public double getClassMedian () {
      return classMedian;
   }
   public Course getThisCourse () {
      return thisCourse;
   }
   
   // mutators
   public void setClassMean (double classMean) {
      this.classMean = classMean;
   }
   public void setClassMedian (double classMedian) {
      this.classMedian = classMedian;
   }
   public void setThisCourse (Course thisCourse) {
      this.thisCourse = thisCourse;
   }
   
   // methods
   public void updateAvg() {
      classMean = calcMean();
      classMedian = calcMedian();
   }
   private double calcMean () {
      ArrayList<MyCourse> classList = thisCourse.getStudentInCourseList();
      int numStudent = thisCourse.getNumStudent();
      double sum = 0;
      for (int i = 0; i < numStudent; i++) {
         sum += classList.get(i).getWeightedAverage();
      }
      return sum/numStudent;
   }
   private double calcMedian () {
      ArrayList<MyCourse> classList = thisCourse.getStudentInCourseList();
      int numStudent = thisCourse.getNumStudent();
      if (numStudent % 2 == 0) {
         return ((classList.get(numStudent/2)).getWeightedAverage() +
         (classList.get(numStudent/2 + 1)).getWeightedAverage()) / 2;
      } else {
         return (classList.get(numStudent/2 + 1)).getWeightedAverage();
      }
   }
   public String toString () {
      return "";
   }
}