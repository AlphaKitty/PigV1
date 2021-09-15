package com.zyl.pigv1.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.zyl.pigv1.R;
import com.zyl.pigv1.common.async.Async;
import com.zyl.pigv1.databinding.FragmentAddBinding;
import com.zyl.pigv1.service.pojo.User;

import java.util.concurrent.ExecutionException;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    private FragmentAddBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel = new ViewModelProvider(this).get(AddViewModel.class);

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button saveUserBtn = root.findViewById(R.id.btnSaveUser);

        saveUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText name = root.findViewById(R.id.userNameText);
                EditText phone = root.findViewById(R.id.userPhoneText);
                EditText address = root.findViewById(R.id.userAddressText);
                String nameStr = name.getText().toString();
                String phoneStr = phone.getText().toString();
                String addressStr = address.getText().toString();

                if ("".equals(nameStr)) {
                    Toast.makeText(AddFragment.this.getActivity(), "客户姓名必须填写", Toast.LENGTH_LONG).show();
                }

                User user = new User();
                user.setName(nameStr);
                user.setPhone(phoneStr);
                user.setAddress(addressStr);
                try {
                    String msg = Async.saveUser(user).execute().get();
                    Toast.makeText(AddFragment.this.getActivity(), msg, Toast.LENGTH_LONG).show();

                    name.setText(null);
                    phone.setText(null);
                    address.setText(null);

                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return root;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}