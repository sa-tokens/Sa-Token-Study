package com.demo.config;

import org.springframework.stereotype.Component;

@Component  // 屏蔽这里将返回默认信息
public class InfoBean {

    public String getInfo() {
        return "这是一个信息";
    }

}
