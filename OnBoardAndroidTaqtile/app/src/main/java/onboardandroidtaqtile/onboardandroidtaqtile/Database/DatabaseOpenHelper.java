package onboardandroid.taqtile.onboardandroidtaqtile.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;

/**
 * Created by taqtile on 1/8/16.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "onboardstudio.db";
    public static final Integer DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UsersHelper.createTableUsers());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
