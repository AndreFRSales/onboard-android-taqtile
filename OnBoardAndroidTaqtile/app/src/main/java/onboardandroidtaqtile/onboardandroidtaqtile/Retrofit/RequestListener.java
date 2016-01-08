package onboardandroid.taqtile.onboardandroidtaqtile.Retrofit;

import java.util.List;

import de.greenrobot.event.EventBus;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.ListUsers;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by taqtile on 1/7/16.
 */
public class RequestListener implements Callback<ListUsers> {
    @Override
    public void onResponse(Response<ListUsers> response, Retrofit retrofit) {
        EventBus.getDefault().postSticky(response.body());
    }

    @Override
    public void onFailure(Throwable t) {
        EventBus.getDefault().post(t);
    }
}
