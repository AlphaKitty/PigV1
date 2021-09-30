package com.zyl.pigv1.service.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 账单
 *
 * @author 张代富
 * @since 2021-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 账单名称
     */
    private String name;

    /**
     * 账单类型 0入账 1出账
     */
    private Integer type;

    /**
     * 账单创建时间
     */
    private Date time;

    /**
     * 支付类型 0现金 1微信 2支付宝
     */
    private Integer payType;

    /**
     * 支付时间
     */
    private Date payDay;

    /**
     * 猪个数
     */
    private Integer pigSum;

    /**
     * 应付款
     */
    private Double shouldAmount;

    /**
     * 实付款
     */
    private Double realAmount;

    /**
     * 客户id
     */
    private Long userId;
}
