package top.jionjion.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  定时调度任务
 *  参阅 <a href="https://www.jianshu.com/p/06c4307214b7">...</a>
 *
 * @author Jion
 */
@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }
}
