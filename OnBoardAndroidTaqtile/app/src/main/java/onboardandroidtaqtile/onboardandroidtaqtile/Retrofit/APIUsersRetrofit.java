package onboardandroid.taqtile.onboardandroidtaqtile.Retrofit;

import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Entities.ListUsers;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.Call;
import retrofit.http.Query;
import retrofit2.http.Path;

/**
 * Created by taqtile on 1/7/16.
 */
public interface APIUsersRetrofit {

    @GET("/api/users")
    Call <ListUsers> getListUser(@Query("page") int numberPage);
}
