package onboardandroid.taqtile.onboardandroidtaqtile.Activities.Views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import onboardandroid.taqtile.onboardandroidtaqtile.R;

/**
 * Created by taqtile on 1/6/16.
 */
public class UserDetailView extends LinearLayout {


    TextView txtUserFieldName;
    TextView txtValueUser;

    public UserDetailView(Context context) {
        super(context);

        View view = View.inflate(context, R.layout.layout_data_user, this);
        txtUserFieldName = (TextView) view.findViewById(R.id.txt_user_field_name);
        txtValueUser = (TextView) view.findViewById(R.id.txt_value_user);

    }

    public void setText(String textFieldName, String textValue){

        txtUserFieldName.setText(textFieldName);
        txtValueUser.setText(textValue);
    }


}
