package ch.bfh.btx8108.w2015.androidmedicationapp2.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by johns2@bfh.ch at 15.12.2015
 *
 * The User class defines an app user within three settings flags.
 *
 */
public class User implements Parcelable {

    private int user_id;
    private String username;
    private String firstname;
    private String lastname;
    private String eMailAddress;
    private Boolean mute;
    private Boolean notificationSound;
    private Boolean notificationVibration;

    public User(){
        //Empty user constructor
    }

    /**
     * Constructor creates a user object with all available parameters
     *
     * @param user_id
     * @param username
     * @param firstname
     * @param lastname
     * @param eMailAddress
     * @param mute
     * @param notificationSound
     * @param notificationVibration
     */
    public User (int user_id, String username, String firstname, String lastname, String eMailAddress, Boolean mute, Boolean notificationSound, Boolean notificationVibration){
        this.setUser_id(user_id);
        this.setUsername(username);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.seteMailAddress(eMailAddress);
        this.setMute(mute);
        this.setNotificationSound(notificationSound);
        this.setNotificationVibration(notificationVibration);
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
        this.lastname = lastname;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    /**
     * Returns the setting value of mute notifications of an user
     * @return mute Boolean
     */
    public Boolean getMute() {
        return mute;
    }

    /**
     * Sets the value of mute notifications of an user
     * @param mute
     */
    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    /**
     * Returns the setting value of mute sound while a notification of an user
     * @return notificationSound Boolean
     */
    public Boolean getNotificationSound() {
        return notificationSound;
    }

    /**
     * Sets the value of mute sound while a notification of an user
     * @param notificationSound
     */
    public void setNotificationSound(Boolean notificationSound) {
        this.notificationSound = notificationSound;
    }

    /**
     * Returns the setting value of mute vibration while a notification of an user
     * @return notificationVibration Boolean
     */
    public Boolean getNotificationVibration() {
        return notificationVibration;
    }

    /**
     * Sets the value of mute vibration while a notification of an user
     * @param notificationVibration
     */
    public void setNotificationVibration(Boolean notificationVibration) {
        this.notificationVibration = notificationVibration;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            User mUser = new User();
            mUser.user_id = source.readInt();
            mUser.username = source.readString();
            mUser.firstname = source.readString();
            mUser.lastname = source.readString();
            mUser.eMailAddress = source.readString();
            mUser.mute = source.readByte() != 0;
            mUser.notificationSound = source.readByte() != 0;
            mUser.notificationVibration = source.readByte() != 0;
            return mUser;
        }
        public User[] newArray(int size) {
            return new User[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeString(username);
        parcel.writeString(firstname);
        parcel.writeString(lastname);
        parcel.writeString(eMailAddress);
        parcel.writeByte((byte) (mute ? 1 : 0)); //if mute == true, byte == 1
        parcel.writeByte((byte) (notificationSound ? 1 : 0)); //if notificationSound == true, byte == 1
        parcel.writeByte((byte) (notificationVibration ? 1 : 0)); //if notificationVibration == true, byte == 1
    }


}
