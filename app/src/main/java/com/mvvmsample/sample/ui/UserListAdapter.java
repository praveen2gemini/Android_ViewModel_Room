package com.mvvmsample.sample.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvvmsample.sample.R;
import com.mvvmsample.sample.dao.User;

import java.util.List;

/**
 * @author Praveen on 30/05/18.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final LayoutInflater mInflater;
    private List<User> users; // Cached copy of users

    public UserListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User userInfo = null;
        if (users != null && null != (userInfo = users.get(position))) {
            User current = users.get(position);
            holder.userItemView.setText(userInfo.toString());
            Log.d("@@@@@", "" + userInfo.toString());
        } else {
            // Covers the case of data not being ready yet.
            holder.userItemView.setText("No Word");
        }
        if (null == userInfo) return;
        Log.e("@@@@@", "" + userInfo.toString());
    }

    public void updateUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != users) ? users.size() : 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView userItemView;

        private UserViewHolder(View itemView) {
            super(itemView);
            userItemView = itemView.findViewById(R.id.textView);
        }
    }
}
