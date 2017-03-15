package ca.uwo.csd.cs2212.team07;

import java.io.Serializable;

/**
 * Stores User Configuration as it relates to personal customization options.
 *
 * @author team07
 */
public class UserConfig implements Serializable {

    private static final long serialVersionUID = 6L;

    private boolean testMode;

    private boolean caloriesVisible;
    private boolean distanceVisible;
    private boolean floorsVisible;
    private boolean stepsVisible;
    private boolean activeVisible;
    private boolean sedentaryVisible;

    private boolean fatVisible, peakVisible, cardioVisible, outVisible;

    private boolean caloriesAccolade[];
    private boolean distanceAccolade[];
    private boolean activeAccolade[];
    private boolean stepsAccolade[];
    private boolean floorsAccolade[];
    private boolean goalsAccolade[];
    private boolean accoladesAccolade[];

    private long calGoal, activeGoal, stepsGoal, floorsGoal, distanceGoal;
    private int goalsComplete;

    public UserConfig() {
        caloriesVisible = true;
        distanceVisible = true;
        floorsVisible = true;
        stepsVisible = true;
        activeVisible = true;
        sedentaryVisible = true;
        fatVisible = true;
        peakVisible = true;
        cardioVisible = true;
        outVisible = true;
        caloriesAccolade = new boolean[3];
        distanceAccolade = new boolean[3];
        activeAccolade = new boolean[3];
        stepsAccolade = new boolean[3];
        floorsAccolade = new boolean[3];
        goalsAccolade = new boolean[3];
        accoladesAccolade = new boolean[3];
        calGoal = -1;
        activeGoal = -1;
        stepsGoal = -1;
        floorsGoal = -1;
        distanceGoal = -1;
        goalsComplete = 0;
    }

    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public boolean[] getCaloriesAccolade() {
        return caloriesAccolade;
    }

    public void setCaloriesAccolade(boolean[] caloriesAccolade) {
        this.caloriesAccolade = caloriesAccolade;
    }

    public boolean[] getDistanceAccolade() {
        return distanceAccolade;
    }

    public void setDistanceAccolade(boolean[] distanceAccolade) {
        this.distanceAccolade = distanceAccolade;
    }

    public boolean[] getActiveAccolade() {
        return activeAccolade;
    }

    public void setActiveAccolade(boolean[] activeAccolade) {
        this.activeAccolade = activeAccolade;
    }

    public boolean[] getStepsAccolade() {
        return stepsAccolade;
    }

    public void setStepsAccolade(boolean[] stepsAccolade) {
        this.stepsAccolade = stepsAccolade;
    }

    public boolean[] getFloorsAccolade() {
        return floorsAccolade;
    }

    public void setFloorsAccolade(boolean[] floorsAccolade) {
        this.floorsAccolade = floorsAccolade;
    }

    public boolean[] getGoalsAccolade() {
        return goalsAccolade;
    }

    public void setGoalsAccolade(boolean[] goalsAccolade) {
        this.goalsAccolade = goalsAccolade;
    }

    public boolean[] getAccoladesAccolade() {
        return accoladesAccolade;
    }

    public void setAccoladesAccolade(boolean[] accoladesAccolade) {
        this.accoladesAccolade = accoladesAccolade;
    }

    public boolean isCaloriesData() {
        return caloriesVisible;
    }

    public void setCaloriesData(boolean caloriesData) {
        this.caloriesVisible = caloriesData;
    }

    public boolean isDistanceData() {
        return distanceVisible;
    }

    public void setDistanceData(boolean distanceData) {
        this.distanceVisible = distanceData;
    }

    public boolean isFloorsData() {
        return floorsVisible;
    }

    public void setFloorsData(boolean floorsData) {
        this.floorsVisible = floorsData;
    }

    public boolean isStepsData() {
        return stepsVisible;
    }

    public void setStepsData(boolean stepsData) {
        this.stepsVisible = stepsData;
    }

    public boolean isActiveData() {
        return activeVisible;
    }

    public void setActiveData(boolean activeData) {
        this.activeVisible = activeData;
    }

    public boolean isSedentaryData() {
        return sedentaryVisible;
    }

    public void setSedentaryData(boolean sedentaryData) {
        this.sedentaryVisible = sedentaryData;
    }

    public long getCalGoal() {
        return calGoal;
    }

    public void setCalGoal(long calGoal) {
        this.calGoal = calGoal;
    }

    public long getActiveGoal() {
        return activeGoal;
    }

    public void setActiveGoal(long activeGoal) {
        this.activeGoal = activeGoal;
    }

    public long getStepsGoal() {
        return stepsGoal;
    }

    public void setStepsGoal(long stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    public long getFloorsGoal() {
        return floorsGoal;
    }

    public void setFloorsGoal(long floorsGoal) {
        this.floorsGoal = floorsGoal;
    }

    public long getDistanceGoal() {
        return distanceGoal;
    }

    public void setDistanceGoal(long distanceGoal) {
        this.distanceGoal = distanceGoal;
    }

    public boolean isFatVisible() {
        return fatVisible;
    }

    public void setFatVisible(boolean fatVisible) {
        this.fatVisible = fatVisible;
    }

    public boolean isPeakVisible() {
        return peakVisible;
    }

    public void setPeakVisible(boolean peakVisible) {
        this.peakVisible = peakVisible;
    }

    public boolean isCardioVisible() {
        return cardioVisible;
    }

    public void setCardioVisible(boolean cardioVisible) {
        this.cardioVisible = cardioVisible;
    }

    public boolean isOutVisible() {
        return outVisible;
    }

    public void setOutVisible(boolean outVisible) {
        this.outVisible = outVisible;
    }

    public int getGoalsComplete() {
        return goalsComplete;
    }

    public void setGoalsComplete(int goalsComplete) {
        this.goalsComplete = goalsComplete;
    }

}
