public class Date {
    private int day;
    private int month;
    private int year;

    //constructor
    public Date (int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Accessors
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    //Mutators
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    //comparing two date objects
    //if current date is earlier than comparing date, 1 will be returned
    //if current date is later than comparing date, -1 will be returned
    //if both dates are the same, 0 will be returned
    public int compareToDay (Date current, Date comparing){
        if ( (current.year < comparing.year) || (current.year == comparing.year && current.month < comparing.month) || (current.year==comparing.year && current.month==comparing.month && current.day < comparing.day) ){
            return 1;
        } 
        else if(( comparing.year < current.year) || (comparing.year == current.year && comparing.month < current.month) || (comparing.year==current.year && comparing.month==current.month && comparing.day < current.day) ){
            return -1;
        }else{
            return 0;   
        }
    }//compareToDay method
    
    //converts the called date from int to all in one string  (DDMMYYYY) date format
    public void toString(){
        if (day < 10 && month > 10){
            return ("0" + day + month + year);
        }
        else if (day > 10 && month < 10){  
            return("" + day + "0" + month + year);
        }
        else if (day > 10 && month > 10){
            return("" + day + month + year);
        }
    }//toString method
}//Date class
