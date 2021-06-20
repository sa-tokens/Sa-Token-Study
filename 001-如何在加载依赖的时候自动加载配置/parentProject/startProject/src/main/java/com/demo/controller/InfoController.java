package com.demo.controller;

import com.demo.way1.plugin.ModuleAgePluginBean;
import com.demo.way2.plugin.ModuleNamePluginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    ModuleNamePluginBean nameObj;

    @Autowired
    ModuleAgePluginBean ageObj;

    @GetMapping("/name")
    public Object get() {
        return nameObj.getName();
    }

    @GetMapping("/age")
    public Object get2() {
        return ageObj.getAge();
    }

}
