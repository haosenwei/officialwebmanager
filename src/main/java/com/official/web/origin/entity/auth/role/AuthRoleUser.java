package com.official.web.origin.entity.auth.role;

import lombok.Data;

import java.io.Serializable;

/**
 * ,null实体类
 *
 * @author hsw
 */
@Data
public class AuthRoleUser implements Serializable {


    /**
     *
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色
     */
    private Long roleId;

}