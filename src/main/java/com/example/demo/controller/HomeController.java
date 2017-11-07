package com.example.demo.controller;


import com.example.demo.entity.Msg;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private SysUserService sysUserService;








    /**
     * 用户列表展示功能
     * @param model
     * @return
     */
    //@RequestMapping(value = "/user/all" ,method = RequestMethod.GET)
    //@RequestMapping("/")/user_list/css/bootstrap.css
    @RequestMapping(value = "/user_list/",method = RequestMethod.GET)
    public String getUserList(/*@RequestParam Map<String, Object> params*/Model model, Integer page){
        Page<SysUser> users = sysUserService.getUserList(page,10);
        model.addAttribute("userList",users);
        return "case/user_list";
    }


    /**
     * 用户搜索功能
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/user_query")
    public String selectUser(SysUser sysUser){
        sysUserService.selectUserList();

        return "case/user_list";
    }


    @RequestMapping(value = "/user_add")
    public String addUser(SysUser sysUser){

        return "case/user_list";
    }


   // public String
}
