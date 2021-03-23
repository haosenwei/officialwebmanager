package com.official.web.origin.entity.auth.role;

import lombok.Data;

import java.io.Serializable;

/**
 * ,null实体类
 *
 * @author hsw
 */
@Data
public class AuthRoleMenu implements Serializable {


    /**
     * 主键
     */
    private Long id;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 角色id
     */
    private Long roleId;

}