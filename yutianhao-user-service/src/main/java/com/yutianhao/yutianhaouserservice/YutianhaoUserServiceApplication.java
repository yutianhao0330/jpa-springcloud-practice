package com.yutianhao.yutianhaouserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(value = {"com.yutianhao.yutianhaocommon","com.yutianhao.yutianhaouserservice"})
public class YutianhaoUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YutianhaoUserServiceApplication.class, args);
    }

}
