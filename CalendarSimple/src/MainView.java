
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.DimensionUIResource;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheff
 */
public class MainView {
    
    public MainView(final EventModel model) {
        this.model = model;
        
        JButton createButton = new JButton("Create");
        JButton previousButton = new JButton("<");
        JButton nextButton = new JButton(">");
        
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CreateEventView cev = new CreateEventView(model);
            }
        });
        
        previousButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.previousDay();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextDay();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        
        monthPanel = new JPanel();
        monthPanel.setLayout(new GridLayout(0, 7, 5, 5));
        monthPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        
        monthLabel = new JLabel("Hello");
        
        JPanel monthWrap = new JPanel();
        monthWrap.setLayout(new FlowLayout());
        monthWrap.add(monthLabel);
        monthWrap.add(monthPanel);
        
        drawMonth(monthPanel);
        
        dayPanel = new JPanel();
        dayPanel.setLayout(new BoxLayout(dayPanel, BoxLayout.PAGE_AXIS));
        dayPanel.setPreferredSize(new Dimension(400, 400));
        dayPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        drawDay(dayPanel);
       
        JFrame frame = new JFrame();
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(monthWrap, BorderLayout.WEST);
        frame.add(dayPanel, BorderLayout.EAST);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void repaint() {

        monthPanel.removeAll();
        drawMonth(monthPanel);
        monthPanel.revalidate();
        monthPanel.repaint();
        
        dayPanel.removeAll();
        drawDay(dayPanel);
        dayPanel.revalidate();
        dayPanel.repaint();
    }

    private void drawMonth(JPanel monthPanel) {
        
        Calendar cal = model.getCal();
        
        monthLabel.setText(cal.get(Calendar.MONTH) + "");
        
        //Add Week Labels at top of Month View
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i<7; i++) {
            JLabel day = new JLabel("<html><u>" + daysOfWeek[i] + "</u></html>");
            monthPanel.add(day);
        }
        
        //Add days in month
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        Calendar getStart = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        int startDay = getStart.get(Calendar.DAY_OF_WEEK);
        
        for (int i = 1; i<daysInMonth+startDay; i++) {
            if (i<startDay) {
                final JLabel day = new JLabel("");
                
                monthPanel.add(day);
            } else {
                int dayNumber = i-startDay+1;
                final JLabel day = new JLabel(dayNumber+"");
                day.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int num = Integer.parseInt(day.getText());
                        model.setDay(num);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
                if (dayNumber == cal.get(Calendar.DAY_OF_MONTH)) {
                    day.setBorder(BorderFactory.createLineBorder(Color.blue));
                }
                monthPanel.add(day);
            }
        }
    }
    
    public void drawDay(JPanel dayPanel) {
        
        ArrayList<Event> todaysEvents = model.getEvents();
        Calendar cal = model.getCal();
        
        for (Event e : todaysEvents) {
            if (e.start.get(Calendar.DAY_OF_MONTH) == cal.get(Calendar.DAY_OF_MONTH)) {
                dayPanel.add(new JLabel(e.name));
            }
        }
    }

    
    private EventModel model;
    private final JLabel monthLabel;
    private final JLabel dayLabel = new JLabel();
    private final JPanel monthPanel;
    private final JPanel dayPanel;

}
