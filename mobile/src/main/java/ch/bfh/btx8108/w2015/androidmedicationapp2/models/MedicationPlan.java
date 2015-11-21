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
}
