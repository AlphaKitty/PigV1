package com.zyl.pigv1.common.async.pig;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONArray;
import com.zyl.pigv1.common.dto.PigResponse;
import com.zyl.pigv1.common.http.HttpService;
import com.zyl.pigv1.common.util.ResponseUtil;
import com.zyl.pigv1.service.pojo.Check;
import com.zyl.pigv1.service.pojo.Pig;

import java.util.List;

import okhttp3.Response;

public class GetPigByCheck extends AsyncTask<Check, Void, List<Pig>> {

    public GetPigByCheck() {
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected List<Pig> doInBackground(Check... checks) {
        try {
            Response response = HttpService.doHttp("http://192.168.1.20:8084/pig/check", "POST", new Check());
            PigResponse pigResponse = ResponseUtil.getServiceResponse(response, PigResponse.class);
            assert pigResponse != null;
            if (pigResponse.isOk()) {
                String data = pigResponse.getData().toString();
                return JSONArray.parseArray(data, Pig.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}