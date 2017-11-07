package com.example.demo.service;

import com.example.demo.entity.SysUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SysUserService {

    public List<SysUser> selectUserList();

    public Page<SysUser> getUserList(Integer page, Integer size);
}
