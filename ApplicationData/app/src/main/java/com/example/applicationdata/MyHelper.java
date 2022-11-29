package com.example.applicationdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {
    private String tname="student";
    SQLiteDatabase database;
    List<Student> list;
    Student s;

    public MyHelper(@Nullable Context context) {
        super(context, "stdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE "+ tname + "(id INTEGER PRIMARY KEY, name TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tname);
        onCreate(sqLiteDatabase);
    }

    public void doSave(Student s){
         database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id" ,s.getId());
        cv.put("name" ,s.getName());
        cv.put("email" ,s.getEmail());
        database.insert(tname, null , cv);
        database.close();

    }

    // do update
    public void doUpdate(Student s){
        database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" ,s.getName());
        cv.put("email" ,s.getEmail());
        database.update(tname,cv,"id=?", new String [] {String.valueOf(s.getId())});
        database.close();

    }

    /// do delete
    public void doDelete(Student s){
        database = this.getWritableDatabase();
        database.delete(tname,"id=?", new String [] {String.valueOf(s.getId())} );
        database.close();

    }

    public List<Student> allStudent(){

        list=new ArrayList<>();
        database = this.getWritableDatabase();
      Cursor cursor = database.rawQuery("Select * from " + tname, null);
      while (cursor.moveToNext()){
          s= new Student(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
          list.add(s);
      }
        return list;
    }

}
