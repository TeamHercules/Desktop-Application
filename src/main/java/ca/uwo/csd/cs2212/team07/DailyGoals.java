package ca.uwo.csd.cs2212.team07;

import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;



/**
 * Creates a Daily Goals panel that displays the Daily Goals to the user.
 *
 * @author team07
 */
public class DailyGoals extends JPanel {

    private final FitbitInfo fitbitInfo;

    private JLabel date;
    
    private JLabel caloriesBurnedGoal= new JLabel("You haven't set up your daily goal yet!");
    private JLabel cbdg = new JLabel("Calories Burned Daily Goal");
    private JLabel totalDistanceGoal = new JLabel("You haven't set up your daily goal yet!");
    private JLabel floorsClimbedGoal = new JLabel("You haven't set up your daily goal yet!");
    private JLabel stepsTakenGoal = new JLabel("You haven't set up your daily goal yet!");
    

    private JComboBox calBox, distBox, floorBox, stepBox;  
    private JLabel calLabel, distLabel, floorLabel, stepLabel;
    /**
     * Constructor for the Daily Goals class
     *
     * @param fitbitInfo container for user data
     */
    public DailyGoals(FitbitInfo fitbitInfo) {
        super();
        this.fitbitInfo = fitbitInfo;
        initPanel();
    }

    /**
     * Initializes the panel to display Daily Goals to the user
     */
    private void initPanel() {

        /*
        this.setBackground(Color.CYAN); //Color of the menu bar

        date = new JLabel(new SimpleDateFormat("dd MMM yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));


        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(10));
        this.add(date);
        this.add(Box.createVerticalStrut(20));
        
        JPanel panCal = new JPanel();
        panCal.setBackground(Color.CYAN);
        calBox = new JComboBox();
        calBox.addItem("");
        calBox.addItem("250");
        calBox.addItem("500");
        calBox.addItem("750");
        calBox.addItem("1000");        
        calBox.addItem("1250");
        calBox.addItem("1500");
        calBox.addItem("1750");
        calBox.addItem("2000");
        calBox.addItem("2250");
        calBox.addItem("2500");
        calLabel = new JLabel("Edit you calories burned daily goal: ");
        //panCal.add(calLabel);
        //panCal.add(calBox);
        calBox.addItemListener(new ItemStateCal());
        //this.add(panCal);
        
        JPanel caloriesGoal = this.createDataBox(cbdg, caloriesBurnedGoal, Color.red, calBox);
        this.add(caloriesGoal);
        //caloriesBurnedGoal.setAlignmentX(10);
        //cbdg.setAlignmentX(10);
        this.add(Box.createVerticalStrut(20));
        
        JPanel distanceGoal = this.createDataBox(new JLabel("Total Distance Daily Goal"), totalDistanceGoal, Color.green, null);
        this.add(distanceGoal);
        this.add(Box.createVerticalStrut(20));
        
        JPanel floorsGoal = this.createDataBox(new JLabel("Floors Climbed Daily Goal"), floorsClimbedGoal, Color.yellow, null);
        this.add(floorsGoal);
        this.add(Box.createVerticalStrut(20));
           
        JPanel stepsGoal = this.createDataBox(new JLabel("Steps Taken Daily Goal"), stepsTakenGoal, Color.white, null);
        this.add(stepsGoal);
        this.add(Box.createVerticalStrut(20));
                   

        
        JPanel panDist = new JPanel();
        panDist.setBackground(Color.CYAN);
        distBox = new JComboBox();
        distBox.addItem("");
        distBox.addItem("1000");
        distBox.addItem("1500");
        distBox.addItem("2000");
        distBox.addItem("2500");        
        distBox.addItem("3000");
        distBox.addItem("3500");
        distBox.addItem("4000");
        distBox.addItem("4500");
        distBox.addItem("5000");
        distBox.addItem("10000");
        distBox.addItem("20000");
        distLabel = new JLabel("Edit you distance daily goal (meters): ");
        panDist.add(distLabel);
        panDist.add(distBox);
        distBox.addItemListener(new ItemStateDist());
        this.add(panDist);
        
        JPanel panFloor = new JPanel();
        panFloor.setBackground(Color.CYAN);
        floorBox = new JComboBox();
        floorBox.addItem("");
        floorBox.addItem("1");
        floorBox.addItem("2");
        floorBox.addItem("3");
        floorBox.addItem("4");        
        floorBox.addItem("5");
        floorBox.addItem("6");
        floorBox.addItem("7");
        floorBox.addItem("8");
        floorBox.addItem("9");
        floorBox.addItem("10");
        floorBox.addItem("15");
        floorBox.addItem("20");
        floorBox.addItem("25");
        floorBox.addItem("30");
        floorBox.addItem("50");
        floorBox.addItem("10000");
        floorLabel = new JLabel("Edit you floors climbed daily goal: ");
        panCal.add(floorLabel);
        panCal.add(floorBox);
        floorBox.addItemListener(new ItemStateFloor());
        this.add(panFloor);
        
        JPanel panStep = new JPanel();
        panStep.setBackground(Color.CYAN);
        stepBox = new JComboBox();
        stepBox.addItem("");
        stepBox.addItem("100");
        stepBox.addItem("150");
        stepBox.addItem("200");
        stepBox.addItem("250");        
        stepBox.addItem("300");
        stepBox.addItem("350");
        stepBox.addItem("400");
        stepBox.addItem("450");
        stepBox.addItem("500");
        stepBox.addItem("1000");
        stepBox.addItem("2000");
        stepBox.addItem("3000");
        stepBox.addItem("5000");
        stepBox.addItem("10000");
        stepLabel = new JLabel("Edit you taken steps daiy goal: ");
        panStep.add(stepLabel);
        panStep.add(stepBox);
        stepBox.addItemListener(new ItemStateStep());
        this.add(panStep);
    }
    
    class ItemStateCal implements ItemListener{
           public void itemStateChanged(ItemEvent e) {
           String a = (String) e.getItem();
           caloriesBurnedGoal.setText(a);     
        }     
    }
    class ItemStateDist implements ItemListener{
           public void itemStateChanged(ItemEvent e) {
           String a = (String) e.getItem();
           totalDistanceGoal.setText(a);                   
        }      
    }
    class ItemStateFloor implements ItemListener{
           public void itemStateChanged(ItemEvent e) {
           String a = (String) e.getItem();
           floorsClimbedGoal.setText(a);                   
        }      
    }
    class ItemStateStep implements ItemListener{
           public void itemStateChanged(ItemEvent e) {
           String a = (String) e.getItem();
           stepsTakenGoal.setText(a);                   
        }      
    }
    
    private JPanel createDataBox(JLabel header, JLabel data, Color color, JComboBox box) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(600, 10)));     
        panel.add(header);
        panel.add(data);
        panel.add(box);
        panel.add(Box.createRigidArea(new Dimension(600, 10)));
        
 
        return panel;
        */
    }
    
   
    /**
     * Refresh the data displayed to the user
     */
    public void refresh() {
        
    }


    public void refreshConfig() {
        System.out.println("To Implement");
    }

}