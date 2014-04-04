/**
 * Time holds variables for @hour and @minute
 * @author sheff
 * 
 */
class Time {
    
    final private int hour;
    final private int minute;
    
    /**
     * Time constructs the Time class to hold and hour and minute.
     * If new time is needed this object should be thrown away and a new
     * Time object should be Created.
     * @param hour  24 hour time of the day, accepts 0-23
     * @param minute    minutes of the hour, accepts 0-59
     */
    public Time(int hour, int minute) throws IllegalArgumentException {
        this.hour = hour;
        this.minute = minute;
        
        if (hour > 23 || hour < 0) {
            throw new IllegalArgumentException("A max of 23 is allowed for the hour");
        }
        if (minute > 59 || hour < 0) {
            throw new IllegalArgumentException("A max of 59 is allowed for the minute");
        }
    }
    
    /**
     * Returns the hour previously saved in the Time object
     * @return the hour of the created Time object
     */
    public int getHour() {
        return hour;
    }
    
    /**
     * Returns the minute previously saved in the Time object
     * @return minute
     */
    public int getMinute() {
        return minute;
    }
    
    /**
     * Returns a String of the time in the format hour:minute
     * @return string hour:minute
     */
    @Override
    public String toString() {
        return hour + ":" + minute;
    }
}
