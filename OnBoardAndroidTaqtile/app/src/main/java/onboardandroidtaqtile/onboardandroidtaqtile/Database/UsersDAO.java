package onboardandroid.taqtile.onboardandroidtaqtile.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;

/**
 * Created by taqtile on 1/8/16.
 */
public class UsersDAO {

    SQLiteDatabase db;

    public UsersDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public boolean insertUser(Users users) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersHelper.USERS_COLUMN_FIRST_NAME, users.getFirst_name());
        contentValues.put(UsersHelper.USERS_COLUMN_LAST_NAME, users.getLast_name());
        contentValues.put(UsersHelper.USERS_COLUMN_AVATAR, users.getAvatar());
        contentValues.put(UsersHelper.USERS_COLUM_VIEW_COUNT, 0);
        db.insert(UsersHelper.USERS_TABLE_NAME, null, contentValues);

        return true;
    }


    public boolean insertViewCount(Integer id) {

        Cursor cursor = getUsersById(id);

        Users users = UsersHelper.convertCursor(cursor).get(0);

        ContentValues contentValues = fillContentValues(users.getId(), users.getFirst_name(), users.getLast_name(), users.getAvatar(), users.getView_count() + 1);

        db.update(UsersHelper.USERS_TABLE_NAME, contentValues, UsersHelper.USERS_COLUMN_ID + " = ?", new String[]{id.toString()});

        return true;
    }

    public boolean removeViewCount(Integer id) {

        Cursor cursor = getUsersById(id);

        Users users = UsersHelper.convertCursor(cursor).get(0);

        ContentValues contentValues = fillContentValues(users.getId(), users.getFirst_name(), users.getLast_name(), users.getAvatar(), users.getView_count() - 1);

        db.update(UsersHelper.USERS_TABLE_NAME, contentValues, UsersHelper.USERS_COLUMN_ID + " = ?", new String[]{id.toString()});

        return true;
    }

    private ContentValues fillContentValues(Integer id, String first_name, String last_name, String avatar, Integer view_count) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UsersHelper.USERS_COLUMN_ID, id);
        contentValues.put(UsersHelper.USERS_COLUMN_FIRST_NAME, first_name);
        contentValues.put(UsersHelper.USERS_COLUMN_LAST_NAME, last_name);
        contentValues.put(UsersHelper.USERS_COLUMN_AVATAR, avatar);
        contentValues.put(UsersHelper.USERS_COLUM_VIEW_COUNT, view_count);

        return contentValues;

    }


    public Integer getViewCountByUser(Integer id) {

        String[] projection = {UsersHelper.USERS_COLUM_VIEW_COUNT};

        String selection = UsersHelper.USERS_COLUMN_ID + " = ?";

        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query(UsersHelper.USERS_TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        Users users = UsersHelper.convertCursor(cursor).get(0);

        return users.getView_count();
    }

    public Cursor getUsersById(Integer id) {

        String[] projection = {
                UsersHelper.USERS_COLUMN_ID,
                UsersHelper.USERS_COLUMN_FIRST_NAME,
                UsersHelper.USERS_COLUMN_LAST_NAME,
                UsersHelper.USERS_COLUMN_AVATAR,
                UsersHelper.USERS_COLUM_VIEW_COUNT,
        };

        String selection = UsersHelper.USERS_COLUMN_ID + " = ?";

        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query(UsersHelper.USERS_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        return cursor;
    }
}
