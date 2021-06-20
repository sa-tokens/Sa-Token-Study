package com.demo.way1.plugin;

public class ModuleAgePluginBean {

    static {
        System.out.println("\n\nage被注入到然后自动加载了\n\n");
    }

    public Integer getAge() {
        return 20;
    }
}
