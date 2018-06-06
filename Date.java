public class Date {
    int day;
    int month;
    int year;

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
    public compareToDay int (Date current, Date comparing){
        if ( (current.year < comparing.year) || (current.year == comparing.year && current.month < comparing.month) || (current.year==comparing.year && current.month==comparing.month && current.day){
            return 1;
        } else if(current.year > comparing.year){
            return -1;
        }
    }//compareToDay method
    public toString String(Date formatDate){
        return (formatDate.day + formatDate.month + formatDate.year);
    }
}//Date class
