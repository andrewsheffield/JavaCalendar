
import java.util.ArrayList;
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
public final class EventModel {
    private ArrayList<Event> events = new ArrayList<>();
    private int currentMonth;
    private int currentYear;
    private int currentDay;
    private Calendar cal;
    private int daysInMonth;
    private MainView view;
    
    public EventModel(int initYear, int initMonth, int initDay) {
        this.currentMonth = initMonth;
        this.currentYear = initYear;
        this.currentDay = initDay;
        cal = new GregorianCalendar(initYear, initMonth, initDay);
        this.setDaysInMonth();
    }
    
    public void setDay(int day) {
        currentDay=day;
        view.repaint();
    }
    
    public Calendar getCal() {
        return cal;
    }
    
    public void setDaysInMonth() {
        daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    public int getDaysInMonth() {
        return daysInMonth;
    }
    
    public void previousDay() {
        currentDay -= 1;
        if (currentDay < 1) {
            currentMonth -= 1;
            if (currentMonth < 0) {
                currentMonth = 11;
                currentYear -= 1;
            }
            cal.set(currentYear, currentMonth, 1);
            setDaysInMonth();
            currentDay = getDaysInMonth();
        }
        view.repaint();
    }
    
    public void nextDay() {
        currentDay += 1;
        if (currentDay > daysInMonth) {
            currentDay = 1;
            currentMonth += 1;
            if (currentMonth > 11) {
                currentYear += 1;
                currentMonth = 0;
            }
            cal.set(currentYear, currentMonth, 1);
            this.setDaysInMonth();
        }
        view.repaint();
    }
    
    public int getDay() {
        return currentDay;
    }
    
    public int getMonth() {
        return currentMonth;
    }
    
    public int getYear() {
        return currentYear;
    }
    
    public void addEvent(Event e) {
        
        Calendar cal1 = new GregorianCalendar(2014, 3, 8, 10, 30);
        Calendar cal2 = new GregorianCalendar(2014, 3, 8, 9, 30);
        
        if (cal1.after(cal2)) {
            System.out.println("test");
        }
        
        events.add(e);
    }
    
    public ArrayList<Event> getTodaysEvents() {
        ArrayList<Event> todaysEvents = new ArrayList<>();
        
        for (Event e: events) {
            if (e.date.getYear() == currentYear
                    && e.date.getMonth() == currentMonth
                    && e.date.getDay() == currentDay) {
                todaysEvents.add(e);
            }
        }
        return todaysEvents;
    }

    void setView(MainView mv) {
        this.view = mv;
    }
    
}
