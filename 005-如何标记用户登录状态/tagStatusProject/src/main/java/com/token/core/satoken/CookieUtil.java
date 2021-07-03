package com.token.core.satoken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这个类本来是在用户登录和获取用户信息的时候自动调用的
 * 为了方便理解因此单独提出来
 * SaToken默认会从cookie, header, 参数 等多个方面尝试获取 唯一token字符串, 这里只用cookie作为演示
 */
public class CookieUtil {

    private static String tokenName = "sa-token-demo";

    /**
     * 将生成的唯一token字符串写入返回的cookie里面
     * @param res
     * @param token
     */
    public static void recordToken(HttpServletResponse res, String token) {
        // 记录 token 信息
        Cookie c = new Cookie(tokenName, token);
        res.addCookie(c);
    }

    /**
     * 从请求体的cookie中获取唯一token字符串
     * @param req
     * @return
     */
    public static String getToken(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(tokenName)) {
                return cookie.getValue();
            }
        }
        return "";
    }

}
