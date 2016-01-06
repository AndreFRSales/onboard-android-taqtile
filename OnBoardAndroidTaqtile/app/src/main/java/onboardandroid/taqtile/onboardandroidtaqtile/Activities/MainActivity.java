package onboardandroid.taqtile.onboardandroidtaqtile.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.DAOUsers;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import onboardandroid.taqtile.onboardandroidtaqtile.R;


public class MainActivity extends ActionBarActivity {

    private Integer MAX_USERS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillingUsers();
    }

    private void fillingUsers() {

        DAOUsers daoUsers = new DAOUsers();

        for(int count = 0; count < MAX_USERS; count++){

            Users users = new Users(count, "name " + count, "last_name" + count, "avatar " + count);
            daoUsers.incrementViewCount(count, users);

        }

        Log.d("Size of Hash", daoUsers.getViewCount().toString());
        daoUsers.list(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
