
import java.io.Console;
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
        
        
        System.out.println(event);
    }
}
