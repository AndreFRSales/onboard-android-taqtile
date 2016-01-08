package onboardandroid.taqtile.onboardandroidtaqtile.Entities;

import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Database.UsersHelper;

/**
 * Created by taqtile on 1/5/16.
 */
public class Users implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("view_count")
    private int view_count;


    public Users(Integer id, String first_name, String last_name, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Users(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }




}
