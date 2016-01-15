package ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.models.Medication;

/**
 * @Created by johns2@bfh.ch on 10.01.2016
 *
 * This helper/adapter class prepares the required sql statements for providing medication data.
 * This class extends the class DatabaseHelper with passing prepared sql statements to it
 *
 */
public class MedicationData extends DatabaseHelper{
    private static final String MEDICAMENTS_TABLE_NAME = "medications";
    private int logged_in_user_id;
    private ArrayList<Medication> medicationsList;
    private ArrayList<String> medicationListByAttribute;

    public MedicationData(Context context, int logged_in_user_id) {
        super(context);
        this.logged_in_user_id = logged_in_user_id;
    }

    public Cursor getData(){
        Cursor res =  super.getData("SELECT id_medication, ProductNumber, LongNameGerman, LongNameFrench, " +
                "ShortNameGerman, ShortNameFrench, Consistence, Dose, DoseUnit, Barcode, ATCCode" +
                " FROM " + MEDICAMENTS_TABLE_NAME +
                " INNER JOIN medicationList ON medications.id_medication = medicationList.medication_id" +
                " WHERE medicationList.StartDate <= date('now') AND medicationList.EndDate >= date('now') AND medicationList.user_id = " + logged_in_user_id +
                " GROUP BY medicationList.medication_id" +
                " ORDER BY medications.LongNameGerman;");
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

    public ArrayList<String> getMedicationsListByAttribute(String attribute){
        Cursor res = this.getData();
        res.moveToFirst();
        medicationListByAttribute = new ArrayList<>();
        while(res.isAfterLast() == false){
            medicationListByAttribute.add(res.getString(res.getColumnIndex(attribute)));
            res.moveToNext();
        }
        return medicationListByAttribute;
    }
}
