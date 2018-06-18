/*
* CourseStatistics.java
* CourseStatistics Class stores the numerical statistics of the class, this
* includes points such as the class median, and median as well as which course
* the data pertains to. The class contains the following methods:
*        + updateAverage: calls on the calcMean and calcMedian methods to update average
*        - calcMean: calculates the mean and updates the value in the respective field
*        - calcMedian: calculates the median and updates the value in the respective field
*        + toString: prints out the course, median and mean
*     Class also contains the necessary accessors and mutators
*
*  Note: in order to create a new instance of courseStatistics, one can pass in only the Course
*        or the Course, classMedian, and class Mean into the constructor 
*/

import java.util.*;

public class CourseStatistics {
   /*
   *  FIELDS: classMean, classMedian, Course (all have accessors and mutators)
   */
   private double classMean;
   private double classMedian;
   private Course thisCourse;
   
   
   
   /*
   *  CONSTRUCTOR: 
   *     - can create a new object by passing in the Course
   *     - can create a new object by passing in the Course, classMedian, classMean
   *   Note: no empty constructor, at very least requires corresponding Course
   */
   public CourseStatistics(Course thisCourse) {
		classMean = 100;
		classMedian = 100;
		this.thisCourse = thisCourse;
	} // CourseStatistics constructor - a Course as parameter
   
   public CourseStatistics(double classMean, double classMedian, Course thisCourse) {
		if (classMean >= 0) {
         this.classMean = classMean;
      } else {
         this.classMean = 100;
      } // checks if valid classMean - if not default to 100
      
      if (classMedian >= 0) {
		   this.classMedian = classMedian;
      } else {
         this.classMean = 100;
      } // checks if valid classMedian - if not default to 100
      
      this.thisCourse = thisCourse;
	} // CourseStatistics constructor - classMean, classMedian, a Course as parameter
   
   
   
   /* 
   *  ACCESSORS:
   *     + getClassMean, + getClassMedian, + getThisCourse
   *  returns varables of type double, double, Course respectively 
   */
   public double getClassMean () {
      return classMean;
   } // classMean accessor
   
   public double getClassMedian () {
      return classMedian;
   } // classMedian accessor
   
   public Course getThisCourse () {
      return thisCourse;
   } // thisCourse accessor
   
   
   /* 
   *  MUTATORS:
   *     + setDay, + setMonth, + setYear
   *  passes in variables of type int, checks if a valid day, month,
   *  or year are passed in respectively. If yes, sets the field to the
   *  passed in value
   *
   *    Note: assume number of days in a month are constant: 31 days 
   */
   
   public void setClassMean (double classMean) {
      if (classMean >= 0) {
         this.classMean = classMean;
      } else {
         this.classMean = 100;
      } // checks if valid classMean - if not default to 100
   } // setClassMean mutator
   
   public void setClassMedian (double classMedian) {
      if (classMedian >= 0) {
		   this.classMedian = classMedian;
      } else {
         this.classMean = 100;
      } // checks if valid classMedian - if not default to 100
   } // setClassMedian mutator
   
   public void setThisCourse (Course thisCourse) {
      this.thisCourse = thisCourse;
   } // setThisCourse mutator
   
   
   /*
   *  METHODS:
   *     + updateAvg
   *     - calcMean
   *     - calcMedian
   *     + toString
   */
   
   // updateAvg public method
   //       - calls on calcMean and calcMedian to update the two types of
   //         statistical data found in CourseStatistics
   public void updateAvg() {
      classMean = calcMean();
      classMedian = calcMedian();
   } // updateAverage method
   
   // calcMean public method
   //       - loops through the arraylist for the corresponding Course which 
   //         contains the classList of various MyCourses for different students
   //       - adds the sum of all the weighted averages for the students
   //       - divides some by the number of students to find the mean
   //    returns: value of type double (mean)
   private double calcMean () {
      ArrayList<MyCourse> classList = thisCourse.getStudentInCourseList();
      int numStudent = thisCourse.getNumStudent();
      double sum = 0;
      for (int i = 0; i < numStudent; i++) {
         sum += classList.get(i).getWeightedAverage();
      } // for loop - adds sum of all the weighted averages of the students
      return sum/numStudent; // calculates and returns the mean of type double
   } // calcMean method
   
   
   // calcMedian public method
   //       - sorts the list of students in the course
   //       - determines the middle of the list
   //             - if even number of students: take average between centermost values
   //             - if odd number of students: take the centermost values
   private double calcMedian () {
      ArrayList<MyCourse> classList = thisCourse.getStudentInCourseList();
      thisCourse.sortStudentMarkHL();
      int numStudent = thisCourse.getNumStudent();
      if (numStudent % 2 == 0) {
         return ((classList.get(numStudent/2)).getWeightedAverage() +
         (classList.get(numStudent/2 + 1)).getWeightedAverage()) / 2;  // odd: take avg of centre two
      } else {
         return (classList.get(numStudent/2 + 1)).getWeightedAverage(); // even: take centre value 
      } // determines if there are an even or odd number of students
   } // calcMedian method
   
   // toString public method
   //       - formats output for CourseStatistics such that the courseCode, classMean,
   //         and classMedian outputs are labelled
   //    returns: String of the output
   public String toString() {
		return "Course Code: " + thisCourse.getCourseCode() + 
             "\nClass Mean: " + classMean + 
             "\nClass Median: " + classMedian;
	} // toString method
} // CourseStatistics Class