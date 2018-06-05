import java.security.Principal;
import java.util.ArrayList;

public class School {
    String schoolName;
    String schoolID;
    ArrayList <User> listOfStudents = new ArrayList <User>();
    ArrayList <User> listOfTeachers = new ArrayList <User>();
    ArrayList <User> listOfGuidanceCouns = new ArrayList <User>();
    User principal;
    Student user;

    public School ()
    {

    }

    public String getSchoolID() {
        return schoolID;

        ;
    }

    public String getSchoolName() {
        return schoolName;
    }



    public void updateStudentList (Student other)
    {
        listOfStudents.add(other);
    }
    public void updateTeacherList (Teacher other)
    {
        listOfStudents.add(other);
    }
    public void updateGuidanceCouns (Guidance other)
    {
        listOfGuidanceCouns.add(other);
        // need to make guidance class
    }


}
