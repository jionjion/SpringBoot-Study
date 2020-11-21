package top.jionjion.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 基础的使用 Flux
 *
 * @author Jion
 */
@SpringBootTest
class FluxTest {

    @Test
    public void test() {
        // 多通道
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        Flux<Integer> arrayFlux = Flux.fromArray(new Integer[]{1, 2, 3, 4, 5});
        Flux<Integer> listFlux = Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5));
        Flux<Integer> streamFlux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5));
        // 单通道
        Mono<Integer> mono = Mono.just(1);

        // 订阅
        flux.subscribe();
        // 订阅, 处理
        arrayFlux.subscribe(System.out::println);
        // 订阅, 处理, 异常回调
        arrayFlux.subscribe(System.out::println, System.err::println);
        // 订阅, 处理, 异常回调, 完成处理
        listFlux.subscribe(System.out::println, System.err::println,
                () -> System.out.println("完成处理..."));
        // 订阅, 处理, 异常回调, 完成处理, 背压
        listFlux.subscribe(System.out::println, System.err::println,
                () -> System.out.println("完成处理..."),
                subscription -> subscription.request(3));
    }
}
