package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * Daily class, contains information of all goals and statistics of any given
 * day
 *
 * @author Team07
 */
public class Daily implements Serializable {

    //INSTANCE VARIABLES:
    // instance variables are declared as public final so that they can be accessed easily, but not changed
    private String date;
    private long activeMinGoal;
    private long activityCalories;
    private long calOutGoal;
    private long stepsGoal;
    private long caloriesBMR;
    private long caloriesOut;
    private long fairlyActiveMins;
    private long lightlyActiveMins;
    private long marginalCalories;
    private long sedentaryMins;
    private long steps;
    private long veryActiveMins;
    private long activeMins;
    private double floorGoal, distanceGoal, distance, elevation, floors;

    /**
     * Contructor Method, creates a new Daily object
     *
     * @param dailyDate the date
     * @param dailyActiveMinGoal the active minimum goal
     * @param dailyCalOutGoal the calories out goal
     * @param dailyDistanceGoal the distance goal
     * @param dailyFloorGoal the floor goal
     * @param dailyStepsGoal the steps goal
     * @param dailyActivityCalories the active calories
     * @param dailyCaloriesBMR the BMR calories
     * @param dailyCaloriesOut the calories out
     * @param dailyDistance distance
     * @param dailyElevation elevation
     * @param dailyFairlyActiveMins fairly active minutes
     * @param dailyFloors floors
     * @param dailyLightActMins light active minutes
     * @param dailyMargCals marginal calories
     * @param dailySedMins sedentary minutes
     * @param dailySteps steps
     * @param dailyVeryActMins very active minutes
     */
    public Daily(String dailyDate, long dailyActiveMinGoal, long dailyCalOutGoal, double dailyDistanceGoal, double dailyFloorGoal, long dailyStepsGoal, long dailyActivityCalories,
            long dailyCaloriesBMR, long dailyCaloriesOut, double dailyDistance, double dailyElevation, long dailyFairlyActiveMins, double dailyFloors, long dailyLightActMins,
            long dailyMargCals, long dailySedMins, long dailySteps, long dailyVeryActMins) {

        // create Daily object using paramatized information
        this.date = dailyDate;
        this.activeMinGoal = dailyActiveMinGoal;
        this.calOutGoal = dailyCalOutGoal;
        this.distanceGoal = dailyDistanceGoal;
        this.floorGoal = dailyFloorGoal;
        this.stepsGoal = dailyStepsGoal;
        this.activityCalories = dailyActivityCalories;
        this.caloriesBMR = dailyCaloriesBMR;
        this.caloriesOut = dailyCaloriesOut;
        this.distance = dailyDistance;
        this.elevation = dailyElevation;
        this.floors = dailyFloors;
        this.lightlyActiveMins = dailyLightActMins;
        this.marginalCalories = dailyMargCals;
        this.sedentaryMins = dailySedMins;
        this.steps = dailySteps;
        this.veryActiveMins = dailyVeryActMins;
        this.fairlyActiveMins = dailyFairlyActiveMins;
        this.activeMins = fairlyActiveMins + veryActiveMins + lightlyActiveMins;
    }

    /**
     * toString() method, used for testing api calls
     *
     * @return String containing info of Daily object
     */
    @Override
    public String toString() {
        return "Date: " + date + "\n\nGOALS:\nActive Minutes Goal: " + activeMinGoal + "\nCalories Out Goal: " + calOutGoal + "\nSteps Taken Goal: " + stepsGoal
                + "\nFloors Goal: " + floorGoal + "\nDistance Goal: " + distanceGoal + "\n\nDAILY:\nActivity Calories Out: " + activityCalories
                + "\nCalories BMR: " + caloriesBMR + "\nCalories Out: " + caloriesOut + "\nSedentary Minutes: " + sedentaryMins
                + "\nFairly Active Minutes: " + fairlyActiveMins + "\nLightly Active Minutes: " + lightlyActiveMins + "\nVery Active Minutes: " + veryActiveMins
                + "\nMarginal Calories:" + marginalCalories
                + "\nSteps Taken: " + steps + "\nDistance: " + distance + "\nElevation: " + elevation + "\nFloors: " + floors;
    }

    /**
     * getDate() method
     *
     * @return returns string of date associated with this Daily object
     */
    public String getDate() {
        return date;
    }

    /**
     * setDate method
     *
     * @param date sets the date of this daily object as the parameter String
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getActiveMinGoal() method:
     *
     * @return long of this daily's active minute goal
     */
    public long getActiveMinGoal() {
        return activeMinGoal;
    }

    /**
     * setActiveMinGoal() method
     *
     * @param activeMinGoal long to set as this Daily's active minute goal
     */
    public void setActiveMinGoal(long activeMinGoal) {
        this.activeMinGoal = activeMinGoal;
    }

    /**
     * getActivityCalories() method
     *
     * @return long of this Daily's activity calories
     */
    public long getActivityCalories() {
        return activityCalories;
    }

    /**
     * setActivityCalories() method
     *
     * @param activityCalories long value to set as this Daily's Activity
     * Calories
     */
    public void setActivityCalories(long activityCalories) {
        this.activityCalories = activityCalories;
    }

    /**
     * getCalOutGoal() method:
     *
     * @return a long of this Daily's calOutGoal
     */
    public long getCalOutGoal() {
        return calOutGoal;
    }

    /**
     * setCalOutGoal() method:
     *
     * @param calOutGoal long value to set as this Daily's calorie out goal
     */
    public void setCalOutGoal(long calOutGoal) {
        this.calOutGoal = calOutGoal;
    }

