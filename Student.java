public class Student extends User {
    boolean eslStudent;
    boolean internationalStudent;
    boolean IEP;
    int grade;
    //add transcript class and

    public Student (String givenFirstName, String givenLastName, String givenID, String password, int birthYear,
                    int birthDay,int birthMonth, boolean isEsl, boolean isInternationalStudent, boolean isIEP, int grade)
    {
        super (givenFirstName, givenLastName, givenID, password, birthYear, birthDay,
                birthMonth);
        eslStudent = isEsl;
        internationalStudent = isInternationalStudent;
        this.grade = grade;
        IEP = isIEP

        }

    public int getGrade() {
        return grade;
    }
}
