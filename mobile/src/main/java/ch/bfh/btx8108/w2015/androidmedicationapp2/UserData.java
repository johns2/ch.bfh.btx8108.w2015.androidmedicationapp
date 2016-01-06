package ch.bfh.btx8108.w2015.androidmedicationapp2;

        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.DatabaseUtils;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;
        import android.util.SparseArray;

        import ch.bfh.btx8108.w2015.androidmedicationapp2.models.User;

public class UserData extends DatabaseHelper {

    private static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_ID_USER = "id_user";
    public static final String USERS_COLUMN_USERNAME = "username";
    public static final String USERS_COLUMN_FIRSTNAME = "firstname";
    public static final String USERS_COLUMN_LASTNAME = "lastname";
    public static final String USERS_COLUMN_EMAILADDRESS = "eMailAddress";
    private SparseArray<User> userList;

    public UserData(Context context) {
        super(context);
    }

    public boolean insertUser  (String username, String firstname, String lastname, String eMailAddress)    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("emailaddress", eMailAddress);
        db.insert("users", null, contentValues);
        return true;
    }

    public Cursor getData(){
        Cursor res =  super.getData("select id_user, username, firstname, lastname, eMailAddress from " + USERS_TABLE_NAME + ";");
        return res;
    }

    public SparseArray<User> getUserObjects(){
        Cursor res = this.getData();
        res.moveToFirst();

        userList = new SparseArray<>();
        while(res.isAfterLast() == false){
            userList.put(res.getInt(res.getColumnIndex(USERS_COLUMN_ID_USER)),
                    new User(res.getInt(res.getColumnIndex(USERS_COLUMN_ID_USER)),
                    res.getString(res.getColumnIndex(USERS_COLUMN_USERNAME)),
                    res.getString(res.getColumnIndex(USERS_COLUMN_FIRSTNAME)),
                    res.getString(res.getColumnIndex(USERS_COLUMN_LASTNAME)),
                    res.getString(res.getColumnIndex(USERS_COLUMN_EMAILADDRESS))));
                    res.moveToNext();
        }
        return userList;
    }

    public boolean updateUser (Integer id, String username, String firstname, String emailaddress)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("firstname", firstname);
        contentValues.put("emailaddress", emailaddress);
        db.update("users", contentValues, "id_user = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteUser (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users",
                "id_user = ? ",
                new String[] { Integer.toString(id) });
    }
}