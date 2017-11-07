package com.example.demo.repository;

import com.example.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String username);

}
