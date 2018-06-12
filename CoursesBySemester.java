import java.util.ArrayList;

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
	//Accessors

	public CoursesBySemester[] getSemesterList() {
		return semesterList;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// METHODS

	public double calcYearAverage ()
	{
		double average, totalSum = 0;
		for (int i = 0; i < NUMSEMESTERS; i ++)
		{
			totalSum = totalSum + semesterList[i].calcSemAverage();
		}

		average = totalSum/NUMSEMESTERS;
		return average;
	}

	public String toString()
	{
		String output = "";
		for(int i = 0 ; i < NUMSEMESTERS ; i++)
		{
			output += semesterList[i];
		}
		return output;
	}
}
