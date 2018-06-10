import java.util.*;

public class CoursesBySemester {
	
	// FIELDS

	private ArrayList<MyCourse> courseList = new ArrayList<MyCourse>();
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// CONSTRUCTOR
	
	public CoursesBySemester(ArrayList<MyCourse> courses)
	{
		int length = courses.size();
		
		for (int i = 0 ; i < length ; i++)
		{
			courseList.add(courses.get(i));
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// METHODS
	
	public String toString()
	{
		String output = "";
		for(int i = 0 ; i < courseList.size() ; i++)
		{
			output += courseList.get(i).getCourseCode() + " - " + courseList.get(i).getCurrentAverage() + "\n";
		}
		return output;
	}
	
}