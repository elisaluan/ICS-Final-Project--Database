public class MyAssessment {
  //Initializes fields
  private String assessmentName;
  private double assessmentMarkPer;
  private double assessmentNum;
  private double assessmentDen;
  private double weight;
  
  //Method to calculate the mark
  public void calcMark(){
    assessmentMarkPer = assessmentNum/assessmentDen;
  }
  
  //Method to return all info as a string
  public String toString(){
    String s = "Assessment name: " + assessmentName + "\nAssessment percent mark: " + assessmentMarkPer;
    s+= "\nAssessment mark: " + assessmentNum + "/" + assessmentDen + "\nWeight: " + weight;
    return s;
  }
}
