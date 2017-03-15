package ca.uwo.csd.cs2212.team07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import org.json.JSONException;

/**
 * Creates a Dashboard panel that displays the Dashboard to the user.
 *
 * @author team07
 */
public class Dashboard extends JPanel implements ActionListener {

    private final FitbitInfo fitbitInfo;
    private final UserConfig userConfig;

    private JLabel date;
    private JLabel caloriesBurnedData, totalDistanceData, floorsClimbedData, stepsTakenData, activeMinutesData, sedentaryMinutesData;
    
    private JToggleButton calendarButton;
    private DateChooserPanel dateChooser;
    private ButtonGroup buttonGroup;
    private JToggleButton todayButton, bestButton, lifetimeButton;

    private JPanel displayPanel, caloriesPanel, distancePanel, floorsPanel, stepsPanel, activePanel, sedentaryPanel;

    /**
     * Constructor for the Dashboard class
     *
     * @param fitbitInfo container for user data
     * @param userConfig container for user configuration
     */
    public Dashboard(FitbitInfo fitbitInfo, UserConfig userConfig) {
        super();
        this.fitbitInfo = fitbitInfo;
        this.userConfig = userConfig;
        initPanel();
    }

    /**
     * Initializes the panel that displays the Dashboard
     */
    private void initPanel() {
        this.setBackground(Color.white);

        date = new JLabel("");
        dateChooser = new DateChooserPanel((Calendar) fitbitInfo.getLastRefreshTime().clone(), false);
        //Today, Best, Lifetime views
        calendarButton = new JToggleButton();
        calendarButton.addActionListener(this);
        calendarButton.setToolTipText("View Previous Day");
        ImageIcon icon = new ImageIcon(FileReader.getImage("calendar.png"));
        calendarButton.setIcon(icon);

        todayButton = new JToggleButton("Today");
        todayButton.setToolTipText("Today's Activity");
        todayButton.addActionListener(this);
        bestButton = new JToggleButton("Best");
        bestButton.setToolTipText("Best Days");
        bestButton.addActionListener(this);
        lifetimeButton = new JToggleButton("Lifetime");
        lifetimeButton.setToolTipText("Total Lifetime Activity");
        lifetimeButton.addActionListener(this);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(calendarButton);
        buttonGroup.add(todayButton);
        buttonGroup.add(bestButton);
        buttonGroup.add(lifetimeButton);

        displayPanel = new JPanel();
        displayPanel.setOpaque(false);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.add(Box.createHorizontalStrut(15));
        displayPanel.add(calendarButton);
        displayPanel.add(Box.createHorizontalStrut(5));
        displayPanel.add(todayButton);
        displayPanel.add(Box.createHorizontalStrut(5));
        displayPanel.add(bestButton);
        displayPanel.add(Box.createHorizontalStrut(5));
        displayPanel.add(lifetimeButton);
        displayPanel.add(Box.createHorizontalGlue());
        displayPanel.add(date);
        displayPanel.add(Box.createHorizontalStrut(15));
        //End of Today, Best, Lifetime views

        //Panels for each data item
        caloriesBurnedData = new JLabel("");
        caloriesPanel = this.createDataBox(new JLabel("Calories Burned"), caloriesBurnedData, "dataicons/calories.png", new Color(255, 175, 175));
        totalDistanceData = new JLabel("");
        distancePanel = this.createDataBox(new JLabel("Total Distance"), totalDistanceData, "dataicons/distance.png", new Color(180, 255, 190));
        floorsClimbedData = new JLabel("");
        floorsPanel = this.createDataBox(new JLabel("Floors Climbed"), floorsClimbedData, "dataicons/floors.png", new Color(255, 180, 245));
        stepsTakenData = new JLabel("");
        stepsPanel = this.createDataBox(new JLabel("Steps Taken"), stepsTakenData, "dataicons/steps.png", new Color(180, 250, 255));
        activeMinutesData = new JLabel("");
        activePanel = this.createDataBox(new JLabel("Active Minutes"), activeMinutesData, "dataicons/active.png", new Color(250, 255, 180));
        sedentaryMinutesData = new JLabel("");
        sedentaryPanel = this.createDataBox(new JLabel("Sedentary Minutes"), sedentaryMinutesData, "dataicons/sedentary.png", new Color(255, 220, 180));
        //end of Panels for each data item

        this.setLayout(new BorderLayout());
        //Layout Specifications - Top
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(displayPanel);
        this.add(topPanel, BorderLayout.NORTH);
        //Layout Specifications - WEST and EAST
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        westPanel.setOpaque(false);
        eastPanel.setOpaque(false);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        //Layout Specifications - Center
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(caloriesPanel);
        centerPanel.add(distancePanel);
        centerPanel.add(floorsPanel);
        centerPanel.add(stepsPanel);
        centerPanel.add(activePanel);
        centerPanel.add(sedentaryPanel);
        centerPanel.add(Box.createVerticalStrut(20));
        this.add(centerPanel, BorderLayout.CENTER);

        //sets the view to Today
        todayButton.doClick();
    }

