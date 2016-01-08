package onboardandroid.taqtile.onboardandroidtaqtile.Activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import onboardandroid.taqtile.onboardandroidtaqtile.R;

/**
 * Created by taqtile on 1/6/16.
 */
public class BaseActivity extends AppCompatActivity {

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public Toolbar createToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.getBackground().setAlpha(255);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    public Toolbar createToolbarWithBack(String title){
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.getBackground().setAlpha(255);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_48dp));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return toolbar;
    }

}
