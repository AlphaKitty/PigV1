package com.zyl.pigv1.common.dto;

import lombok.Data;

@Data
public class PigResponse {
    // 是否成功
    private boolean ok;
    // 附加信息
    private String message;
    // 返回实体
    private Object data;
}
