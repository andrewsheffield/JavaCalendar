
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

        EventModel model = new EventModel(2014, 3, 8);
        
        model.addEvent(new Event("Hello", new Date(3, 8, 2014), new Time(10, 30), new Time(11, 30)));
        model.addEvent(new Event("Sup", new Date(3, 8, 2014), new Time(10, 30), new Time(11, 30)));
        
        MainView mv = new MainView(model);
        model.setView(mv);
    }
}
