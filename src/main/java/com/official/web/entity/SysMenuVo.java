package com.official.web.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ,1实体类
 *
 * @author hsw
 */
@Data
public class SysMenuVo implements Serializable {


    /**
     *
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 类型
     */
    private String typeDic;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 上级节点
     */
    private Long pid;

    /**
     * 状态
     */
    private String statusDic;

    /**
     * 地址
     */
    private String url;

    /**
     * 路径
     */
    private String path;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private int sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者
     */
    private Long modifyUerId;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private List<SysMenuVo> list = new ArrayList<SysMenuVo>();

}