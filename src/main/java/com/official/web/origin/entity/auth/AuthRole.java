package com.official.web.origin.entity.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * ,null实体类
 *
 * @author hsw
 */
@Data
public class AuthRole implements Serializable {


    /**
     * id
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 主要职责
     */
    private String majorDuty;

    /**
     * 备注
     */
    private String remark;

}