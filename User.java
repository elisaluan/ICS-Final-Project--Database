

public abstract class User {
    Private String firstName;
    Private String lastName;
    Private String userID;
    Private String password;
    Private Date birthDate;

    public User (String givenFirstName, String givenLastName, String givenID, String password, int birthYear,
                 int birthDay,int birthMonth)
    {
        birthDate = new Date (birthDay, birthMonth, birthYear);
        firstName = givenFirstName;
        lastName = givenLastName;
        userID = givenID;
        this.password = password;

    }

    //Accessors and Mutators
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }

    public String getUserID() {
        return userID;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLasName(String lasName) {
        this.lastName = lasName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    //Methods

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

    public int compareToFirstName (User other)
    {
        return (this.getFirstName().compareToIgnoreCase(other.getFirstName()));
    }

    public int  compareToLastName (User other)
    {
        return (this.getLastName().compareToIgnoreCase(other.getLastName()));
    }

    public String toString ()
    {
        String output;
        output = "Full Name: " + getFirstName() + " " + getLastName() + "\n";
        output = output + "User ID: " + getUserID() + "\n";
        output = output + "Birth Date: " + getBirthDate();
        return output;
    }


}
