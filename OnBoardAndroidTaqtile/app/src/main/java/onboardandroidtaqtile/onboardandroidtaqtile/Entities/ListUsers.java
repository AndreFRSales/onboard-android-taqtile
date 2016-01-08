package onboardandroid.taqtile.onboardandroidtaqtile.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by taqtile on 1/7/16.
 */
public class ListUsers {

    @SerializedName("page") String page;
    @SerializedName("per_page") Integer per_page;
    @SerializedName("total") Integer total;
    @SerializedName("total_pages") Integer total_pages;
    @SerializedName("data")List<Users> listUsers;


    public List<Users> getListUsers() {
        return listUsers;
    }
}
