import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        Calendar cal = model.getCal();
        
        final JTextField descField = new JTextField("Description here");
        final JTextField dateField = new JTextField((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR));
        final JTextField startField = new JTextField("10:30am");
        final JTextField endField = new JTextField("11:30am");
        JButton saveButton = new JButton("Save");
        
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = descField.getText();
                String date = dateField.getText();
                String start = startField.getText();
                String end = endField.getText();
                
                SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyyhh:mmaa");
                
                Date startDate = null;
                try {
                    startDate = sf.parse(date+start);
                } catch (ParseException ex) {
                    Logger.getLogger(CreateEventView.class.getName()).log(Level.SEVERE, null, ex);
                }
                Date endDate = null;
                try {
                    endDate = sf.parse(date+end);
                } catch (ParseException ex) {
                    Logger.getLogger(CreateEventView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Calendar startCal = new GregorianCalendar();
                startCal.setTime(startDate);
                Calendar endCal = new GregorianCalendar();
                endCal.setTime(endDate);
                
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
