
import java.io.Console;
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
public class CalendarSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalendarModel data = new CalendarModel();
        
        Calendar calendar = new GregorianCalendar();
        
        Date date = new Date(12,31,1984);
        Time start_time = new Time(14,30);
        Time end_time = new Time(23,59);
        
        Event event = new Event("Going to work", date, start_time, end_time);
        
        Date date1 = new Date(12,31,2014);
        Time start_time1 = new Time(16,20);
        Time end_time1 = new Time(20,00);
        
        Event event1 = new Event("Going to School", date1, start_time1, end_time1);
        
        data.addEvent(event);
        data.addEvent(event1);
        ArrayList<Event> ar = data.getData();
        System.out.println(ar);
    }
}
