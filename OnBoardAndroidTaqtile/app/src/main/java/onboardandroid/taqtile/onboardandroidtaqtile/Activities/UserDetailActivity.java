package onboardandroid.taqtile.onboardandroidtaqtile.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import onboardandroid.taqtile.onboardandroidtaqtile.Activities.Adapters.RecyclerViewUsersAdapter;
import onboardandroid.taqtile.onboardandroidtaqtile.Activities.Views.UserDetailView;
import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;
import onboardandroid.taqtile.onboardandroidtaqtile.Database.UsersHelper;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import onboardandroid.taqtile.onboardandroidtaqtile.R;
import onboardandroid.taqtile.onboardandroidtaqtile.Helper.ResourcesHelper;

public class UserDetailActivity extends BaseActivity {

    Users user;
    @Bind(R.id.container_user_details)
    LinearLayout containerUserDetails;

    public Integer page;
    public static final String TAG_RESULT_PAGE = "result_page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
        user = (Users) getIntent().getExtras().getSerializable(RecyclerViewUsersAdapter.TAG_USER);
        page = getIntent().getExtras().getInt(MainActivity.TAG_NUMBER_PAGE);
        createToolbarWithBack(user.getFirst_name());
        creatingFields();


    }

    private void creatingFields() {

        Field[] fields = Users.class.getDeclaredFields();
        fields = sortFields(fields);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(user) != null) {
                    UserDetailView userView = new UserDetailView(getApplicationContext());
                    userView.setText(ResourcesHelper.getStringResourceByName(field.getName(), getApplicationContext()), field.get(user).toString());
                    containerUserDetails.addView(userView);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Field[] sortFields(Field[] fields) {

        ArrayList<String> list = UsersHelper.genereateOrderOfUsersFields();
        List<Field> auxListField = new ArrayList<>();

        for (String fieldName: list) {
            for (Field field : fields) {
                if (fieldName.equals(field.getName())){
                    auxListField.add(field);
                }
            }
        }

        return auxListField.toArray(new Field[list.size()]);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
        setResultPage();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setResultPage(){
        Intent intent = new Intent();
        intent.putExtra(TAG_RESULT_PAGE, page);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResultPage();
    }
}
