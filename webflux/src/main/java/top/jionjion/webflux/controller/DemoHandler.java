package top.jionjion.webflux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.jionjion.webflux.service.DomeService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * 函数式处理, 作为响应输出
 *
 * @author Jion
 */
@Component
public class DemoHandler {

    private final Logger logger = Logger.getLogger(DemoHandler.class.getName());

    @Autowired
    DomeService domeService;

    /**
     * 处理并响应
     */
    public Mono<ServerResponse> hello(ServerRequest request) {
        logger.info(() -> "url: " + request.uri());
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("hello"), String.class);
    }

    /**
     * 处理并响应
     */
    public Mono<ServerResponse> world(ServerRequest request) {
        logger.info(() -> "method: " + request.method());
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("world"), String.class);
    }

    /**
     * 处理并响应, 服务端不断向客户端发送数据
     * 每隔一秒发送一份当前时间
     */
    public Mono<ServerResponse> times(ServerRequest request) {
        logger.info(() -> "request: " + request.toString());
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1))
                                .map(it -> LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)),
                        String.class);
    }

    /**
     * 数据库处理查询
     */
    public Mono<ServerResponse> queryById(ServerRequest request) {
        // 通过路径参数获得
        String id = request.pathVariable("id");
        try {
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                    .body(Mono.just(domeService.findById(id)), String.class);
        } catch (JsonProcessingException e) {
            return ServerResponse.status(HttpStatus.BAD_GATEWAY).body(Mono.just("服务器异常"), String.class);
        }
    }
}
