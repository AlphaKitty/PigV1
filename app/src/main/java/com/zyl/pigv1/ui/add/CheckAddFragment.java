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

import com.zyl.pigv1.R;
import com.zyl.pigv1.common.async.Async;
import com.zyl.pigv1.databinding.FragmentCheckAddBinding;
import com.zyl.pigv1.service.pojo.Check;

import java.util.concurrent.ExecutionException;

public class CheckAddFragment extends Fragment {

    //    private AddViewModel addViewModel;
    private FragmentCheckAddBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        addViewModel = new ViewModelProvider(this).get(AddViewModel.class);

        binding = FragmentCheckAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button saveCheckBtn = root.findViewById(R.id.btnSaveCheck);

        saveCheckBtn.setOnClickListener(v -> {

            // 送猪人
            EditText name = root.findViewById(R.id.userNameText);
            // 手机号
            EditText phone = root.findViewById(R.id.userPhoneText);
            // 送猪时间
            EditText date = root.findViewById(R.id.textViewDate);
            // 猪个数
            EditText sum = root.findViewById(R.id.pigSumEditText);
            // 付款方式
            EditText type = root.findViewById(R.id.payTypeEditText);
            // 备注
            EditText comment = root.findViewById(R.id.commentEditText);
            // 当日结清
            EditText theDay = root.findViewById(R.id.theDayEditText);

            String nameStr = name.getText().toString();
            String phoneStr = phone.getText().toString();
            String dateStr = date.getText().toString();
            String sumStr = sum.getText().toString();
            String typeStr = type.getText().toString();
            String commentStr = comment.getText().toString();
            String theDayStr = theDay.getText().toString();

            if ("".equals(nameStr)) {
                Toast.makeText(CheckAddFragment.this.getActivity(), "送猪人信息必须填写", Toast.LENGTH_LONG).show();
                return;
            }
            if ("".equals(dateStr)) {
                Toast.makeText(CheckAddFragment.this.getActivity(), "送猪时间必须填写", Toast.LENGTH_LONG).show();
                return;
            }
            if ("".equals(sumStr)) {
                Toast.makeText(CheckAddFragment.this.getActivity(), "猪信息为空", Toast.LENGTH_LONG).show();
                return;
            }

            Check check = new Check();
            check.setName(dateStr + " " + nameStr + " " + typeStr);
            check.setPigSum(Integer.parseInt(sumStr));
            check.setPayType(Integer.parseInt(typeStr));
            try {
                String msg = Async.saveCheck(check).execute().get();
                Toast.makeText(CheckAddFragment.this.getActivity(), msg, Toast.LENGTH_LONG).show();

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}