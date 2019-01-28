package com.zhongfu.jwtTolen.controller;

import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public class Demo {

//    public static void main(String[] args) throws Exception {
//        String jwtToken = JwtToken.createJwtToken();//创建token
//        System.out.println("获取的token为：" +jwtToken);
//
//        Map<String, Claim> claimMap = JwtToken.verifyToken(jwtToken);//检验token
//        System.out.println(claimMap.get("name").asString());
//        System.out.println(claimMap.get("age").asString());
//        System.out.println(claimMap.get("org").asString());
//
//
//        String exceedToken= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9."+"eyJvcmciOiLmr4_ml6XlpYfor7QiLCJuYW1lIjoi5aSc6K6_5aWH6LCIIiwiZXhwIjoxNTQ3NTU4NDY2LCJpYXQiOjE1NDc1NTg0MDYsImFnZSI6Mjh9."
//                +"h33iEZTzXK0zPc-BSgbhn1XkloKIWlowY8UvjhaTGYc";
//
//        Map<String, Claim> claimMap1 = JwtToken.verifyToken(exceedToken);
//    }

    public static void main(String[] args) {
        JJWt jjWt = new JJWt();
        String s = jjWt.creatJwt();
        System.out.println(s);
        Map<String, Object> validate = jjWt.isValidate(s);
        if (null!=validate) {
            String userName = (String) validate.get("userName");
            Object org = validate.get("org");
            System.out.print(userName);
            System.out.print(org);
        }else {
            System.out.println("有问题");
        }

    }


}
