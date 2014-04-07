import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sheff
 */
public class CreateEventView {
    
    public CreateEventView() {
        JFrame frame = new JFrame();
        
        JTextField desc = new JTextField("Descrition here");
        JTextField date = new JTextField("10/02/2012");
        JTextField startTime = new JTextField("10:30am");
        JTextField endTime = new JTextField("11:30pm");
        JButton saveButton = new JButton("Save");
        
        JPanel panel = new JPanel();
        
        panel.add(desc);
        panel.add(date);
        panel.add(startTime);
        panel.add(endTime);
        panel.add(saveButton);
        
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
