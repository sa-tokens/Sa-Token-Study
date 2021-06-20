package com.demo.config;

import com.demo.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {

    @Autowired(required = false)
    public void setInfo(InfoBean infoBean) {
        ToolUtil.setInfo(infoBean.getInfo());
    }

}
