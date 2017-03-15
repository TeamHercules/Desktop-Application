package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * BestDay class, stores data pertaining to a "best day" of the user
 * @author Team07
 */
public class BestDay implements Serializable {

    //Instance Variables: declared as public final so they can be easily accessed, but not changed
    private String date;
    private String activity;
    private double value;

    /**
     * Constructor Method: creates a new BestDay object
     * @param bestDate string of date
     * @param act String of the activity
     * @param bestValue double value. The value that the user achieved in the specified activity on this day
     */
    public BestDay(String bestDate, String act, double bestValue) {
        this.date = bestDate;
        this.activity = act;
        this.value = bestValue;
    }

    /**
     * toString() method, used for testing purposes
     * @return String containing activity name, date and value
     */
    public String toString() {
        return "Activity: " + this.activity + "\nDate: " + this.date + "\nValue: " + this.value;
    }

    /**
     * getDate() method
     * @return String of date when this best date was achieved on
     */
    public String getDate() {
        return date;
    }

    /**
     * setDate() method:
     * @param date String date to set as the date relating to this BestDay object
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getActivity() method:
     * @return the activity associated with this best day object
     */
    public String getActivity() {
        return activity;
    }

    /**
     * setActivity() method:
     * @param activity String of activity name associated with this BestDay object
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * getValue() method:
     * @return value of the floors/steps/distance traveled on this BestDay
     */
    public double getValue() {
        return value;
    }

    /**
     * setValue() method:
     * @param value double value to set as the distance/steps/floors of this best day
     */
    public void setValue(double value) {
        this.value = value;
    }

    
}

