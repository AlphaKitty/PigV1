package com.zyl.pigv1.common.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyl.pigv1.common.dto.PigResponse;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Response;

public class ResponseUtil {
    /**
     * 获取返回的okhttp3.Response中的业务Response 后面可能会有多种业务Response 所以用了泛型
     *
     * @param response okhttp3.Response
     * @param clazz    业务Response泛型
     * @param <T>      泛型
     * @return 业务Response
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static <T> T getServiceResponse(Response response, Class<T> clazz) {
        if (null == response) {
            return null;
        }
        if (response.isSuccessful()) {

            String resultStr = null;

            try {
                resultStr = Objects.requireNonNull(response.body()).string();
//                resultStr = new String(Objects.requireNonNull(response.body()).bytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                // TODO 异常处理
                e.printStackTrace();
            }
            return JSON.parseObject(resultStr, clazz);
        }
        return null;
    }

    /**
     * 根据泛型从业务Response中获取data内容
     *
     * @param pigResponse 业务Response
     * @param clazz       泛型
     * @param <T>         泛型
     * @return 泛型
     */
    public static <T> T getServiceResponseData(PigResponse pigResponse, Class<T> clazz) {
        assert pigResponse != null;
        T result = null;
        if (pigResponse.isOk()) {
            String data = pigResponse.getData().toString();
            if (clazz.equals(String.class))
                return (T) data;
            JSONObject jsonObject = JSONObject.parseObject(data);
            try {
                result = JSON.toJavaObject(jsonObject, clazz);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return result;
    }
}
