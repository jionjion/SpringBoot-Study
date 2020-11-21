package top.jionjion.webflux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

/**
 * 处理符号
 *
 * @author Jion
 */
@SpringBootTest
class FluxOperationTest {

    Flux<Integer> flux;

    /**
     *  初始化
     */
    @BeforeEach
    public void init() {
        this.flux = Flux.just(1, 2, 3, 4, 5);
    }

    /** 依次处理 */
    @Test
    public void map() {
        flux.map(i -> i * 3).subscribe(System.out::println);
    }

    /** 拍平处理 */
    @Test
    public void flatMap() {
        flux.flatMap(i -> flux).subscribe(System.out::println);
    }

    /** 过滤处理 */
    @Test
    public void filter() {

        flux.filter(i -> i <= 3).subscribe(System.out::println);
    }

    @Test
    public void zip() {
        Flux.zip(flux, flux).subscribe(System.out::println);
    }

}
