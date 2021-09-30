package com.zyl.pigv1.activity.pig;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zyl.pigv1.R;
import com.zyl.pigv1.common.async.Async;
import com.zyl.pigv1.databinding.ActivityPigListBinding;
import com.zyl.pigv1.service.pojo.Pig;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PigListActivity extends AppCompatActivity {

    private ActivityPigListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("猪列表");

        binding = ActivityPigListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();

        initList();
    }

    private void initList() {

        List<Pig> list = getPigList();

        Context context = PigListActivity.this;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.activity_pig_list, null);
        ListView myListView = layout.findViewById(R.id.pig_list_view);
        PigListAdapter adapter = new PigListAdapter(context, list);
        myListView.setAdapter(adapter);
//        myListView.setOnItemClickListener((arg0, arg1, position, id) -> {
//            //在这里面就是执行点击后要进行的操作,这里只是做一个显示
//            EditText nameText = findViewById(R.id.userNameText);
//            nameText.setText(list.get(position).getName());
//            EditText phoneText = findViewById(R.id.userPhoneText);
//            phoneText.setText(list.get(position).getPhone());
//            EditText idText = findViewById(R.id.userIdText);
//            idText.setText(String.valueOf(list.get(position).getId()));
//        });
        // 根据账单查询猪信息集合
        // 创建listxml 包含listview和新增按钮
        // 创建listviewxml 包含根据猪id编辑的功能 跳转到编辑activity
    }

    private List<Pig> getPigList() {
        try {
            List<Pig> pigs = Async.getPigByCheck().execute().get();
            System.out.println(pigs);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void pigAdd(View view) {
        Toast.makeText(PigListActivity.this, "add a pig!", Toast.LENGTH_LONG).show();
    }

    public class PigListAdapter extends BaseAdapter {

        private final Context context;
        private final List<Pig> list;

        public PigListAdapter(Context context, List<Pig> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            PigListAdapter.PigView pigView;
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(R.layout.activity_pig_list_item, null);
                pigView = new PigListAdapter.PigView();
                pigView.name = view.findViewById(R.id.pig_identifier);
                pigView.edit = view.findViewById(R.id.pigInfoEditBtn);
                view.setTag(pigView);
            } else {
                pigView = (PigListAdapter.PigView) view.getTag();
            }
            pigView.name.setText(list.get(position).getIdentifier());
            pigView.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(PigListActivity.this, list.get(position).getIdentifier(), Toast.LENGTH_LONG).show();
                }
            });
            return view;
        }

        class PigView {
            TextView name;
            Button edit;
        }
    }

}