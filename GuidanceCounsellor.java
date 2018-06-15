import java.util.*;

public class GuidanceCounsellor extends Teacher {
	
	// FIELDS
	
	private ArrayList<School> list = AcademicDatabase.getTdsbSchoolList();
	private FileInputOutput fileIO = AcademicDatabase.getFileIO();
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	// CONSTRUCTOR
	
	public GuidanceCounsellor() {
		super();
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// METHODS
	
	public boolean addStudent(int school, Student stud) {
		
		list.get(school).getListOfStudents().add(stud);
		list.get(school).sortStudentLastAZ();
		return fileIO.add(stud);
	}
	
	public boolean removeStudent(int school, int idx) {
		
		// int lenght = list.size();
		
		list.get(school).getListOfStudents().remove(idx);
		
//		if(length > list.size()) {
//			return true;
//		}else {
//			return false
//		}
	}
	
}