
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
        
        System.out.print(calendar.get(Calendar.MONTH) + "/");
        System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "/");
        System.out.println(calendar.get(Calendar.YEAR) + "");
        
        Date date = new Date();
        
        
    }
}
