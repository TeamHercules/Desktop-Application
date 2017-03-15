
package ca.uwo.csd.cs2212.team07;

import java.util.ArrayList;

/**
 * TimeSeriesData class: stores information relating to Time Series Data, an ArrayList of the TimePoints, a date, the resolution that this data
 * exists at, and a String of the activity name
 * @author Team07
 */
public class TimeSeriesData {
    
    //INSTANCE VARIABLES:
    private ArrayList<TimePoint> data;
    private String date;
    private int resolution;
    private String activity;

    /**
     * Constructor Method: Creates a new TimeSeriesData object
     * @param data ArrayList of type TimePoint, storing the actual data from Fitbit
     * @param date String storing the date that this TimeSeriesData is from
     * @param resolution int value of the resolution of this time series data (i.e. every 15 mins, every 1 min)
     * @param activity String of the activity name of this TimeSeriesData (heartrate, steps, calories etc..)
     */
    public TimeSeriesData(ArrayList<TimePoint> data, String date, int resolution, String activity) {
        this.data = data;
        this.date = date;
        this.resolution = resolution;
        this.activity = activity;
    }
    
    public int getDatasetLength() {
        return data.size();
    }
    
    public TimePoint getTimePoint(int index) {
        return data.get(index);
    }
}
