

public abstract class User {
    String firstName;
    String lastName;
    String userID;
    String password;
    Date birthDate;

    public User (String givenFirstName, String givenLastName, String givenID, String password, int birthYear,
                 int birthDay,int birthMonth)
    {
        birthDate = new Date (birthDay, birthMonth, birthYear);
        firstName = givenFirstName;
        lastName = givenLastName;
        userID = givenID;
        this.password = password;

    }

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

}
