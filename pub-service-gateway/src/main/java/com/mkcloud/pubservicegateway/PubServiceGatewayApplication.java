package com.mkcloud.pubservicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PubServiceGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PubServiceGatewayApplication.class, args);
    }
}
