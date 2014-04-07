
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
public class MainView {
    
    public MainView() {
        JFrame frame = new JFrame();
        
        
        JButton createButton = new JButton("Create");
        JButton previousButton = new JButton("<");
        JButton nextButton = new JButton(">");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(new JLabel("April 2014"));
        buttonPanel.add(nextButton);
        
        JPanel monthPanel = new JPanel();
        monthPanel.setLayout(new GridLayout(0, 7, 5, 5));
        monthPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        
        //Add Week Labels at top of Month View
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i<7; i++) {
            JLabel day = new JLabel("<html><u>" + daysOfWeek[i] + "</u></html>");
            monthPanel.add(day);
        }
        
        //Add days in month
        for (int i=1; i<32; i++) {
            JLabel day = new JLabel(i+"");
            if (i==3) {
                day.setFont(new Font("Serif", Font.BOLD, 14));
                day.setForeground(Color.red);
            }
            monthPanel.add(day);
        }
        
        
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(monthPanel, BorderLayout.WEST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
