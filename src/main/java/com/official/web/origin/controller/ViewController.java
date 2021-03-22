package com.official.web.origin.controller;

import com.official.web.origin.entity.auth.AuthRole;
import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.origin.entity.sys.menu.SysMenuField;
import com.official.web.origin.service.auth.AuthRoleServiceImpl;
import com.official.web.origin.service.sys.SysMenuServiceImpl;
import com.official.web.origin.service.sys.menu.SysMenuFieldServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author hsw
 */
@Controller
public class ViewController {
    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

    /**
     * 服务实现类
     **/
    @Autowired
    AuthRoleServiceImpl authRoleServiceImpl;

    @Autowired
    SysMenuServiceImpl sysMenuService;

    @Autowired
    SysMenuFieldServiceImpl sysMenuFieldService;

    /**
     * main页面
     *
     * @return
     */
    @RequestMapping("/menu/{code}/main")
    public ModelAndView main(@PathVariable(value = "code") String code) {
        logger.info("authRole main");
        ModelAndView mav = new ModelAndView("list");
        SysMenu sysMenuById = sysMenuService.findSysMenuById(Long.valueOf(code));
        if (sysMenuById != null) {
            mav.addObject("path", sysMenuById.getCode().replace("_", "/"));
            mav.addObject("title", sysMenuById.getName());
            Map<String, Object> condition = new HashMap<>();
            condition.put("menuId", code);
            List<SysMenuField> sysMenuFieldByCondition = sysMenuFieldService.findSysMenuFieldByCondition(condition);
            mav.addObject("fields", sysMenuFieldByCondition);
        }
        return mav;
    }

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping("toAdd")
    public ModelAndView toAdd() {
        logger.info("authRole toAdd");
        ModelAndView mav = new ModelAndView("auth/role/authRole-add");
        return mav;
    }


    /**
     * 跳转到修改页面
     *
     * @param id
     * @return
     */
    @RequestMapping("toEdit")
    public ModelAndView toEdit(Long id) {
        logger.info("authRole toEdit");
        ModelAndView mav = new ModelAndView("auth/role/authRole-edit");
        AuthRole authRole = authRoleServiceImpl.findAuthRoleById(id);
        mav.addObject("authRole", authRole);
        return mav;
    }


    /**
     * 跳转到查看页面
     *
     * @param id
     * @return
     */
    @RequestMapping("toView")
    public ModelAndView toView(Long id) {
        logger.info("authRole doEdit");
        ModelAndView mav = new ModelAndView("auth/role/authRole-view");
        AuthRole authRole = authRoleServiceImpl.findAuthRoleById(id);
        mav.addObject("authRole", authRole);
        return mav;
    }


    /**
     * 跳转到dialog页面
     *
     * @return
     */
    @RequestMapping("toDialog")
    public ModelAndView toDialog() {
        logger.info("authRole toDialog");
        ModelAndView mav = new ModelAndView("auth/role/authRole-dialog");
        return mav;
    }
}