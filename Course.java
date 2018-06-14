import java.util.*;

public class Course {
   private Teacher teacher;
   private String courseCode;
   private CourseStatistics average;
   private int numStudent;
   private ArrayList<MyCourse> studentInCourseList = new ArrayList <MyCourse> ();
   boolean complete;
   
   // accessors
   public Teacher getTeacher () {
      return teacher;
   }
   public String getCourseCode () {
      return courseCode;
   }
   public CourseStatistics getAverage () {
      return average;
   }
   public int getNumStudent () {
      return numStudent;
   }
   
   public ArrayList<MyCourse> getStudentInCourseList () {
      return studentInCourseList;
   }
   
   // mutator
   public void setTeacher (Teacher teacher) {
      this.teacher = teacher;
   }
   public void setCourseCode (String courseCode) {
      this.courseCode = courseCode;
   }
   public void setAverage (CourseStatistics average) {
      this.average = average;
   }
   public void setNumStudent (int numStudent) {
      this.numStudent = numStudent;
   }
   
   public void setStudentInCourseList (ArrayList<MyCourse> studentInCourseList) {
      this.studentInCourseList = studentInCourseList;
   }
   
   // methods
   public void newAssessment () {
   }
   
   public void sortLastNameAZ() {
      int count;
      String temp;
      for (int i = 1; i < numStudent; i++) {
         count = i;
         while (count > 0 && studentInCourseList.get(count).getStudent().compareToLastName(studentInCourseList.get(count-1).getStudent()) < 0) {
            Collections.swap(studentInCourseList, count, count - 1);
            count--;
         }
      }
   }
   
   public void sortFirstNameAZ() {
      int count;
      String temp;
      for (int i = 1; i < numStudent; i++) {
         count = i;
         while (count > 0 && studentInCourseList.get(count).getStudent().compareToFirstName(studentInCourseList.get(count-1).getStudent()) < 0) {
            Collections.swap(studentInCourseList, count, count - 1);
            count--;
         }
      }
   }
   
   public void sortStudentMarkHL () {
      int lengthList = numStudent;
      int highestIndex = 0;
      
      for (int i = 0; i < lengthList - 1; i++) {
         highestIndex = 0;
         for (int j = 0; j < lengthList - i; j++) {
            if (studentInCourseList.get(j).getWeightedAverage() < studentInCourseList.get(highestIndex).getWeightedAverage()) {
               highestIndex = j;
            }
         }
         Collections.swap(studentInCourseList, highestIndex, lengthList - (i+1));
      }
   }  
   
   public void sortStudentMarkLH () {
      int lengthList = numStudent;
      int highestIndex = 0;
      
      for (int i = 0; i < lengthList - 1; i++) {
         highestIndex = 0;
         for (int j = 0; j < lengthList - i; j++) {
            if (studentInCourseList.get(j).getWeightedAverage() > studentInCourseList.get(highestIndex).getWeightedAverage()) {
               highestIndex = j;
            }
         }
         Collections.swap(studentInCourseList, highestIndex, lengthList - (i+1));
      }
   }
   
   public void sortStudentByID () {
      int listLength = numStudent;
      boolean sorted = false;
      int comparison;
      
      for (int i = 0; i < listLength && !sorted; i++) {
         sorted = true;
         for (int j = 0; j < listLength - (i+1); j++) {
            comparison = studentInCourseList.get(j).getStudent().compareToID(studentInCourseList.get(j+1).getStudent());
            if (comparison > 0) {//compare ID
               Collections.swap(studentInCourseList, j, j+1);
               sorted = false;
            } else if (comparison == 0) {
               if (studentInCourseList.get(j).getStudent().compareToLastName(studentInCourseList.get(j+1).getStudent()) > 0) {
                  Collections.swap(studentInCourseList, j, j+1);
                  sorted = false;
               }
            }
         }
      }
   }
   public Student searchHighestAvg () {
      int index = 0;
      int listLength = numStudent;
      
      for (int i = 1; i < listLength; i++) {
         if (studentInCourseList.get(i).getWeightedAverage() > studentInCourseList.get(index).getWeightedAverage()) {
            index = i;
         }
      }
      
      return studentInCourseList.get(index).getStudent();
   }
   public Student searchStudentByID (String findUserID) {
      int index = -1;
      int bottom = 0;
      int top = numStudent - 1;
      boolean found = false;
      int middle;
      String middleValue;
      
      while (!found && bottom <= top) {
         middle = (bottom + top)/2;
         middleValue = studentInCourseList.get(middle).getStudent().getUserID();
         if (middleValue.equals(findUserID)) {
            found = true;
            index = middle;
         } else if (middleValue.compareToIgnoreCase(findUserID) > 0) { // figure out compare to
            bottom = middle + 1;
         } else {
            top = middle - 1;
         }
      }
      
      return studentInCourseList.get(index).getStudent();
   }
   
   public Student searchStudentByName (String firstName, String lastName) {
      int index = 0;
      int listLength = numStudent;
      
      for (int i = 1; i < listLength; i++) {
         if (studentInCourseList.get(i).getStudent().getLastName().equals(lastName) &&
            studentInCourseList.get(i).getStudent().getFirstName().equals(firstName)) {
            index = i;
         }
      }
      
      return studentInCourseList.get(index).getStudent();
   }
   public void courseComplete () {
      this.complete = true;
   }
   public String toString () {
      return "";
   }
}