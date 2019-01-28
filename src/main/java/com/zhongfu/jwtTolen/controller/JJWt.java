package com.zhongfu.jwtTolen.controller;


import io.jsonwebtoken.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JJWt {

    /**
     * @Author xiaocang
     * @Description 创建token
     * @Date 18:48 2019/1/24
     * @Param
     * @return
     **/
    private final static String  privateKey = "xiaocang";
    private final static String  privateKey2 = "cangcang";
    public static String creatJwt(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,1);
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("userName","xiaocnag");
        userMap.put("org","爱吃肉的毛毛虫");
        Map<String ,Object> map = new HashMap<>();
        map.put("alg","HS512");
        map.put("typ","JWt");
        String compact = Jwts.builder()
                .setHeader(map)
                .setClaims(userMap)
                .setIssuedAt(new Date())
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256,privateKey)
                .compact();
        return compact;
    }

    /**
     * @Author xiaocang
     * @Description 验证token
     * @Date 18:52 2019/1/24
     * @Param
     * @return
     **/
    public static Map<String, Object>  isValidate(String token) {
        try {
            Map<String, Object> body = Jwts.parser().setSigningKey(privateKey2).parseClaimsJws(token).getBody();
            return body;
        } catch (Exception e) {
            return null;
        }
    }
}
