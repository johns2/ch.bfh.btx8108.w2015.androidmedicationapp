package ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.util.SparseArray;
        import ch.bfh.btx8108.w2015.androidmedicationapp2.models.User;

/**
 *
 * @Created by johns2@bfh.ch on 17.12.2015
 *
 * This helper/adapter class prepares the required sql statements for providing user data.
 * This class extends the class DatabaseHelper with passing prepared sql statements to it
 *
 */
public class UserData extends DatabaseHelper {

    private static final String USERS_TABLE_NAME = "users";
    private SparseArray<User> userList;

    public UserData(Context context) {
        super(context);
    }

    public boolean insertUser (String username, String firstname, String lastname, String eMailAddress)    {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("eMailAddress", eMailAddress);
        contentValues.put("Mute", false);
        contentValues.put("notificationSound", true);
        contentValues.put("notificationVibration", true);
        //db.insert("users", null, contentValues);
        super.insertRecord(USERS_TABLE_NAME, contentValues);
        return true;
    }

    public Cursor getData(){
        Cursor res =  super.getData("select id_user, username, firstname, lastname, eMailAddress, Mute, notificationSound, notificationVibration from " + USERS_TABLE_NAME + ";");
        return res;
    }

    public SparseArray<User> getUserObjects(){
        Cursor res = this.getData();
        res.moveToFirst();

        userList = new SparseArray<>();
        while(res.isAfterLast() == false){
            userList.put(res.getInt(res.getColumnIndex("id_user")),
                    new User(res.getInt(res.getColumnIndex("id_user")),
                    res.getString(res.getColumnIndex("username")),
                    res.getString(res.getColumnIndex("firstname")),
                    res.getString(res.getColumnIndex("lastname")),
                    res.getString(res.getColumnIndex("eMailAddress")),
                    (res.getInt(res.getColumnIndex("Mute")) != 0),
                    (res.getInt(res.getColumnIndex("notificationSound"))!=0),
                    (res.getInt(res.getColumnIndex("notificationVibration"))!=0)
                    ));
                    res.moveToNext();
        }
        return userList;
    }

    public boolean updateUser (Integer user_id, String username, String firstname, String lastname, String eMailAddress, Boolean mute, Boolean notificationSound, Boolean notificationVibration)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("eMailAddress", eMailAddress);
        contentValues.put("Mute", mute);
        contentValues.put("notificationSound", notificationSound);
        contentValues.put("notificationVibration", notificationVibration);
        return super.updateRecord(USERS_TABLE_NAME, "id_user", user_id, contentValues);
    }

    public Integer deleteUser (Integer user_id)
    {
        return super.deleteRecord(USERS_TABLE_NAME, "id_user", user_id);
        //SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete("users",
//                "id_user = ? ",
//                new String[] { Integer.toString(user_id) });
    }
}