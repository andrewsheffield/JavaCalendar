import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
public final class EventModel {
    private ArrayList<Event> events = new ArrayList<>();
    private Calendar todayCal;
    private MainView view;
    
    /**
     * Set up a new Data model with today as the default value 
     */
    public EventModel() {
        todayCal = new GregorianCalendar();
    }
    
    public void setDay(int day) {
        todayCal.set(Calendar.DAY_OF_MONTH, day);
        view.repaint();
    }
    
    public void previousDay() {
        todayCal.add(Calendar.DAY_OF_MONTH, -1);
        view.repaint();
    }
    
    public void nextDay() {
        todayCal.add(Calendar.DAY_OF_MONTH, 1);
        view.repaint();
    }
    
    public Calendar getCal() {
        return todayCal;
    }
    
    public void addEvent(Event e) {
        events.add(e);
        Collections.sort(events);
        view.repaint();
    }
    
    public ArrayList<Event> getEvents() {
        return events;
    }

    void setView(MainView view) {
        this.view = view;
    }
}
