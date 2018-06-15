abstract class User {
   private String firstName;
   private String lastName;
   private String userID;
   private String password;
   private Date birthDate;
   private int NUM_START = 3;
   
   // accessors
   public String getFirstName () {
      return firstName;
   }
   public String getLastName () {
      return lastName;
   }
   public String getUserID () {
      return userID;
   }
   public String getPassword () {
      return password;
   }
   public Date getBirthDate () {
      return birthDate;
   }
   
   // mutators
   public void setFirstName (String firstName) {
      this.firstName = firstName;
   }
   public void setLastName (String lastName) {
      this.lastName = lastName;
   }
   public void setUserID (String userID) {
      this.userID = userID;
   }
   public void setPassword (String password) {
      this.password = password;
   }
   public void setBirthDate (Date birthDate) {
      this.birthDate = birthDate;
   }
   
   // methods
   public int compareToAge (User other) {
     return birthDate.compareToDate(other.getBirthDate()); 
   }
   public int compareToFirstName (User other) {
      return firstName.compareToIgnoreCase(other.getFirstName());
      
   }
   public int compareToLastName (User other) {
      return lastName.compareToIgnoreCase(other.getLastName());
   }
   public int compareToID(User other) {
      return (lastName.substring(NUM_START).compareToIgnoreCase(other.getLastName().substring(NUM_START)));
   }
   public String toString () {
      String output = "Name: " + firstName + " " + lastName + "\nUser ID: " + userID + "\nBirth Date: " + birthDate ;
      return output;
   }
}
