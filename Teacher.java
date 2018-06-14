import java.util.ArrayList;

public class Teacher extends User {
	
	// FIELDS
	
    private static final int NUMCOURSES = 3;
    private String [] coursesTeaching = new String [NUMCOURSES];
    private ArrayList <Course> courseArrayList = new ArrayList <Course> ();
    private Date beginTeaching;
    
////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // CONSTRUCTORS
    
    public Teacher()
    {
    	
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // ACCESSORS

    public ArrayList<Course> getCourseArrayList() {
        return courseArrayList;
    }

    public static int getNUMCOURSES() {
        return NUMCOURSES;
    }

    public String[] getCoursesTeaching() {
        return coursesTeaching;
    }

    public Date getBeginTeaching() {
        return beginTeaching;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // MUTATORS
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // METHODS
    
    

}
