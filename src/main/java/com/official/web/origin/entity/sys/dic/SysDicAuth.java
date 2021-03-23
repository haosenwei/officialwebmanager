package com.official.web.origin.entity.sys.dic;

import lombok.Data;

import java.io.Serializable;

/**
 * ,null实体类
 *
 * @author hsw
 */
@Data
public class SysDicAuth implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * fieldid
     */
    private Long sysMenuFieldId;

    /**
     * 数据字典项id
     */
    private Long sysDicItemId;

}