package com.mirc.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        String password = "123";
        String pwd = encodePassword(password);

        System.out.println(pwd);
    }


}
