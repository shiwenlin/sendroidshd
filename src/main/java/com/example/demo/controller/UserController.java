package com.example.demo.controller;


import com.example.demo.entity.Msg;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;



    /**
     * 用户列表展示功能
     * @param model
     * @return
     */
/*    @RequestMapping(value = "/user_list",method = RequestMethod.GET)
    public String getUserList(Model model, @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer size){
        Page<SysUser> users = sysUserService.getUserList(page,size);
        model.addAttribute("userList",users);
        return "case/user_list";
    }*/


    /**
     * 用户搜索功能
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/user_list")
    public String selectUser(Model model,SysUser sysUser,@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer size){
        Page<SysUser> users = sysUserService.selectUserList(sysUser, page, size);
        model.addAttribute("datas",users);
        model.addAttribute("query",sysUser);
        return "case/user/user_list";
    }


    /**
     * 添加用户页面
     * @return
     */
    @RequestMapping(value = "/add_user",method = RequestMethod.GET)
    public String add_User(){
        return "case/user/add_user";
    }


    /**
     * 用户增加
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/user_add")
    public String addUser(SysUser sysUser){
        sysUserService.saveUser(sysUser);
        return "case/user/user_list";
    }


    /**
     * 更新用户
     * @param sysUser
     * @return
     */
    public String updateUser(SysUser sysUser){
        sysUserService.updateUser(sysUser);
        return "case/user/user_list";
    }


}
