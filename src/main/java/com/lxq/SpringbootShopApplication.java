package com.lxq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringbootShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShopApplication.class, args);
    }

}
