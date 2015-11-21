package ch.bfh.btx8108.w2015.androidmedicationapp2.models;

/**
 * Created by David on 11.11.2015.
 * Medication class that defines a classic medicament with name, dose, substance, etc.
 */
public class Medication {

    private String name; //example: Dafalgan 0.5g
    private String consistence; //example: pill, fluid, salve
    private double dose; //example: 0.5, 500
    private String dose_unit; //example: g, mg, ml
    private int barcode; //example: 58368349421


    //------------------------ Constructors ----------------------------------------------
    /**
     *Constructor to create a new medicament knowing all information.
     *
     * @param name Name of Medicament - example: Dafalgan 0.5g
     * @param consistence Kind of consistence - example: pill, fluid, salve
     * @param dose Dose - example: 0.5, 500
     * @param dose_unit Dose unit - example: g, mg, ml
     * @param barcode Barcode - example: 948129383921
     */
    public Medication(String name, String consistence, double dose, String dose_unit, int barcode){
        this.name = name;
        this.consistence = consistence;
        this.dose = dose;
        this.dose_unit = dose_unit;
        this.barcode = barcode;

    }

    /**
     * Constructor to create a new medicament knowing only the name.
     *
     * @param name Name of Medicament - example: Dafalgan 0.5g
     */
    public Medication(String name){
        this.name = name;
    }


    //---------------- Getter and Setter ------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsistence() {
        return consistence;
    }

    public void setConsistence(String consistence) {
        this.consistence = consistence;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public String getDose_unit() {
        return dose_unit;
    }

    public void setDose_unit(String dose_unit) {
        this.dose_unit = dose_unit;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}
