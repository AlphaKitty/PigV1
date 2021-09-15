package com.zyl.pigv1.ui.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.zyl.pigv1.service.pojo.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public UserAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public UserAdapter(@NonNull Context context, int resource, @NonNull User[] objects) {
        super(context, resource, objects);
    }

    public UserAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull User[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    public UserAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<User> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
