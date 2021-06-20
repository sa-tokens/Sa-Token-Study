package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadConfig {

    @Bean
    @ConfigurationProperties(prefix = "前缀.后缀")  // 这里之所以使用中文就是为了表明前缀是自定义的, 随意写, 还可以写多个层级
    public ConfigBean get() {
        return new ConfigBean();
    }

}
