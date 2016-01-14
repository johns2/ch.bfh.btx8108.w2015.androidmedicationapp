package ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController;

import android.content.Context;
import android.database.Cursor;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.models.Medication;

/**
 * @Created by johns2@bfh.ch on 10.01.2016
 *
 * This helper/adapter class prepares the required sql statements for providing medication list data.
 * This class extends the class DatabaseHelper with passing prepared sql statements to it
 *
 */
public class MedicationListData extends DatabaseHelper{
    private static final String MEDICATION_PLAN_TABLE_NAME = "medicationsPlan";
    private int logged_in_user_id;
    private ArrayList<Medication> medicationsList;
    private ArrayList<String> medicationListByAttribute;
    private double[] currentDosette = new double[4];

    public MedicationListData(Context context, int logged_in_user_id) {
        super(context);
        this.logged_in_user_id = logged_in_user_id;
    }

    public Cursor getDosetteData(){
        Cursor res =  super.getData("SELECT id_medicationList, SUM(AppliedDose_Morning) SUM_AppliedDose_Morning, " +
                        "SUM(AppliedDose_Noon) SUM_AppliedDose_Noon, SUM(AppliedDose_Evening) SUM_AppliedDose_Evening, " +
                        "SUM(AppliedDose_Night) SUM_AppliedDose_Night " +
                        "FROM " + MEDICATION_PLAN_TABLE_NAME +
                        " WHERE StartDate <= date('now') AND EndDate >= date('now') AND user_id = "+ logged_in_user_id + ";");
        return res;
    }

    public ArrayList<Medication> getMedicationsList(){
        Cursor res = this.getData();
        res.moveToFirst();

        medicationsList = new ArrayList<>();
        while(res.isAfterLast() == false){
            Medication newMedication = new Medication();
            newMedication.setId_medication(res.getInt(res.getColumnIndex("id_medication")));
            newMedication.setProduct_number(res.getInt(res.getColumnIndex("ProductNumber")));
            newMedication.setLong_name_german(res.getString(res.getColumnIndex("LongNameGerman")));
            newMedication.setLong_name_french(res.getString(res.getColumnIndex("LongNameFrench")));
            newMedication.setShort_name_german(res.getString(res.getColumnIndex("ShortNameGerman")));
            newMedication.setShort_name_french(res.getString(res.getColumnIndex("ShortNameFrench")));
            if (!res.isNull(res.getColumnIndex("Consistence"))){
                newMedication.setConsistence(res.getString(res.getColumnIndex("Consistence")));
            }
            if (!res.isNull(res.getColumnIndex("Dose"))){
                newMedication.setConsistence(res.getString(res.getColumnIndex("Dose")));
            }
            if (!res.isNull(res.getColumnIndex("DoseUnit"))){
                newMedication.setConsistence(res.getString(res.getColumnIndex("DoseUnit")));
            }
            if (!res.isNull(res.getColumnIndex("Barcode"))){
                newMedication.setConsistence(res.getString(res.getColumnIndex("Barcode")));
            }
            if (!res.isNull(res.getColumnIndex("ATCCode"))){
                newMedication.setConsistence(res.getString(res.getColumnIndex("ATCCode")));
            }
            medicationsList.add(newMedication);
            res.moveToNext();
        }
        return medicationsList;
    }

    public ArrayList<String> getCurrentMedicationList(String attribute){
        Cursor res = this.getData();
        res.moveToFirst();
        medicationListByAttribute = new ArrayList<>();
        while(res.isAfterLast() == false){
            medicationListByAttribute.add(res.getString(res.getColumnIndex(attribute)));
            res.moveToNext();
        }
        return medicationListByAttribute;
    }

//    public double[] getCurrentDosette{
//        Cursor res = this.getDosetteData();
//        for(int i=0;i<currentDosette.length;i++){
//            if(i==add.length-1){
//                add[i]=4;
//            }else{
//                add[i]=arr[i];
//            }
//    }
//}
