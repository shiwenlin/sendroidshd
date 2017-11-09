package com.example.demo.repository;

import com.example.demo.entity.SysUser;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser,Long>,JpaSpecificationExecutor<SysUser> {
    SysUser findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update sys_user set phone=?1 where id=?2",nativeQuery = true)
    int updateUserById(String phone,Long id);

}
