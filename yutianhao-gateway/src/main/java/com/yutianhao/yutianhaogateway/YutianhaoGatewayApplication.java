package com.yutianhao.yutianhaogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YutianhaoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YutianhaoGatewayApplication.class, args);
    }

}
