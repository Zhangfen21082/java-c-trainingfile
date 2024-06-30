package com.example.springblog.controller;

import com.example.springblog.model.Result;
import com.example.springblog.model.UserInfo;
import com.example.springblog.service.UserService;
import com.example.springblog.utils.JwtUtils;
import com.example.springblog.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.example.springblog.constants.Constant.USER_TOKEN;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(String userName, String password) {
        // 参数校验
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("用户名或密码不能为空");
        }
        // 查询用户是否存在
        UserInfo userInfo = userService.queryUserByName(userName);
        if(userInfo == null || userInfo.getId() < 0) {
            return Result.fail("用户不存在");
        }

        // 密码校验
        if (!SecurityUtils.verify(password, userInfo.getPassWord())){
            return Result.fail("密码错误");
        }

        // 密码正确，生成token
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", userInfo.getId());
        claim.put("name", userInfo.getUserName());
        return Result.success(JwtUtils.genToken(claim));

    }

    /**
     * 获取当前登录用户信息
     */
    @RequestMapping("/getUserInfo")

    public UserInfo getUserInfo(HttpServletRequest request) {
        String userToken = request.getHeader(USER_TOKEN);
        Integer userId = JwtUtils.getUserIdFromToken(userToken);
        if (userId == null || userId < 0)
            return null;

        UserInfo userInfo = userService.queryUserById(userId);
        // 防止被被人看见
        userInfo.setPassWord("");
        return userInfo;
    }

    /**
     * 根据博客id获取作者信息
     */
    @RequestMapping("/getAuthorInfo")

    public UserInfo getAuthorInfo(Integer blogId){
        if(blogId == null || blogId < 1) {
            return null;
        }

        UserInfo authorInfo = userService.getAuthorInfoByBlogId(blogId);
        authorInfo.setPassWord("");
        return authorInfo;
    }

}
