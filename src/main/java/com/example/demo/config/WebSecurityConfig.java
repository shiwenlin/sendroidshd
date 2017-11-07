package com.example.demo.config;

import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{




    @Bean
    UserDetailsService customUserService() {
        return  new UserDetailServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }


    /**
     * permitAll表示该请求任何人都可以访问，.anyRequest().authenticated(),表示其他的请求都必须要有权限认证。
     5.这里我们可以通过匹配器来匹配路径，比如antMatchers方法，假设我要管理员才可以访问admin文件夹下的内容，
     我可以这样来写：.antMatchers("/admin/**").hasRole("ROLE_ADMIN")，
     也可以设置admin文件夹下的文件可以有多个角色来访问，写法如下：.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ROLE_USER")
     6.可以通过hasIpAddress来指定某一个ip可以访问该资源,假设只允许访问ip为210.210.210.210的请求获取admin下的资源，
     写法如下.antMatchers("/admin/**").hasIpAddress("210.210.210.210")
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.authorizeRequests().antMatchers("/css/**","fonts/**","js/**").permitAll().
                .authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and()
                .logout().permitAll();*/


        /*http.authorizeRequests().anyRequest().permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/index").permitAll();

        http.csrf().disable();*/
       http.authorizeRequests().antMatchers("/css/**","/fonts/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/index").permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll();

    }

    /*
    *     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

        .antMatchers(StaticParams.PATHREGX.NOAUTH,
                StaticParams.PATHREGX.CSS,StaticParams.PATHREGX.JS,StaticParams.PATHREGX.IMG).permitAll()//无需访问权限

        .antMatchers(StaticParams.PATHREGX.AUTHADMIN).hasAuthority(StaticParams.USERROLE.ROLE_ADMIN)//admin角色访问权限

        .antMatchers(StaticParams.PATHREGX.AUTHUSER).hasAuthority(StaticParams.USERROLE.ROLE_USER)//user角色访问权限

        .anyRequest()//all others request authentication
        .authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().permitAll();
    }
    *
    * */
}
