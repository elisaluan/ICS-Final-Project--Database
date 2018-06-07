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
        average = new CourseStatistics(/*Add fields to pass in*/);
        for (int i = 0; i < listOfStudents.size(); i ++)
        {
            if ((/*student course code*/).equals (courseCode))
            {
                addStudentToCourse(listOfStudents.get(i));
            }
        }

    }

    //Methods
    public void addStudentToCourse (Student other)
    {
        studentInCourseList.add(/*student my course */);
    }
}
