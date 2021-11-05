package top.jionjion.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jion
 */
@SpringBootTest
@Slf4j
@Transactional
@Rollback
public class JpaApplicationTest {

}