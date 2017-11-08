package com.example.demo.service;

import com.example.demo.entity.SysUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SysUserService {

    Page<SysUser> selectUserList(SysUser sysUser,int page,int size);

    Page<SysUser> getUserList(Integer page, Integer size);

    void saveUser(SysUser sysUser);

    void deleteUser(long id);

    void updateUser(SysUser sysUser);

     SysUser getUserById(Long id);
}
