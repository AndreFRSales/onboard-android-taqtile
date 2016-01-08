package onboardandroid.taqtile.onboardandroidtaqtile.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import onboardandroid.taqtile.onboardandroidtaqtile.Activities.Adapters.RecyclerViewUsersAdapter;
import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.ListUsers;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import onboardandroid.taqtile.onboardandroidtaqtile.MainApplication;
import onboardandroid.taqtile.onboardandroidtaqtile.R;


public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rvContatos)
    android.support.v7.widget.RecyclerView rvContatos;

    public static int REQUEST_PAGE = 1;
    public final static String TAG_NUMBER_PAGE = "page";
    private Integer number_page = 0;
    UsersDomain usersDomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        createToolbar(getResources().getString(R.string.title_main_activity));
        usersDomain = new UsersDomain(MainApplication.getDatabase());

    }



    private void settingRecyclerView(List<Users> list) {

        rvContatos.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvContatos.setLayoutManager(llm);
        RecyclerViewUsersAdapter recyclerViewUsersAdapter = new RecyclerViewUsersAdapter(MainActivity.this, list, number_page);
        rvContatos.setAdapter(recyclerViewUsersAdapter);

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
        switch (id) {
            case R.id.page_first:
                number_page = 1;
                new UsersDomain().list(1);
                return true;
            case R.id.page_second:
                number_page = 2;
                new UsersDomain().list(2);
                return true;
            case R.id.page_third:
                number_page = 3;
                new UsersDomain().list(3);
                return true;
            case R.id.page_forty:
                number_page = 4;
                new UsersDomain().list(4);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(number_page == 0){
            usersDomain.list(1);
            number_page = 1;
        }
        else
            usersDomain.list(number_page);

    }

    public void onEvent(ListUsers listUsers) {

        usersDomain.insertUsers(listUsers.getListUsers());
        settingRecyclerView(listUsers.getListUsers());
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == REQUEST_PAGE && resultCode == RESULT_OK){
//            number_page = data.getExtras().getInt(UserDetailActivity.TAG_RESULT_PAGE);
//            usersDomain.list(number_page);
//        }
//    }

}
