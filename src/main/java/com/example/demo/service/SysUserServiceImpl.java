package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SysUserServiceImpl implements SysUserService{


    @Autowired
    private SysUserRepository sysUserRepository;

    @Transactional(readOnly = true)
    public List<SysUser> selectUserList(){
        return null;
    }

    public Page<SysUser> getUserList(Integer page, Integer size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return  sysUserRepository.findAll(pageable);
    }
}