    /**
     * Create a data box for one of the data items displayed on the Dashboard
     *
     * @param header name of data item
     * @param data the data to display
     * @param color the color of the data box
     * @return a JPanel containing the data box for the data item
     */
    private JPanel createDataBox(JLabel header, JLabel data, String iconFile, Color color) {
        JPanel panel = new JPanel();

        panel.setBackground(color);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        ImageIcon iconImage = new ImageIcon(FileReader.getImage(iconFile));
        JLabel iconLabel = new JLabel(iconImage);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(iconLabel);
        panel.add(Box.createHorizontalStrut(250));

        header.setFont(new Font(header.getFont().getName(), Font.PLAIN, 14));
        panel.add(header);
        panel.add(Box.createHorizontalGlue());

        data.setFont(new Font(data.getFont().getName(), Font.PLAIN, 14));
        panel.add(data);
        panel.add(Box.createHorizontalStrut(50));

        return panel;
    }

    /**
     * Refreshes the Dashboard after refreshing the data in FitbitInfo or
     * returning to Today's view
     */
    public void refresh() {
        this.refreshConfig();
        todayButton.setSelected(true);

        date.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(fitbitInfo.getLastRefreshTime().getTime()));

        Daily day = fitbitInfo.getDay();
        caloriesBurnedData.setText("" + day.getCaloriesOut());
        totalDistanceData.setText("" + day.getDistance());
        stepsTakenData.setText("" + day.getSteps());
        floorsClimbedData.setText("" + day.getFloors());
        activeMinutesData.setText("" + day.getActiveMins());
        sedentaryMinutesData.setText("" + day.getSedentaryMins());

    }

    /**
     * Sets the results of clicking different buttons on the Dashboard
     *
     * @param e event called when button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calendarButton) {
            this.switchDay();
        } else if (e.getSource() == todayButton) {
            this.refreshConfig();
            this.refresh();
        } else if (e.getSource() == bestButton) {
            this.displayBest();
        } else if (e.getSource() == lifetimeButton) {
            this.displayLifetime();
        }
    }

    private void switchDay() {
        int n = JOptionPane.showOptionDialog(this, dateChooser,
                "Calendar", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (n == JOptionPane.OK_OPTION) {
            Daily dayInfo;

            if (fitbitInfo.isTestMode()) { //checks if in Test Mode
                FitbitInfo info = new FitbitInfo();
                info.testModeData();
                dayInfo = info.getDay();
            } else {
                try {
                    dayInfo = Api.getDailySummary(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate()));
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Unable to display data.");
                    return; //so that the data does not update
                } catch (RefreshTokenException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Refresh Tokens are out of date. Please replace tokens.");
                    return; //so that the data does not update
                }
            }

            date.setText(new SimpleDateFormat("EEEE, MMMM d, yyyy").format(dateChooser.getDate()));
            sedentaryMinutesData.setText("" + dayInfo.getSedentaryMins());
            activeMinutesData.setText("" + dayInfo.getActiveMins());
            stepsTakenData.setText("" + dayInfo.getSteps());
            floorsClimbedData.setText("" + dayInfo.getFloors());
            totalDistanceData.setText("" + dayInfo.getDistance());
            caloriesBurnedData.setText("" + dayInfo.getCaloriesOut());
        }
    }

    /**
     * Displays the Best Days data to the user
     */
    private void displayBest() {
        try {
            double roundedBestDistance = Math.round(fitbitInfo.getBestDays()[0].getValue() * 100.0) / 100.0;
            double roundedBestFloors = Math.round(fitbitInfo.getBestDays()[1].getValue() * 100.0) / 100.0;
            int roundedBestSteps = (int) fitbitInfo.getBestDays()[2].getValue();
            DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
            fromFormat.setLenient(false);
            DateFormat toFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
            toFormat.setLenient(false);

            date.setText("Best Days");
            caloriesPanel.setVisible(false);
            totalDistanceData.setText(toFormat.format(fromFormat.parse(fitbitInfo.getBestDays()[0].getDate()))
                    + "\t\t - \t\t" + roundedBestDistance);
            floorsClimbedData.setText(toFormat.format(fromFormat.parse(fitbitInfo.getBestDays()[1].getDate()))
                    + "\t\t - \t\t" + roundedBestFloors);
            stepsTakenData.setText(toFormat.format(fromFormat.parse(fitbitInfo.getBestDays()[2].getDate()))
                    + "\t\t - \t\t" + roundedBestSteps);

            activePanel.setVisible(false);
            sedentaryPanel.setVisible(false);

        } catch (ParseException ex) {
            System.err.println("ERROR PARSING DATE");
        }

    }

    /**
     * Displays the Lifetime data to the user
     */
    private void displayLifetime() {
        double roundedBestDistance = Math.round(fitbitInfo.getLifetime().getDistance() * 100.0) / 100.0;
        double roundedBestFloors = Math.round(fitbitInfo.getLifetime().getFloors() * 100.0) / 100.0;
        int roundedBestSteps = (int) fitbitInfo.getLifetime().getSteps();

        date.setText("Lifetime Totals");
        caloriesPanel.setVisible(false);
        totalDistanceData.setText("" + roundedBestDistance);
        floorsClimbedData.setText("" + roundedBestFloors);
        stepsTakenData.setText("" + roundedBestSteps);
        activePanel.setVisible(false);
        sedentaryPanel.setVisible(false);

    }

    public void refreshConfig() {
        caloriesPanel.setVisible(userConfig.isCaloriesData());
        distancePanel.setVisible(userConfig.isDistanceData());
        floorsPanel.setVisible(userConfig.isFloorsData());
        stepsPanel.setVisible(userConfig.isStepsData());
        activePanel.setVisible(userConfig.isActiveData());
        sedentaryPanel.setVisible(userConfig.isSedentaryData());
    }

}
