package top.jionjion.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 处理响应路由
 *
 * @author Jion
 */
@Configuration
public class RouterConfig {


    @Autowired
    DemoHandler demoHandler;

    /**
     * 自定义配置路由.
     *
     * @return 路由
     */
    @Bean
    public RouterFunction<ServerResponse> demoRouter() {
        /*
            http://127.0.0.1:8080/hello
            http://127.0.0.1:8080/world
            http://127.0.0.1:8080/times
            http://127.0.0.1:8080/query/1
         */
        return RouterFunctions.route(RequestPredicates.GET("/hello"), demoHandler::hello)
                .andRoute(RequestPredicates.GET("/world"), demoHandler::world)
                .andRoute(RequestPredicates.GET("/times"), demoHandler::times)
                .andRoute(RequestPredicates.GET("/query/{id}"), demoHandler::queryById);
    }
}
