public class Principal {
  
  //Constructor
  public Principal(){
    super(firstName, lastName, userID, password, birthDate)
  }
  
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
   
   public void addTeacher(Teacher t){
     if (AcademicDatabase.newTeacher() && FileInputOutput.store(t))
       System.out.println("This teacher has been added.");
     else 
       System.out.println("Error. This teacher has not been added.");
   }
  

  
}
