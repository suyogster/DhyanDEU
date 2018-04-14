/*
package DatabaseConnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Domain.Task;

public class DBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Task.db";

    private static final String TABLE_NAME = "tasklist";

    private static final String COLUMN_Key_Name = "name";


    public DBHandler(Context context) {
        super(null,DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TASK = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_Key_Name + "TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_TASK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addList(Task task){

        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_Key_Name,task.getTask());
        long status = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return (status != -1);

    }
}
*/
