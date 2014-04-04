/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
class Event {
    String name;
    Date date;
    Time start_time;
    Time end_time;
    
    
    public Event(String name, Date date, Time start_time, Time end_time) throws IllegalArgumentException {
        this.name = name;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        
        if (start_time.getHour() > end_time.getHour()
                || start_time.getHour() == end_time.getHour() && start_time.getMinute() > end_time.getMinute()
                ) {
            throw new IllegalArgumentException("Start time cannot come after end time");
        }
    }
    
    @Override
    public String toString() {
        return "Name: " + name + "\nDate: " + date + "\nStart: " + start_time + "\nEnd: " + end_time;
    }
}
