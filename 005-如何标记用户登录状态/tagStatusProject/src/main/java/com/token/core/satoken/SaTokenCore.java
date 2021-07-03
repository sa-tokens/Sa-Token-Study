package com.token.core.satoken;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * sa-token 核心模拟类
 * 不完全准确, 但基本思想类似
 */
public class SaTokenCore {

    // 保存 token 和用户 id对应的关系
    Map<String, Object> tokenAndUserId = new HashMap<>();
    // 保存 token 和用户 session对应的关系
    Map<String, Object> tokenAndInfo = new HashMap<>();

    /**
     * 对标的是 登录方法
     * @param loginId
     */
    public String login(Object loginId) {
        String userId = loginId.toString();
        if (tokenAndUserId.containsValue(userId)) {
            // 之前登录过
            Optional<Map.Entry<String, Object>> opt = tokenAndUserId.entrySet().stream()
                    .filter(kv -> kv.getValue() == userId)
                    .findFirst();
            return opt.get().getKey();
        } else {
            // 初始化一个新用户
            // 通过随机字符串构建用户唯一 token
            String randomToken = Double.toString(Math.random()).substring(2);
            // 通过token关联用户信息和绑定此用户的session对象
            tokenAndUserId.put(randomToken, userId);
            tokenAndInfo.put(randomToken, "用户session信息");
            return randomToken;
        }
    }

    /**
     * 对标的是 获取登录状态的方法
     * @param token
     * @return
     */
    public boolean getNowLoginState(String token) {
        return tokenAndUserId.containsKey(token);
    }

    /**
     * 对标的是 获取用户唯一id的方法
     * @param token
     * @return
     */
    public Object getLoginId(String token) {
        return tokenAndUserId.get(token);
    }

    /**
     * 对标的是 退出方法
     * @param token
     */
    public void logout(String token) {
        tokenAndUserId.remove(token);
        tokenAndInfo.remove(token);
    }

    /**
     * 模拟 StpUtil
     * @return
     */
    public static SaTokenCore Util() {
        return new SaTokenCore();
    }

}
