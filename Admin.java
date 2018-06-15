import java.sql.Struct;
import java.util.ArrayList;

public class Admin extends User {
    private ArrayList <School> schoolList = AcademicDatabase.getTdsbSchoolList();


    public void addPrincipal (int schoolIndex, Principal principal)
    {
        if (schoolList.get(schoolIndex).getPrincipal() == null)
        {
            schoolList.get(schoolIndex).setPrincipal(principal);
        }
        else
        {
            System.out.println("School already has principal please remove and try again.");
        }

    }
    public void removePrincipal (int schoolIndex)
    {
        schoolList.get(schoolIndex).setPrincipal(null);
    }
    public void addTeacher (int schoolIndex, Teacher teacher)
    {
        schoolList.get(schoolIndex).getListOfTeachers().add(teacher);
    }
    public void removeTeacher (int schoolIndex, int teacherIndex)
    {
        schoolList.get(schoolIndex).getListOfTeachers().remove(teacherIndex);
    }
    public void addStudent (int schoolIndex, Student student)
    {
        schoolList.get(schoolIndex).getListOfStudents().add(student);
    }
    public void removeStudent (int schoolIndex, int studentIndex)
    {
        schoolList.get(schoolIndex).getListOfStudents().remove(studentIndex);
    }
    public void addSchool ( School school)
    {
        schoolList.add(school);
    }
    public void removeSchool (int schoolIndex)
    {
        schoolList.remove(schoolIndex);
    }

    public String toString ()
    {
        String output = super.toString();
        return output;
    }



}//Admin class
