public abstract class User {
    private String firstName;
    private String lastName;
    private String userID;
    private String password;
    private Date birthDate;

    //Contructors
    public User (String givenFirstName, String givenLastName, String givenID, String password, int birthYear,
                 int birthDay,int birthMonth)
    {
        birthDate = new Date (birthDay, birthMonth, birthYear);
        firstName = givenFirstName;
        lastName = givenLastName;
        userID = givenID;
        this.password = password;

    }//Constructor

    //Accessors
    public String getFirstName() {
        return firstName;
    }// First name accessor

    public String getLastName() {
        return lastName;
    }// Last name accessor

    public Date getBirthDate() {
        return birthDate;
    }//Birth date accessor

    public String getPassword() {
        return password;
    }// Password accessor

    public String getUserID() {
        return userID;
    }// User ID accessor

    //Mutators
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }// Birth day mutator

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }// First name mutator

    public void setLasName(String lasName) {
        this.lastName = lasName;
    }// Last name mutator

    public void setPassword(String password) {
        this.password = password;
    }// Password mutator

    public void setUserID(String userID) {
        this.userID = userID;
    }// User ID mutator

    //Methods
    
    //Compares the age of implicit and explicit objects and returns (1) if the implicit student is older than explicit student
    //returns (-1) if implicit student is younger than explicit student and returns (0) if implicit student is the same age
    //as explicit student
    public int compareToAge (User other)
    {
        if (birthDate.getYear() > other.birthDate.getYear())
            return -1;
        else if (birthDate.getYear() < other.birthDate.getYear())
            return 1;
        else if (birthDate.getMonth() < other.birthDate.getMonth())
            return 1;
        else if (birthDate.getMonth() > other.birthDate.getMonth())
            return -1;
        else if (birthDate.getDay() < other.birthDate.getDay())
            return 1;
        else if (birthDate.getDay() > other.birthDate.getDay())
            return -1;
        else
            return 0;

    }

    //Compares the first name of implicit and explicit user object and returns (1) if the implicit object first name is 
    //alphabetically first and returns (0) if the two names are the same. It also returns (-1) if the implicit
    //object first name is alphabeticaly last compared to the explicit object first name.
    public int compareToFirstName (User other)
    {
        if (this.getFirstName().compareToIgnoreCase(other.getFirstName()) > 0)
            return 1;
        else if (this.getFirstName().compareToIgnoreCase(other.getFirstName()) == 0)
            return 0;
        else
            return -1;
    }// compareToFirstName method

    //Compares the last name of implicit and explicit user object and returns (1) if the implicit object last name is 
    //alphabetically first and returns (0) if the two last names are the same. It also returns (-1) if the implicit
    //object last name is alphabeticaly last compared to the explicit object last name.
    public int  compareToLastName (User other)
    {
        if (this.getLastName().compareToIgnoreCase(other.getLastName()) > 0)
            return 1;
        else if (this.getLastName().compareToIgnoreCase(other.getLastName()) == 0)
            return 0;
        else
            return -1;
        
    }// compareToLastName method

    //Outputs the information of the user in a line by line format.
    public String toString ()
    {
        String output;
        output = "Full Name: " + getFirstName() + " " + getLastName() + "\n";
        output = output + "User ID: " + getUserID() + "\n";
        output = output + "Birth Date: " + getBirthDate();
        return output;
    }// toString method


}// User class
