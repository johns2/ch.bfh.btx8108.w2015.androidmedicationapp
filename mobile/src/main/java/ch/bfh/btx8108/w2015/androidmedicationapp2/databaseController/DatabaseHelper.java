package ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Created by johns2@bfh.ch on 05.01.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "/data/data/ch.bfh.btx8108.w2015.androidmedicationapp2/databases/medicationapp.db";
    private Context context;
    private SQLiteDatabase db;

    public void DatabaseHelper(){

    }

    public DatabaseHelper (Context context){
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

    public Cursor getData(String query){
        Cursor res =  db.rawQuery(query, null);
        return res;
    }

    public boolean insertRecord (String tableName, ContentValues contentValues){
        db = this.getWritableDatabase();
        db.insert(tableName, null, contentValues);
        return true;
    }

    public boolean updateRecord (String tableName, String idName, Integer id, ContentValues contentValues){
        try {
            db.update(tableName, contentValues, idName + "=?", new String[]{Integer.toString(id)});
        } catch (SQLiteException e) {
            Log.i("db log", e.toString());
        }
        return true;
    }

    public Integer deleteRecord(String tableName, String idName, Integer id){
        return db.delete(tableName,
                idName+ " = ? ",
                new String[] { Integer.toString(id) });
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
    public int numberOfRows(String table){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, table);
        return numRows;
    }
}
