
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author sheff
 */
public class CalendarModel {
    
    public CalendarModel() {
        Calendar cal =  new GregorianCalendar(2014, 0, 1);
        
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        Date month = cal.getTime();
        
        System.out.println(new SimpleDateFormat("MMM").format(month));
        System.out.print("sun\tmon\ttue\twed\tthu\tfri\tsat\n");
        
        for (int i = 1; i<daysInMonth+startDay; i++) {
            if (i<startDay) {
                System.out.print("\t");
            } else {
                System.out.print(i-startDay+1 + "\t");
            }
            if (i%7 == 0) {
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }

}
