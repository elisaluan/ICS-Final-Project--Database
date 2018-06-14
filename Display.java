import java.util.*;

public class Display {
    private String userID;
    private String password;
    private int schoolIndex;
    private int userIndex;
    private char userType;
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<School> schoolArrayList;

    public Display(ArrayList<School> schoolArrayList) {
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

            } else {
                System.out.println("The password or user name entered is invalid.");
                System.out.println("Please try again");
            }

        }
    }//log in method

    public void studentOutput() {
        boolean logOut = false, validInput = false;
        String choice;
        int numInput;
        double totalSum = 0, average = 0;
        String output;

        while (!logOut) {
            try {
                System.out.println("");
                System.out.println("Menu:");
                System.out.println("A) View credit counselling\n" +
                        "B) View year summary (includes courses, marks, and averages (own and class))\n" +
                        "C) View average\n" +
                        "D) View individuals marks per course\n" +
                        "E) Update Password\n" + "F) To Logout Please type \"logout\" or choose this option\n");
                choice = input.nextLine();
                if (choice.equalsIgnoreCase("A")) {
                    output = (schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript()).toString();
                    System.out.println(output);
                } else if (choice.equalsIgnoreCase("B")) {
                    //Doesn't make sense because of the date
                    //possible solution: Add a date object to the CourseByYear
                    System.out.println("");
                    System.out.println("What year would you like to look: ");
                    numInput = input.nextInt();
                    int grade9Year = 14 + schoolArrayList.get(schoolIndex).
                            listOfStudents.get(userIndex).getBirthDate().getYear();
                    numInput = numInput - grade9Year;

                    for (int i = 0; i < 0; i++) {
                        //output the my course list for that year
                    }
                } else if (choice.equalsIgnoreCase("C")) {
                    while (!validInput) {
                        System.out.println("which grade would you like to look up");
                        System.out.println("A) Grade 9 \nB) Grade 10 \nC) Grade 11 \nD) Grade 12\nE) Other \nF) All Years");
                        System.out.print("Your Choice: ");
                        choice = input.nextLine();
                        if (choice.equalsIgnoreCase("A")) {
                            System.out.println("Your average in grade 9 is: " +
                                    schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().
                                            getYearList().get(0).calcYearAverage());
                            validInput = true;
                        } else if (choice.equalsIgnoreCase("B")) {
                            validInput = true;
                            if (/*check if old enough*/) {
                                System.out.println("Your average in grade 10 is: " +
                                        schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().
                                                getYearList().get(1).calcYearAverage());
                            }
                        } else if (choice.equalsIgnoreCase("C")) {
                            validInput = true;
                            if (/*check if old enough*/) {
                                System.out.println("Your average in grade 11 is: " +
                                        schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().
                                                getYearList().get(2).calcYearAverage());
                            }
                        } else if (choice.equalsIgnoreCase("D")) {
                            validInput = true;
                            if (/*check if old enough*/) {
                                System.out.println("Your average in grade 12 is: " +
                                        schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().
                                                getYearList().get(3).calcYearAverage());
                            }
                        } else if (choice.equalsIgnoreCase("E")) {
                            validInput = true;
                            do {
                                System.out.println("What grade would you like to look at?");
                                numInput = input.nextInt();
                                if (numInput >= 9 && choice <= /*Max Grade*/) {
                                    System.out.println("Your average in grade " + choice + "is: " +
                                            schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().
                                                    getYearList().get(numInput - 9).calcYearAverage());
                                } else {
                                    System.out.println("");
                                    System.out.println("Invalid Input");
                                }
                            } while (numInput >= 9 && choice <= /*Max Grade*/);
                        } else if (choice.equalsIgnoreCase("F")) {
                            validInput = true;
                            for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).
                                    getTranscript().getYearList().size(); i++) {
                                System.out.println("Your average in grade " + (i + 9) + "is: " +
                                        schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().
                                                getYearList().get(i).calcYearAverage());
                            }
                        } else {
                            System.out.println("Invalid Input");
                        }
                    }
                    validInput = false;
                } else if (choice.equalsIgnoreCase("D")) {
                    while (!validInput) {
                        System.out.print("Please enter the course code you like to look up: ");
                        choice = input.nextLine();
                        if (schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).getTranscript().searchByCourse(choice)
                                == null) {
                            System.out.println("The course code entered is invalid please try again.");
                        } else {
                            System.out.println(schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).
                                    getTranscript().searchByCourse(choice));
                            validInput = true;
                        }
                    }
                    validInput = false;
                } else if (choice.equalsIgnoreCase("E")) {
                    System.out.print("Please enter your new password: ");
                    choice = input.nextLine();
                    schoolArrayList.get(schoolIndex).listOfStudents.get(userIndex).setPassword(choice);
                    System.out.println("Password Changed.");
                } else if (choice.equalsIgnoreCase("logout") || choice.equalsIgnoreCase("F")) {
                    logOut = true;
                } else {
                    System.out.println("Invalid Input, Please Try Again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("The option you entered is invalid please try again.");
            }


        }
    }

    public void teacherOutput() {
        boolean logOut = false, validInput = false;
        String choice;
        int numInput = -1;
        double totalSum = 0, average = 0;


        while (!logOut) {
            try {
                System.out.println(
                        "A) View courses (list format)\n" +
                                "B) View course (assessments, grades, students) by course code\n" +
                                "C) View students in a course\n" +
                                "D) Search for Students In Course (by ID and name or by ID only)\n" +
                                "E) Sort Class (given course ID) - Alphabetical, Average\n" +
                                "F) Search in class (Given Course ID)\n" +
                                "G) Input new assessment/quiz/test\n" +
                                "H) Edit assessment/quiz/test\n" + "I) To Logout Please type \"logout\" or choose this option\n");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("A")) {
                    while (!validInput) {
                        System.out.println("Please choose how you would like to view your courses");
                        System.out.println("A) All Courses\n" + "B) Courses Taught\n" + "C) Courses Teaching\n");
                        System.out.print("Your Choice: ");
                        choice = input.nextLine();

                        if (choice.equalsIgnoreCase("A")) {
                            validInput = true;

                        } else if (choice.equalsIgnoreCase("B")) {
                            validInput = true;

                        } else if (choice.equalsIgnoreCase("C")) {
                            validInput = true;
                            for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                    getCourseArrayList().size(); i ++)
                            {
                                System.out.println(schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                        getCourseArrayList().get(i));
                            }

                        }
                        else
                        {
                            System.out.println("Invalid Input. Please Try Again");
                        }
                    }
                    validInput = false;

                } else if (choice.equalsIgnoreCase("B")) {

                    while (validInput)
                    {
                        System.out.println("Please enter the course code: ");
                        choice = input.nextLine();



                        for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                getCourseArrayList().size() && !validInput; i ++)
                        {
                            if (schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                    getCourseArrayList().get(i).getCourseCode() .equalsIgnoreCase(choice))
                            {
                                validInput = true;
                                System.out.println(schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                        getCourseArrayList().get(i));
                            }

                        }

                        if (!validInput)
                        {
                            System.out.println("Course Code Invalid. Please Try Again");
                        }
                    }
                    validInput = false;


                } else if (choice.equalsIgnoreCase("C")) {
                    boolean idFound, nameFound = false;
                    String firstName, lastName, id;
                    String foundFirstName, foundLastName;

                    while (validInput)
                    {
                        System.out.println("Please enter the course code: ");
                        choice = input.nextLine();



                        for (int i = 0; i < schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                getCourseArrayList().size() && !validInput; i ++)
                        {
                            if (schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).
                                    getCourseArrayList().get(i).getCourseCode() .equalsIgnoreCase(choice))
                            {
                                validInput = true;
                                numInput = i;
                            }

                        }

                        if (!validInput)
                        {
                            System.out.println("Course Code Invalid. Please Try Again");
                        }
                    }
                    validInput = false;

                    while (!validInput)
                    {
                    System.out.println("Please choose how you would like to search for student");
                    System.out.println("A) By Name\nB) By Student ID");
                    System.out.print("Your Choice: ");
                    choice = input.nextLine();


                        if (choice.equalsIgnoreCase("A"))
                        {
                            validInput = true;
                            while (!nameFound) {
                                System.out.print("Please enter student's first name: ");
                                firstName = input.next();
                                System.out.print("Please enter student's last name: ");
                                lastName = input.next();

                                if (schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).getCourseArrayList().
                                        get(numInput).searchStudentByName(firstName, lastName) != null)
                                {
                                    nameFound = true;
                                    System.out.println(schoolArrayList.get(schoolIndex).listOfTeachers.
                                            get(userIndex).getCourseArrayList().get(numInput).
                                            searchStudentByName(firstName, lastName));
                                }
                                else
                                {
                                    System.out.println("Name not found please try again.");
                                    System.out.println("");
                                }
                            }

                        }
                        else if (choice.equalsIgnoreCase("B"))
                        {
                            validInput = true;
                            idFound = false;
                            String idBeingSearched;
                            while (!idFound) {
                                System.out.println("Please enter student ID: ");
                                choice = input.next();

                                if (schoolArrayList.get(schoolIndex).listOfTeachers.get(userIndex).getCourseArrayList().
                                        get(numInput).searchStudentById(choice) != null)
                                {
                                    nameFound = true;
                                    System.out.println(schoolArrayList.get(schoolIndex).listOfTeachers.
                                            get(userIndex).getCourseArrayList().get(numInput).
                                            searchStudentById(choice));
                                }
                                else
                                {
                                    System.out.println("ID not found please try again.");
                                    System.out.println("");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Choice Please try Again");
                        }
                    }
                    validInput = false;



                } else if (choice.equalsIgnoreCase("D")) {

                    //This is the same as Option C

                } else if (choice.equalsIgnoreCase("E")) {


                } else if (choice.equalsIgnoreCase("F")) {

                } else if (choice.equalsIgnoreCase("G")) {

                } else if (choice.equalsIgnoreCase("H")) {

                } else if (choice.equalsIgnoreCase("logout") || choice.equalsIgnoreCase("I")) {
                    logOut = true;
                } else {
                    System.out.println("Invalid Input. Please try again");
                }




            } catch(InputMismatchException e)
        {
            System.out.println("");
            System.out.println("Your input was invalid. Please try again");
        }
    }

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
