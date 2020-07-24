package com.yutianhao.yutianhaoeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YutianhaoEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YutianhaoEurekaServerApplication.class, args);
    }

}
