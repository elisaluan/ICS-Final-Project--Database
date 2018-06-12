public class MyCourse {
	
	// FIELDS
	
   private Student student;
   private String courseCode;
   private String courseName;
   private static final int PASS_BOUND = 50;
   private double currentAverage;
   private int weightDen;
   private double weightedAverage;
   
///////////////////////////////////////////////////////////////////////////////////
   
   // CONSTRUCTORS
   
   public MyCourse(Student student, String code, String name, double avg, int weight, double weightedAvg)
   {
	   this.student = student;
	   courseCode = code;
	   courseName = name;
	   currentAverage = avg;
	   weightDen = weight;
	   weightedAverage = weightedAvg;
   }
   
///////////////////////////////////////////////////////////////////////////////////
   
   // ACCESSORS
   
   public Student getStudent () {
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
   
///////////////////////////////////////////////////////////////////////////////////

   // MUTATORS
   
   public void setStudent (Student student) {
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
   
///////////////////////////////////////////////////////////////////////////////////
   
   // METHODS
   
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
