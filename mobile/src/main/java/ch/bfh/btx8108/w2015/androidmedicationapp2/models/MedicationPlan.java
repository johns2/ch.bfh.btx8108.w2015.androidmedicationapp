package ch.bfh.btx8108.w2015.androidmedicationapp2.models;


import java.util.List;
import java.sql.Time;

/**
 * Created by David on 11.11.2015.
 * MedicationPlan has a list of all active medications including the alerts. Also contains the times for the standard alerts morning, noon, evening and night.
 *
 */
public class MedicationPlan {

    private List<Medication> medicationList;
    private Time morning;
    private Time noon;
    private Time evening;
    private Time night;
    private int morning_sum;
    private int noon_sum;
    private int evening_sum;
    private int night_sum;


    /**
     * Adds a new medicament to the list.
     *
     * @param medication - The new medicament to add to list.
     */
    public void addMedication (Medication medication){

        medicationList.add(medication);
    }

    /**
     * Removes the given medicament from the list.
     *
     * @param medication - The medicament that should be removed from the list.
     */
    public void removeMedication (Medication medication){

        medicationList.remove(medication);
    }

    public Time getMorning() {
        return morning;
    }

    public void setMorning(Time morning) {
        this.morning = morning;
    }

    public Time getNoon() {
        return noon;
    }

    public void setNoon(Time noon) {
        this.noon = noon;
    }

    public Time getEvening() {
        return evening;
    }

    public void setEvening(Time evening) {
        this.evening = evening;
    }

    public Time getNight() {
        return night;
    }

    public void setNight(Time night) {
        this.night = night;
    }

    public int getMorning_sum() {
        return morning_sum;
    }

    public void setMorning_sum(int morning_sum) {
        this.morning_sum = morning_sum;
    }

    public int getNoon_sum() {
        return noon_sum;
    }

    public void setNoon_sum(int noon_sum) {
        this.noon_sum = noon_sum;
    }

    public int getEvening_sum() {
        return evening_sum;
    }

    public void setEvening_sum(int evening_sum) {
        this.evening_sum = evening_sum;
    }

    public int getNight_sum() {
        return night_sum;
    }

    public void setNight_sum(int night_sum) {
        this.night_sum = night_sum;
    }
}
