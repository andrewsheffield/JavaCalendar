import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sheff
 */
public class CreateEventView {
    
    public CreateEventView(final EventModel model) {
        final JFrame frame = new JFrame();
        
        final JTextField descField = new JTextField("Descrition here");
        final JTextField dateField = new JTextField("10/02/2012");
        final JTextField startField = new JTextField("10:30");
        final JTextField endField = new JTextField("11:30");
        JButton saveButton = new JButton("Save");
        
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = descField.getText();
                String date = dateField.getText();
                String start = startField.getText();
                String end = endField.getText();
                
                String dateArr[] = date.split("/");
                String startTimeArr[] = start.split(":");
                String endTimeArr[] = end.split(":");
                
                int year = Integer.parseInt(dateArr[2]);
                int month = Integer.parseInt(dateArr[0]);
                int day = Integer.parseInt(dateArr[1]);
                
                int startHour = Integer.parseInt(startTimeArr[0]);
                int startMinute = Integer.parseInt(startTimeArr[1]);
                
                int endHour = Integer.parseInt(endTimeArr[0]);
                int endMinute = Integer.parseInt(endTimeArr[0]);
                
                Calendar startCal = new GregorianCalendar(year, month, day, startHour, startMinute);
                Calendar endCal = new GregorianCalendar(year, month, day, endHour, endMinute);
                
                Event newEvent = new Event(name, (GregorianCalendar)startCal, (GregorianCalendar) endCal);
                
                model.addEvent(newEvent);
                
                frame.dispose();
            }
        });
        
        JPanel panel = new JPanel();
        
        panel.add(descField);
        panel.add(dateField);
        panel.add(startField);
        panel.add(endField);
        panel.add(saveButton);
        
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
