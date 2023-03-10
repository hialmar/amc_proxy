package fr.miage.amc_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AmcProxyApplication {

    @Bean
    public GlobalFilter customFilter() {
        return new PreFilter();
    }



    public static void main(String[] args) {
        SpringApplication.run(AmcProxyApplication.class, args);
    }



}
