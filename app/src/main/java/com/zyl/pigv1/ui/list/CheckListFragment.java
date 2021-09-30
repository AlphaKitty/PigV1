package com.zyl.pigv1.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.zyl.pigv1.R;
import com.zyl.pigv1.common.async.Async;
import com.zyl.pigv1.databinding.FragmentCheckListBinding;
import com.zyl.pigv1.service.pojo.Check;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CheckListFragment extends Fragment {

    //    private ListViewModel listViewModel;
    private FragmentCheckListBinding binding;

    public CheckListFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        binding = FragmentCheckListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = root.findViewById(R.id.check_list_view);
        List<Check> checks = null;

        try {
            checks = Async.getChecks().execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        List<String> nameList = new ArrayList<>();
        if (null != checks) {
            nameList = checks.stream().map(Check::getName).collect(Collectors.toList());
        }

        ArrayAdapter<String> array = new ArrayAdapter<>(container.getContext(), android.R.layout.simple_list_item_1, nameList);

        listView.setAdapter(array);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {

        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
