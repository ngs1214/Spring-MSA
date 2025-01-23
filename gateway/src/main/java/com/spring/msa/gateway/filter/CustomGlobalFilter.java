package com.spring.msa.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("PRE global filter Order -1");

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("POST global filter order -1");
        }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
