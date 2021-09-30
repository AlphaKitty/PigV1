package com.zyl.pigv1.common.async.check;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONArray;
import com.zyl.pigv1.common.dto.PigResponse;
import com.zyl.pigv1.common.http.HttpService;
import com.zyl.pigv1.common.util.ResponseUtil;
import com.zyl.pigv1.service.pojo.Check;

import java.util.List;

import okhttp3.Response;

public class GetChecks extends AsyncTask<Void, Void, List<Check>> {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected List<Check> doInBackground(Void... voids) {
        try {
            Response response = HttpService.doHttp("http://192.168.1.20:8084/check/search", "POST", new Check());
            PigResponse pigResponse = ResponseUtil.getServiceResponse(response, PigResponse.class);
            if (pigResponse == null) {
                return null;
            }
            if (pigResponse.isOk()) {
                String data = pigResponse.getData().toString();
                return JSONArray.parseArray(data, Check.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
