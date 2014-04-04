
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
public class CalendarModel {
    ArrayList<Event> events = new ArrayList<>();
    
    public void addEvent(Event e) {
        events.add(e);
    }
    
    public ArrayList<Event> getData() {
        return events;
    }
    
    /*repaint view*/
    
}
