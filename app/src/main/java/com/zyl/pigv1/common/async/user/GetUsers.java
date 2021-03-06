package com.zyl.pigv1.common.async.user;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONArray;
import com.zyl.pigv1.common.dto.PigResponse;
import com.zyl.pigv1.common.http.HttpService;
import com.zyl.pigv1.common.util.ResponseUtil;
import com.zyl.pigv1.service.pojo.User;

import java.util.List;

import okhttp3.Response;

public class GetUsers extends AsyncTask<User, Void, List<User>> {

    private User user;

    public GetUsers(User user) {
        this.user = user;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected List<User> doInBackground(User... users) {
        try {
            Response response = HttpService.doHttp("http://192.168.1.20:8084/user/search", "POST", user);
            PigResponse pigResponse = ResponseUtil.getServiceResponse(response, PigResponse.class);
            assert pigResponse != null;
            if (pigResponse.isOk()) {
                String data = pigResponse.getData().toString();
                return JSONArray.parseArray(data, User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
