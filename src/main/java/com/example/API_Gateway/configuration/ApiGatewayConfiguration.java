package com.example.API_Gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    
    @Bean
    public RouteLocator getewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(p -> p.path("/product/**")
                .filters(f -> f.rewritePath("/product/(?<segment>.*)", "/${segment}")
                    .addRequestHeader("ReqHeader-1", "PS-RequestHeader")
                    .addRequestParameter("ReqParam-1", "PS-RequestParam"))
                .uri("lb://product-service"))
            .route(p -> p.path("/loan/**")
                .filters(f -> f.rewritePath("/loan/(?<segment>.*)", "/${segment}"))
                .uri("lb://loan-application"))
            .build();
    }
}
