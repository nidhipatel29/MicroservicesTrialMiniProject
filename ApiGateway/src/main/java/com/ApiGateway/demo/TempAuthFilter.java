package com.ApiGateway.demo;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TempAuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // skip check for open APIs (like login)
        if (path.startsWith("/auth")) {
            return chain.filter(exchange);
        }

        // read the header
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        // temporary rule: header must be exactly "Bearer test123"
        if (token == null || !token.equals("Bearer test123")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // valid, so forward the request to the service
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1; // run before other filters
    }
}
