import java.util.*;

public class Display {
    private String userID;
    private String password;
    private int schoolIndex;
    private int userIndex;
    private char userType;
    private static Scanner input = new Scanner(System.in);
    private static ArrayList <School> schoolArrayList;

    public Display (ArrayList<School> schoolArrayList)
    {
        this.schoolArrayList = schoolArrayList;
    }


    public void logIn() {
        String schoolAcronym, restOfID, currentUserResOfID = "";
        boolean userFound, passCorrect;

        while (true) {

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
                for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfStudents.size(); i++) {
                    currentUserResOfID = schoolArrayList.get(schoolIndex).listOfStudents.get(i).getUserID().substring(3,
                            schoolArrayList.get(schoolIndex).listOfStudents.get(i).getUserID().length());
                    if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                        userFound = true;
                        userIndex = i;
                    } else {
                        userFound = false;
                    }
                }
            } else if (userType == 'T') {
                for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfTeachers.size(); i++) {
                    currentUserResOfID = schoolArrayList.get(schoolIndex).listOfTeachers.get(i).getUserID().substring(3,
                            schoolArrayList.get(schoolIndex).listOfTeachers.get(i).getUserID().length());
                    if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                        userFound = true;
                        userIndex = i;
                    } else {
                        userFound = false;
                    }
                }
            } else if (userType == 'G') {
                for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfGuidanceCouns.size(); i++) {
                    currentUserResOfID = schoolArrayList.get(schoolIndex).listOfGuidanceCouns.get(i).getUserID().substring(3,
                            schoolArrayList.get(schoolIndex).listOfGuidanceCouns.get(i).getUserID().length());
                    if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                        userFound = true;
                        userIndex = i;
                    } else {
                        userFound = false;
                    }
                }
            } else if (userType == 'P') {

                currentUserResOfID = schoolArrayList.get(schoolIndex).principal.getUserID().substring(3,
                        schoolArrayList.get(schoolIndex).principal.getUserID().length());
                if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                    userFound = true;
                    userIndex = -1;
                } else {
                    userFound = false;
                }

            } else if (userType == 'A') {
                //check the admin list
                if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                    userFound = true;
                } else {
                    userFound = false;
                }
            }


            System.out.print("Please enter your password: ");
            password = input.next();

            if (userFound) {
                if (userType == 'S') {

                    if (password.equalsIgnoreCase(
                            schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getPassword())) {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }

                } else if (userType == 'T') {

                    if (password.equalsIgnoreCase(
                            schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).getPassword())) {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }
                } else if (userType == 'G') {
                    if (password.equalsIgnoreCase(
                            schoolArrayList.get(schoolIndex).listOfGuidanceCouns.get(userIndex).getPassword())) {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }

                } else if (userType == 'P') {
                    if (password.equalsIgnoreCase(
                            schoolArrayList.get(schoolIndex).principal.getPassword())) {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }

                } else if (userType == 'A') {
                    if () {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }
                }
            }
            if (passCorrect && userFound) {
                if (userType == 'S') {
                    studentOutput();
                } else if (userType == 'T') {
                    teacherOutput();

                } else if (userType == 'G') {
                    guidanceOutput();

                } else if (userType == 'P') {
                    principalOutput();

                } else if (userType == 'A') {
                    adminOutput();
                }

            }
            else
            {
                System.out.println("The password or user name entered is invalid.");
                System.out.println("Please try again");
            }

        }
    }//log in method

    public void studentOutput() {
            boolean logOut = false;
            int choice;
            double totalSum, average;
        String output;

            while (!logOut)
            {
                try {
                    System.out.println("");
                    System.out.println("Menu:");
                    System.out.println("1) View credit counselling\n" +
                            "2) View year summary (includes courses, marks, and averages (own and class))\n" +
                            "3) View average\n" +
                            "4) View individuals marks per course\n" +
                            "5) View volunteer hours\n" +
                            "6) Update Password\n");
                    choice = input.nextInt();
                    if (choice == 1)
                    {
                         output = (schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript()).toString();
                        System.out.println(output);
                    }
                    else if (choice == 2)
                    {

                        System.out.println("");
                        System.out.println("What year would you like to look: ");
                        choice = input.nextInt();
                        int grade9Year = 14 + schoolArrayList.get(schoolIndex).
                                listOfStudents.get(userIndex).getBirthDate().getYear();
                        choice = choice - grade9Year;

                        for (int i = 0; i < 0; i ++)
                        {
                            //output the my course list for that year
                        }
                    }
                    else if (choice == 3)
                    {
                        System.out.println("which grade would you like to look up");
                        System.out.println("1) Grade 9 \n2) Grade 10 \n3) Grade 11 \n4) Grade 12\n5) Other \n6) All Years");
                        System.out.print("Your Choice: ");
                        choice = input.nextInt();
                        if (choice == 1)
                        {
                            
                        }
                        else if (choice == 2)
                        {

                        }
                        else if (choice == 3)
                        {

                        }
                        else if (choice == 4)
                        {

                        }
                        else if (choice == 5)
                        {

                        }
                        else if (choice == 6)
                        {

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                        }
                    }
                } catch (InputMismatchException e)
                {
                    System.out.println("");
                    System.out.println("The option you entered is invalid please try again.");
                }


            }
    }

    public void teacherOutput() {

    }

    public void guidanceOutput() {

    }

    public void principalOutput() {

    }

    public void adminOutput() {

    }

    public void logOut() {

    }


}
