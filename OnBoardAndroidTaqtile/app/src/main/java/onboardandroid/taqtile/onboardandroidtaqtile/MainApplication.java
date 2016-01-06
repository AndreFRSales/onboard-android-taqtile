package onboardandroid.taqtile.onboardandroidtaqtile;

import android.app.Application;

import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;

/**
 * Created by taqtile on 1/6/16.
 */
public class MainApplication extends Application {

    static UsersDomain usersDomain;
    private Integer MAX_USERS = 20;

    @Override
    public void onCreate() {
        super.onCreate();

        initSingletonUsersDomain();
        fillingUsers(usersDomain);
    }

    private void initSingletonUsersDomain() {

        this.usersDomain = new UsersDomain();
    }

    public static UsersDomain getUsersDomain() {

        return usersDomain;
    }

    private void fillingUsers(UsersDomain usersDomain) {


        for (int count = 0; count < MAX_USERS; count++) {

            Users users = new Users(count, "name " + count, "last_name" + count, "avatar " + count);
            usersDomain.addUser(count, users);

        }

        usersDomain.list(1);
    }
}
