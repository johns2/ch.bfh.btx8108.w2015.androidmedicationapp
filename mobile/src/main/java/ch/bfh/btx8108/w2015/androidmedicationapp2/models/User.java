package ch.bfh.btx8108.w2015.androidmedicationapp2.models;

/**
 * Created by johns2@bfh.ch at 15.12.2015
 */
public class User {

    private int user_id;
    private String username;
    private String firstname;
    private String lastname;
    private String eMailAddress;

    public User (int user_id, String username, String firstname, String lastname, String eMailAddress){
        this.setUser_id(user_id);
        this.setUsername(username);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.seteMailAddress(eMailAddress);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        lastname = lastname;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }



}
