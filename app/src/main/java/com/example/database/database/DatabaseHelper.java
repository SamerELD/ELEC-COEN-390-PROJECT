package com.example.database.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrinterId;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.database.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, Config.DATABASE_NAME, null, Config.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_COURSE = "CREATE TABLE " + Config.COURSE_TABLE_NAME + " ( " + Config.COLUMN_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Config.COLUMN_COURSE_TITLE + " TEXT NOT NULL, " + Config.COLUMN_COURSE_CODE + " TEXT NOT NULL )"; //+ Config.COLUMN_COURSE_ASSIGNTITLE + "// TEXT NOT NULL, "+Config.COLUMN_COURSE_ASSIGNGRADE+" INTEGER NOT NULL )";
        Log.d(TAG, CREATE_TABLE_COURSE);

        sqLiteDatabase.execSQL(CREATE_TABLE_COURSE);
        Log.d(TAG, "db created. ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public  long insertCourse(Course course)
    {long id=-1;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Config.COLUMN_COURSE_TITLE,course.getTitle());
        contentValues.put(Config.COLUMN_COURSE_CODE,course.getCode());
      //  contentValues.put(Config.COLUMN_COURSE_ASSIGNTITLE,course.getAssititle());
     //   contentValues.put(Config.COLUMN_COURSE_ASSIGNGRADE,course.getAssigrade());


    try{
        id= db.insertOrThrow(Config.COURSE_TABLE_NAME,null,contentValues);
    }
        catch(SQLException e){Log.d(TAG,"Exception: "+e);
            Toast.makeText(context,"Operation failed "+e,Toast.LENGTH_LONG).show();
    }
    finally

    {db.close();
    }
    return id;
    }


    public List<Course> getAllCourse()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
       try {



           cursor = db.query(Config.COURSE_TABLE_NAME, null, null, null, null, null, null);
           if(cursor!=null)
           {if(cursor.moveToFirst())
           {
               List<Course> courses = new ArrayList<>();
               do {
                int id=cursor.getInt(cursor.getColumnIndex(Config.COLUMN_COURSE_ID));
                    String title=cursor.getString(cursor.getColumnIndex(Config.COLUMN_COURSE_TITLE));
                   String code=cursor.getString(cursor.getColumnIndex(Config.COLUMN_COURSE_CODE));
                //   String assigtitle=cursor.getString(cursor.getColumnIndex(Config.COLUMN_COURSE_ASSIGNTITLE));
               //    Double assigrad=cursor.getDouble(cursor.getColumnIndex(Config.COLUMN_COURSE_ASSIGNGRADE));
                    courses.add(new Course(id,title,code));//,assigtitle,assigrad));




               } while (cursor.moveToNext());
               return courses;
           }
           }

       }

       catch(SQLException e){Log.d(TAG,"Exception: "+e);
           Toast.makeText(context,"Operation failed "+e,Toast.LENGTH_LONG).show();
       }
       finally

       {if(cursor!=null)
       cursor.close();
           db.close();
       }
        return Collections.emptyList();
       }

//    public  void updateCourse(Course course) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Config.COLUMN_COURSE_TITLE, course.getTitle());
//        contentValues.put(Config.COLUMN_COURSE_CODE, course.getCode());
//     //   contentValues.put(Config.COLUMN_COURSE_ASSIGNTITLE, course.getAssititle());
//     //   contentValues.put(Config.COLUMN_COURSE_ASSIGNGRADE, course.getAssigrade());
//        String x = course.getCode();
//        Cursor cursor = null;
//        try {//going all through the database looking for the course and i will check if its already there with an assignment or create a new row
//            cursor = db.query(Config.COURSE_TABLE_NAME, null, null, null, null, null, null);
//            if (cursor != null) {
//                if (cursor.moveToFirst()) {
//                    List<Course> courses = new ArrayList<>();
//                    do {
//                        int id = cursor.getInt(cursor.getColumnIndex(Config.COLUMN_COURSE_ID));
//                        String title = cursor.getString(cursor.getColumnIndex(Config.COLUMN_COURSE_TITLE));
//                        String code = cursor.getString(cursor.getColumnIndex(Config.COLUMN_COURSE_CODE));
//                    //    String assigtitle = cursor.getString(cursor.getColumnIndex(Config.COLUMN_COURSE_ASSIGNTITLE));
//                      //  Double assigrad = cursor.getDouble(cursor.getColumnIndex(Config.COLUMN_COURSE_ASSIGNGRADE));
//                       // if (x.equals(code)) {
//                          //  if (!assigtitle.equals("")) {
//                            //    try {
//                             //       cursor.moveToPosition(cursor.getCount() - 1);
//                             //       cursor.moveToNext();
//                                    db.insertOrThrow(Config.COURSE_TABLE_NAME, null, contentValues);
//                                } catch (SQLException e) {
//                                    Log.d(TAG, "Exception: " + e);
//                                    Toast.makeText(context, "Operation failed " + e, Toast.LENGTH_LONG).show();
//                                }
//
//
//                            }
//
//                           //in this part i was going to update a current course that has null assignment and 0
//                            // else
//                            // {db.update(Config.COURSE_TABLE_NAME,contentValues,,)}
//                            // }
//
//                            // courses.add(new Course(id,title,code,assigtitle,assigrad));
//                        }
//                    }
//                    while (cursor.moveToNext());
//
//                }
//            }
//
//        } catch (SQLException e) {
//            Log.d(TAG, "Exception: " + e);
//            Toast.makeText(context, "Operation failed " + e, Toast.LENGTH_LONG).show();
//        } finally {
//            if (cursor != null)
//                cursor.close();
//            db.close();
//        }
//
//    }
//
public void deleteEntry(long row) {
    SQLiteDatabase db=this.getWritableDatabase();
    // Deletes a row given its rowId, but I want to be able to pass
    // in the name of the KEY_NAME and have it delete that row.
    db.delete(Config.COURSE_TABLE_NAME, Config.COLUMN_COURSE_ID + "=" + row, null);
}

}

