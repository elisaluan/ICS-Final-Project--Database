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
	//Accessors

	public ArrayList<MyCourse> getCourseList() {
		return courseList;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// METHODS

	public double calcSemAverage ()
	{
		double totalSum = 0, average;
		for (int i = 0; i < courseList.size(); i ++)
		{
			totalSum = totalSum + courseList.get(i).getCurrentAverage();

		}
		average = totalSum/courseList.size();
		return average;

	}

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
