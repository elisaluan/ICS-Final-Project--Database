import java.util.*;

public class Student {
	
	// FIELDS
	
	private int numCourses;
	private creditSummary transcript;
	private int grade;
	private boolean esl;
	private boolean internationalStudent;
	private boolean iep;
	
//////////////////////////////////////////////////////////////////
	
	// CONSTRUCTOR
	
	public Student(int courses, creditSummary transcript, int level, boolean esl, boolean international, boolean iep)
	{
		numCourses = courses;
		this.transcript = transcript;
		grade = level;
		this.esl = esl;
		internationalStudent =  international;
		this.iep = iep;
	}

/////////////////////////////////////////////////////////////////
	
	// ACCESSORS
	
	public int getNumCourse()
	{
		return numCourses;
	}
	
	public creditSummary getTranscript()
	{
		return transcript;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public boolean getESL()
	{
		return esl;
	}
	
	public boolean getInternationalStudent()
	{
		return internationalStudent;
	}
	
	public boolean getIEP()
	{
		return iep;
	}
	
///////////////////////////////////////////////////////////////////
	
	// MUTATORS
	
	public void setNumCourse (int num)
	{
		numCourses = num;
	}
	
	public void setTranscript (creditSummary transcript)
	{
		this.transcript = transcript;
	}
	
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	
	public void setESL (boolean ifYes) 
	{
		esl = ifYes;
	}
	
	public void setInternatoinalStudent (boolean ifYes)
	{
		internationalStudent = ifYes;
	}
	
	public void setIEP (boolean ifYes)
	{
		iep = ifYes;
	}

///////////////////////////////////////////////////////////////////////////////
	
	// METHODS
	
	
	
	
	
	
	
}