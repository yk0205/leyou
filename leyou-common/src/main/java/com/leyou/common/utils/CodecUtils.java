package com.leyou.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: 98050
 * @Time: 2018-10-23 10:49
 * @Feature: 密码加密
 */
public class CodecUtils {

    public static String passwordBcryptEncode(String username,String password){

        return new BCryptPasswordEncoder().encode(username + password);
    }

    public static Boolean passwordConfirm(String rawPassword,String encodePassword){
        return new BCryptPasswordEncoder().matches(rawPassword,encodePassword);
    }

    public static void main(String[] args) {
        String username = "yangkai";
        String password = "123";
        String jiamiok = passwordBcryptEncode(username, password);
        System.out.println(jiamiok);
        Boolean aBoolean = passwordConfirm(username + password, "$2a$10$3MCwY7HD3TWuMYLtMURvqu7OWUbFuybPux3O/C9CjgYGykpx./gKa");
        System.out.println(aBoolean);


    }

}
