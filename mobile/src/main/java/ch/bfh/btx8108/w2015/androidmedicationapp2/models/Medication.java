package ch.bfh.btx8108.w2015.androidmedicationapp2.models;

/**
 * Created by David on 11.11.2015.
 * Medication class that defines a classic medicament with name, dose, substance, etc.
 */
public class Medication {

    private int id_medication; //example: 1
    private int product_number; //example: 123
    private String long_name_german; //example: Aspirin Cardio Filmtabl 100 mg 28 Stk
    private String long_name_french; //example: Aspirine Cardio cpr pell 100 mg 28 pce
    private String short_name_german; //example: ASPIRIN CARDIO Filmtabl 100 mg 28 Stk
    private String short_name_french; //example: ASPIRINE CARDIO cpr pell 100 mg 28 pce
    private String consistence; //example: pill, fluid, salve
    private double dose; //example: 0.5, 500
    private String dose_unit; //example: g, mg, ml
    private int barcode; //example: 58368349421
    private String atc_code; //example: B01AC06


    //------------------------ Constructors ----------------------------------------------
    /**
     *Constructor to create a new medicament knowing all information.
     *
     * @param long_name_german German name of Medicament - example: Dafalgan 0.5g
     * @param consistence Kind of consistence - example: pill, fluid, salve
     * @param dose Dose - example: 0.5, 500
     * @param dose_unit Dose unit - example: g, mg, ml
     * @param barcode Barcode - example: 948129383921
     */
    public Medication(String long_name_german, String consistence, double dose, String dose_unit, int barcode){
        this.long_name_german = long_name_german;
        this.consistence = consistence;
        this.dose = dose;
        this.dose_unit = dose_unit;
        this.barcode = barcode;

    }

    /**
     * Constructor to create a new medicament knowing only the german name.
     *
     * @param name Name of Medicament - example: Dafalgan 0.5g
     */
    public Medication(String name){
        this.long_name_german = name;
    }


    //---------------- Getter and Setter ------------------------------------------------
    public String getLong_name_german() {
        return long_name_german;
    }

    public void setLong_name_german(String long_name_german) {
        this.long_name_german = long_name_german;
    }

    public int getId_medication() {
        return id_medication;
    }

    public void setId_medication(int id_medication) {
        this.id_medication = id_medication;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public String getLong_name_french() {
        return long_name_french;
    }

    public void setLong_name_french(String long_name_french) {
        this.long_name_french = long_name_french;
    }

    public String getShort_name_german() {
        return short_name_german;
    }

    public void setShort_name_german(String short_name_german) {
        this.short_name_german = short_name_german;
    }

    public String getShort_name_french() {
        return short_name_french;
    }

    public void setShort_name_french(String short_name_french) {
        this.short_name_french = short_name_french;
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

    public String getAtc_code() {
        return atc_code;
    }

    public void setAtc_code(String atc_code) {
        this.atc_code = atc_code;
    }
}
