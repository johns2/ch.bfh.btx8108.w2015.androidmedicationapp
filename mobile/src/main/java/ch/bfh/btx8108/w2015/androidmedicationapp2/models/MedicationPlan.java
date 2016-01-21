package ch.bfh.btx8108.w2015.androidmedicationapp2.models;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by David on 11.11.2015.
 * MedicationPlan has a list of all active medications including the alerts. Also contains the times for the standard alerts morning, noon, evening and night.
 *
 */
public class MedicationPlan {

    private int medicationPlan_id;
    private int medication_id;
    private double applied_dose_morning;
    private double applied_dose_noon;
    private double applied_dose_evening;
    private double applied_dose_night;
    private String start_date;
    private String end_date;
    private String medicamentName_D;

    public int getMedicationPlan_id() {
        return medicationPlan_id;
    }

    public void setMedicationPlan_id(int medicationPlan_id) {
        this.medicationPlan_id = medicationPlan_id;
    }

    public int getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(int medication_id) {
        this.medication_id = medication_id;
    }

    public double getApplied_dose_morning() {
        return applied_dose_morning;
    }

    public void setApplied_dose_morning(double applied_dose_morning) {
        this.applied_dose_morning = applied_dose_morning;
    }

    public double getApplied_dose_noon() {
        return applied_dose_noon;
    }

    public void setApplied_dose_noon(double applied_dose_noon) {
        this.applied_dose_noon = applied_dose_noon;
    }

    public double getApplied_dose_evening() {
        return applied_dose_evening;
    }

    public void setApplied_dose_evening(double applied_dose_evening) {
        this.applied_dose_evening = applied_dose_evening;
    }

    public double getApplied_dose_night() {
        return applied_dose_night;
    }

    public void setApplied_dose_night(double applied_dose_night) {
        this.applied_dose_night = applied_dose_night;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getMedicamentName_D() {
        return medicamentName_D;
    }

    public void setMedicamentName_D(String medicamentName_D) {
        this.medicamentName_D = medicamentName_D;
    }

    public static final Parcelable.Creator<MedicationPlan> CREATOR = new Parcelable.Creator<MedicationPlan>() {
        public MedicationPlan createFromParcel(Parcel source) {
            MedicationPlan mMedicationPlan = new MedicationPlan();
            mMedicationPlan.applied_dose_morning = source.readDouble();
            mMedicationPlan.applied_dose_noon = source.readDouble();
            mMedicationPlan.applied_dose_evening = source.readDouble();
            mMedicationPlan.applied_dose_night = source.readDouble();
            return mMedicationPlan;
        }

        @Override
        public MedicationPlan[] newArray(int size) {
            return new MedicationPlan[0];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeDouble(applied_dose_morning);
        parcel.writeDouble(applied_dose_noon);
        parcel.writeDouble(applied_dose_evening);
        parcel.writeDouble(applied_dose_night);
    }
}
