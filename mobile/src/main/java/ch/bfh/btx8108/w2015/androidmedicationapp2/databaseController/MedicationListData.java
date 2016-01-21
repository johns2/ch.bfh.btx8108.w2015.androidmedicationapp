package ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController;

import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.models.MedicationPlan;

/**
 * @Created by johns2@bfh.ch on 10.01.2016
 *
 * This helper/adapter class prepares the required sql statements for providing medication list data.
 * This class extends the class DatabaseHelper with passing prepared sql statements to it
 *
 */
public class MedicationListData extends DatabaseHelper {
    private static final String MEDICATION_PLAN_TABLE_NAME = "medicationList";
    private int logged_in_user_id;
    private ArrayList<String> medicationPlan;
    private ArrayList<String> medicationPlanByAttribute;
    private double[] currentDosette = new double[4];

    public MedicationListData(Context context, int logged_in_user_id) {
        super(context);
        this.logged_in_user_id = logged_in_user_id;
    }

    public Cursor getMedicationPlanData(){
        Cursor res = super.getData("SELECT id_medicationList, AppliedDose_Morning, AppliedDose_Noon, " +
                "AppliedDose_Evening, AppliedDose_Night, StartDate, EndDate, medication_id, medications.LongNameGerman LongNameGerman " +
                "FROM " + MEDICATION_PLAN_TABLE_NAME +
                " INNER JOIN medications ON medicationList.medication_id = medications.id_medication " +
                "WHERE StartDate <= date('now') AND EndDate >= date('now') AND user_id = " + logged_in_user_id + ";");
        return res;
    }

    public Cursor getDosetteData() {
        Cursor res = super.getData("SELECT id_medicationList, SUM(AppliedDose_Morning) SUM_AppliedDose_Morning, " +
                "SUM(AppliedDose_Noon) SUM_AppliedDose_Noon, SUM(AppliedDose_Evening) SUM_AppliedDose_Evening, " +
                "SUM(AppliedDose_Night) SUM_AppliedDose_Night " +
                "FROM " + MEDICATION_PLAN_TABLE_NAME +
                " WHERE StartDate <= date('now') AND EndDate >= date('now') AND user_id = " + logged_in_user_id + ";");
        return res;
    }

    public ArrayList<String> getMedicationPlanList() {
        Cursor res = this.getMedicationPlanData();
        res.moveToFirst();

        medicationPlan = new ArrayList<>();
        while (res.isAfterLast() == false) {
            MedicationPlan newMedicationPlan = new MedicationPlan();

            newMedicationPlan.setMedicationPlan_id(res.getInt(res.getColumnIndex("id_medicationList")));
            newMedicationPlan.setApplied_dose_morning(res.getDouble(res.getColumnIndex("AppliedDose_Morning")));
            newMedicationPlan.setApplied_dose_noon(res.getDouble(res.getColumnIndex("AppliedDose_Noon")));
            newMedicationPlan.setApplied_dose_evening(res.getDouble(res.getColumnIndex("AppliedDose_Evening")));
            newMedicationPlan.setApplied_dose_night(res.getDouble(res.getColumnIndex("AppliedDose_Night")));
            newMedicationPlan.setStart_date(res.getString(res.getColumnIndex("StartDate")));
            newMedicationPlan.setEnd_date(res.getString(res.getColumnIndex("EndDate")));
            newMedicationPlan.setMedication_id(res.getInt(res.getColumnIndex("medication_id")));
            newMedicationPlan.setMedicamentName_D(res.getString(res.getColumnIndex("LongNameGerman")));

            try {
                medicationPlan.add(newMedicationPlan.getMedicamentName_D() + "\n\r" + newMedicationPlan.getApplied_dose_morning() + "-"
                        + newMedicationPlan.getApplied_dose_noon() + "-" + newMedicationPlan.getApplied_dose_evening() + "-" + newMedicationPlan.getApplied_dose_night() + "\n\rVom "
                        + new SimpleDateFormat("dd.mm.yyyy").format(new SimpleDateFormat("yyyy-mm-dd").parse(newMedicationPlan.getStart_date())) + " bis " + new SimpleDateFormat("dd.mm.yyyy").format(new SimpleDateFormat("yyyy-mm-dd").parse(newMedicationPlan.getEnd_date())));
            } catch (ParseException e){
                e.printStackTrace();
            }
            res.moveToNext();
        }
        return medicationPlan;
    }

    public double[] getCurrentDosette()    {
        Cursor res = this.getDosetteData();
        res.moveToFirst();
        currentDosette[0] = res.getInt(res.getColumnIndex("SUM_AppliedDose_Morning"));
        currentDosette[1] = res.getInt(res.getColumnIndex("SUM_AppliedDose_Noon"));
        currentDosette[2] = res.getInt(res.getColumnIndex("SUM_AppliedDose_Evening"));
        currentDosette[3] = res.getInt(res.getColumnIndex("SUM_AppliedDose_Night"));
        return currentDosette;
    }

    public ArrayList<String> getMedicationsPlanByAttribute(String attribute){
        Cursor res = this.getMedicationPlanData();
        res.moveToFirst();
        medicationPlanByAttribute = new ArrayList<>();
        while(res.isAfterLast() == false){
            medicationPlanByAttribute.add(res.getString(res.getColumnIndex(attribute)));
            res.moveToNext();
        }
        return medicationPlanByAttribute;
    }
}
