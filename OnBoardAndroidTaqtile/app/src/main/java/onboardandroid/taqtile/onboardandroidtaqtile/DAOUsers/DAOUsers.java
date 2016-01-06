package onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by taqtile on 1/5/16.
 */
public class Users {

    public static final String TAG_LOG_METHOD = "Name of Method";


    private HashMap<Integer, Users> hashMapOfUsers = new HashMap<>();
    private Integer id;
    private String first_name;
    private String last_name;
    private String avatar;

    public Users(Integer id, String first_name, String last_name, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public ArrayList<Users> list(Integer pagina) {

        ArrayList<Users> list = new ArrayList<>();

        //Filling the auxiliar List.
        for (int count = pagina * 10; count < count + 10; count++) {
            list.add(this.hashMapOfUsers.get(count));
        }

        Log.d(TAG_LOG_METHOD, "list");

        return list;
    }


    public void incrementViewCount(Integer id, Users user) {

        this.hashMapOfUsers.put(id, user);

        Log.d(TAG_LOG_METHOD, "incrementViewCount");
    }

    public void resetViewCount(Integer id, Users users) {

        this.hashMapOfUsers.remove(id);
        Log.d(TAG_LOG_METHOD, "resetViewCount");
    }

    public Integer getViewCount(){

        Log.d(TAG_LOG_METHOD, "getViewCount");

        return this.hashMapOfUsers.size();
    }


}
