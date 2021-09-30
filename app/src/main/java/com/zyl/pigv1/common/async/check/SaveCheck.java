package com.zyl.pigv1.common.async.check;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.zyl.pigv1.common.dto.PigResponse;
import com.zyl.pigv1.common.http.HttpService;
import com.zyl.pigv1.common.util.ResponseUtil;
import com.zyl.pigv1.service.pojo.Check;

import okhttp3.Response;

public class SaveCheck extends AsyncTask<Void, Void, String> {

    private Check check;

    public SaveCheck(Check check) {
        this.check = check;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected String doInBackground(Void... voids) {
        try {
            Response response = HttpService.doHttp("http://192.168.1.20:8084/check", "POST", check);
            PigResponse pigResponse = ResponseUtil.getServiceResponse(response, PigResponse.class);
            assert pigResponse != null;
            return pigResponse.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
