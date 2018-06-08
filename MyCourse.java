public class MyCourse {
   private String student;
   private String courseCode;
   private String courseName;
   private static int PASS_BOUND = 50;
   private int weightDen;
   private double weightedAverage;
   
   // mutators
   public void setStudent (String student) {
      this.student = student;
   }
   public void setCourseCode (String courseCode) {
      this.courseCode = courseCode;
   }
   public void setCourseName (String courseName) {
      this.courseName = courseName;
   }
   public void setWeightDen (int weightDen) {
      this.weightDen = weightDen;
   }
   public void setWeightedAverage (double weightedAverage) {
      this.weightedAverage = weightedAverage;
   }
   // accessors
   public String getStudent () {
      return student;
   }
   public String getCourseCode () {
      return courseCode;
   }
   public String getCourseName () {
      return courseName;
   }
   public double getCurrentAverage () {
      return currentAverage;
   }
   public double getWeightDen () {
      return weightDen;
   }
   public double getWeightedAverage() {
      return weightedAverage;
   }
   
   // methods
   public void calcWeightAverage () {
   }
   public boolean updateAssessments () {
   }
   public boolean passCourse () {
   }
   public double devFromAvg () {
   }
   public double standDev () {
   }
   public int compareAverageToStudentInCourse() {
   }
   public int compareToAverage() {
   }
   public String toString () {
   }
   
}
