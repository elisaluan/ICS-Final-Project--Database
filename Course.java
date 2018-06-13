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
    
    //Accessors
    public ArrayList<MyCourse> getStudentInCourseList() {
        return studentInCourseList;
    }

    public CourseStatistics getAverage() {
        return average;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public boolean isComplete() {
        return complete;
    }
    
    //Mutators
    public void setAverage(CourseStatistics average) {
        this.average = average;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setStudentInCourseList(ArrayList<MyCourse> studentInCourseList) {
        this.studentInCourseList = studentInCourseList;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    

    //Methods
    public void addStudentToCourse (Student other)
    {
        studentInCourseList.add(/*student my course */);
    }
}
