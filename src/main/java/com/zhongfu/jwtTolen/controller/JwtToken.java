package com.zhongfu.jwtTolen.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static javax.crypto.Cipher.PRIVATE_KEY;

@Component
public class JwtToken {
   private  static  String  PUBLICKEY= "xiaocangdsd";

        /**
         * @Author xiaocang
         * @Description 生成token
         * @Date 20:52 2019/1/15
         * @Param
         * @return
         **/
   @Scheduled(cron = "* * * * * ?")
   public static String createJwtToken() throws Exception{
       //签发时间
       Date iaDate = new Date();
       //一分钟后过期
       Calendar nowTime = Calendar.getInstance();
       nowTime.add(Calendar.MINUTE,1);
       Date expiresData = nowTime.getTime();


       Map<String ,Object> map = new HashMap<>();
       map.put("alg","HS256");
       map.put("typ","JWt");
       String token = JWT.create()
               .withHeader(map)
               .withClaim("name","夜访奇谈")
               .withClaim("age","28")
               .withClaim("org","每日奇说")
               .withExpiresAt(expiresData)
               .withIssuedAt(iaDate)
               .sign(Algorithm.HMAC256(PUBLICKEY));
       return token;
   }

        /**
         * @Author xiaocang
         * @Description 解密Jwt
         * @Date 20:55 2019/1/15
         * @Param
         * @return
         **/
   public static Map<String ,Claim> verifyToken(String token) throws Exception{
       JWTVerifier verifier = JWT.require(Algorithm.HMAC256(PUBLICKEY)).build();
       DecodedJWT jwt = null;
       try {
           jwt = verifier.verify(token);

       } catch (Exception e) {
          throw  new RuntimeException("登录超时，请重新获取token");
       }
       return  jwt.getClaims();
   }


}
