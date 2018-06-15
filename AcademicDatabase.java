import java.lang.*;
import java.util.*;

public class AcademicDatabase {
    private final String STUDENT_PREFIX = "STU";
    private final String TEACHER_PREFIX = "TEA";
    private final String SCHOOL_PREFIX = "SCH";
    private final String PRINCIPAL_PREFIX = "PRI";
    private static ArrayList <School> tdsbSchoolList= new ArrayList <School> ();

    private int numDigit = 6;


    public String getSTUDENT_PREFIX() {
        return STUDENT_PREFIX;
    }

    public String getTEACHER_PREFIX() {
        return TEACHER_PREFIX;
    }

    public String getSCHOOL_PREFIX() {
        return SCHOOL_PREFIX;
    }

    public String getPRINCIPAL_PREFIX() {
        return PRINCIPAL_PREFIX;
    }

    public static ArrayList<School> getTdsbSchoolList() {
        return tdsbSchoolList;
    }

    public int getNumDigit() {
        return numDigit;
    }

    //Class to sort students at every school by their last name in alphabetical order using bubble sort
    public void sortStudentLastAZ(){
        //For loop to loop through every school
        for (int school = 0; school < tdsbSchoolList.size(); school++){
            //variable to check if array is sorted
            boolean sorted = false;
            //Outer for loop for bubble sort
            for (int i = 0; i < tdsbSchoolList.get(school).listOfStudents.size() && sorted == false; i++){
                sorted = true;
                //Inner for loop for bubble sort
                for (int j = 0; j < tdsbSchoolList.get(school).listOfStudents.size() - i - 1; j++){
                    //Initializes two Students to be sorted
                    Student stud1 = tdsbSchoolList.get(school).listOfStudents.get(j);
                    Student stud2 = tdsbSchoolList.get(school).listOfStudents.get(j+1);
                    //Determines if the first student should be put after the second student
                    if (stud1.getFirstName().charAt(0) > stud2.getFirstName().charAt(0)){
                        //If a sort happens sets indicates that the array is not yet sorted
                        sorted = false;

                        //swaps the two students
                        tdsbSchoolList.get(school).listOfStudents.get(j).set(stud2);
                        tdsbSchoolList.get(school).listOfStudents.get(j+1).set(stud1);
                    }
                }
            }
        }
    }

    //Class to sort students at every school by their current year's average in decreasing order by bubble sort
    public void sortStudentHL(){
        //For loop to loop through every school
        for (int school = 0; school < tdsbSchoolList.size(); school++){
            //Boolean to check if array is sorted
            boolean sorted = false;

            //Outer for loop for bubble sort
            for (int i = 0; i < tdsbSchoolList.get(school).listOfStudents.size() && sorted == false; i++){
                sorted = true;

                //Inner for loop for bubble sort
                for (int j = 0; j < tdsbSchoolList.get(school).listOfStudents.size() - i - 1; j++){
                    //Initializes two Students to be sorted
                    Student stud1 = tdsbSchoolList.get(school).listOfStudents.get(j);
                    Student stud2 = tdsbSchoolList.get(school).listOfStudents.get(j+1);

                    //Determines if the first student has a lower average than the second student
                    if (stud1.getTranscript().getYearList.get(stud1.getTranscript().getYearList.size()-1).calcYearAverage()
                            < stud2.getTranscript().getYearList.get(stud1.getTranscript().getYearList.size()-1).calcYearAverage()) {
                        //If a sort happens sets indicates that the array is not yet sorted
                        sorted = false;

                        //swaps the two students
                        tdsbSchoolList.get(school).listOfStudents.set(j,stud2);
                        tdsbSchoolList.get(school).listOfStudents.set(j+1,stud1);
                    }
                }
            }
        }
    }

    //Method to change all names to lower case
    public String standardizeName(String name) {
        //returns the name all in lower case
        return name.toLowerCase();
    }

    //Method to take in an ID and check if no other user has this ID
    public boolean checkUnique(String ID){
        //loops through all users
        int numUsers = allUsers.size();
        for (int userIndex = 0; userIndex < numUsers; userIndex++) {
            //returns false if a user already has this ID
            if (ID == allUsers.get(userIndex).getUserID())
                return false;
        }

        //if no other user has this ID, returns true
        return true;
    }

    private String digitGenerator(int numDigit, String soFar){
        if (numDigit == 0) {
            return soFar;
        } else {
            return digitGenerator(numDigit - 1, soFar + (int)(Math.random()*10));
        }
    }

    //calls digitGenerator to generate an ID for student, also checks whether the generated ID is unique
    //checks if id is unique, if not, regenerates id
    public String studentIDGenerator (){
        String studentID;
        do {
            studentID = STUDENT_PREFIX + digitGenerator(numDigit, "");
        }while(!(checkUnique(studentID)));
        return studentID;
    }
    //calls digitGenerator to generate an ID for teacher
    //checks if id is unique, if not, regenerates id
    public String teacherIDGenerator (){
        String teacherID;
        do {
            teacherID = TEACHER_PREFIX + digitGenerator(numDigit, "");
        }while(!(checkUnique(teacherID)));
        return teacherID;
    }
    public String principalIDGenerator () {
        String principalID;
        do {
            principalID = PRINCIPAL_PREFIX + digitGenerator(numDigit, "");
        } while (!(checkUnique(principalID)));
        return principalID;
    }
    public String schoolIDGenerator () {
        String schoolID;
        do {
            schoolID = SCHOOL_PREFIX + digitGenerator(numDigit, "");
        } while (!(checkUnique(schoolID)));
        return schoolID;
    }
}
