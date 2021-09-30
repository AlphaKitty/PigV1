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
import com.zyl.pigv1.databinding.FragmentUserListBinding;
import com.zyl.pigv1.service.pojo.User;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class UserListFragment extends Fragment {

//    private ListViewModel listViewModel;
    private FragmentUserListBinding binding;

    public UserListFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        binding = FragmentUserListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = root.findViewById(R.id.user_list_view);
        List<User> users = null;

        try {
            users = Async.getUsers(new User()).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        assert users != null;
        List<String> nameList = users.stream().map(User::getName).collect(Collectors.toList());

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
