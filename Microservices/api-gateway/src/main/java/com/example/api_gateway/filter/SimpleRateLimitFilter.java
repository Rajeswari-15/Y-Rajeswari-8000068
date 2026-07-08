package com.example.api_gateway.filter;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SimpleRateLimitFilter implements GlobalFilter, Ordered {

    private final AtomicInteger requestCount = new AtomicInteger(0);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        int current = requestCount.incrementAndGet();

        System.out.println("Request Count : " + current);

        if (current > 5) {

            exchange.getResponse()
                    .setStatusCode(HttpStatus.TOO_MANY_REQUESTS);

            return exchange.getResponse().setComplete();

        }

        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}