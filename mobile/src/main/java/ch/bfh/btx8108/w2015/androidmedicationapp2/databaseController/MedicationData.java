package ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.models.Medication;

/**
 * @Created by johns2@bfh.ch on 10.01.2016.
 */
public class MedicationData extends DatabaseHelper{
    private static final String MEDICAMENTS_TABLE_NAME = "medications";
    private ArrayList<Medication> medicationsList;
    private ArrayList<String> medicationListByAttribute;

    public MedicationData(Context context) {
        super(context);
    }

    public Cursor getData(){
        Cursor res =  super.getData("select id_medication, ProductNumber, LongNameGerman, LongNameFrench, " +
                "ShortNameGerman, ShortNameFrench, Consistence, Dose, DoseUnit, Barcode, ATCCode " +
                "from " + MEDICAMENTS_TABLE_NAME + ";");
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
