package com.example.redistest.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class ValCodeController {
    // 注入连接池
    @Autowired
    private JedisPool jedisPool;

    /**
     * 生成4位验证码，实际情况可以调付费api
     */
    public int phoneCode() {
        int num = (int)(Math.random()*10000);
        return num;
    }

    /**
     * 根据用户的手机号生成redis中的key，也即phone:code:手机号
     * 判断key是否存在，如果key不存在则对key进行赋值，设置过期时间为60s
     * 如果key存在，提示用户验证码已经发送注意查收
     */

    @GetMapping("/getValCode")
    public String getValCode(@RequestParam("phoneNum")String phoneNum) {
        // 获取jedis连接
        Jedis jedis = jedisPool.getResource();
        log.info("jedis已连接");
        // key
        String key = "phone:code:" + phoneNum;
        log.info("Redis key已设置" + key);

        if(!jedis.exists(key)) {
            // 如果key不存在，则发送验证码
            log.info("Redis key不存在");
            // 发送验证码
            int phoneCode = this.phoneCode();
            System.out.println(phoneCode);
            log.info("验证码已发送" + phoneCode);
            jedis.set(key, phoneCode+"");
            // 设置过期时间
            jedis.expire(key, 60);
            log.info("验证码发送成功");
            return "验证码发送成功";
        } else {
            // 如果key存在，则等待
            log.info("Redis key存在，需要等待");
            return "验证码已发送，还需等待" + jedis.ttl(key) + "秒！";
        }
    }
    /**
     * 当用户点击确认按钮后，就会将前端输入的手机号和验证码发送给后端
     * 后端接受后，会和Redis key比较以判断是否可以登录
     */
    @GetMapping("valCode")
    public String valCode(@RequestParam("code") String code, @RequestParam("phoneNum") String phoneNum, HttpServletResponse response) {
        // 获取jedis连接
        Jedis jedis = jedisPool.getResource();
        log.info("jedis已连接");
        // key
        String key = "phone:code:" + phoneNum;
        log.info("Redis key已设置" + key);
        // 判断
        if(code.equals(jedis.get(key))) {
            log.info("验证成功，执行登录逻辑");
            return "登录成功";
        }

        log.warn("验证失败");
        response.setStatus(403);
        return "登录失败";

    }

}
