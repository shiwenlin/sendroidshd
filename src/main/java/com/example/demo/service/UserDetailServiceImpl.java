package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;



public  class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private SysUserRepository sysUserRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            SysUser sysUser = sysUserRepository.findByUsername(s);
            if(sysUser==null){
                throw  new UsernameNotFoundException("用户名不存在");
            }
            System.out.println("s:"+s);
            System.out.println("username:"+sysUser.getUsername()+";password:"+sysUser.getPassword());
            return sysUser;
    }



}
