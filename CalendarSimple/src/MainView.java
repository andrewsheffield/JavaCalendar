
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
public class MainView {
    
    final EventModel model;
    final JLabel monthLabel;
    final Calendar cal;
    final JPanel monthPanel;
    
    public MainView(final EventModel model) {
        this.model = model;
        
        JFrame frame = new JFrame();
        
        cal =  new GregorianCalendar(model.getYear(), model.getMonth(), 1);
        
        Date monthDate = cal.getTime();
        
        
        JButton createButton = new JButton("Create");
        JButton previousButton = new JButton("<");
        JButton nextButton = new JButton(">");
        
        previousButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.previousMonth();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextMonth();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(previousButton);
        monthLabel = new JLabel(new SimpleDateFormat("MMM").format(monthDate) + " 2014");
        buttonPanel.add(monthLabel);
        buttonPanel.add(nextButton);
        
        monthPanel = new JPanel();
        monthPanel.setLayout(new GridLayout(0, 7, 5, 5));
        monthPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        
        drawMonth(monthPanel);
        
        
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(monthPanel, BorderLayout.WEST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void repaint() {
        cal.set(model.getYear(), model.getMonth(), 1);
        Date monthDate = cal.getTime();
        monthLabel.setText(new SimpleDateFormat("MMM").format(monthDate) + " " + model.getYear());
        monthLabel.repaint();
        
        monthPanel.removeAll();
        drawMonth(monthPanel);
        monthPanel.repaint();
    }

    private void drawMonth(JPanel monthPanel) {
        //Add Week Labels at top of Month View
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i<7; i++) {
            JLabel day = new JLabel("<html><u>" + daysOfWeek[i] + "</u></html>");
            monthPanel.add(day);
        }
        
        //Add days in month
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        
        for (int i = 1; i<daysInMonth+startDay; i++) {
            if (i<startDay) {
                JLabel day = new JLabel("");
                monthPanel.add(day);
            } else {
                int dayNumber = i-startDay +1;
                JLabel day = new JLabel(dayNumber+"");
                monthPanel.add(day);
            }
        }
    }

}
