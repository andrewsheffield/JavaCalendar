
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
        
        
        
        EventModel model = new EventModel();
        MainView mv = new MainView(model);
        model.setView(mv);    
        
    }
}
