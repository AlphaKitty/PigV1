package com.zyl.pigv1.activity.check;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zyl.pigv1.R;
import com.zyl.pigv1.activity.pig.PigAddActivity;
import com.zyl.pigv1.activity.pig.PigListActivity;
import com.zyl.pigv1.common.async.Async;
import com.zyl.pigv1.databinding.ActivityCheckBinding;
import com.zyl.pigv1.service.pojo.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CheckActivity extends AppCompatActivity {

    private ActivityCheckBinding binding;
    private List<User> list = new ArrayList<>();
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_check_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_user_list, R.id.navigation_user_add)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_check);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navCheckView, navController);

        list = initData();

    }

    private List<User> initData() {
        try {
            User user = new User();
            user.setType(0);
            list = Async.getUsers(user).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void chooseDate(View view) {
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);//获取当前年
        int m = calendar.get(Calendar.MONTH);//获取月份，加1是因为月份是从0开始计算的
        int d = calendar.get(Calendar.DATE);//获取日
        DatePickerDialog pickerDialog = new DatePickerDialog(CheckActivity.this,
                (view1, year, month, dayOfMonth) -> {
                    EditText textView = findViewById(R.id.textViewDate);
                    textView.setText("" + year + "-" + (month + 1) + "-" + dayOfMonth);
                }, y, m, d);
        pickerDialog.show();
    }

    public void pigInfo(View view) {
//        Context context = CheckActivity.this;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
//        View layout = inflater.inflate(R.layout.activity_pig, null);
//
//        builder = new AlertDialog.Builder(context);
//        builder.setView(layout);
//        alertDialog = builder.create();
//        alertDialog.show();
        Intent intent = new Intent(this, PigListActivity.class);
        startActivity(intent);
        intent.putExtra("checkId", "asdgsdg");
    }

    public void chooseInUser(View view) {
        ShowDialog();
    }

    public void ShowDialog() {
        Context context = CheckActivity.this;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.formcommonlist, null);
        ListView myListView = layout.findViewById(R.id.formcustomspinner_list);
        MyAdapter adapter = new MyAdapter(context, list);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener((arg0, arg1, position, id) -> {
            //在这里面就是执行点击后要进行的操作,这里只是做一个显示
            EditText nameText = findViewById(R.id.userNameText);
            nameText.setText(list.get(position).getName());
            EditText phoneText = findViewById(R.id.userPhoneText);
            phoneText.setText(list.get(position).getPhone());
            EditText idText = findViewById(R.id.userIdText);
            idText.setText(String.valueOf(list.get(position).getId()));
//            Toast.makeText(CheckActivity.this, "您点击的是" + list.get(position).toString(), Toast.LENGTH_LONG).show();
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        });
        builder = new AlertDialog.Builder(context);
        builder.setView(layout);
        alertDialog = builder.create();
        alertDialog.show();
    }

    class MyAdapter extends BaseAdapter {
        private List<User> mlist;
        private Context mContext;

        public MyAdapter(Context context, List<User> list) {
            this.mContext = context;
            mlist = new ArrayList<>();
            this.mlist = list;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Person person;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.rtu_item, null);
                person = new Person();
                person.name = convertView.findViewById(R.id.tv_name);
                convertView.setTag(person);
            } else {
                person = (Person) convertView.getTag();
            }
            person.name.setText(list.get(position).getName());
            return convertView;
        }

        class Person {
            TextView name;
        }
    }
}