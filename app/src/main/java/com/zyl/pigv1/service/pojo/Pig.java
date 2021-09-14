package com.zyl.pigv1.service.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 猪
 *
 * @author 张代富
 * @since 2021-09-09
 */
@Data
public class Pig implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 编号
     */
    private String identifier;

    /**
     * 重量
     */
    private Integer weight;

    /**
     * 入库价格
     */
    private Double inPrice;

    /**
     * 出库价格
     */
    private Integer outPrice;

    /**
     * 入库时间
     */
    private Date inTime;

    /**
     * 出库时间
     */
    private Date outTime;

    /**
     * 入库账单编号
     */
    private Long inCheckId;

    /**
     * 出库账单编号
     */
    private Long outCheckId;

    /**
     * 是否已出售
     */
    private Integer isSale;

    /**
     * 备注
     */
    private String comment;

}
