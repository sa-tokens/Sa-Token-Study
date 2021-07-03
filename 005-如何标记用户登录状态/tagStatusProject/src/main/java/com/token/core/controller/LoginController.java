package com.token.core.controller;

import com.token.core.satoken.CookieUtil;
import com.token.core.satoken.SaTokenCore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    SaTokenCore stpUtil = SaTokenCore.Util();

    @GetMapping("/login")
    public String login(String userId, HttpServletResponse res) {
        // ---------------------
        // 这两个方法在SaToken框架里面本来是合在一起的
        String token = stpUtil.login(userId);
        CookieUtil.recordToken(res, token);
        // ---------------------
        return "登录成功";
    }

    @GetMapping("/state")
    public Boolean checkLoginState(HttpServletRequest req) {
        // ---------------------
        // 这两个方法在SaToken框架里面本来是合在一起的
        String token = CookieUtil.getToken(req);
        boolean nowLoginState = stpUtil.getNowLoginState(token);
        // ---------------------
        return nowLoginState;
    }

    @GetMapping("/userId")
    public Object getNowLoginUserId(HttpServletRequest req) {
        // ---------------------
        // 这两个方法在SaToken框架里面本来是合在一起的
        String token = CookieUtil.getToken(req);
        Object nowLoginUserId = stpUtil.getLoginId(token);
        // ---------------------
        return nowLoginUserId == null? "当前用户未登陆": nowLoginUserId;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        // ---------------------
        // 这两个方法在SaToken框架里面本来是合在一起的
        String token = CookieUtil.getToken(req);
        stpUtil.logout(token);
        // ---------------------
        return "已退出";
    }

}
