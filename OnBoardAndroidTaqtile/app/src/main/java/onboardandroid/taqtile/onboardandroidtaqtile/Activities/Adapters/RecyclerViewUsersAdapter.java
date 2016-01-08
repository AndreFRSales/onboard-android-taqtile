package onboardandroid.taqtile.onboardandroidtaqtile.Activities.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import onboardandroid.taqtile.onboardandroidtaqtile.Activities.MainActivity;
import onboardandroid.taqtile.onboardandroidtaqtile.Activities.UserDetailActivity;
import onboardandroid.taqtile.onboardandroidtaqtile.DAOUsers.UsersDomain;
import onboardandroid.taqtile.onboardandroidtaqtile.Entities.Users;
import onboardandroid.taqtile.onboardandroidtaqtile.MainApplication;
import onboardandroid.taqtile.onboardandroidtaqtile.R;

/**
 * Created by taqtile on 1/6/16.
 */
public class RecyclerViewUsersAdapter extends RecyclerView.Adapter<RecyclerViewUsersAdapter.ViewHolder> {

    UsersDomain mUsersDomain;
    List<Users> usersList;
    private Context mcontext;
    private Integer number_page;
    public final static String TAG_USER = "user";


    public RecyclerViewUsersAdapter(Context context, List<Users> usersList, Integer number_page) {
        this.mcontext = context;
        this.usersList = usersList;
        mUsersDomain = new UsersDomain(MainApplication.getDatabase());
        this.number_page = number_page;
    }

    @Override
    public RecyclerViewUsersAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_view_users, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewUsersAdapter.ViewHolder viewHolder, int i) {

        viewHolder.txtIdUser.setText("ID: " + usersList.get(i).getId().toString());
        viewHolder.txtNameAndLast.setText(usersList.get(i).getFirst_name() + " " + usersList.get(i).getLast_name());

        if (mUsersDomain.getViewCount(usersList.get(i).getId()) >= 1) {
            viewHolder.txtIdUser.setTypeface(null, Typeface.BOLD);
        }
    }

    @Override
    public int getItemCount() {

        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtIdUser;
        public TextView txtNameAndLast;

        public ViewHolder(View itemView) {
            super(itemView);
            txtIdUser = (TextView) itemView.findViewById(R.id.txtIdUser);
            txtNameAndLast = (TextView) itemView.findViewById(R.id.txtNameAndLast);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mUsersDomain.incrementViewCount(usersList.get(getAdapterPosition()).getId());
            Intent intent = new Intent(mcontext, UserDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Users user = usersList.get(position);
            intent.putExtra(TAG_USER, user);
            intent.putExtra(MainActivity.TAG_NUMBER_PAGE, number_page);
            Activity activity = (Activity) mcontext;
            activity.startActivityForResult(intent,MainActivity.REQUEST_PAGE);

        }
    }
}
