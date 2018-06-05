import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileInputOutput {
    private final String studentFileName = "Student#";
    private final String teacherFileName = "Teacher#";
    private final String guidanceFileName = "Guidance#";
    private final String principalFileName = "Principal";

    public void saveSchools (ArrayList <School> schoolList)
    {

        String studentFileName, teacherFileName, principalFileName, directory;



        File schoolFolder = new File ("Schools");
        schoolFolder.mkdir();
        String schoolName, schoolFile, output;
        for (int i = 0; i <= schoolList.size(); i ++)
        {
            schoolName = schoolList.get(i).getSchoolID();
            File everySchool = new File (("Schools\\"+ schoolName));
            everySchool.mkdir();
            schoolFile = schoolList.get(i).getSchoolName() +".txt";
            try{

                BufferedWriter out = new BufferedWriter(new FileWriter(schoolFile));
                output = schoolList.get(i).getSchoolName();
                out.write(output);
                output = schoolList.get(i).getSchoolID();
                out.write(output);
                out.write("Student List");


                directory = "Schools\\" + schoolName + "\\Students";
                File studentFiles = new File(directory);
                studentFiles.mkdir();
                for (int counter = 0; counter <= schoolList.get(i).listOfStudents.size(); counter ++)
                {
                    output = (schoolList.get(i)).listOfStudents.get(counter).getUserID();
                    out.write(output);
                    saveStudents(schoolList, directory, i, counter);
                }

                out.write("Teacher List");

                for (int counter = 0; counter <= schoolList.get(i).listOfTeachers.size(); counter ++)
                {
                    output = (schoolList.get(i)).listOfTeachers.get(counter).getUserID();
                    out.write(output);
                }

                out.write("Guidance List");

                for (int counter = 0; counter <= schoolList.get(i).listOfGuidanceCouns.size(); counter ++)
                {
                    output = (schoolList.get(i)).listOfGuidanceCouns.get(counter).getUserID();
                    out.write(output);
                }

                out.write("Principal");
                output = (schoolList.get(i)).principal.getUserID();
                out.write(output);

                out.close();
            }catch (IOException iox)
            {
                System.out.println("Error Reading to File");
            }
        }
    }

    public void saveStudents (ArrayList <School> schoolList, String directory, int indexOfSchool, int studentIndex)
    {

        String fileName = schoolList.get(indexOfSchool).listOfStudents.get(studentIndex).getUserID();
        String output;
            try {

                BufferedWriter out = new BufferedWriter(new FileWriter(directory + "\\" + fileName));
                output = (schoolList.get(indexOfSchool)).listOfStudents.get(studentIndex).getUserID();
                out.write(output);

                output = (schoolList.get(indexOfSchool)).listOfStudents.get(studentIndex).getPassword();
                out.write(output);

                output = (schoolList.get(indexOfSchool)).listOfStudents.get(studentIndex).getFirstName();
                out.write(output);

                output = (schoolList.get(indexOfSchool)).listOfStudents.get(studentIndex).getLastName();
                out.write(output);

                output = "" + (schoolList.get(indexOfSchool)).listOfStudents.get(studentIndex).getBirthDate();
                out.write(output);

                output = "" + (Student)((schoolList.get(indexOfSchool)).listOfStudents.get(studentIndex).getGrade());
                out.write(output);



            }catch (IOException iox)
            {
                System.out.println("Error Writting to file");
            }



    }



}
