public class Admin extends User {
	private School schoolList;
	private School principal;

	// constructor
	public Admin(School other, School principal) {
		schoolList = other;
		this.principal = principal;
	}

	// accessors
	public School getSchoolList() {
		return schoolList;
	}

	public School getPrincipal() {
		return principal;
	}

	// mutators
	public void setSchoolList(School schoolList) {
		this.schoolList = schoolList;
	}

	public void setPrincipal(School principal) {
		this.principal = principal;
	}

	// add principal to a school if not already assigned. Otherwise, outputs an
	// error message
	public void addPrincipal(School principal) {
		if (this.principal == null) {
			this.principal = principal;
		} else {
			System.out.println("A principal is already assigned to this school, remove the principal and try again.");
		}
	}

	// removes a principal assigned to a school
	public void removePrincipal() {
		if (this.principal != null) {
			this.principal = null;
		} else {
			System.out.println("Cannot remove principal because no principal is assigned to this school");
		}
	}

	public void addTeacher(Teacher teacher) {
		schoolList.listOfTeachers.add(teacher);
	}

	public void removeTeacher(String teacherID) {
		for (int index = 0; index < schoolList.listOfTeachers.size(); index++) {
			if (teacherID.equalsIgnoreCase(schoolList.listOfTeachers.get(index).getUserID())) {
				schoolList.listOfTeachers.remove(index);
			}
		}
	}

	public String toString() {
		return "";
	}
  
}//Admin class
