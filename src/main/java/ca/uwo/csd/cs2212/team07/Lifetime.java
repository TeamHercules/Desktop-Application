
package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * Lifetime class, this class stores data of the user's lifetime information. Total distance that they traveled,
 * total floors climbed and steps taken
 * @author Team07
 */
public class Lifetime implements Serializable {

    //Instance Variables, declared as public final so that they can be accessed easily but not changed
    private double distance;
    private double floors;
    private long steps;
    private long caloriesOut;

    /**
     * Constructor Method: makes a new Lifetime object
     * @param lifeDistance distance that user has traveled while using Fitbit
     * @param lifeFloors floors that user has climbed while using Fitbit
     * @param lifeSteps steps that user has taken while using Fitbit
     */
    public Lifetime(double lifeDistance, double lifeFloors, long lifeSteps, long caloriesOut) {
        this.distance = lifeDistance;
        this.floors = lifeFloors;
        this.steps = lifeSteps;
        this.caloriesOut = caloriesOut;
    }

    /**
     * toString method: used for testing.
     * @return String containing info about Lifetime object
     */
    public String toString() {
        return "Lifetime Distance: " + this.distance + "\nLifetime Floors: " + this.floors + "\nLifetime Steps: " + this.steps;
    }

    /**
     * getCaloriesOut() method: returns lifetime calories burned
     * @return long value of caloriesOut
     */
    public long getCaloriesOut() {
        return caloriesOut;
    }

    /**
     * setCaloriesOut() method: sets the lifetime calories out
     * @param caloriesOut long value to set as caloriesOut
     */
    public void setCaloriesOut(long caloriesOut) {
        this.caloriesOut = caloriesOut;
    }
    
    

    /**
     * getDistance() method:
     * @return the distance that has been traveled in the lifetime of this Fitbit
     */
    public double getDistance() {
        return distance;
    }

    /**
     * setDistance() method
     * @param distance double to set as the distance that has been traveled in the lifetime of the fitbit
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * getFloors() method:
     * @return double of the number of floors climbed
     */
    public double getFloors() {
        return floors;
    }

    /**
     * setFloors() method
     * @param floors, value to set as number of floors climbed
     */
    public void setFloors(double floors) {
        this.floors = floors;
    }

    /**
     * getSteps() method:
     * @return value of steps that have been taken
     */
    public long getSteps() {
        return steps;
    }

    /**
     * setSteps() method:
     * @param steps long value of steps that have been taken
     */
    public void setSteps(long steps) {
        this.steps = steps;
    }

    
}

