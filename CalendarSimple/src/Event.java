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
    
    
    public Event(String name, Date date, Time start_time, Time end_time) {
        this.name = name;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
