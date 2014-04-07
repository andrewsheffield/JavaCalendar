
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
public class EventModel {
    ArrayList<Event> events = new ArrayList<>();
    int currentMonth;
    int currentYear;
    private MainView view;
    
    public EventModel(int initMonth, int initYear) {
        this.currentMonth = initMonth;
        this.currentYear = initYear;
    }
    
    public void previousMonth() {
        currentMonth -= 1;
        if (currentMonth < 0) {
            currentMonth = 11;
            currentYear -= 1;
        }
        view.repaint();
    }
    
    public void nextMonth() {
        currentMonth += 1;
        if (currentMonth >= 12) {
            currentMonth = 0;
            currentYear += 1;
        }
        view.repaint();
    }
    
    public int getMonth() {
        return currentMonth;
    }
    
    public int getYear() {
        return currentYear;
    }
    
    public void addEvent(Event e) {
        events.add(e);
    }
    
    public ArrayList<Event> getData() {
        return events;
    }

    void setView(MainView mv) {
        this.view = mv;
    }
    
}
