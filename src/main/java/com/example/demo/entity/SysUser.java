package com.example.demo.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity(name="sys_user")
public class SysUser implements UserDetails {


    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "username",nullable = false)
    @Length(min=6,max=14,message = "*用户名长度5-14")  //被注释的字符串的大小必须在指定的范围内
    private String username;


    @Column(name = "password",nullable = false)
    @Length(min=6,max=14,message = "*密码长度5-14")
    private String password;

    /**
     * 村镇信息先省略
     */

    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "*请输入正确的手机号")
    private String phone;

    @Column(name="email", nullable = false)
    @Email(message = "*邮箱错误")
    private String email;

    @Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createTime;

    @Length(min=2,message = "*请输入两个字以上的姓名")  //
    @Column(name = "name", nullable = false)
    private String name;



    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysRole> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = this.getRoles();


        for (SysRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
