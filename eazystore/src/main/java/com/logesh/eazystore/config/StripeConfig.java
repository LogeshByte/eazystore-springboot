package com.logesh.eazystore.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:stripe.properties")
@Slf4j
public class StripeConfig {

    @Value("${stripe.apiKey}")
    private String apiKey;

    @PostConstruct
    public void init() {
        if (apiKey == null || apiKey.isEmpty() || apiKey.contains("dummy")) {
            log.warn("Stripe API key not configured. Stripe payment functionality will not work.");
            log.warn("Please set STRIPE_API_KEY environment variable for production.");
        } else {
            Stripe.apiKey = apiKey;
            log.info("Stripe API configured successfully");
        }
    }
}
