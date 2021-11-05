package top.jionjion.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DataJdbcApplicationTest {

    @Test
    void contextLoads() {
        log.info("容器启动成功");
    }
}
