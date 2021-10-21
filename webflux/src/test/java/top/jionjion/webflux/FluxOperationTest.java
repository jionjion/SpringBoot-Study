package top.jionjion.webflux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * 处理符号
 *
 * @author Jion
 */
@SpringBootTest
class FluxOperationTest {

    Flux<Integer> flux;

    /**
     * 初始化
     */
    @BeforeEach
    public void init() {
        this.flux = Flux.just(1, 2, 3, 4, 5);
    }

    /**
     * 依次处理
     */
    @Test
    public void map() {
        flux.map(i -> i * 3).subscribe(System.out::println);
    }

    /**
     * 拍平处理, 输出5次 1,2,3,4,5
     */
    @Test
    public void flatMap() {
        flux.flatMap(i -> flux).subscribe(System.out::println);
    }

    /**
     * 过滤处理
     */
    @Test
    public void filter() {

        flux.filter(i -> i <= 3).subscribe(System.out::println);
    }

    @Test
    public void zip() {
        Flux.zip(flux, flux).subscribe(System.out::println);
    }


    /**
     *  线程池
     */
    @Test
    public void testSchedulers() {
        flux.map(i -> {
            System.out.println(Thread.currentThread().getName() + "map1...");
            return i * 3;
        }).publishOn(Schedulers.elastic()
        ).map(i -> {
            System.out.println(Thread.currentThread().getName() + "map2...");
            return i / 3;
        }).subscribeOn(Schedulers.parallel()
        ).subscribe(i -> System.out.println(Thread.currentThread().getName() + "end..."));

        // 避免因为线程切换, 而无法看到输出
        while(true){
            
        }
    }
}
