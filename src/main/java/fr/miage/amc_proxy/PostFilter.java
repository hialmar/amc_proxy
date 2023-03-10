package fr.miage.amc_proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.net.URI;


@Configuration
public class PostFilter {

    final Logger logger =
            LoggerFactory.getLogger(
                    PostFilter.class);

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // Ceci est un filtre Post
                        Route route = exchange.getAttribute("org.springframework.cloud.gateway.support.ServerWebExchangeUtils.gatewayRoute");
                        URI destination = route.getUri();
                        logger.info("-----> req "+exchange.getRequest().getMethod()+" sur " + destination.getHost() + " " + exchange.getRequest().getPath());
                        logger.info("-------------> params "+exchange.getRequest().getQueryParams());
                    }));
        };
    }
}