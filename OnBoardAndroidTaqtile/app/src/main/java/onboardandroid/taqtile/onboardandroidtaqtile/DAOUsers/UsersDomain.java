package onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;

/**
 * Created by taqtile on 1/5/16.
 */
public class UsersDomain {

    public static final String TAG_LOG_METHOD = "Name of Method";
    public static final String TAG_LOG_USER = "Information User";

    private HashMap<Integer, Integer> hashMapViewCount = new HashMap<>();
    private HashMap<Integer, Users> hashMapOfUsers = new HashMap<>();


    public ArrayList<Users> list(Integer pagina) {

        ArrayList<Users> list = new ArrayList<>();

        //Filling the auxiliar List.
        for (int count = (pagina-1) * 10; count < ((pagina-1) * 10) + 10; count++) {
            list.add(this.hashMapOfUsers.get(count));
            Log.i(TAG_LOG_USER, list.get(count - ((pagina - 1) * 10)).getFirst_name());
            Log.i(TAG_LOG_USER, list.get(count - ((pagina-1) * 10)).getLast_name());
            Log.i(TAG_LOG_USER, list.get(count - ((pagina-1) * 10)).getAvatar());
            Log.i(TAG_LOG_USER, list.get(count - ((pagina-1) * 10)).getId().toString());
        }

        Log.d(TAG_LOG_METHOD, "list");


        return list;
    }


    public void incrementViewCount(Integer id, Users user) {

        this.hashMapOfUsers.put(id, user);

        if(hashMapViewCount.get(id) == null) {
            hashMapViewCount.put(id, 1);
        }
        else {
            int count = hashMapViewCount.get(id);
            hashMapViewCount.put(id, count + 1);
        }


        Log.d(TAG_LOG_METHOD, "incrementViewCount");
    }

    public void resetViewCount(Integer id, Users users) {

        this.hashMapOfUsers.remove(id);
        hashMapViewCount.remove(id);
        Log.d(TAG_LOG_METHOD, "resetViewCount");
    }

    public Integer getViewCount(Integer id){

        Log.d(TAG_LOG_METHOD, "getViewCount");

        return this.hashMapOfUsers.get(id) == null || hashMapViewCount.get(id) == 0 ? 0 : hashMapViewCount.get(id);
    }


}
