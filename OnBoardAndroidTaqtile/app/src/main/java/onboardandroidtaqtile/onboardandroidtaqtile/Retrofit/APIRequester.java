package onboardandroid.taqtile.onboardandroidtaqtile.Retrofit;

import java.io.IOException;
import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Entities.ListUsers;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit2.Callback;

/**
 * Created by taqtile on 1/7/16.
 */
public class APIRequester {

    Retrofit retrofit;
    public static final String BASE_URL = "http://reqres.in/";

    public APIRequester(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public void requestUsers(int numberOfPage) {
        APIUsersRetrofit apiUsersRetrofit = retrofit.create(APIUsersRetrofit.class);
        Call<ListUsers> call = apiUsersRetrofit.getListUser(numberOfPage);
        call.enqueue(new RequestListener());
    }
}
