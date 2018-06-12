import java.security.Principal;
import java.util.ArrayList;

public class School {
    String schoolName;
    String schoolID;
    ArrayList <Student> listOfStudents = new ArrayList <User>();
    ArrayList <Teacher> listOfTeachers = new ArrayList <User>();
    ArrayList <GuidanceCounselor> listOfGuidanceCouns = new ArrayList <User>();
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
