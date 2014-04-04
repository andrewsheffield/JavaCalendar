/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
class Date {
    private int month;
    private int day;
    private int year;
    
    public Date(int month, int day, int year) throws IllegalArgumentException {
        this.month = month;
        this.day = day;
        this.year = year;
        
        if (month > 12) {
            throw new IllegalArgumentException("A max of 12 is allowed for month");
        }
        if (day > 31) {
            throw new IllegalArgumentException("A max of 31 is allowed for the day");
        }
        if (year > 2100 || year < 1900) {
            throw new IllegalArgumentException("Come on!  Your not going to be Alive at this time!");
        }
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
    public int getYear() {
        return year;
    }
    
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
