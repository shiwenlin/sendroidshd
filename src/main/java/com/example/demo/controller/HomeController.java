package com.example.demo.controller;


import com.example.demo.entity.Msg;
import com.example.demo.entity.SysUser;
import com.example.demo.service.CustomUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CustomUserServiceImpl customUserService;

    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg();
        msg.setContent("测试信息");
        model.addAttribute("msg",msg);
        return "index";
    }


    //@RequestMapping(value = "/user/all" ,method = RequestMethod.GET)
    //@RequestMapping("/")
    public String getUserList(/*@RequestParam Map<String, Object> params*/Model model) throws Exception {
       /* Query query = new Query(params);*/
        List<SysUser> users = customUserService.getUserList();
        long count = customUserService.getUserCount();
        //PageUtils pageUtils = new PageUtils(users, count, query.getLimit(), query.getPage());

        model.addAttribute("userList",users);
        model.addAttribute("userCount",count);
        return "index";
    }
}
