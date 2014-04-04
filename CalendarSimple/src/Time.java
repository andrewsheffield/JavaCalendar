/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
class Time {
    private int hour;
    private int minute;
    
    public Time(int hour, int minute) throws IllegalArgumentException {
        this.hour = hour;
        this.minute = minute;
        
        if (hour > 23) {
            throw new IllegalArgumentException("A max of 23 is allowed for the hour");
        }
        if (minute > 59) {
            throw new IllegalArgumentException("A max of 59 is allowed for the minute");
        }
    }
    
    public int getHour() {
        return hour;
    }
    
    public int getMinute() {
        return minute;
    }
    
    @Override
    public String toString() {
        return hour + ":" + minute;
    }
}
