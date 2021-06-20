package com.demo.controller;

import com.demo.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    ConfigBean configBean;

    @GetMapping("/info")
    public Object get() {
        return configBean.toString();
    }

}
