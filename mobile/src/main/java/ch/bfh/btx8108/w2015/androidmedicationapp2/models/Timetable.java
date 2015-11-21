package ch.bfh.btx8108.w2015.androidmedicationapp2.models;

import java.sql.Time;
import java.util.List;

/**
 * For every medication there is a timetable. Here we have the times that the medication has to be taken.
 *
 * Created by David on 12.11.2015.
 */
public class Timetable {

    private boolean morning;
    private boolean noon;
    private boolean evening;
    private boolean night;
    private List<Time> times;

    /**
     * Adds new time to list of times that the medication has to be taken.
     *
     * @param time - New Time to add to list.
     */
    public void addNewTime(Time time){
        //Checks if the time already exists in the list.
        if(!times.contains(time)){
        times.add(time);}
        else{
            //Error message that time already exists in the list.
        }
    }

    /**
     * Removes a time from the list of times that the medication has to be taken.
     *
     * @param time - Time to remove from list.
     */
    public void removeTime(Time time){
        times.remove(time);
    }

    /**
     * Activates that the medication has to be taken in the morning.
     */
    public void activateMorning(){

        morning = true;
    }

    public void deactivateMorning(){

        morning = false;
    }

}
