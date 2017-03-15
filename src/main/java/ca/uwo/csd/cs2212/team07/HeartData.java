
package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;
import org.json.JSONArray;

/**
 * HeartData Class: Stores all the heartrate data for the user on any given day
 * @author Team07
 */
public class HeartData implements Serializable {
    
    //INSTANCE VARIABLES:
    private String date;
    private int restingHeartRate;
    private int outOfRangeMins, fatBurnMins, cardioMins, peakMins;
    private double outOfRangeCalsOut, fatBurnCalsOut, cardioCalsOut, peakCalsOut;
    private final JSONArray intraDayDataset;

    /**
     * CONSTRUCTOR: Creates a new HeartData object
     * @param date The date that this heartrate data comes from
     * @param restingHeartRate Resting heart rate of the user on this day
     * @param outOfRangeMins minutes in the "out of range" heartrate category
     * @param fatBurnMins minutes in the "fat burn" heart rate category
     * @param cardioMins minutes in the "cardio" heart rate category
     * @param peakMins minutes in the "peak" heart rate category
     * @param outOfRangeCalsOut calories burned while in the "out of range" category
     * @param fatBurnCalsOut calories burned while in the "fatburn" category
     * @param cardioCalsOut calories burned while in the "cardio" category
     * @param peakCalsOut calories burned while in the "peak" category
     * @param intraDayDataset JSONArray storing intraday heart rate data
     */
    public HeartData(String date, int restingHeartRate, int outOfRangeMins, int fatBurnMins, int cardioMins, int peakMins, double outOfRangeCalsOut, 
                     double fatBurnCalsOut, double cardioCalsOut, double peakCalsOut, JSONArray intraDayDataset) {
        this.date = date;
        this.restingHeartRate = restingHeartRate;
        this.outOfRangeMins = outOfRangeMins;
        this.fatBurnMins = fatBurnMins;
        this.cardioMins = cardioMins;
        this.peakMins = peakMins;
        this.outOfRangeCalsOut = outOfRangeCalsOut;
        this.fatBurnCalsOut = fatBurnCalsOut;
        this.cardioCalsOut = cardioCalsOut;
        this.peakCalsOut = peakCalsOut;
        this.intraDayDataset = intraDayDataset;
    }

    /**
     * getDate() method: returns the date string
     * @return date that this heart rate data comes from
     */
    public String getDate() {
        return date;
    }

    /**
     *setDate() method: sets the date of this heart rate data
     * @param date String of date to set for this heart rate data
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getRestingHeartRate() method:
     * @return int of the resting heart rate for this day
     */
    public int getRestingHeartRate() {
        return restingHeartRate;
    }

    /**
     * setRestingHeartRate() method: sets the resting heart rate for this day
     * @param restingHeartRate int of resting heart rate to set
     */
    public void setRestingHeartRate(int restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    /**
     * getOutOfRangeMins() method: returns the minutes that this user spent in the "out of range" heartrate category in this day
     * @return outOfRangeMins integer of mins user spent in the out of range heartrate category
     */
    public int getOutOfRangeMins() {
        return outOfRangeMins;
    }

    /**
     * setOutOfRangeMins()
     * @param outOfRangeMins minutes to set as minutes spent in out of range heartrate category
     */
    public void setOutOfRangeMins(int outOfRangeMins) {
        this.outOfRangeMins = outOfRangeMins;
    }

    /**
     * getFatBurnMins() method:
     * @return int of the minutes spent in the fat burn heart rate category on this day
     */
    public int getFatBurnMins() {
        return fatBurnMins;
    }

    /**
     * setFatBurnMins() method:
     * @param fatBurnMins int to set as the fat burn minutes for this day
     */
    public void setFatBurnMins(int fatBurnMins) {
        this.fatBurnMins = fatBurnMins;
    }

    /**
     * getCardioMins() method:
     * @return int of the minutes spent in the cardio heart rate category
     */
    public int getCardioMins() {
        return cardioMins;
    }

    /**
     * setCardioMins() method:
     * @param cardioMins int to set as the minutes spent in the "cardio" heart rate category
     */
    public void setCardioMins(int cardioMins) {
        this.cardioMins = cardioMins;
    }

    /**
     * getPeakMins() method:
     * @return int of the minutes spent in the "peak" heart rate category
     */
    public int getPeakMins() {
        return peakMins;
    }

    /**
     * setPeakMins() method
     * @param peakMins int to set as the minutes spent in the "peak" heart rate category
     */
    public void setPeakMins(int peakMins) {
        this.peakMins = peakMins;
    }

    /**
     * getOutOfRangeCalsOut() method
     * @return a double value of the calories burned while spent in the "out of range" heart rate category
     */
    public double getOutOfRangeCalsOut() {
        return outOfRangeCalsOut;
    }

    /**
     * setOutOfRangeCalsOut() method:
     * @param outOfRangeCalsOut double value to set as the calories burned while in the out of range heart rate category
     */
    public void setOutOfRangeCalsOut(double outOfRangeCalsOut) {
        this.outOfRangeCalsOut = outOfRangeCalsOut;
    }

    /**
     * getFatBurnCalsOut() method:
     * @return double value representing calories burned while in the "fat burn" heart rate category
     */
    public double getFatBurnCalsOut() {
        return fatBurnCalsOut;
    }

    /**
     * setFatBurnCalsOut() method:
     * @param fatBurnCalsOut double value to set as the calories burned while in the fat burn heart rate category
     */
    public void setFatBurnCalsOut(double fatBurnCalsOut) {
        this.fatBurnCalsOut = fatBurnCalsOut;
    }

    /**
     * getCardioCalsOut() method:
     * @return double value of the calories burned while in the cardio heart rate category
     */
    public double getCardioCalsOut() {
        return cardioCalsOut;
    }

    /**
     * setCardioCalsOut() method:
     * @param cardioCalsOut double value to set as the calories burned while in the cardio heart rate category
     */
    public void setCardioCalsOut(double cardioCalsOut) {
        this.cardioCalsOut = cardioCalsOut;
    }

    /**
     * getPeakCalsOut() method:
     * @return double value of the calories burned while in the peak heart rate category
     */
    public double getPeakCalsOut() {
        return peakCalsOut;
    }

    /**
     * setPeakCalsOut() method:
     * @param peakCalsOut double value to set as the calories burned while in the peak heart rate category
     */
    public void setPeakCalsOut(double peakCalsOut) {
        this.peakCalsOut = peakCalsOut;
    }

    /**
     * toString() method: used for testing purposes
     * @return string containing data in object
     */
    public String toString() {
        return "HeartData{" + "date=" + date + ", restingHeartRate=" + restingHeartRate + ", outOfRangeMins=" + outOfRangeMins + ", fatBurnMins=" + fatBurnMins + ", cardioMins=" + cardioMins + ", peakMins=" + peakMins + ", outOfRangeCalsOut=" + outOfRangeCalsOut + ", fatBurnCalsOut=" + fatBurnCalsOut + ", cardioCalsOut=" + cardioCalsOut + ", peakCalsOut=" + peakCalsOut + '}';
    }
   
}
