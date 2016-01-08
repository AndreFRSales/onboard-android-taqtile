package onboardandroid.taqtile.onboardandroidtaqtile.Database;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;

/**
 * Created by taqtile on 1/8/16.
 */
public class UsersHelper {

    public static final String USERS_TABLE_NAME = "Users";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_FIRST_NAME = "first_name";
    public static final String USERS_COLUMN_LAST_NAME = "last_name";
    public static final String USERS_COLUMN_AVATAR = "avatar";
    public static final String USERS_COLUM_VIEW_COUNT = "view_count";


    public static String createTableUsers(){
        String columns = "("+ USERS_COLUMN_ID + " integer primary key, " + USERS_COLUMN_FIRST_NAME + " text, "+ USERS_COLUMN_LAST_NAME + " " +
                "text, " + USERS_COLUMN_AVATAR + " text, " + USERS_COLUM_VIEW_COUNT + " text)";

        return "CREATE TABLE " + USERS_TABLE_NAME + columns;
    }

    public static List<Users> convertCursor(Cursor cursor) {

        List<Users> usersList = new ArrayList<>();

        if (cursor.moveToNext()) {
            Users users = new Users();
            if(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_ID) != -1) users.setId(cursor.getInt(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_ID)));
            if(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_FIRST_NAME)!=-1) users.setFirst_name(cursor.getString(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_FIRST_NAME)));
            if(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_LAST_NAME)!=-1) users.setLast_name(cursor.getString(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_LAST_NAME)));
            if(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_AVATAR)!=-1) users.setAvatar(cursor.getString(cursor.getColumnIndex(UsersHelper.USERS_COLUMN_AVATAR)));
            if(cursor.getColumnIndex(UsersHelper.USERS_COLUM_VIEW_COUNT)!=-1) users.setView_count(cursor.getInt(cursor.getColumnIndex(UsersHelper.USERS_COLUM_VIEW_COUNT)));

            usersList.add(users);
        }

        return usersList;

    }

    public static ArrayList<String> genereateOrderOfUsersFields(){
        ArrayList<String> list = new ArrayList<>();

        list.add("id");
        list.add("first_name");
        list.add("last_name");
        list.add("avatar");

        return list;
    }
}
