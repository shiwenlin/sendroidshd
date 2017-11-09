package com.example.demo.controller;


import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
//@SessionAttributes(types = SysUser.class)
public class UserController {

    @Autowired
    private SysUserService sysUserService;


    /**
     * 添加用户页面跳转
     * @return
     */
    @RequestMapping(value = "/add_user",method = RequestMethod.GET)
    public String add_User(Model model){
        model.addAttribute("sysUser",new SysUser());
        return "case/user/add_user";
    }


    /**
     * 编辑用户页面跳转
     * @return
     */
    @RequestMapping(value = "/edit_user",method = RequestMethod.GET)
    public String edit_User(@RequestParam(value = "id") Long uid,Model model,
                            @RequestParam(defaultValue = "0") Integer page){

        SysUser user = sysUserService.getUserById(uid);
        model.addAttribute("sysUser",user);
        //记录更新的页数
        model.addAttribute("page",page);

        return "case/user/add_user";
    }




    /**
     * 用户搜索功能
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/user_list")
    public String selectUser(Model model,SysUser sysUser,@RequestParam(defaultValue = "0") Integer page,
                             @RequestParam(defaultValue = "10") Integer size){
        Page<SysUser> users = sysUserService.selectUserList(sysUser, page, size);
        model.addAttribute("datas",users);
        model.addAttribute("query",sysUser);
        return "case/user/user_list";
    }





    /**
     * 用户增加
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/user_add",method = RequestMethod.POST)
    public String addUser(Model model,@Validated SysUser sysUser,BindingResult result){
        if (result.hasErrors()){
            //hasError会在model返回sysUser  th:object也要是sysUser
            model.addAttribute("sysUser",sysUser);
            return "case/user/add_user";
        }

        //差判断是否已经注册
        sysUserService.saveUser(sysUser);
        return "redirect:/user/user_list";
    }


    /**
     * 更新用户
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/user_edit",method = RequestMethod.POST)
    public String updateUser(Model model,@Validated SysUser sysUser,BindingResult result,Integer page){
        if (result.hasErrors()){
            model.addAttribute("sysUser",sysUser);
            return "case/user/add_user";
        }

        //只更新phone

        sysUserService.updateUser(sysUser.getPhone(),sysUser.getId());
        return "redirect:/user/user_list?page="+page;
    }


    /**
     * 删除指定用户
     * @param uid
     * @return
     */
    @RequestMapping("/user_delete")
    public String deleteUser(@RequestParam(value = "id") long uid){
        sysUserService.deleteUser(uid);
        return "redirect:/user/user_list";
    }



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


}
