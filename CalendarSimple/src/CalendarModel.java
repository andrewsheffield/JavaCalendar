
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
        drawCal(1, 2014);
    }
    
    public void drawCal(int month, int year) {
        Calendar cal =  new GregorianCalendar(year, month, 1);
        
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        Date monthDate = cal.getTime();
        
        System.out.println(new SimpleDateFormat("MMM").format(monthDate));
        System.out.print("sun\tmon\ttue\twed\tthu\tfri\tsat\n");
        
        for (int i = 1; i<daysInMonth+startDay; i++) {
            if (i<startDay) {
                System.out.print("\t");
            } else {
                int day = i-startDay +1;
                System.out.print(day + "\t");
            }
            if (i%7 == 0) {
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }
    
    

}
