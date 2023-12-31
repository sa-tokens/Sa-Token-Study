package com.demo;

import com.demo.util.ToolUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartMain {

    public static void main(String[] args) {
        SpringApplication.run(StartMain.class, args);
        System.out.println(ToolUtil.getInfo());
        System.exit(0);
    }

}
