public class MyAssessment {
  //Initializes fields
  private String assessmentName;
  private double assessmentMarkPer;
  private double assessmentNum;
  private double assessmentDen;
  private double weight;
  
  //Constructor
  public MyAssessment(){
    assessmentName = "";
    assessmentMarkPer = 0;
    assessmentNum = 0;
    assessmentDen = 0;
    weight = 0;
  }
  
  public MyAssessment(String assessmentName, double assessmentMarkPer, double assessmentNum, double assessmentDen, double weight){
    this.assessmentName = assessmentName;
    this.assessmentMarkPer = assessmentMarkPer;
    this.assessmentNum = assessmentNum;
    this.assessmentDen = assessmentDen;
    this.weight = weight;
  }
  
  //Accessors
  public String getAssessmentName(){
    return assessmentName;
  }
  
  public double getAssessmentMarkPer(){
    return assessmentMarkPer;
  }
  
  public double getAssessmentMarkNum(){
    return assessmentNum;
  }
  
  public double getAssessmentMarkDen(){
    return assessmentDen;
  }
  
  public double weight(){
    return weight;
  }
  
  //Mutators
  public void setAssessmentName(String assessmentName){
    this.assessmentName = assessmentName;
  }
  
  public void setAssessmentMarkPer(double assessmentMarkPer){
    this.assessmentMarkPer = assessmentMarkPer;
  }
  
  public void setAssessmentMarkNum(double assessmentMarkNum){
    this.assessmentNum = assessmentMarkNum;
  }
  
  public void setAssessmentMarkDen(double assessmentMarkDen){
    this.assessmentDen = assessmentMarkDen;
  }
  
  public void setWeight(double weight){
    this.weight = weight;
  }
  
  //Method to calculate the mark
  public void calcMark(){
    assessmentMarkPer = assessmentNum/assessmentDen * 100;
  }
  
  //Method to return all info as a string
  public String toString(){
    String s = "Assessment name: " + assessmentName + "\nAssessment percent mark: " + assessmentMarkPer;
    s+= "\nAssessment mark: " + assessmentNum + "/" + assessmentDen + "\nWeight: " + weight;
    return s;
  }
}
