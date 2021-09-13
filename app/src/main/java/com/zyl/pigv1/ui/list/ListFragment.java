package com.zyl.pigv1.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.zyl.pigv1.R;
import com.zyl.pigv1.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private ListViewModel listViewModel;
    private FragmentListBinding binding;

    public ListFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = root.findViewById(R.id.list_view);

        String[] data = {"肖申克的救赎", "这个杀手不太冷", "霸王别姬", "泰坦尼克号", "瓦力",
                "三傻大闹宝莱坞", "放牛班的春天", "千与千寻", "鬼子来了", "星际穿越"};

        ArrayAdapter<String> array = new ArrayAdapter<String>(container.getContext(), android.R.layout.simple_list_item_1, data);

        listView.setAdapter(array);
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
