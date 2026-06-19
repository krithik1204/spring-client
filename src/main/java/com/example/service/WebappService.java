package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.WebappFeignClient;
import com.example.client.WebappFeignClientWithEureka;

@Service
public class WebappService {

    private static final Logger log = LoggerFactory.getLogger(WebappService.class);

    @Autowired(required = false)
    private WebappFeignClientWithEureka webappFeignClientWithEureka;

    @Autowired(required = false)
    private WebappFeignClient webappFeignClient;

    public String getTesting() {
        // Prefer Eureka-discovered client if available
        if (webappFeignClientWithEureka != null) {
            try {
                return webappFeignClientWithEureka.getTesting();
            } catch (Exception e) {
                log.warn("Eureka-based Feign client failed, falling back: {}", e.toString());
            }
        }

        // Fallback to hardcoded URL client
        if (webappFeignClient != null) {
            try {
                return webappFeignClient.getTesting();
            } catch (Exception e) {
                log.warn("Hardcoded Feign client failed: {}", e.toString());
            }
        }

        // Last-resort local response
        log.error("Both Feign clients failed to contact webapp; returning local fallback message");
        return "Testers (local fallback)";
    }
}
