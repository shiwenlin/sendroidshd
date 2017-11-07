package com.example.demo.repository;

import com.example.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser,Long>,JpaSpecificationExecutor<SysUser> {
    SysUser findByUsername(String username);

}
