package com.demo.way2.plugin;

import org.springframework.stereotype.Component;

@Component
public class ModuleNamePluginBean {

    static {
        System.out.println("\n\nname被扫描到然后自动加载了\n\n");
    }

    public String getName() {
        return "你的名字";
    }

}
