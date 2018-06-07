public class MyAssessment {
  //Initializes fields
  private String assessmentName;
  private double assessmentMark;
  private double assessmentNum;
  private double assessmentDen;
  private double weight;
  
  //Constructor
  public MyAssessment(){
    assessmentName = "";
    assessmentMark = 0;
    assessmentNum = 0;
    assessmentDen = 0;
    weight = 0;
  }
  
  public MyAssessment(String assessmentName, double assessmentMark, double assessmentNum, double assessmentDen, double weight){
    this.assessmentName = assessmentName;
    this.assessmentMark = assessmentMark;
    this.assessmentNum = assessmentNum;
    this.assessmentDen = assessmentDen;
    this.weight = weight;
  }
  
  //Accessors
  public String getAssessmentName(){
    return assessmentName;
  }
  
  public double getAssessmentMark(){
    return assessmentMark;
  }
  
  public double getAssessmentMarkNum(){
    return assessmentMarkNum;
  }
  
  public double getAssessmentMarkDen(){
    return assessmentMarkDen;
  }
  
  public double weight(){
    return weight;
  }
  
  //Mutators
  public void setAssessmentName(String assessmentName){
    this.assessmentName = assessmentName;
  }
  
  public void setAssessmentMark(double assessmentMark){
    this.assessmentMark = assessmentMark;
  }
  
  public void setAssessmentMarkNum(double assessmentMarkNum){
    this.assessmentMarkNum = assessmentMarkNum;
  }
  
  public void setAssessmentMarkDen(double assessmentMarkDen){
    this.assessmentMarkDen = assessmentMarkDen;
  }
  
  public void setWeight(double weight){
    this.weight = weight;
  }
  
  //Method to calculate the mark
  public void calcMark(){
    assessmentMark = assessmentNum/assessmentDen * 100;
  }
  
  //Method to return all info as a string
  public String toString(){
    String s = "Assessment name: " + assessmentName + "\nAssessment percent mark: " + assessmentMark;
    s+= "\nAssessment mark: " + assessmentNum + "/" + assessmentDen + "\nWeight: " + weight;
    return s;
  }
}
