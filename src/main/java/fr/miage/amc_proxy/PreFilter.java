package fr.miage.amc_proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class PreFilter implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Ceci est un filtre Pre
        logger.info("-----> req "+exchange.getRequest().getMethod()+ " sur " + exchange.getRequest().getPath());
        logger.info("-------------> params "+exchange.getRequest().getQueryParams());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
