import java.util.*;

public class Display {
    private String userID;
    private String password;
    private int schoolIndex;
    private int userIndex;
    private char userType;
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<School> schoolArrayList = AcademicDatabase.getTdsbSchoolList();


    public void logIn() {
        String schoolAcronym, restOfID, currentUserResOfID = "";
        boolean userFound = false, passCorrect = false;

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
                for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfStudents().size(); i++) {
                    currentUserResOfID = schoolArrayList.get(schoolIndex).getListOfStudents().get(i).getUserID().substring(3,
                            schoolArrayList.get(schoolIndex).getListOfStudents().get(i).getUserID().length());
                    if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                        userFound = true;
                        userIndex = i;
                    } else {
                        userFound = false;
                    }
                }
            } else if (userType == 'T') {
                for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().size(); i++) {
                    currentUserResOfID = schoolArrayList.get(schoolIndex).getListOfTeachers().get(i).getUserID().substring(3,
                            schoolArrayList.get(schoolIndex).getListOfTeachers().get(i).getUserID().length());
                    if (restOfID.equalsIgnoreCase(currentUserResOfID)) {
                        userFound = true;
                        userIndex = i;
                    } else {
                        userFound = false;
                    }
                }
            } else if (userType == 'G') {
                for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfGuidanceCouns().size(); i++) {
                    currentUserResOfID = schoolArrayList.get(schoolIndex).getListOfGuidanceCouns().get(i).getUserID().substring(3,
                            schoolArrayList.get(schoolIndex).getListOfGuidanceCouns().get(i).getUserID().length());
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
                currentUserResOfID = AcademicDatabase.getAdmin().getUserID().substring(3,
                        AcademicDatabase.getAdmin().getUserID().length());
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
                            schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).getPassword())) {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }

                } else if (userType == 'T') {

                    if (password.equalsIgnoreCase(
                            schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getPassword())) {
                        passCorrect = true;
                    } else {
                        passCorrect = false;
                    }
                } else if (userType == 'G') {
                    if (password.equalsIgnoreCase(
                            schoolArrayList.get(schoolIndex).getListOfGuidanceCouns().get(userIndex).getPassword())) {
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
                    if (password.equalsIgnoreCase(AcademicDatabase.getAdmin().getPassword())) {
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
                    output = (schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).getTranscript()).toString();
                    System.out.println(output);
                } else if (choice.equalsIgnoreCase("B")) {
                    //Doesn't make sense because of the date
                    //possible solution: Add a date object to the CourseByYear
                    System.out.println("");
                    System.out.println("What year of high school would you like to look: ");
                    numInput = input.nextInt();
                    int grade9Year = 14 + schoolArrayList.get(schoolIndex).
                            getListOfStudents().get(userIndex).getBirthDate().getYear();
                    numInput = numInput - grade9Year;

                    for (int i = 0; i < 0; i++) {
                        //output the my course list for that year
                    }
                } else if (choice.equalsIgnoreCase("C")) {
                    while (!validInput) {
                        System.out.println("");
                        System.out.println("What year of high school would you like to look: ");
                        numInput = input.nextInt();

                        if (numInput < schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).getTranscript().
                                getYearList().size()) {
                            validInput = true;
                            System.out.println(schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).getTranscript().
                                    getYearList().get(numInput).calcYearAverage());
                        } else {
                            System.out.println("The high school year you are looking for is currently invalid.");
                        }
                    }
                    validInput = false;
                } else if (choice.equalsIgnoreCase("D")) {
                    while (!validInput) {
                        System.out.print("Please enter the course code you like to look up: ");
                        choice = input.nextLine();
                        if (schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).getTranscript().searchByCourse(choice)
                                == null) {
                            System.out.println("The course code entered is invalid please try again.");
                        } else {
                            System.out.println(schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).
                                    getTranscript().searchByCourse(choice));
                            validInput = true;
                        }
                    }
                    validInput = false;
                } else if (choice.equalsIgnoreCase("E")) {
                    System.out.print("Please enter your new password: ");
                    choice = input.nextLine();
                    schoolArrayList.get(schoolIndex).getListOfStudents().get(userIndex).setPassword(choice);
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
        logOut();
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
                                "D) Sort Class (given course ID) - Alphabetical, Average\n" +
                                "E) Input new assessment/quiz/test\n" +
                                "F) Edit Student Mark\n" +
                                "G) Update Password\n" +
                                "H) To Logout Please type \"logout\" or choose this option\n");
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
                            for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                    getCourseArrayList().size(); i++) {
                                System.out.println(schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                        getCourseArrayList().get(i));
                            }

                        } else {
                            System.out.println("Invalid Input. Please Try Again");
                        }
                    }
                    validInput = false;

                } else if (choice.equalsIgnoreCase("B")) {

                    while (!validInput) {
                        System.out.println("Please enter the course code: ");
                        choice = input.nextLine();


                        for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                getCourseArrayList().size() && !validInput; i++) {
                            if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                    getCourseArrayList().get(i).getCourseCode().equalsIgnoreCase(choice)) {
                                validInput = true;
                                System.out.println(schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                        getCourseArrayList().get(i));
                            }

                        }

                        if (!validInput) {
                            System.out.println("Course Code Invalid. Please Try Again");
                        }
                    }
                    validInput = false;


                } else if (choice.equalsIgnoreCase("C")) {
                    boolean idFound, nameFound = false;
                    String firstName, lastName, id;
                    String foundFirstName, foundLastName;

                    while (!validInput) {
                        System.out.println("Please enter the course code: ");
                        choice = input.nextLine();


                        for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                getCourseArrayList().size() && !validInput; i++) {
                            if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                    getCourseArrayList().get(i).getCourseCode().equalsIgnoreCase(choice)) {
                                validInput = true;
                                numInput = i;
                            }

                        }

                        if (!validInput) {
                            System.out.println("Course Code Invalid. Please Try Again");
                        }
                    }
                    validInput = false;

                    while (!validInput) {
                        System.out.println("Please choose how you would like to search for student");
                        System.out.println("A) By Name\nB) By Student ID");
                        System.out.print("Your Choice: ");
                        choice = input.nextLine();


                        if (choice.equalsIgnoreCase("A")) {
                            validInput = true;
                            while (!nameFound) {
                                System.out.print("Please enter student's first name: ");
                                firstName = input.next();
                                System.out.print("Please enter student's last name: ");
                                lastName = input.next();

                                if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                        get(numInput).searchStudentByName(firstName, lastName) != null) {
                                    nameFound = true;
                                    System.out.println(schoolArrayList.get(schoolIndex).getListOfTeachers().
                                            get(userIndex).getCourseArrayList().get(numInput).
                                            searchStudentByName(firstName, lastName));
                                } else {
                                    System.out.println("Name not found please try again.");
                                    System.out.println("");
                                }
                            }

                        } else if (choice.equalsIgnoreCase("B")) {
                            validInput = true;
                            idFound = false;
                            String idBeingSearched;
                            while (!idFound) {
                                System.out.println("Please enter student ID: ");
                                choice = input.next();

                                if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                        get(numInput).searchStudentByID(choice) != null) {
                                    nameFound = true;
                                    System.out.println(schoolArrayList.get(schoolIndex).getListOfTeachers().
                                            get(userIndex).getCourseArrayList().get(numInput).
                                            searchStudentByID(choice));
                                } else {
                                    System.out.println("ID not found please try again.");
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("Invalid Choice Please try Again");
                        }
                    }
                    validInput = false;


                }
                else if (choice.equalsIgnoreCase("D")) {

                    while (!validInput) {
                        System.out.println("Please enter the course code: ");
                        choice = input.nextLine();


                        for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                getCourseArrayList().size() && !validInput; i++) {
                            if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                    getCourseArrayList().get(i).getCourseCode().equalsIgnoreCase(choice)) {
                                validInput = true;
                                numInput = i;
                            }

                        }

                        if (!validInput) {
                            System.out.println("Course Code Invalid. Please Try Again");
                        }
                    }
                    validInput = false;
                    while (!validInput) {
                        System.out.println("Please choose how to sort class");
                        System.out.println("");
                        System.out.println(
                                "A) Sort alphabetical Last Name\n" +
                                        "B) Alphabetical First Name\n" +
                                        "C) sort by mark (Highest to lowest)\n" +
                                        "D) sort by mark (Lowest to highest)\n");

                        choice = input.next();

                        if (choice.equalsIgnoreCase("A")) {
                            schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                    get(numInput).sortLastNameAZ();
                            System.out.println("Students Sorted");

                        } else if (choice.equalsIgnoreCase("B")) {
                            schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                    get(numInput).sortFirstNameAZ();
                            System.out.println("Students Sorted");
                        } else if (choice.equalsIgnoreCase("C")) {
                            schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                    get(numInput).sortStudentMarkHL();
                            System.out.println("Students Sorted");
                        } else if (choice.equalsIgnoreCase("D")) {
                            schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                    get(numInput).sortStudentMarkLH();
                            System.out.println("Students Sorted");
                        } else {
                            System.out.println("Invalid Input. Please try again later");
                        }

                    }
                } else if (choice.equalsIgnoreCase("E")) {


                } else if (choice.equalsIgnoreCase("F")) {
                    boolean nameFound = false;
                    String firstName, lastName;
                    Student student = new Student();
                    int mark;


                    while (!validInput) {
                        System.out.println("Please enter the course code: ");
                        choice = input.nextLine();


                        for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                getCourseArrayList().size() && !validInput; i++) {
                            if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                    getCourseArrayList().get(i).getCourseCode().equalsIgnoreCase(choice)) {
                                validInput = true;
                                numInput = i;
                            }

                        }

                        if (!validInput) {
                            System.out.println("Course Code Invalid. Please Try Again");
                        }
                    }
                    validInput = false;

                    validInput = true;
                    while (!nameFound) {
                        System.out.print("Please enter student's first name: ");
                        firstName = input.next();
                        System.out.print("Please enter student's last name: ");
                        lastName = input.next();

                        if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                get(numInput).searchStudentByName(firstName, lastName) != null) {
                            nameFound = true;
                            student = schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).getCourseArrayList().
                                    get(numInput).searchStudentByName(firstName, lastName);
                        } else {
                            System.out.println("Name not found please try again.");
                            System.out.println("");
                        }
                    }

                    System.out.print("Please enter the new mark of student: ");
                    mark = input.nextInt();

                    System.out.print("Please enter the name of assessment: ");
                    choice = input.nextLine();

                    boolean markChanged = schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                            updateAverage(student, (schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).
                                    getCourseArrayList().get(numInput)), choice, mark);

                    if (markChanged) {
                        System.out.println("Mark has been updated");
                    } else {
                        System.out.println("Unable to update mark please try again.");
                    }

                } else if (choice.equalsIgnoreCase("G")) {
                    System.out.print("Please enter your new password: ");
                    choice = input.nextLine();
                    schoolArrayList.get(schoolIndex).getListOfTeachers().get(userIndex).setPassword(choice);
                    System.out.println("Password Changed.");
                } else if (choice.equalsIgnoreCase("logout") || choice.equalsIgnoreCase("H")) {
                    logOut = true;
                } else {
                    System.out.println("Invalid Input. Please try again");
                }

            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Your input was invalid. Please try again");
            }
        }
        logOut();
    }

    public void guidanceOutput() {

    }

    public void principalOutput() {
        boolean logOut = false, validInput = false, teacherRemoved;
        String choice;
        int numInput;
        String firstName, lastName, password, course1, course2, course3;
        int birthYear, birthDay, birthMonth, teachYear, teachMonth, teachDay;


        while (!logOut) {
            try {
                System.out.println("A) Add new teacher\n" + "B) Remove teacher\n" +
                        "C) To Logout Please type \"logout\" or choose this option");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("A")) {
                    System.out.print("Please enter teacher first name: ");
                    firstName = input.next();
                    System.out.print("Please enter teacher last name: ");
                    lastName = input.next();
                    System.out.print("Please enter teacher password: ");
                    password = input.next();
                    System.out.print("Please enter teacher birth year: ");
                    birthYear = input.nextInt();
                    System.out.print("Please enter teacher birth month: ");
                    birthMonth = input.nextInt();
                    System.out.print("Please enter teacher birth day: ");
                    birthDay = input.nextInt();
                    System.out.print("Please enter the year this teacher started teachin: ");
                    teachYear = input.nextInt();
                    System.out.print("Please enter the month this teacher started teachin: ");
                    teachMonth = input.nextInt();
                    System.out.print("Please enter the day this teacher started teachin: ");
                    teachDay = input.nextInt();
                    System.out.print("Please enter the name of the first course: ");
                    course1 = input.nextLine();
                    System.out.print("Please enter the name of the second course: ");
                    course2 = input.nextLine();
                    System.out.print("Please enter the name of the third course: ");
                    course3 = input.nextLine();


                    //make teacher constructor

                } else if (choice.equalsIgnoreCase("B")) {
                    System.out.print("Please enter the teach ID: ");
                    choice = input.nextLine();
                    teacherRemoved = schoolArrayList.get(schoolIndex).principal.removeTeacher(choice);

                    if (teacherRemoved) {
                        System.out.println("Teacher Successfully Removed");
                    } else {
                        System.out.println("Error removing teacher. Please try again");
                    }

                } else if (choice.equalsIgnoreCase("logout") || choice.equalsIgnoreCase("C")) {
                    logOut = true;
                } else {
                    System.out.println("Invalid Input. Please try agai");
                }

            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("The option you entered is invalid please try again.");
            }

        }
        logOut();
    }

    public void adminOutput() {

        boolean logOut = false, validInput = false, schoolFound = false, userFound = false;
        String choice;
        int birthYear, birthDay, birthMonth, teachYear, teachMonth, teachDay, numInput;
        String firstName, lastName, password, course1, course2, course3;


        while (!logOut) {
            try {
                System.out.println("A) Add new principal\n" + "B) Remove Principal\n" + "C) Add new Teacher\n" +
                        "D) Remove Teacher\n" + "E)Add Student\n" + "F)Remove Student" + "G) Add new School" +
                        "H) Remove School" +
                        "I) To Logout Please type \"logout\" or choose this option");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("A")) {

                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }

                    System.out.print("Please enter principal first name: ");
                    firstName = input.next();
                    System.out.print("Please enter principal last name: ");
                    lastName = input.next();
                    System.out.print("Please enter principal password: ");
                    password = input.next();
                    System.out.print("Please enter principal birth year: ");
                    birthYear = input.nextInt();
                    System.out.print("Please enter principal birth month: ");
                    birthMonth = input.nextInt();
                    System.out.print("Please enter principal birth day: ");
                    birthDay = input.nextInt();

                    Principal principal = new Principal(/*fields*/);
                    AcademicDatabase.getAdmin().addPrincipal(schoolIndex, principal);

                } else if (choice.equalsIgnoreCase("B")) {
                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }

                    AcademicDatabase.getAdmin().removePrincipal(schoolIndex);
                    System.out.println("Principal has been removed");
                } else if (choice.equalsIgnoreCase("C")) {
                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }

                    System.out.print("Please enter teacher first name: ");
                    firstName = input.next();
                    System.out.print("Please enter teacher last name: ");
                    lastName = input.next();
                    System.out.print("Please enter teacher password: ");
                    password = input.next();
                    System.out.print("Please enter teacher birth year: ");
                    birthYear = input.nextInt();
                    System.out.print("Please enter teacher birth month: ");
                    birthMonth = input.nextInt();
                    System.out.print("Please enter teacher birth day: ");
                    birthDay = input.nextInt();
                    System.out.print("Please enter the year this teacher started teachin: ");
                    teachYear = input.nextInt();
                    System.out.print("Please enter the month this teacher started teachin: ");
                    teachMonth = input.nextInt();
                    System.out.print("Please enter the day this teacher started teachin: ");
                    teachDay = input.nextInt();
                    System.out.print("Please enter the name of the first course: ");
                    course1 = input.nextLine();
                    System.out.print("Please enter the name of the second course: ");
                    course2 = input.nextLine();
                    System.out.print("Please enter the name of the third course: ");
                    course3 = input.nextLine();

                    Teacher teacher = new Teacher (/*Fields*/);
                    AcademicDatabase.getAdmin().addTeacher(schoolIndex, teacher);
                } else if (choice.equalsIgnoreCase("D")) {
                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }

                    while (!userFound) {
                        System.out.print("Please enter the teacher's ID: ");
                        choice = input.next();
                        for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfTeachers().size(); i++) {
                            if (schoolArrayList.get(schoolIndex).getListOfTeachers().get(i).getUserID().equalsIgnoreCase(choice)) {
                                userFound = true;
                                userIndex = i;
                            }
                        }

                        if (!userFound)
                            System.out.println("Teacher not found please try again");
                    }

                    AcademicDatabase.getAdmin().removeTeacher(schoolIndex, userIndex);
                    System.out.println("Teacher has been successfully removed");
                } else if (choice.equalsIgnoreCase("E")) {
                    boolean esl, international, iep;
                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }

                    System.out.print("Please enter student's first name: ");
                    firstName = input.next();
                    System.out.print("Please enter student's last name: ");
                    lastName = input.next();
                    System.out.print("Please enter student's password: ");
                    password = input.next();
                    System.out.print("Please enter student's birth year: ");
                    birthYear = input.nextInt();
                    System.out.print("Please enter student's birth month: ");
                    birthMonth = input.nextInt();
                    System.out.print("Please enter student's birth day: ");
                    birthDay = input.nextInt();
                    System.out.print("Is the student in ESL: ");
                    esl = input.nextBoolean();
                    System.out.print("Is the student international student: ");
                    international = input.nextBoolean();
                    System.out.print("Is the student in IEP: ");
                    iep = input.nextBoolean();


                    Student student = new Student(/*Fields*/);

                    AcademicDatabase.getAdmin().addStudent(schoolIndex, student);

                } else if (choice.equalsIgnoreCase("F")) {
                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }

                    while (!userFound) {
                        System.out.print("Please enter the student's ID: ");
                        choice = input.next();
                        for (int i = 0; i < schoolArrayList.get(schoolIndex).getListOfStudents().size(); i++) {
                            if (schoolArrayList.get(schoolIndex).getListOfStudents().get(i).getUserID().equalsIgnoreCase(choice)) {
                                userFound = true;
                                userIndex = i;
                            }
                        }

                        if (!userFound)
                            System.out.println("Student not found please try again");
                    }

                   AcademicDatabase.getAdmin().removeStudent(schoolIndex, userIndex);
                    System.out.println("Student has been successfully removed");

                } else if (choice.equalsIgnoreCase("G")) {
                    String schoolName, schoolId;
                    int dayEst, yearEst, monthEst;

                    System.out.print("Please enter the name of the school you like to add: ");
                    schoolName = input.nextLine();
                    System.out.print("Please enter the ID of the school you like to add: ");
                    schoolName = input.nextLine();
                    System.out.print("Please enter the year of the school was established: ");
                    yearEst = input.nextInt();
                    System.out.print("Please enter the month of the school was established: ");
                    yearEst = input.nextInt();
                    System.out.print("Please enter the day of the school was established: ");
                    yearEst = input.nextInt();

                    School school = new School(/*Fields*/);
                    AcademicDatabase.getAdmin().addSchool(school);
                    System.out.println("School has been added successfully.");

                } else if (choice.equalsIgnoreCase("H")) {
                    while (!schoolFound) {
                        System.out.println("Please enter the school ID ");
                        choice = input.nextLine();

                        for (int i = 0; i < schoolArrayList.size(); i++) {
                            if (schoolArrayList.get(i).getSchoolID().equalsIgnoreCase(choice)) {
                                schoolIndex = i;
                                schoolFound = true;
                            }
                        }
                        if (!schoolFound) {
                            System.out.println("School not found please try again");
                        }
                    }
                    AcademicDatabase.getAdmin().removeSchool(schoolIndex);
                    System.out.println("School has been removed.");

                } else if (choice.equalsIgnoreCase("logout") || choice.equalsIgnoreCase("I")) {
                    logOut = true;
                } else {
                    System.out.println("Invalid input, please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("The option you entered is invalid please try again.");
            }

        }
        logOut();
    }

    public void guidanceOutput() 
    {   
        boolean logOut = false;
        String choice;
        String firstName;
        String lastName;
        String firstName;
        String lastName;
        String courseCode;
        String ID;
        boolean stop = false;
        boolean invalidInput = false;
        int gradeInput;
        Teacher selectedT;
        Student selectedS
        
        while (!logout)
        {
            try
            {
                do
                {
                    System.out.println("A) Modify a teacher's courses.");
                    System.out.println("B) Sort students.");
                    System.out.println("C) Modify/View students.");
                    System.out.println("Input logout at any point to log out.");
                
                    choice = input.nextLine();
                    
                    if (choice.equalsIgnoreCase("A"))
                    {
                        invalidInput = false;
                        do
                        {
                            System.out.println("Would you like to search by the teacher's ID or their first and last name? (Input ID/name)");
                            choice = input.nextLine();

                            if (choice.equalsIgnoreCase("ID"))
                            {
                                invalidInput = false;
                                System.out.println("Input the teacher's ID: ");
                                ID = input.nextLine();
                                selectedT = searchForTeacherID(ID);
                                
                            }

                            else if (choice.equalsIgnoreCase("name"))
                            {
                                invalidInput = false;
                                System.out.println("Input the teacher's first name: ");
                                firstName = input.nextLine();
                                System.out.println("Input the teacher's last name: ");
                                lastName = input.nextLine();
                                if (searchForTeacher(firstName,lastName).size() == 1)
                                    {
                                        invalidInput = false;
                                        selectedT = searchForTeacher(firstName, lastName);
                                    }
                                    else searchForTeacher(firstName,lastName).size() > 1)
                                    {
                                        invalidInput = false;
                                        System.out.println("There are multiple teachers with this name, please input the teachers ID: ")
                                        ID = input.nextInt();
                                        selectedS = searchForTeacherID(ID);
                                    }
                                    else if (choice.equalsIgnoreCase("logout"));
                                    {
                                        invalidInput = false;
                                        logout = true;
                                    }
                                    else   
                                    {
                                        System.out.println("There are no matches for this name, please try again.");
                                        invalidInput = true;
                                    }
                            }

                            else if (choice.equalsIgnoreCase("logout"));
                            {
                                invalidInput = false;
                                logout = true;
                            }
                            else
                            {
                                System.out.println("Invalid input. Please try again.");
                                invalidInput = true;
                            }
                        } while (invalidInput);
                        
                        do
                        {
                            System.out.println("Would you like to add a course to this teacher, or remove a course from this teacher? (input add/remove)");
                            choice = input.nextLine();

                            if (choice.equalsIgnoreCase("add"))
                            {
                                invalidInput = false;
                                System.out.println("Enter the course code that you would like to add: ");
                                courseCode = input.nextLine();
                                if(GuidanceCounsellor.addCourseToTeacher(selectedT, courseCode))
                                    System.out.println("The course has been added.");
                                else
                                    System.out.println("Error. The course has not been added.");
                            }

                            else if (choice.equalsIgnoreCase("remove"))
                            {
                                invalidInput = false;
                                System.out.println("Enter the course code that you would like to remove: ");      
                                courseCode = input.nextLine();
                                if(GuidanceCounsellor.removeCourseFromTeacher(selectedT, courseCode))
                                    System.out.println("The course has been removed.");
                                else
                                    System.out.println("Error. The course has not been removed.");
                            }

                            else if (choice.equalsIgnoreCase("logout"));
                            {
                                invalidInput = false;
                                logout = true;
                            }
                            else
                            {
                                System.out.println("Invalid input. Please try again.");
                                invalidInput = true;
                            }
                        } while (invalidInput);
                    }
                    
                    else if (choice.equalsIgnoreCase("B"))
                    {
                        do
                        {
                            System.out.println("A) Sort alphabetically.")
                            System.out.println("B) Sort by mark.")
                            choice = input.nextLine();

                            if (choice.equalsIgnoreCase("A"))
                            {
                                invalidInput = false;
                                listOfStudents.sortStudentLastAZ();
                                System.out.println("The list of students has been sorted alphabetically by their last names.");
                            }

                            else if (choice.equalsIgnoreCase("B"))
                            { 
                                invalidInput = false;
                                do
                                {
                                    System.out.println("A) Sort by marks high to low.\nB) Sort by marks low to high.");
                                    choice = input.nextLine();

                                    if (choice.equalsIgnoreCase("A"))
                                    {
                                        invalidInput = false;
                                        listOfStudents.sortStudentHL();
                                        System.out.println("The list of students has been sorted by their marks from high to low.");
                                    }

                                    else if (choice.equalsIgnoreCase("B"))
                                    {
                                        invalidInput = false;
                                        listOfStudents.sortStudentLH();
                                        System.out.println("The list of students has been sorted by their marks from low to high.");
                                    }
                                    else if (choice.equalsIgnoreCase("logout"));
                                    {
                                        invalidInput = false;
                                        logout = true;
                                    }
                                    else
                                    {
                                        System.out.println("Invalid input. Please try again.");
                                        invalidInput = true;
                                    }
                                } while (invalidInput);
                            }
                            else if (choice.equalsIgnoreCase("logout"));
                            {
                                logout = true;
                            }
                            else
                            {
                                System.out.println("Invalid input. Please try again.");
                                invalidInput = true;
                            }
                        } while (invalidInput);
                    } 
                
                    else if (choice.equalsIgnoreCase("C"))
                    {
                        invalidInput = false;
                    
                            System.out.println("A) Add new student.\nB) Modify an existing student.");                         
                            choice = input.nextLine();
                            if (choice.equalsIgnoreCase("A"))
                            {
                                System.out.println("Input the student's first name: ")
                                firstName = input.nextLine();
                                System.out.println("Input the student's last name: ")
                                lastName = input.nextLine();
                                ID = AcademicDatabase.StudentIDGenerator();
                                ///////////////////// FINISH THIS LATER
                            }
                            do
                            {
                                System.out.println("To view a student, you can search by ID or name: (Input ID/name)");
                                choice = input.nextInt();

                                if (choice.equalsIgnoreCase("ID"))
                                {
                                    invalidInput = false;
                                    System.out.println("Input the student's ID: ");
                                    ID = input.nextInt();
                                    selectedS = searchForStudentID(ID);
                                }

                                else if (choice.equalsIgnoreCase("name"))
                                {         
                                    invalidInput = false;
                                    do
                                    {
                                        System.out.println("Input the student's first name: ");
                                        firstName = input.nextLine();
                                        System.out.println("Input the student's last name: ");
                                        lastName = input.nextLine();
                                        if (searchForStudent(firstName,lastName).size() == 1)
                                        {
                                            invalidInput = false;
                                            selectedS = searchForStudent(firstName, lastName);
                                        }
                                        else searchForStudent(firstName,lastName).size() > 1)
                                        {
                                            invalidInput = false;
                                            System.out.println("There are multiple students with this name, please input the student's ID: ")
                                            ID = input.nextInt();
                                            selectedS = searchForStudentID(ID);
                                        }
                                        else if (choice.equalsIgnoreCase("logout"));
                                        {
                                            invalidInput = false;
                                            logout = true;
                                        }
                                        else   
                                        {
                                            System.out.println("There are no matches for this name, please try again.");
                                            invalidInput = true;
                                        }
                                    } while (invalidInput);
                                }
                                else if (choice.equalsIgnoreCase("logout"));
                                {
                                    invalidInput = false;
                                    logout = true;
                                }
                                else
                                {
                                    System.out.println("Invalid input. Please try again.");
                                    invalidInput = true;
                                }
                            } while (invalidInput);

                            do
                            {
                                System.out.println("A) View transcript.\nB) Edit student information.");
                                choice = input.nextLine();

                                if (choice.equalsIgnoreCase("A"))
                                {
                                    invalidInput = false;
                                    selectedS.viewTranscript();
                                }

                                else if (choice.equalsIgnoreCase("B"))
                                {
                                    invalidInput = false;
                                    do
                                    {
                                        System.out.println("Would you like to modify this student's courses? (Y/N)");
                                        choice = input.nextLine();
                                        if (choice.equalsIgnoreCase("Y"))
                                        {
                                            invalidInput = false;
                                            do
                                            {
                                                System.out.print("Would you like to add or remove a course (input add/remove");
                                                choice = input.nextLine();
                                                if (choice.equalsIgnoreCase("add"))
                                                {
                                                    invalidInput = false;
                                                    System.out.println("Input course code for the course you would like to add: ");
                                                    courseCode = input.nextLine();
                                                    if(GuidanceCounsellor.addCourseToStudent(selectedS, courseCode))
                                                        System.out.println("The course has been added.");
                                                    else
                                                        System.out.println("Error. The course has not been added.");
                                                }
                                                else if (choice.equalsIgnoreCase("remove"));
                                                {
                                                    invalidInput = false;
                                                    System.out.println("Input course code for the course you would like to remove: ");
                                                    courseCode = input.nextLine();
                                                    if(GuidanceCounsellor.removeCourseFromStudent(selectedS, courseCode))
                                                        System.out.println("The course has been removed.");
                                                    else
                                                        System.out.println("Error. The course has not been removed.");
                                                }
                                                else if (choice.equalsIgnoreCase("logout"));
                                                {
                                                    invalidInput = false;
                                                    logout = true;
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid input. Please try again.");
                                                    invalidInput = true;
                                                }
                                            } while (invalidInput);
                                        }
                                        else if (choice.equalsIgnoreCase("N"));
                                        {
                                            invalidInput = false;
                                        }
                                        else if (choice.equalsIgnoreCase("logout"));
                                        {
                                            invalidInput = false;
                                            logout = true;
                                        }
                                        else
                                        {
                                            System.out.println("Invalid input. Please try again.");
                                            invalidInput = true;
                                        }    
                                    } while (invalidInput);
                                    if (schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).getEsl)
                                    {
                                        invalidInput = false;
                                        do
                                        {
                                            System.out.println("This student is currently ESL. Change to not ESL? (Y/N)");
                                            choice = input.nextLine();
                                            if (choice.equalsIgnoreInput("Y"))
                                            {
                                                invalidInput = false;
                                                schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).setEsl(false);
                                            }
                                            else if (choice.equalsIgnoreInput("N"))
                                            {
                                                invalidInput = false;
                                            }
                                            else if (choice.equalsIgnoreCase("logout"));
                                            {
                                                invalidInput = false;
                                                logout = true;
                                            }
                                            else
                                            {
                                                System.out.println("Invalid input. Please try again.");
                                                invalidInput = true;
                                            } 
                                        } while (invalidInput);
                                    }
                                    else
                                    {
                                        do
                                        {
                                            System.out.println("This student is currently not ESL. Change to ESL? (Y/N)");
                                            if (choice.equalsIgnoreInput("Y"))
                                            {
                                                invalidInput = false;
                                                schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).setEsl(true);
                                            }   
                                            else if (choice.equalsIgnoreInput("N"))
                                            {
                                                invalidInput = false;
                                            }
                                            else if (choice.equalsIgnoreCase("logout"));
                                            {
                                                invalidInput = false;
                                                logout = true;
                                            }
                                            else
                                            {
                                                System.out.println("Invalid input. Please try again.");
                                                invalidInput = true;
                                            }  
                                        } while (invalidInput);
                                    }
                                    if (schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).getInternationalStudent)
                                    {
                                        invalidInput = false;
                                        do
                                        {
                                            System.out.println("This student is currently an international student. Remove international student status?? (Y/N)");
                                            choice = input.nextLine();
                                            if (choice.equalsIgnoreInput("Y"))
                                            {
                                                invalidInput = false;
                                                schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).setInternationalStudent(false);
                                            }
                                            if (choice.equalsIgnoreInput("N"))
                                            {
                                                invalidInput = false;
                                            }
                                            else if (choice.equalsIgnoreCase("logout"));
                                            {
                                                invalidInput = false;
                                                logout = true;
                                            }
                                            else
                                            {
                                                System.out.println("Invalid input. Please try again.");
                                                invalidInput = true;
                                            }  
                                        } while (invalidInput);
                                    }
                                    else
                                    {
                                        invalidInput = false;
                                        System.out.println("This student is currently not an international student. Add international student status? (Y/N)");
                                        do
                                            {
                                            if (choice.equalsIgnoreInput("Y"))
                                            {
                                                invalidInput = false;
                                                schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).setInternationalStudent(true);
                                            }     
                                            else if (choice.equalsIgnoreInput("N"))
                                            {
                                                invalidInput = false;
                                            }
                                            else if (choice.equalsIgnoreCase("logout"));
                                            {
                                                invalidInput = false;
                                                logout = true;
                                            }
                                            else
                                            {
                                                System.out.println("Invalid input. Please try again.");
                                                invalidInput = true;
                                            }  
                                        } while (invalidInput);
                                    }
                                    do
                                    {
                                        System.out.println("Would you like to change this student's grade? (Y/N)");
                                        choice = input.nextLine();
                                        if (choice.equalsIgnoreCase("Y"))
                                        {
                                            invalidInput = false;
                                            System.out.println("Input the grade you want to put this student in: ")
                                            gradeInput = input.nextInt();
                                            schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).setGrade(gradeInput);
                                        }
                                        else if (choice.equalsIgnoreCase("N"))
                                        {
                                            invalidInput = false;
                                        }
                                        else if (choice.equalsIgnoreCase("logout"));
                                        {
                                            invalidInput = false;
                                            logout = true;
                                        }
                                        else
                                        {
                                            System.out.println("Invalid input. Please try again.");
                                            invalidInput = true;
                                        }  
                                    } while (invalidInput);

                                    do
                                    {
                                        System.out.println("Would you like to change this student's name? (Y/N)");
                                        choice = input.nextLine();
                                        if (choice.equalsIgnoreCase("Y"))
                                        {
                                            invalidInput = false;
                                            System.out.println("Input the student's first name: ")
                                            firstName2 = input.nextLine()
                                            schoolArrayList.get(schoolIndex).searchForStudent(firstName,lastName).setFirstName(firstName2);
                                            System.out.println("Input the student's last name: ")
                                            lastName2 = input.nextLine()
                                            schoolArrayList.get(schoolIndex).searchForStudent(firstName2,lastName).setLastName(lastName2);
                                        }
                                        else if (choice.equalsIgnoreCase("N"))
                                        {
                                            invalidInput = false;
                                        }
                                        else if (choice.equalsIgnoreCase("logout"));
                                        {
                                            invalidInput = false;
                                            logout = true;
                                        }
                                        else
                                        {
                                            System.out.println("Invalid input. Please try again.");
                                            invalidInput = true;
                                        }  
                                    } while invalidInput();
                                else if (choice.equalsIgnoreCase("logout"));
                                {
                                    logout = true;
                                }
                                else
                                {
                                    System.out.println("Invalid input. Please try again.");
                                    invalidInput = true;
                                }
                            }  while (invalidInput);
                            else if (choice.equalsIgnoreCase("logout"));
                            {
                                invalidInput = false;
                                logout = true;
                            }
                            else
                            {
                                System.out.println("Invalid input. Please try again.");
                                invalidInput = true;
                            }
                    }                                         
                } while (invalidInput);
            }
        }
    }
    public void logOut() {
        userID = "";
        password = "";
        logIn();

    }


}
