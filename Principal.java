public class Principal extends User {
    private School schoolList;
    
    public Principal (School other)
    {
        schoolList = other;
    }


    public School getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(School schoolList) {
        this.schoolList = schoolList;
    }

    public void addTeacher (Teacher teacher)
    {
        schoolList.listOfTeachers.add(teacher);
    }
    public  void removeTeacher (String teacherID)
    {
        for (int i = 0; i < schoolList.listOfTeachers.size(); i ++)
        {
            if (teacherID.equalsIgnoreCase(schoolList.listOfTeachers.get(i).getUserID()))
            {
                schoolList.listOfTeachers.remove(i);
            }
        }
    }

    public String toString ()
    {
        return "";
    }
}
