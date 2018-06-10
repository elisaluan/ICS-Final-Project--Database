public class CoursesByYear {
	
	// FIELDS
	
	private final int NUMSEMESTERS = 2;
	private CoursesBySemester[] semesterList = new CoursesBySemester[NUMSEMESTERS];
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// CONSTRUCTORS
	
	public CoursesByYear(CoursesBySemester[] courses)
	{
		for(int i = 0 ; i < NUMSEMESTERS ; i++)
		{
			semesterList[i] = courses[i];
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// METHODS
	
	public String toString()
	{
		String output = "";
		for(int i = 0 ; i < NUMSEMESTERS ; i++)
		{
			output += semesterList[i].toString();
		}
		return output;
	}
}