    /**
     * getStepsGoal() method:
     *
     * @return long of this Daily's steps goal
     */
    public long getStepsGoal() {
        return stepsGoal;
    }

    /**
     * setStepsGoal() method:
     *
     * @param stepsGoal value to set as this Daily's steps goal
     */
    public void setStepsGoal(long stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    /**
     * getCaloriesBMR() method:
     *
     * @return value of this Daily's calories BMR
     */
    public long getCaloriesBMR() {
        return caloriesBMR;
    }

    /**
     * setCaloriesBMR() method:
     *
     * @param caloriesBMR value to set as the calories BMR for this Daily object
     */
    public void setCaloriesBMR(long caloriesBMR) {
        this.caloriesBMR = caloriesBMR;
    }

    /**
     * getCaloriesOut() method:
     *
     * @return calue of this Daily object's Calories Out
     */
    public long getCaloriesOut() {
        return caloriesOut;
    }

    /**
     * setCaloriesOut() method:
     *
     * @param caloriesOut value to set as this Daily's calories out
     */
    public void setCaloriesOut(long caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    /**
     * getFairlyActiveMins() method:
     *
     * @return fairlyActiveMins, value of this Daily's fairly active mins
     */
    public long getFairlyActiveMins() {
        return fairlyActiveMins;
    }

    /**
     * setFairlyActiveMins() method:
     *
     * @param fairlyActiveMins the value to set as this Daily's fairlyActiveMins
     */
    public void setFairlyActiveMins(long fairlyActiveMins) {
        this.fairlyActiveMins = fairlyActiveMins;
    }

    /**
     * getLightlyActiveMins()
     *
     * @return number of lightly active minutes associated with this Daily
     * object
     */
    public long getLightlyActiveMins() {
        return lightlyActiveMins;
    }

    /**
     * setLightlyActiveMins() method
     *
     * @param lightlyActiveMins value to set as this Daily's lightly active
     * minutes
     */
    public void setLightlyActiveMins(long lightlyActiveMins) {
        this.lightlyActiveMins = lightlyActiveMins;
    }

    /**
     * getMarginalCalories() function
     *
     * @return marginalCalories, value of this Daily's marginal calories
     */
    public long getMarginalCalories() {
        return marginalCalories;
    }

    /**
     * setMarginalCalories() method
     *
     * @param marginalCalories value to set as this Daily's marginal calories
     */
    public void setMarginalCalories(long marginalCalories) {
        this.marginalCalories = marginalCalories;
    }

    /**
     * getSedentaryMins() function
     *
     * @return value of sedentary minutes associated with this Daily object
     */
    public long getSedentaryMins() {
        return sedentaryMins;
    }

    /**
     * setSedentaryMins() function
     *
     * @param sedentaryMins long value to set as the sedentary minutes of this
     * Daily object
     */
    public void setSedentaryMins(long sedentaryMins) {
        this.sedentaryMins = sedentaryMins;
    }

    /**
     * getSteps() method
     *
     * @return number of steps associated with this Daily object
     */
    public long getSteps() {
        return steps;
    }

    /**
     * setSteps() method
     *
     * @param steps value of steps to set
     */
    public void setSteps(long steps) {
        this.steps = steps;
    }

    /**
     * getVeryActiveMins() method
     *
     * @return very active minutes associated with this Daily object
     */
    public long getVeryActiveMins() {
        return veryActiveMins;
    }

    /**
     * setVeryActiveMins()
     *
     * @param veryActiveMins, value to set as the very active minutes for this
     * Daily object
     */
    public void setVeryActiveMins(long veryActiveMins) {
        this.veryActiveMins = veryActiveMins;
    }

    /**
     * getActiveMins() method:
     *
     * @return value of active minutes for this Daily object
     */
    public long getActiveMins() {
        return activeMins;
    }

    /**
     * setActiveMins() method:
     *
     * @param activeMins, value to set as the number of active minutes for this
     * Daily object
     */
    public void setActiveMins(long activeMins) {
        this.activeMins = activeMins;
    }

    /**
     * getFloorGoal() method:
     *
     * @return floors climbed goal value associated with this Daily object
     */
    public double getFloorGoal() {
        return floorGoal;
    }

    /**
     * setFloorGoal() method
     *
     * @param floorGoal value to set as the floor goal for this Daily object
     */
    public void setFloorGoal(double floorGoal) {
        this.floorGoal = floorGoal;
    }

    /**
     * getDistanceGoal() method:
     *
     * @return distanceGoal associated with Daily Object
     */
    public double getDistanceGoal() {
        return distanceGoal;
    }

    /**
     * setDistanceGoal() method:
     *
     * @param distanceGoal value to set as this Daily's distance goal
     */
    public void setDistanceGoal(double distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    /**
     * getDistance() method:
     *
     * @return distance value associated with this Daily object
     */
    public double getDistance() {
        return distance;
    }

    /**
     * setDistance() method:
     *
     * @param distance to set as the Distance traveled for the current Daily
     * object
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * getElevation() method:
     *
     * @return value of elevation for this Daily object
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * setElevation() method:
     *
     * @param elevation value to set as the elevation for this Daily object
     */
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    /**
     * getFloors() method:
     *
     * @return value of floors climbed for this Daily object
     */
    public double getFloors() {
        return floors;
    }

    /**
     * setFloors() method
     *
     * @param floors, value to set as the number of floors for this Daily object
     */
    public void setFloors(double floors) {
        this.floors = floors;
    }

}
