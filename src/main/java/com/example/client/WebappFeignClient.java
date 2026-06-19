package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "spring-cloud-webapp", url = "http://localhost:8083")
public interface WebappFeignClient {

    @GetMapping("/testing")
    String getTesting();
}
