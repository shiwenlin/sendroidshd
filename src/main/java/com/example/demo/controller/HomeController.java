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

    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg();
        msg.setContent("测试信息");
        model.addAttribute("msg",msg);
        return "case/index";
    }




    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String case_index() {
        return "case/index";
    }

    @RequestMapping(value = "/data_view",method = RequestMethod.GET)
    public String data_view() {
        return "data/data_view";
    }

    @RequestMapping(value = "/case_progress",method = RequestMethod.GET)
    public String case_progress() {
        return "case/case_progress";
    }

    @RequestMapping(value = "/data_detail",method = RequestMethod.GET)
    public String data_detail() {
        return "data/data_detail";
    }

    @RequestMapping(value = "/data_detail2",method = RequestMethod.GET)
    public String data_detail2() {
        return "data/data_detail2";
    }

    @RequestMapping(value = "/case_view",method = RequestMethod.GET)
    public String case_view() {
        return "case/case_view";
    }

    @RequestMapping(value = "/case_view2",method = RequestMethod.GET)
    public String case_view2() {
        return "case/case_view2";
    }

    @RequestMapping(value = "/case_detail",method = RequestMethod.GET)
    public String case_detail() {
        return "case/case_detail";
    }

    @RequestMapping(value = "/case_detail2",method = RequestMethod.GET)
    public String case_detail2() {
        return "case/case_detail2";
    }

    @RequestMapping(value = "/case_town_view",method = RequestMethod.GET)
    public String case_town_view() {
        return "case/case_town_view";
    }

    @RequestMapping(value = "/case_town_view_all",method = RequestMethod.GET)
    public String case_town_view_all() {
        return "case/case_town_view_all";
    }

    @RequestMapping(value = "/case_town_view2",method = RequestMethod.GET)
    public String case_town_view2() {
        return "case/case_town_view2";
    }

    @RequestMapping(value = "/case_town_detail",method = RequestMethod.GET)
    public String case_town_detail() {
        return "case/case_town_detail";
    }

    @RequestMapping(value = "/new_case",method = RequestMethod.GET)
    public String new_case() {
        return "case/new_case";
    }

    @RequestMapping(value = "/new_town_case",method = RequestMethod.GET)
    public String new_town_case() {
        return "case/new_town_case";
    }

    @RequestMapping(value = "/new_forestry_case",method = RequestMethod.GET)
    public String new_forestry_case() {
        return "case/new_forestry_case";
    }

    @RequestMapping(value = "/messages_view",method = RequestMethod.GET)
    public String messages_view() {
        return "messages/messages_view";
    }

    @RequestMapping(value = "/messages_detail",method = RequestMethod.GET)
    public String messages_detail() {
        return "messages/messages_detail";
    }

    @RequestMapping(value = "/new_messages",method = RequestMethod.GET)
    public String new_messages() {
        return "messages/new_messages";
    }

    @RequestMapping(value = "/settings",method = RequestMethod.GET)
    public String setting() {
        return "setting/settings";
    }


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
