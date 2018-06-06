import java.util.ArrayList;

public class Course {

    //Initializes the fields
    private Teacher teacher;
    private String courseCode;
    private CourseStatistics average;
    private ArrayList <MyCourse> studentInCourseList = new ArrayList<MyCourse>();
    private boolean complete;

    //Constructor
    public Course (Teacher assignedTeacher, String assignedCourseCode, ArrayList <Student> listOfStudents,
                   boolean courseComplete )
    {
        teacher = assignedTeacher;
        courseCode = assignedCourseCode;
        complete = courseComplete;
        
        

    }

    //Methods
    public void addStudentToCourse (Student other)
    {
        studentInCourseList.add(/*student my course */);
    }
}
