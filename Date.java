public class Date {
	private int day;
	   private int month;
	   private int year;
	   
	   // accessors
	   public int getDay () {
	      return day;
	   }
	   public int getMonth () {
	      return month;
	   }
	   public int getYear () {
	      return year;
	   }
	   
	   // mutators
	   public void setDay (int day) {
	      if (day >= 1 && day <= 31) { // constant
	         this.day = day;
	      }
	   }
	   public void setMonth (int month) { // constant
	      if (month >= 1 &&  month <= 12) {
	         this.month = month;
	      }
	   }
	   public void setYear (int year) { // constant
	      this.year = year;
	   }
	   
	   // methods
	   public int compareToDate (Date other) {
	      if (this.year > other.year) {
	         return 1;
	      } else if (this.year < other.year) {
	         return -1;
	      } else {
	         if (this.month > other.month) {
	            return 1;
	         } else if (this.month < other.month){
	            return -1;   
	         } else {
	            if (this.day > other.day) {
	               return 1;
	            } else if (this.day < other.day) {
	               return -1;
	            } else {
	               return 0;
	            } // if structure compares day
	         } // if structure compares month
	      } // if structure compares year 
	   } // compareToDay method
    
    //converts the called date from int to all in one string  (DDMMYYYY) date format
    public String toString(){
        if (day < 10 && month > 10){
            return ("0" + day + month + year);
        }
        else if (day > 10 && month < 10){  
            return ("" + day + "0" + month + year);
        }
        else if (day > 10 && month > 10){
            return ("" + day + month + year);
        }
		return null;
    }//toString method
}//Date class

