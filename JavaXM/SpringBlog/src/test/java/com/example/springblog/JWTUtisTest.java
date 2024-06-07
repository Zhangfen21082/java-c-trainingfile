package com.example.springblog;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtisTest {
    //过期时间: 分钟数 * 秒数 * 毫秒数
    private final static long EXPIRATION_DATE = 60 * 60 * 1000;
    // 密钥
    private final static String secretString = "VsZPrxSlSWHehzC0KHnIFZ3QtOCy16qV9yflCbEIozQ=";
    // 使用密钥创建的Key对象
    private final static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

    //也可以由该方法生成key，随机的
    @Test
    public void genKey(){
        //生成key
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(encode);
    }

    //生成令牌
    @Test
    public void genToken(){

        // 载荷(payload)
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", 8);
        claim.put("name", "lisi");

        // 令牌
        String token = Jwts.builder()
                .setClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_DATE))
                .signWith(key)
                .compact();
        System.out.println(token);
    }


    //校验令牌
    @Test
    public void parseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoibGlzaSIsImlkIjo4LCJleHAiOjE3MTc3MzAwNjV9.9c3ijpBzcHLJPnRS_UhyxWlDMfpbGRVlsB8HHqKBWbM";
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims body = null;
        try {
            body = build.parseClaimsJws(token).getBody();
        } catch (Exception e) {
            System.out.println("令牌校验失败");
        }
        System.out.println(body);
    }
}
