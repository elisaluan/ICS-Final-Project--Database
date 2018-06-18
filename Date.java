/*
* Date.java
* Date class stores the date in regards to the day-month-year, and contains
* the following methods:
*     + compareToDate: to determine which day comes first, the implicit or 
*                      the explicit variable
*     + toString: formats the date into a String of format DDMMYY  
*  Class also contains the necessary accessors and constructors
*
* Note: inorder to create a new instance of date - day, month, year must be
*       passed in as parameters in the constructor, there is no empty constructor
*/

public class Date {
   /*
   *  FIELDS: day, month, year (all of type int, and private)
   */
   private int day;
   private int month;
   private int year;
   
   /*
   *  CONSTRUCTOR: 
   *     - can create a new object by passing in the day, month, and year
   *
   *   Note: assume a consant of 31 days in a month
   */
   Date (int day, int month, int year) {
      if (day >= 1 && day <= 31) { 
         this.day = day;
      } else {
         this.day = 1;
      } // if structure - checks if valid day, if not default to day 1
      
      if (month >= 1 &&  month <= 12) {
         this.month = month;
      } else {
         this.month = 1;
      } // if structure - checks if valid month, if not default to month 1
      
      if (year >= 0 && year <= 99) {
         this.year = year;
      } else {
         this.year = 1;
      } // if structure - checks if valid year, if not default to year 1
   } // Date constructor
   
   
   /* 
   *  ACCESSORS:
   *     + getDay, + getMonth, + getYear
   *  returns varables of type int   
   */
   public int getDay () {
      return day;
   } // getDay accessor
   
   public int getMonth () {
      return month;
   } // getMonth accessor
   
   public int getYear () {
      return year;
   } // getYear accessor
   
   
   
   /* 
   *  MUTATORS:
   *     + setDay, + setMonth, + setYear
   *  passes in variables of type int, checks if a valid day, month,
   *  or year are passed in respectively. If yes, sets the field to the
   *  passed in value
   *
   *    Note: assume number of days in a month are constant: 31 days 
   */
   public void setDay (int day) {
      if (day >= 1 && day <= 31) { 
         this.day = day;
      } // if structure - determine if valid day input
   }// setDay mutator
   
   public void setMonth (int month) { 
      if (month >= 1 &&  month <= 12) {
         this.month = month;
      } // if structure - determine if valid month input
   }// setMonth mutator
   
   public void setYear (int year) { 
      if (year >= 0 && year <= 99) {
         this.year = year;
      } // if structure - determine if valid year input
   } // setYear mutator
   
   
   /*
   *  METHODS:
   *     + compareToDate
   *     + toString
   */
   
   
   //compareToDate public method
   //    - passes in another Date parameter and returns an int:
   //          -1: implicit date before other date
   //          0: same date
   //          1: implicit date after other date
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
   
   
   // toString method: returns a string of the date in DDMMYY format
   //    - adds a 0 or 00 infront of the integer value for day, month, 
   //      and/or year such that the final string conforms to the 
   //      DDMMYY format
   //          day & month: "0" + day/month if day/month is single digit value
   //          year: "00" if year input is for example 0 and 
   //                "0" + year ones digit if year input is for example 1
   public String toString(){
      final int DOUBLE_DIGIT = 10;
      final int DEFAULT = 0;
      String dString, mString, yString;
      
      // if a valid date is indicated:
      //    - create and return the proper Date string
      if (day != DEFAULT && month != DEFAULT && year != DEFAULT){
         if (day < DOUBLE_DIGIT) {
            dString = "0" + day;
         } else {
            dString = day + "";
         } // creates day part of String
         
         if (month < DOUBLE_DIGIT) {
            mString = "0" + month;
         } else {
            mString = month + "";
         } // creates month part of String
         
         if (0 < year && year < DOUBLE_DIGIT) {
            yString = "0" + year;
         } else if (year == 0) {
            yString = "00";
         } else {
            yString = year + "";
         } // creates year part of String
         
         return dString + mString + yString;
      } else {
         return null;
      }
   }// toString method
} // Date Class