
package ca.uwo.csd.cs2212.team07;

/**
 * TimePoint Class: Stores a time of day and the value (calories burned, steps, distance, heartrate) associated with that time
 * @author Team07
**/ 
public class TimePoint {
    
    //INSTANCE VARIABLES:
    private String time;
    private double value;
    
    /**
     * CONSTRUCTOR METHOD: Creates a new TimePoint object
     * @param timeStr String of time of day
     * @param val Value that was achieved at this specific time of day
     */
    public TimePoint(String timeStr, double val) {
        this.time = timeStr;
        this.value = val;
    }
    
    /**
     * getValue() method:
     * @return double value associated with this TimePoint object
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * getTime() method:
     * @return String of the time of this TimePoint object
     */
    public String getTime() {
        return this.time;
    }
    
    /**
     * toString() method: used for testing purposes
     * @return A string detailing the contents of this TimePoint object
     */
    public String toString() {
        return "Value: " + this.value + ", at time: " + this.time + "\n";
    }
    
    
    
    
} 
