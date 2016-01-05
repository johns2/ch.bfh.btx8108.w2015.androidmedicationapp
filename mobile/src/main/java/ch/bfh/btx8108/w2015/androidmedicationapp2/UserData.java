package ch.bfh.btx8108.w2015.androidmedicationapp2;

        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.util.ArrayList;
        import java.util.HashMap;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.DatabaseUtils;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;

        import ch.bfh.btx8108.w2015.androidmedicationapp2.models.User;

public class UserData extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "/data/local/tmp/medicationapp_test_17122015.db";
    private static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_ID_USER = "id";
    public static final String USERS_COLUMN_USERNAME = "username";
    public static final String USERS_COLUMN_FIRSTNAME = "firstname";
    public static final String USERS_COLUMN_LASTNAME = "lastname";
    public static final String USERS_COLUMN_EMAILADDRESS = "emailaddress";
    Context context;
    private SQLiteDatabase db;
    private HashMap hp;

    public UserData(Context context)
    {

        super(context, DATABASE_NAME , null, 1);
        this.context = context;
        if (checkDataBase()) {
            openDataBase();
            Log.i("run", "open db");
        } else {
            try {
                copyDatase();
                openDataBase();
            } catch (Exception ex) {

            }

        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        boolean exist = false;
        try {
            checkDB = SQLiteDatabase.openDatabase(DATABASE_NAME, null,
                    SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            Log.i("db log", "database does't exist");
        }

        if (checkDB != null) {
            exist = true;
            checkDB.close();
        }
        return exist;
    }

    private void copyDatase() throws IOException {
        // Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = DATABASE_NAME;

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        Log.i("run", "copy successful");

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLiteException {
        // Open the database
        db = SQLiteDatabase.openDatabase(DATABASE_NAME, null,
                SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.OPEN_READWRITE);

    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {

            this.getWritableDatabase();
        }
        dbExist = checkDataBase();
        if (!dbExist) {

            this.getReadableDatabase();
            try {
                copyDatase();
            } catch (IOException e) {

            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text,phone text,email text, street text,place text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertContact  (String name, String phone, String email, String street,String place)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", name);
        contentValues.put("firstname", name);
        contentValues.put("lastname", name);
        contentValues.put("emailaddress", name);
        db.insert("users", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        //SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users where id_user="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, USERS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String username, String firstname, String emailaddress)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("firstname", firstname);
        contentValues.put("emailaddress", emailaddress);
        db.update("users", contentValues, "id_user = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users",
                "id_user = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllUsers()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        //SQLiteDatabase db = this.getReadableDatabase();
        //Cursor res =  db.rawQuery( "select * from users", null );
        Cursor res = this.getData(1);
        res.moveToFirst();
        ArrayList<User> UserList = new ArrayList<User>();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(USERS_COLUMN_USERNAME)));
            res.moveToNext();
        }
        return array_list;
    }
}