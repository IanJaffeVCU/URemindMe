package com.example.version3_355app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.version3_355app.ui.note.NoteModel;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DataBaseNotes extends SQLiteOpenHelper {


    public static final String N_TABLE = "N_table";
    public static final String NOTE_TABLE = "NOTE_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SUBJECT = "SUBJECT";
    public static final String COLUMN_NOTES = "NOTES";

    public DataBaseNotes(@Nullable Context context) {
        super(context, "Note.db", null, 1);
    }



    //create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String createTableStatement= "CREATE TABLE " + N_TABLE + " ("
//                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + COLUMN_SUBJECT + " TEXT,"
//                + COLUMN_NOTES + " TEXT,"
        sqLiteDatabase.execSQL("CREATE TABLE " + NOTE_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SUBJECT + " TEXT," + COLUMN_NOTES + " TEXT)");
    }

    //this is called if the database version number changes. It prevents users apps from breaking when you change the database design
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOTE_TABLE);
        // Create tables again
        onCreate(sqLiteDatabase);

    }

    public boolean addOne(NoteModel noteModel){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues cv= new ContentValues();
        cv.put(COLUMN_SUBJECT, noteModel.getSubject());
        cv.put(COLUMN_NOTES, noteModel.getNote());

       long insert = db.insert(NOTE_TABLE, null,cv );
        if (insert==-1){
            return false;
        } else {
            return true;
        }
    }

        public List<String> subjects(){
            List <String>returnlist= new ArrayList<>();
            String queryString= "SELECT * FROM " + NOTE_TABLE;

            SQLiteDatabase db= this.getReadableDatabase();
            Cursor cursor= db.rawQuery(queryString, null);

            if (cursor.moveToFirst()){
                do{

                    String assignment= cursor.getString(1);
                    String course= cursor.getString(2);
                    returnlist.add(assignment+"\n"+course);
                }
                while (cursor.moveToNext());

            }
            else    {

                //failure. do not add anything to the list
            }
                cursor.close();
                db.close();

            return returnlist;
        }
    public List<String> notes(){
        List <String>returnlist= new ArrayList<>();
        String queryString= "SELECT * FROM " + NOTE_TABLE;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            do{

                int month= cursor.getInt(3);
                int day= cursor.getInt(4);
                int year= cursor.getInt(5);
                String time= cursor.getString(6);
                returnlist.add(month +"/"+day+"/"+year +"\n" +time);
            }
            while (cursor.moveToNext());

        }
        else    {

            //failure. do not add anything to the list
        }
        cursor.close();
        db.close();

        return returnlist;
    }

        public List<NoteModel> everything () {
            List<NoteModel> returnlist= new ArrayList<>();

            String queryString= "SELECT * FROM " + NOTE_TABLE;
            SQLiteDatabase db= this.getReadableDatabase();
            Cursor cursor = db.rawQuery(queryString, null);
            if (cursor.moveToFirst()){
                do{
                    int id= cursor.getInt(0);
                    String subject= cursor.getString(1);
                    String note= cursor.getString(2);

                    NoteModel newNote= new NoteModel(id, subject, note);
                    newNote.setId(id);
                    returnlist.add(newNote);
                }
                while (cursor.moveToNext());

            }
            else    {

                //failure. do not add anything to the list
            }
            cursor.close();
            db.close();
            return (List<NoteModel>) returnlist;
        }

        public boolean deleteOne(NoteModel noteModel){
            SQLiteDatabase db= this.getWritableDatabase();
            String queryString = "DELETE FROM " + NOTE_TABLE + " WHERE " + COLUMN_ID + " = " + noteModel.getId();

            Cursor cursor = db.rawQuery(queryString, null);
            if(cursor.moveToFirst()){
                return true;
            }
            else{
                return false;
            }

        }
}
