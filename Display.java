import java.util.*;

public class Display {
    private String userID;
    private String password;
    private int schoolIndex;
    private int userIndex;
    private char userType;
    private static Scanner input = new Scanner(System.in);

    public void optionMenu() {

    }

    public void logIn(ArrayList<School> schoolArrayList) {
        String schoolAcronym, restOfID, currentUserResOfID;
        boolean userFound, passCorrect;

        System.out.print("Please enter your user ID: ");
        userID = input.next(); // check password

        schoolAcronym = userID.substring(0, 3);
        userType = userID.charAt(3);
        restOfID = userID.substring(3, userID.length());

        for (int i = 0; i < schoolArrayList.size(); i++) {
            if (schoolArrayList.get(i).schoolID.equalsIgnoreCase(schoolAcronym)) {
                schoolIndex = i;
            }
        }
        if (userType == 'S') {
            for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfStudents.size(); i ++)
            {
                 currentUserResOfID = schoolArrayList.get(schoolIndex).listOfStudents.get(i).getUserID().substring(3,
                        schoolArrayList.get(schoolIndex).listOfStudents.get(i).getUserID().length());
                if (restOfID.equalsIgnoreCase(currentUserResOfID))
                {
                    userFound = true;
                    userIndex = i;
                }
                else
                {
                    userFound = false;
                }
            }
        } else if (userType == 'T') {
            for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfTeachers.size(); i ++)
            {
                currentUserResOfID = schoolArrayList.get(schoolIndex).listOfTeachers.get(i).getUserID().substring(3,
                        schoolArrayList.get(schoolIndex).listOfTeachers.get(i).getUserID().length());
                if (restOfID.equalsIgnoreCase(currentUserResOfID))
                {
                    userFound = true;
                    userIndex = i;
                }
                else
                {
                    userFound = false;
                }
            }
        } else if (userType == 'G') {
            for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfGuidanceCouns.size(); i ++)
            {
                currentUserResOfID = schoolArrayList.get(schoolIndex).listOfGuidanceCouns.get(i).getUserID().substring(3,
                        schoolArrayList.get(schoolIndex).listOfGuidanceCouns.get(i).getUserID().length());
                if (restOfID.equalsIgnoreCase(currentUserResOfID))
                {
                    userFound = true;
                    userIndex = i;
                }
                else
                {
                    userFound = false;
                }
            }
        } else if (userType == 'P') {

            currentUserResOfID = schoolArrayList.get(schoolIndex).principal.getUserID().substring(3,
                    schoolArrayList.get(schoolIndex).principal.getUserID().length());
            if (restOfID.equalsIgnoreCase(currentUserResOfID))
            {
                userFound = true;
        }
        else 
            {
                userFound = false;
            }
    } else {
            
        }
        
        
        System.out.print("Please enter your password: ");
        password = input.next();
        

        findCorrectInfo(schoolArrayList, schoolAcronym, restOfID);

        callCorrectDisplay();


    }

    public void studentOptions() {

    }

    public void teacherOptions() {

    }

    public void guidanceOptions() {

    }

    public void principalOptions() {

    }

    public void adminOptions() {

    }
    public void logOut ()
    {

    }
    public void findCorrectInfo (ArrayList<School> schoolArrayList, String schoolAcronym, String restOfID)
    {
        String currentUserResOfID;
        
        //find user if student

    }

    public void callCorrectDisplay() {
        if (userType == 'S') {
            studentOptions();
        } else if (userType == 'T') {
            teacherOptions();
        } else if (userType == 'G') {
            guidanceOptions();
        } else if (userType == 'P') {
            principalOptions();
        } else {
            adminOptions();
        }
    }
}
