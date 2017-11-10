package com.example.demo;

import com.example.demo.entity.SysUser;

import java.util.Date;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {


        /**
             public<U> Optional<U> map(Function<? super T, ? extends U> mapper)  //做深入的多重判断是否为空
             public T orElse(T other)              //判断当前对象是否为空，是返回new一个
             public T orElseGet(Supplier<? extends T> other)   //判断当前对象是否为空，是则执行方法
             public void ifPresent(Consumer<? super T> consumer)   //判断是否为空  存在才对它做点什么
             public Optional<T> filter(Predicate<? super T> predicate)
             public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)
             public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
         */

        SysUser sysUser = new SysUser();

        SysUser empty = null;

        Optional<SysUser> optional= Optional.ofNullable(empty);
        SysUser sysUser1 = optional.orElse(sysUser); //如果为空就返回括号内容
        System.out.println(sysUser1);


        optional.orElseGet(()->createUser());//如果为空，执行里面的方法

        //orElseThrow() 在有值时直接返回, 无值时抛出想要的异常
        //isPresent()  null时返回false


        //map
        Optional<Object> o = optional.map((value) -> Optional.of(value.getPhone()));
        System.out.println("map的对象："+o.isPresent());


        //return user.map(u -> u.getUsername()).map(name -> name.toUpperCase()).orElse(null);


        Optional<String> s = optional.map(u -> u.getPhone()).map(p -> p.toUpperCase());

        /*User user = .....
        if(user != null) {
            String name = user.getUsername();
            if(name != null) {
                return name.toUpperCase();
            } else {
                return null;
            }
        } else {
            return null;
        }*/

    }

    public static SysUser createUser(){
        return new SysUser();
    }
}
