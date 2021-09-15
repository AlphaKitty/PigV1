package com.zyl.pigv1.common.async.user;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.zyl.pigv1.common.dto.PigResponse;
import com.zyl.pigv1.common.http.HttpService;
import com.zyl.pigv1.common.util.ResponseUtil;
import com.zyl.pigv1.service.pojo.User;

import okhttp3.Response;

public class SaveUser extends AsyncTask<Void, Void, String> {

    private User user;

    public SaveUser(User user) {
        this.user = user;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected String doInBackground(Void... voids) {
        try {
            Response response = HttpService.doHttp("http://192.168.1.20:8084/user", "POST", user);
            PigResponse pigResponse = ResponseUtil.getServiceResponse(response, PigResponse.class);
            assert pigResponse != null;
            return pigResponse.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
