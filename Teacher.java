public class Teacher extends User {
    final int maxNumOfCourses = 3;
    String coursesTeaching [] = new String [maxNumOfCourses];

    public Teacher (String givenFirstName, String givenLastName, String givenID, String password, int birthYear,
                 int birthDay,int birthMonth)
    {
        super (givenFirstName, givenLastName, givenID, password, birthYear, birthDay,
                birthMonth);


    }

    public void updateCoursesTeaching (/*The list of course Names */)
    {

    }
}
