package com.zyl.pigv1.service.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 人
 *
 * @author 张代富
 * @since 2021-09-09
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 客户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 住址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 类型 0送猪 1拉猪
     */
    private Integer type;

}
