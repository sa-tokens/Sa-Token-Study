package com.demo.way1.config;

import com.demo.way1.plugin.ModuleAgePluginBean;
import org.springframework.context.annotation.Bean;

public class ConfigBeans {

    @Bean
    public ModuleAgePluginBean get() {
        return new ModuleAgePluginBean();
    }

}
