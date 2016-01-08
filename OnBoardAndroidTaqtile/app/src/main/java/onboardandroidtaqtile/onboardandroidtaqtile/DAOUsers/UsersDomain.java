package onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Database.UsersDAO;
import onboardandroid.taqtile.onboardandroidtaqtile.Database.UsersHelper;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import onboardandroid.taqtile.onboardandroidtaqtile.MainApplication;
import onboardandroid.taqtile.onboardandroidtaqtile.Retrofit.APIRequester;
import onboardandroid.taqtile.onboardandroidtaqtile.Retrofit.APIUsersRetrofit;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by taqtile on 1/5/16.
 */
public class UsersDomain  {

    private HashMap<Integer, Users> hashMapOfUsers = new HashMap<>();
    UsersDAO usersDao;

    public UsersDomain(SQLiteDatabase database){
        usersDao = new UsersDAO(database);
    }

    public UsersDomain(){}

    public void list(Integer pagina) {

        new APIRequester().requestUsers(pagina);

    }


    public void incrementViewCount(Integer id) {

        usersDao.insertViewCount(id);

    }

    public void resetViewCount(Integer id) {

        usersDao.removeViewCount(id);

    }

    public Integer getViewCount(Integer id){

        return usersDao.getViewCountByUser(id);

    }

    public void insertUsers(List<Users> list){
        for(Users users : list){
        usersDao.insertUser(users);
        }
    }

    public Users getUserById(Integer id){

        return UsersHelper.convertCursor(usersDao.getUsersById(id)).get(0);
    }
}
