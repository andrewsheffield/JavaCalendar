
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    Calendar start;
    Calendar end;
    
    
    public Event(String name, GregorianCalendar start, GregorianCalendar end) throws IllegalArgumentException {
        this.name = name;
        this.start = start;
        this.end = end;
        
        if (start.after(end)) {
            //throw new IllegalArgumentException("Start time cannot come after end time");
        }
    }
    
    @Override
    public String toString() {
        return start.toString() + end.toString();
    }
}
