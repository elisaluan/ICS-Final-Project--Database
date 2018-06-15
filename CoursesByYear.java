public class CoursesByYear {
	
	// FIELDS
	
	private final int NUM_SEMESTERS = 2;
	private CoursesBySemester[] semesterList = new CoursesBySemester[NUM_SEMESTERS];
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// CONSTRUCTORS
	
	public CoursesByYear(CoursesBySemester[] courses)
	{
		for(int i = 0 ; i < NUM_SEMESTERS ; i++)
		{
			semesterList[i] = courses[i];
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ACCESSORS
	
	public CoursesBySemester [] getSemesterList () {
	      return semesterList;
	   }
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// MUTATORS
	
	public void setSemesterList (CoursesBySemester[] semesterList) {
	      this.semesterList = semesterList;
	   }
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// METHODS
	
	public String toString ()
   {
      String output = "Semester #1: " + semesterList[0] + "\n//////////////////////////////////\nSemester #2: " 
              + semesterList[1];
      return output;
   }

   public double calcYearAverage ()
   {
      double totalSum = 0, average;

      for (int i = 0; i < NUM_SEMESTERS; i ++)
      {
         totalSum = semesterList[i].calcSemAverage() + totalSum;
      }
      average = totalSum/NUM_SEMESTERS;
      return average;
   }
}
