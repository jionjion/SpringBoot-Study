package top.jionjion.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 简单的处理
 *
 * @author Jion
 */
@RestController
public class DemoController {

    /**
     * 返回一个字符串. http://127.0.0.1:8080/string
     *
     * @return 字符串流
     */
    @GetMapping("string")
    public Mono<String> hello() {
        return Mono.just("这是一个响应字符串");
    }
}
