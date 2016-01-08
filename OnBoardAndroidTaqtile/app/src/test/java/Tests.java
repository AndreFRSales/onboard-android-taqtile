import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.test.IsolatedContext;
import android.test.RenamingDelegatingContext;
import android.test.mock.MockContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import de.greenrobot.event.EventBus;
import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;
import onboardandroid.taqtile.onboardandroidtaqtile.Database.DatabaseOpenHelper;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.ListUsers;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import onboardandroid.taqtile.onboardandroidtaqtile.MainApplication;

/**
 * Created by taqtile on 1/8/16.
 */



public class Tests extends AndroidTestCase {

    List<Users> listUsers;
    IsolatedContext mContext;
    UsersDomain usersDomain;
    public SQLiteDatabase db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        db = new DatabaseOpenHelper(context).getWritableDatabase();
    }

    @Override
    public void tearDown() throws Exception {
        db.close();
        super.tearDown();
    }

    //According to Zainodis annotation only for legacy and not valid with gradle>1.1:
    //@Test
    public void testAddEntry(){
        usersDomain = new UsersDomain(db);

        listUsers = new ArrayList<>();
        listUsers.add(new Users(1, "Hello", "Its", "avatar"));
        usersDomain.insertUsers(listUsers);
        usersDomain.incrementViewCount(1);
        Users users = usersDomain.getUserById(1);
        assertThat(users.getView_count(), is(1));
        // Here i have my new database wich is not connected to the standard database of the App
    }

    public void incrementViewCountUsersTest() {
        usersDomain = new UsersDomain(db);

        listUsers = new ArrayList<>();
        listUsers.add(new Users(1, "Hello", "Its", "avatar"));
        usersDomain.insertUsers(listUsers);
        usersDomain.incrementViewCount(1);
        Users users = usersDomain.getUserById(1);
        assertThat(users.getView_count(), is(1));


    }



//    @Test
//    public void resetViewCountUsersTest(){
//
//        usersDomain.resetViewCount(1);
//        assertThat(0, is(MainApplication.getHashMapViewCount().size()));
//
//    }


}
