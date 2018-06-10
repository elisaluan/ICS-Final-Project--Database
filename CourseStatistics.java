import java.util.*;

public class CourseStatistics{
 
	// FIELDS
	
	private double classMean;
	private double classMedian;
	private String courseCode;
	
///////////////////////////////////////////////////////////////////////////////////
	
	// CONSTRUCTORS
	
	public CourseStatistics(double mean, double median, String code)
	{
		classMean = mean;
		classMedian = median;
		courseCode = code;
	}
	
	public CourseStatistics()
	{
		classMean = 100;
		classMedian = 100;
		courseCode = "XXXXXX-00";
	}
	
///////////////////////////////////////////////////////////////////////////////////
	
	// ACCESSORS
	
	public double getClassMean()
	{
		return classMean;
	}
	
	public double getClassMedian()
	{
		return classMedian;
	}
	
	public String getCourseCode()
	{
		return courseCode;
	}
	
///////////////////////////////////////////////////////////////////////////////////
	
	// MUTATORS

	public void setClassMean(double mean)
	{
		classMean = mean;
	}
	
	public void setClassMedian(double median)
	{
		classMedian = median;
	}
	
	public void setCourseCode(String code)
	{
		courseCode = code;
	}
	
///////////////////////////////////////////////////////////////////////////////////
	
	// METHODS
	
	public void updateAvg()
	{
		
	}
	
	public double calcMean(ArrayList<MyAssessment> list)
	{
		double total = 0;
		double num;
		double den;
		for(int i = 0 ; i < list.size() ; i++)
		{
			num = list.get(i).getAssessmentNum();
			den = list.get(i).getAssessmentDen();
			total += (num / den) * 100;
		}
		return total / list.size();
	}
	
	public double calcMedian(ArrayList<MyAssessment> list)
	{
		double median;
		int half = list.size() / 2 + 1;
		
		if(list.size() % 2 != 0)
		{
			MyAssessment assess1 = list.get(half);
			MyAssessment assess2 = list.get(half-1);
			double assess1Avg = (assess1.getAssessmentNum() / assess1.getAssessmentDen()) * 100;
			double assess2Avg = (assess2.getAssessmentNum() / assess2.getAssessmentDen()) * 100;
			median = (assess1Avg + assess2Avg) / 2;
		}else
		{
			median = (list.get(half).getAssessmentNum() / list.get(half).getAssessmentDen()) * 100;
		}
		return median;
	}
	
	public String toString()
	{
		return "Course Code: " + courseCode + "Class Mean: " + classMean + "\nClass Median: " + classMedian;
	}
}
