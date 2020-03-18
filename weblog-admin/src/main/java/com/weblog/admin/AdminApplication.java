package com.weblog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.weblog.dao")
@SpringBootApplication(scanBasePackages = "com.weblog")
//@ComponentScan(basePackages = {"com.weblog"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class);
    }
}
