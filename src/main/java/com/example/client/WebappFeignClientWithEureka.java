package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Alternative Feign Client using Eureka service discovery.
 * This client will use Eureka to discover the service instead of hardcoded URL.
 * 
 * To use this client, uncomment @FeignClient annotation below and comment out
 * the WebappFeignClient with hardcoded URL.
 */
    @FeignClient(name = "spring-cloud-webapp", contextId = "webappEureka")
public interface WebappFeignClientWithEureka {

    @GetMapping("/testing")
    String getTesting();
}
