import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Object type Event hold a name, Calendar start and end times.
 * @author sheff
 */
class Event implements Comparable<Event> {
    String name;
    Calendar start;
    Calendar end;
    
    
    public Event(String name, GregorianCalendar start, GregorianCalendar end) throws IllegalArgumentException {
        this.name = name;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return start.toString() + end.toString();
    }

    @Override
    public int compareTo(Event newEvent) {
        if (newEvent.start.before(this.start) && newEvent.end.before(this.start)) {
            return 1;
        }
        else if (newEvent.start.after(this.end) && newEvent.end.after(this.end)) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
