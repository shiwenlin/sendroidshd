package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.repository.SysUserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


@Service
public class SysUserServiceImpl implements SysUserService{


    @Autowired
    private SysUserRepository sysUserRepository;


    @Override
    public Page<SysUser> selectUserList( SysUser sysUser,int page,int size) {



        Specification specification = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root,
                                         CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                //暂时添加一个电话
                if (!StringUtils.isBlank(sysUser.getPhone())) {
                    predicates.add(criteriaBuilder.like(root.get("phone").as(String.class), "%" + sysUser.getPhone() + "%"));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        Pageable pageable = new PageRequest(page, size);

        return sysUserRepository.findAll(specification,pageable);
    }



    public Page<SysUser> getUserList(Integer page, Integer size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return  sysUserRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public void saveUser(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        //sysUser.setCreateTime(new Timestamp(System.currentTimeMillis()));

        sysUserRepository.save(sysUser);
    }

    @Override
    public void deleteUser(long id) {
        sysUserRepository.delete(id);
    }



    @Override
    public void updateUser(SysUser sysUser) {
        SysUser repositoryOne = sysUserRepository.findOne(sysUser.getId());
        //判断更新的项目
    }


}
