package onboardandroid.taqtile.onboardandroidtaqtile;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;
import onboardandroid.taqtile.onboardandroidtaqtile.Database.DatabaseOpenHelper;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;

/**
 * Created by taqtile on 1/6/16.
 */
public class MainApplication extends Application {


    static List<Users> listUsers;

    static SQLiteDatabase database;

    static HashMap<Integer, Integer> hashMapViewCount;


    @Override
    public void onCreate() {
        super.onCreate();
        initSingletonUsersDomain();
        initDatabase();

    }

    private void initDatabase() {
        DatabaseOpenHelper db = new DatabaseOpenHelper(getApplicationContext());
        MainApplication.database = db.getWritableDatabase();
    }

    private void initSingletonUsersDomain() {

        this.listUsers = new ArrayList<>();

    }

    public static List<Users> getListUsers() {

        return listUsers;
    }

    public static void setListUsers(List<Users> listUsers) {
        MainApplication.listUsers = listUsers;
    }

    public static HashMap<Integer, Integer> getHashMapViewCount() {
        return hashMapViewCount;
    }

    public static void setHashMapViewCount(HashMap<Integer, Integer> hashMapViewCount) {
        MainApplication.hashMapViewCount = hashMapViewCount;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }


}
