package ca.uwo.csd.cs2212.team07;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Creates a Settings Panel to be displayed in the JOptionPane.
 *
 * @author team07
 */
public class SettingsPanel extends JPanel {

    private final UserConfig userConfig;
    private JRadioButton caloriesOn;
    private JRadioButton caloriesOff;
    private JRadioButton distanceOn;
    private JRadioButton distanceOff;
    private JRadioButton floorsOn;
    private JRadioButton floorsOff;
    private JRadioButton stepsOn;
    private JRadioButton stepsOff;
    private JRadioButton activeOn;
    private JRadioButton activeOff;
    private JRadioButton sedentaryOn;
    private JRadioButton sedentaryOff;
    
    private JRadioButton fatOn, fatOff;
    private JRadioButton peakOn, peakOff;
    private JRadioButton cardioOn, cardioOff;
    private JRadioButton outOn, outOff;

    /**
     * Constructs a new Main Window
     *
     * @param userConfig the user configuration
     */
    public SettingsPanel(UserConfig userConfig) {
        this.userConfig = userConfig;
        this.initUI();
    }

    private void initUI() {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(10));
        
        caloriesOn = new JRadioButton("Yes");
        caloriesOff = new JRadioButton("No");
        JLabel calText = new JLabel("Show Calories Burned: ");
        this.add(this.makeField(calText, caloriesOn, caloriesOff, userConfig.isCaloriesData()));
        distanceOn = new JRadioButton("Yes");
        distanceOff = new JRadioButton("No");
        JLabel distText = new JLabel("Show Distance Travelled: ");
        this.add(this.makeField(distText, distanceOn, distanceOff, userConfig.isDistanceData()));
        floorsOn = new JRadioButton("Yes");
        floorsOff = new JRadioButton("No");
        JLabel floorsText = new JLabel("Show Floors Climbed: ");
        this.add(this.makeField(floorsText, floorsOn, floorsOff, userConfig.isFloorsData()));
        stepsOn = new JRadioButton("Yes");
        stepsOff = new JRadioButton("No");
        JLabel stepsText = new JLabel("Show Steps Taken: ");
        this.add(this.makeField(stepsText, stepsOn, stepsOff, userConfig.isStepsData()));
        activeOn = new JRadioButton("Yes");
        activeOff = new JRadioButton("No");
        JLabel activeText = new JLabel("Show Active Minutes: ");
        this.add(this.makeField(activeText, activeOn, activeOff, userConfig.isActiveData()));
        sedentaryOn = new JRadioButton("Yes");
        sedentaryOff = new JRadioButton("No");
        JLabel sedentaryText = new JLabel("Show Sedentary Minutes: ");
        this.add(this.makeField(sedentaryText, sedentaryOn, sedentaryOff, userConfig.isSedentaryData()));
        
        JLabel fatText = new JLabel("Show Fat Heart Rate Zone");
        fatOn = new JRadioButton("Yes");
        fatOff = new JRadioButton("No");
        this.add(this.makeField(fatText, fatOn, fatOff, userConfig.isFatVisible()));
        JLabel peakText = new JLabel("Show Peak Heart Rate Zone");
        peakOn = new JRadioButton("Yes");
        peakOff = new JRadioButton("No");
        this.add(this.makeField(peakText, peakOn, peakOff, userConfig.isPeakVisible()));
        JLabel cardioText = new JLabel("Show Cardio Heart Rate Zone");
        cardioOn = new JRadioButton("Yes");
        cardioOff = new JRadioButton("No");
        this.add(this.makeField(cardioText, cardioOn, cardioOff, userConfig.isCardioVisible()));
        JLabel outText = new JLabel("Show Out Of Range Heart Rate Zone");
        outOn = new JRadioButton("Yes");
        outOff = new JRadioButton("No");
        this.add(this.makeField(outText, outOn, outOff, userConfig.isOutVisible()));
        
        this.add(Box.createVerticalStrut(10));

        this.setVisible(true);
    }

    private JPanel makeField(JLabel text, JRadioButton onButton, JRadioButton offButton, boolean storedBool) {
        ButtonGroup grpCalories = new ButtonGroup();
        grpCalories.add(onButton);
        grpCalories.add(offButton);
        onButton.setSelected(storedBool);
        offButton.setSelected(!storedBool);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setOpaque(false);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.X_AXIS));
        fieldPanel.add(Box.createHorizontalStrut(50));
        fieldPanel.add(text);
        fieldPanel.add(Box.createHorizontalGlue());
        fieldPanel.add(onButton);
        fieldPanel.add(offButton);
        fieldPanel.add(Box.createHorizontalStrut(50));
        
        return fieldPanel;
    }

    void confirmSettings() {
        userConfig.setCaloriesData(caloriesOn.isSelected());
        userConfig.setDistanceData(distanceOn.isSelected());
        userConfig.setFloorsData(floorsOn.isSelected());
        userConfig.setStepsData(stepsOn.isSelected());
        userConfig.setActiveData(activeOn.isSelected());
        userConfig.setSedentaryData(sedentaryOn.isSelected());
        userConfig.setFatVisible(fatOn.isSelected());
        userConfig.setPeakVisible(peakOn.isSelected());
        userConfig.setCardioVisible(cardioOn.isSelected());
        userConfig.setOutVisible(outOn.isSelected());
    }
}
